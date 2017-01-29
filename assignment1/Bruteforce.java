import java.util.*;
import java.io.*;
import java.lang.Double;

public class Bruteforce
{
    // List of coordinates
    public static List<Pair<Integer,Integer>> pairList;

    public static double smallestDist = Double.MAX_VALUE;
    public static List<Pair<Pair<Integer,Integer>,Pair<Integer,Integer>>> foundPairs;

    public static void main(String[] args)
    {
        if(args.length != 1) {
            System.out.println("Usage: java Bruteforce [example.input]");
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
    public static List<Pair<Pair<Integer,Integer>,Pair<Integer,Integer>>> findPairs(List<Pair<Integer,Integer>> pairs)
    {
        List<Pair<Pair<Integer,Integer>,Pair<Integer,Integer>>> found = new ArrayList<Pair<Pair<Integer,Integer>,Pair<Integer,Integer>>>();

        for (int i = 0; i < pairs.size(); i++) { // foreach point
            Pair<Integer,Integer> coord1 = pairs.get(i);
            for (int k = i + 1; k < pairs.size(); k++) { // foreach subsequent point
                Pair<Integer,Integer> coord2 = pairs.get(k);

                // distance formula for the two points
                double x = coord2.getL() - coord1.getL();
                double y = coord2.getR() - coord1.getR();
                double dist = Math.sqrt(Math.pow(x,2.0) + Math.pow(y,2.0));

                if (dist < smallestDist) {
                    smallestDist = dist;
                    found.clear();
                }
                if (dist == smallestDist) {
                    found.add(new Pair<Pair<Integer,Integer>,Pair<Integer,Integer>>(coord1, coord2));
                }
            }
        }

        return found;
    }
}
