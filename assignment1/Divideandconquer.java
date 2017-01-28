import java.util.*;
import java.io.*;
import java.lang.Double;

public class Divideandconquer
{
    // List of coordinates
    public static List<Pair<Integer,Integer>> pairList;

    public static double smallestDist = Double.MAX_VALUE;
    public static List<Pair<Pair<Integer,Integer>,Pair<Integer,Integer>>> foundPairs;

    public static void main(String[] args)
    {
        if(args.length != 1) {
            System.out.println("Usage: java Divideandconquer [example.input]");
            return;
        }

        File inputFile = new File(args[0]);
        try {
            pairList = Utilities.readFile(inputFile);
        }
        catch(IOException ioe) {
            //handle excemption
        }

        foundPairs = findPairs(pairList);
        System.out.println(smallestDist);

        for (int i = 0; i < foundPairs.size(); i++) {
            System.out.println(foundPairs.get(i).getL().getL() + " " + foundPairs.get(i).getL().getR()
            + " " + foundPairs.get(i).getR().getL() + " " + foundPairs.get(i).getR().getR());
        }
    }

    public static List<Pair<Pair<Integer,Integer>,Pair<Integer,Integer>>> findPairs(List<Pair<Integer,Integer>> pairs)
    {
        List<Pair<Pair<Integer,Integer>,Pair<Integer,Integer>>> found = new ArrayList<Pair<Pair<Integer,Integer>,Pair<Integer,Integer>>>();

        /*
         * Algorithm Goes Here
         */

        return found;
    }
}
