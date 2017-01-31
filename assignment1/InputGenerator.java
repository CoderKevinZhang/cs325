import java.util.*;
import java.io.*;

public class InputGenerator
{
    public static List<Double> xs = new ArrayList<Double>();
    public static List<Double> ys = new ArrayList<Double>();
    //public static List<Integer> xs = new ArrayList<Integer>();
    //public static List<Integer> ys = new ArrayList<Integer>();

    public static void main(String[] args)
    {
        if (args.length < 2) {
            System.out.println("Usage: java InputGenerator [lines] [FileName]");
            return;
        }

        final int LINES = Integer.parseInt(args[0]);
        final int MAX_VALUE = 1000;
        //final int MAX_VALUE = Integer.MAX_VALUE;
        Random rn = new Random();
        try {
            PrintWriter writer = new PrintWriter(args[1], "UTF-8");
            for (int i = 0; i < LINES; i++) {
                //int x;
                //int y;
                double x;
                double y;

                do {
                    //x = rn.nextInt(MAX_VALUE);
                    x = MAX_VALUE * rn.nextDouble();
                } while (xs.contains(x));

                do {
                    //y = rn.nextInt(MAX_VALUE);
                    y = MAX_VALUE * rn.nextDouble();
                } while (ys.contains(y));

                xs.add(x);
                ys.add(y);

                writer.println(x + " " + y);
            }
            writer.close();

        } catch(IOException ioe) {
            // handle exception
        }
    }
}