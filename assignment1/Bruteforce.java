import java.util.*;
import java.io.*;

public class Bruteforce
{
    // List of coordinates
    //public static List<Pair<Integer,Integer>> pairList = new ArrayList<Pair<Integer,Integer>>();
    public static List<Pair<Integer,Integer>> pairList;

    public static void main(String[] args)
    {
        if(args.length != 1) {
            System.out.println("Usage: java Bruteforce [example.input]");
            return;
        }

        File inputFile = new File(args[0]);
        try {
            //readFile(inputFile);
            pairList = Utilities.readFile(inputFile);
        }
        catch(IOException ioe) {
            //handle excemption
        }

        // iterate over loaded coordinates
        for (Pair<Integer,Integer> element : pairList) {
            // getL returns x and getR returns y
            System.out.println(element.getL() + "," + element.getR());
        }
    }
}
