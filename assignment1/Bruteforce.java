import java.util.*;
import java.io.*;

public class Bruteforce
{
    public static List<Pair<Integer,Integer>> pairList = new ArrayList<Pair<Integer,Integer>>();

    public static void main(String[] args)
    {
        if(args.length != 1) {
            System.out.println("Usage: java Bruteforce [example.input]");
            return;
        }

        File inputFile = new File(args[0]);
        try {
            readFile(inputFile);
        }
        catch(IOException ioe) {
            //handle excemption
        }

        // works
        for (Pair<Integer,Integer> element : pairList) {
            System.out.println(element.getL() + "," + element.getR());
        }
    }

    private static void readFile(File fin) throws IOException {
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
    }
}
