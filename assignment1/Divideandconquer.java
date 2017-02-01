
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
        foundCoordinates = ClosestPair(coordinateList);

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
    public static List<Pair<Coordinate,Coordinate>> ClosestPair(List<Coordinate> coordinateList) {
        List<Pair<Coordinate,Coordinate>> closestPairs = new ArrayList<Pair<Coordinate,Coordinate>>();

        if (coordinateList.size() <= 3) {
            return bruteforce(coordinateList);
        } else {
            List<Coordinate> left  = coordinateList.subList(0, coordinateList.size()/2);
            List<Coordinate> right = coordinateList.subList(coordinateList.size()/2, coordinateList.size());

            List<Pair<Coordinate,Coordinate>> leftPairs  = ClosestPair(left);
            List<Pair<Coordinate,Coordinate>> rightPairs = ClosestPair(right);

            double leftDist  = Utilities.distanceFormula(leftPairs.get(0).getL(),  leftPairs.get(0).getR());
            double rightDist = Utilities.distanceFormula(rightPairs.get(0).getL(), rightPairs.get(0).getR());
            double min = Math.min(leftDist, rightDist);

            List<Pair<Coordinate,Coordinate>> middle = findIntersection(left, right, min);

            double middleDist = Double.MAX_VALUE;
            if (middle.size() > 0)
                middleDist = Utilities.distanceFormula(middle.get(0).getL(), middle.get(0).getR());

            smallestDist = Math.min(min, middleDist);

            if (leftDist   == smallestDist) { closestPairs.addAll(leftPairs);  }
            if (middleDist == smallestDist) { closestPairs.addAll(middle);     }
            if (rightDist  == smallestDist) { closestPairs.addAll(rightPairs); }
        }
        return closestPairs;
    }

    public static List<Pair<Coordinate,Coordinate>> findIntersection(List<Coordinate> left, List<Coordinate> right, double min)
    {
        List<Coordinate> middle = new ArrayList<Coordinate>();
        List<Pair<Coordinate,Coordinate>> middlePairs = new ArrayList<Pair<Coordinate,Coordinate>>();

        final Coordinate leftMiddle = left.get(left.size() - 1);
        final Coordinate rightMiddle = right.get(0);

        double line = ( leftMiddle.getX() + rightMiddle.getX() ) / 2;

        for (int i = 0; i < left.size() || i < right.size(); i++) {
            boolean moreLeft = false, moreRight = false;

            if(i < left.size()) {
                final Coordinate nextLeft = left.get(left.size() - 1 - i);
                moreLeft = line - nextLeft.getX() <= min;

                if (moreLeft)  { middle.add(nextLeft);  }
            }
            if(i < right.size()) {
                final Coordinate nextRight = right.get(i);
                moreRight = nextRight.getX() - line <= min;

                if (moreRight) { middle.add(nextRight); }
            }

            if (!moreRight && !moreLeft)
                break;
        }

        Collections.sort(middle, Coordinate.compareY);
        double middleMin = min;

        for (int i = 0; i + 1 < middle.size(); i++) {
            final Coordinate coord1 = middle.get(i);
            final Coordinate coord2 = middle.get(i+1);

            if(coord2.getY() - coord1.getY() <= middleMin) {
                double dist = Utilities.distanceFormula(coord1, coord2);

                if(dist < middleMin) {
                    middleMin = dist;
                    middlePairs.clear();
                }
                if(dist == middleMin) {
                    middlePairs.add(new Pair<Coordinate,Coordinate>(coord1,coord2));
                }
            }
        }
        return middlePairs;
    }

    public static List<Pair<Coordinate,Coordinate>> bruteforce(List<Coordinate> coordinates)
    {
        List<Pair<Coordinate,Coordinate>> found = new ArrayList<Pair<Coordinate,Coordinate>>();

        double currentSmallestDist = Double.MAX_VALUE;

        for (int i = 0; i < coordinates.size(); i++) { // foreach point
            final Coordinate coord1 = coordinates.get(i);
            for (int k = i + 1; k < coordinates.size(); k++) { // foreach subsequent point
                final Coordinate coord2 = coordinates.get(k);

                double dist = Utilities.distanceFormula(coord1, coord2);

                if (dist < currentSmallestDist) {
                    currentSmallestDist = dist;
                    found.clear();
                }
                if (dist == currentSmallestDist) {
                    found.add(new Pair<Coordinate,Coordinate>(coord1, coord2));
                }
            }
        }

        return found;
    }
}
