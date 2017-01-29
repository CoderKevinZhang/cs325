import java.util.*;
import java.io.*;

public class Utilities
{
    /**
     * Reads a file with inputs coordinates and stores the
     * coordinates in pairList
     *
     * @param  file The file containing the input coordinates
     * @return list The list of coordinates
     */
    public static List<Pair<Integer,Integer>> readFile(File fin) throws IOException
    {
        List<Pair<Integer,Integer>> pairList = new ArrayList<Pair<Integer,Integer>>();

        FileInputStream fis = new FileInputStream(fin);

        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line = null;
        while ((line = br.readLine()) != null) {
            String[] coord = line.split(" ");
            int a = Integer.parseInt(coord[0]);
            int b = Integer.parseInt(coord[1]);

            pairList.add(new Pair<Integer,Integer>(a,b));
        }

        br.close();

        return pairList;
    }

    public static void printPoints(double smallestDist, List<Pair<Pair<Integer,Integer>,Pair<Integer,Integer>>> foundPairs)
    {
        // output matching format given in assignment
        System.out.println(smallestDist);
        for (int i = 0; i < foundPairs.size(); i++) {
            Pair<Integer,Integer> coord1 = foundPairs.get(i).getL();
            Pair<Integer,Integer> coord2 = foundPairs.get(i).getR();

            System.out.println(coord1.getL() + " " + coord1.getR()
            + " " + coord2.getL() + " " + coord2.getR());
        }
    }
}
