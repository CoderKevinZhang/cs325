import java.util.*;
import java.io.*;
import java.lang.Double;

public class Bruteforce2
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

        for (int i = 0; i < pairs.size(); i++) {
            Pair<Integer,Integer> coord1 = pairs.get(i);
            for (int k = i + 1; k < pairs.size(); k++) {
                Pair<Integer,Integer> coord2 = pairs.get(k);

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
