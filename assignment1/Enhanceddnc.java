import java.util.*;
import java.io.*;
import java.lang.Double;

public class Enhanceddnc
{
    // List of coordinates
    public static List<Pair<Integer,Integer>> pairList;

    public static double smallestDist = Double.MAX_VALUE;
    public static List<Pair<Pair<Integer,Integer>,Pair<Integer,Integer>>> foundPairs;

    public static void main(String[] args)
    {
        if(args.length != 1) {
            System.out.println("Usage: java Enhanceddnc [example.input]");
            return;
        }

        File inputFile = new File(args[0]);
        try {
            // get all pairs from input file
            pairList = Utilities.readFile(inputFile);
        }
        catch(IOException ioe) {
            //handle excemption
        }

        // find closest pairs
        foundPairs = findPairs(pairList);

        Utilities.printPoints(smallestDist, foundPairs);
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
    public static List<Pair<Pair<Integer,Integer>,Pair<Integer,Integer>>> findPairs(List<Pair<Integer,Integer>> pairs)
    {
        List<Pair<Pair<Integer,Integer>,Pair<Integer,Integer>>> found = new ArrayList<Pair<Pair<Integer,Integer>,Pair<Integer,Integer>>>();

        /* Algorthim goes HERE */

        return found;
    }
}
