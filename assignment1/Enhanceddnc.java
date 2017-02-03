
import java.util.*;
import java.io.*;
import java.lang.Double;

public class Enhanceddnc
{
    // List of coordinates
    //public static List<Coordinate> coordinateList;
    public static List<Coordinate> coordinateListX;
    public static List<Coordinate> coordinateListY;

    public static double smallestDist;
    public static Set<Pair<Coordinate,Coordinate>> foundCoordinates;

    public static void main(String[] args)
    {
        if(args.length != 1) {
            System.out.println("Usage: java Enhanceddnc [example.input]");
            return;
        }

        File inputFile = new File(args[0]);
        try {
            coordinateListX = Utilities.readFile(inputFile);
            coordinateListY = new ArrayList<Coordinate>();
            coordinateListY.addAll(coordinateListX);
            Collections.sort(coordinateListY, Coordinate.compareY);
        }
        catch(IOException ioe) {
            //handle exception
        }

        // find closest pairs
        foundCoordinates = ClosestPair(coordinateListX, coordinateListY);

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
    public static Set<Pair<Coordinate,Coordinate>> ClosestPair(List<Coordinate> coordinateListX,
            List<Coordinate> coordinateListY) {
        Set<Pair<Coordinate,Coordinate>> closestPairs = new HashSet<Pair<Coordinate,Coordinate>>();

        if (coordinateListX.size() <= 3) {
            return bruteforce(coordinateListX);
        } else {
            List<Coordinate> left  = coordinateListX.subList(0, coordinateListX.size()/2);
            List<Coordinate> right = coordinateListX.subList(coordinateListX.size()/2, coordinateListX.size());

            Set<Pair<Coordinate,Coordinate>> leftPairs  = ClosestPair(left, coordinateListY);
            Set<Pair<Coordinate,Coordinate>> rightPairs = ClosestPair(right, coordinateListY);

            double leftDist  = Utilities.distanceFormula(leftPairs.iterator().next().getL(),  leftPairs.iterator().next().getR());
            double rightDist = Utilities.distanceFormula(rightPairs.iterator().next().getL(), rightPairs.iterator().next().getR());
            double min = Math.min(leftDist, rightDist);

            Set<Pair<Coordinate,Coordinate>> middle = findIntersection(left, right, coordinateListY, min);

            double middleDist = Double.MAX_VALUE;
            if (middle.size() > 0)
                middleDist = Utilities.distanceFormula(middle.iterator().next().getL(), middle.iterator().next().getR());

            smallestDist = Math.min(min, middleDist);

            if (leftDist   == smallestDist) { closestPairs.addAll(leftPairs);  }
            if (middleDist == smallestDist) { closestPairs.addAll(middle);     }
            if (rightDist  == smallestDist) { closestPairs.addAll(rightPairs); }
        }
        return closestPairs;
    }

    public static Set<Pair<Coordinate,Coordinate>> findIntersection(List<Coordinate> left, List<Coordinate> right,
            List<Coordinate> coordinateListY, double min)
    {
        List<Coordinate> middle = new ArrayList<Coordinate>();
        Set<Pair<Coordinate,Coordinate>> middlePairs = new HashSet<Pair<Coordinate,Coordinate>>();

        final Coordinate leftMiddle = left.get(left.size() - 1);
        final Coordinate rightMiddle = right.get(0);

        double line = ( leftMiddle.getX() + rightMiddle.getX() ) / 2;

        for (int i = 0; i < coordinateListY.size(); i++) {
            final Coordinate coord = coordinateListY.get(i);

            if(left.indexOf(coord) == -1 && right.indexOf(coord) == -1)
                continue;

            if ((line - coord.getX() <= min && line - coord.getX() >= 0)
                || (coord.getX() - line <= min && coord.getX() - line >= 0))
                middle.add(coord);
        }

        double middleMin = min;

        for (int i = 0; i + 1 < middle.size(); i++) {
            final Coordinate coord1 = middle.get(i);
            for(int k = i + 1; k < middle.size(); k++) {
                final Coordinate coord2 = middle.get(k);

                if(coord2.getY() - coord1.getY() > min)
                    break;

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

    public static Set<Pair<Coordinate,Coordinate>> bruteforce(List<Coordinate> coordinates)
    {
        Set<Pair<Coordinate,Coordinate>> found = new HashSet<Pair<Coordinate,Coordinate>>();

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
