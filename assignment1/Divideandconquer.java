
import java.util.*;
import java.io.*;
import java.lang.Double;

public class Divideandconquer
{
    // List of coordinates
    public static List<Coordinate> coordinateList;

    public static double smallestDist;
    public static List<Pair<Coordinate,Coordinate>> foundCoordinates;

    public static void main(String[] args)
    {
        if(args.length != 1) {
            System.out.println("Usage: java Divideandconquer [example.input]");
            return;
        }

        File inputFile = new File(args[0]);
        try {
            // get all pairs from input file
            coordinateList = Utilities.readFile(inputFile);
        }
        catch(IOException ioe) {
            //handle exception
        }

        // find closest pairs
        foundCoordinates = findCoordinates(coordinateList);

        Utilities.printPoints(smallestDist, foundCoordinates);
    }

    /**
     * ???
     *
     * Algorithm performance: O(?)
     *
     * @param  list The list of coordinates
     * @return list The list of point pairs separated by
     *              the smallest found distance
     */
    public static List<Pair<Coordinate,Coordinate>> findCoordinates(List<Coordinate> coordinates)
    {
        List<Pair<Coordinate,Coordinate>> found = new ArrayList<Pair<Coordinate,Coordinate>>();

        List<Coordinate> left = coordinateList.subList(0, coordinateList.size()/2);
        List<Coordinate> right = coordinateList.subList(coordinateList.size()/2, coordinateList.size());

        List<Pair<Coordinate,Coordinate>> smallestLeft = findClosestCoords(left);
        List<Pair<Coordinate,Coordinate>> smallestRight = findClosestCoords(right);

        double leftDist = Utilities.distanceFormula(smallestLeft.get(0).getL(), smallestLeft.get(0).getR());
        double rightDist = Utilities.distanceFormula(smallestRight.get(0).getL(), smallestRight.get(0).getR());

        double dist = (leftDist < rightDist) ? leftDist : rightDist;

        List<Pair<Coordinate,Coordinate>> smallestIntersection = findIntersection(left, right, dist);

        double intersectDist = Double.MAX_VALUE;
        if (smallestIntersection.size() > 0)
            intersectDist = Utilities.distanceFormula(smallestIntersection.get(0).getL(), smallestIntersection.get(0).getR());

        smallestDist = Math.min(leftDist, Math.min(rightDist, intersectDist));

        if (leftDist == smallestDist)      { found.addAll(smallestLeft); }
        if (rightDist == smallestDist)     { found.addAll(smallestRight); }
        if (intersectDist == smallestDist) { found.addAll(smallestIntersection); }

        return found;
    }

    public static List<Pair<Coordinate,Coordinate>> findClosestCoords(List<Coordinate> coordinates)
    {
        List<Pair<Coordinate,Coordinate>> closestCoords = new ArrayList<Pair<Coordinate,Coordinate>>();

        if (coordinates.size() == 2) { // base case 1
            Coordinate coord1 = coordinates.get(0);
            Coordinate coord2 = coordinates.get(1);

            List<Pair<Coordinate,Coordinate>> closestPairs = new ArrayList<Pair<Coordinate,Coordinate>>();
            closestPairs.add(new Pair<Coordinate,Coordinate>(coord1, coord2));
            return closestPairs;
        } else if (coordinates.size() == 3) { // base case 2
                return bruteforce(coordinates);
        } else {
            List<Coordinate> left = coordinates.subList(0, coordinates.size()/2);
            List<Coordinate> right = coordinates.subList(coordinates.size()/2, coordinates.size());

            List<Pair<Coordinate,Coordinate>> leftPairs = findClosestCoords(left);
            List<Pair<Coordinate,Coordinate>> rightPairs = findClosestCoords(right);

            double leftDist = Utilities.distanceFormula(leftPairs.get(0).getL(), leftPairs.get(0).getR());
            double rightDist = Utilities.distanceFormula(rightPairs.get(0).getL(), rightPairs.get(0).getR());
            double middleDist = Utilities.distanceFormula(leftPairs.get(0).getR(), rightPairs.get(0).getL());

            double min = Math.min(leftDist, Math.min(rightDist, middleDist));

            if (leftDist == min) {
                closestCoords.addAll(leftPairs);
            } else if (rightDist == min) {
                closestCoords.addAll(rightPairs);
            } else if (middleDist == min) {
                closestCoords.add(new Pair<Coordinate,Coordinate>(leftPairs.get(0).getR(),rightPairs.get(0).getL()));
            }

            return closestCoords;
        }
    }

    public static List<Pair<Coordinate,Coordinate>> findIntersection(List<Coordinate> left, List<Coordinate> right, double dist)
    {
        List<Coordinate> intersection = new ArrayList<Coordinate>();
        List<Pair<Coordinate,Coordinate>> closePairs = new ArrayList<Pair<Coordinate,Coordinate>>();

        double line = (right.get(0).getX() + left.get(left.size() - 1).getX() ) / 2;

        for (int i = 0; i < left.size() && i < right.size(); i++) {
            boolean moreRight = right.get(i).getX() - line < dist;
            boolean moreLeft = line - left.get(left.size() - 1 - i).getX() < dist;

            if (moreRight)
                intersection.add(right.get(i));
            if (moreLeft)
                intersection.add(left.get(left.size() - 1 - i));
            if (!moreRight && !moreLeft)
                break;
        }

        Collections.sort(intersection, new Comparator<Coordinate>() {
            public int compare(Coordinate coord1, Coordinate coord2)
            {
                final double DX = coord1.getX() - coord2.getX();
                final double DY = coord1.getY() - coord2.getY();

                if (DY > 0)     { return  1; }
                else if(DY < 0) { return -1; }
                else if(DX > 0) { return  1; }
                else if(DX < 0) { return -1; }
                else            { return  0; }
            }
        });

        for (int i = 0; i < intersection.size() - 1; i++) {
            Coordinate coord1 = intersection.get(i);
            Coordinate coord2 = intersection.get(i+1);

            if(coord2.getY() - coord1.getY() > dist) {
                closePairs.add(new Pair<Coordinate,Coordinate>(coord1,coord2));
            }
        }
        return closePairs;
    }

    public static List<Pair<Coordinate,Coordinate>> bruteforce(List<Coordinate> coordinates)
    {
        List<Pair<Coordinate,Coordinate>> found = new ArrayList<Pair<Coordinate,Coordinate>>();

        double currentSmallestDist = Double.MAX_VALUE;

        for (int i = 0; i < coordinates.size(); i++) { // foreach point
            Coordinate coord1 = coordinates.get(i);
            for (int k = i + 1; k < coordinates.size(); k++) { // foreach subsequent point
                Coordinate coord2 = coordinates.get(k);

                double dist = Utilities.distanceFormula(coord1, coord2);

                if (dist < currentSmallestDist) {
                    currentSmallestDist = dist;
                    found.clear();
                } if (dist == currentSmallestDist) {
                    found.add(new Pair<Coordinate,Coordinate>(coord1, coord2));
                }
            }
        }

        return found;
    }
}
