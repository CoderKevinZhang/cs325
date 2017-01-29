import java.util.*;
import java.io.*;
import java.lang.Double;

public class Bruteforce
{
    // List of coordinates
    public static List<Coordinate> coordinateList;

    public static double smallestDist = Double.MAX_VALUE;
    public static List<Pair<Coordinate,Coordinate>> foundCoordinates;

    public static void main(String[] args)
    {
        if(args.length != 1) {
            System.out.println("Usage: java Bruteforce [example.input]");
            return;
        }

        File inputFile = new File(args[0]);
        try {
            // get all pairs from input file
            coordinateList = Utilities.readFile(inputFile);
        }
        catch(IOException ioe) {
            //handle excemption
        }

        // find closest pairs
        foundCoordinates = findCoordinates(coordinateList);

        Utilities.printPoints(smallestDist, foundCoordinates);
    }

    /**
     * Iterates over list of points to retieve the set of
     * point pairs which have the smallest distance
     * between them
     *
     * Algorithm performance: O(n^2)
     *
     * @param  list The list of coordinates
     * @return list The list of point pairs seperated by
     *              the smallest found distance
     */
    public static List<Pair<Coordinate,Coordinate>> findCoordinates(List<Coordinate> coordinates)
    {
        List<Pair<Coordinate,Coordinate>> found = new ArrayList<Pair<Coordinate,Coordinate>>();

        for (int i = 0; i < coordinates.size(); i++) { // foreach point
            Coordinate coord1 = coordinates.get(i);
            for (int k = i + 1; k < coordinates.size(); k++) { // foreach subsequent point
                Coordinate coord2 = coordinates.get(k);

                // distance formula for the two points
                double x = coord2.getX() - coord1.getX();
                double y = coord2.getY() - coord1.getY();
                double dist = Math.sqrt(Math.pow(x,2.0) + Math.pow(y,2.0));

                if (dist < smallestDist) {
                    smallestDist = dist;
                    found.clear();
                }
                if (dist == smallestDist) {
                    found.add(new Pair<Coordinate,Coordinate>(coord1, coord2));
                }
            }
        }

        return found;
    }
}
