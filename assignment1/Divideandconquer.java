import java.util.*;
import java.io.*;
import java.lang.Double;

public class Divideandconquer
{
    // List of coordinates
    public static List<Coordinate> coordinateList;

    public static double smallestDist = Double.MAX_VALUE;
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
            //handle excemption
        }

        // find closest pairs
        foundCoordinates = findCoordinates(coordinateList);

        //Utilities.printPoints(smallestDist, foundCoordinates);
    }

    /**
     * ???
     *
     * Algorithm performance: O(?)
     *
     * @param  list The list of coordinates
     * @return list The list of point pairs seperated by
     *              the smallest found distance
     */
    public static List<Pair<Coordinate,Coordinate>> findCoordinates(List<Coordinate> coordinates)
    {
        List<Pair<Coordinate,Coordinate>> found = new ArrayList<Pair<Coordinate,Coordinate>>();

        List<Coordinate> left = coordinateList.subList(0, coordinateList.size()/2);
        List<Coordinate> right = coordinateList.subList(coordinateList.size()/2 + 1, coordinateList.size());



        return found;
    }
}
