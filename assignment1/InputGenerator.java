import java.util.*;
import java.io.*;

public class InputGenerator
{
    public static void main(String[] args)
    {
        if (args.length < 2) {
            System.out.println("Usage: java InputGenerator [lines] [FileName]");
            return;
        }

        final int LINES = Integer.parseInt(args[0]);
        final int MAX_VALUE = 1000;
        Random rn = new Random();
        try {
            PrintWriter writer = new PrintWriter(args[1], "UTF-8");
            for (int i = 0; i < LINES; i++) {
                int x = rn.nextInt(MAX_VALUE);
                int y = rn.nextInt(MAX_VALUE);

                /*
                if (x == y) {
                    i--;
                    continue;
                }
                */

                writer.println(x + " " + y);
            }
            writer.close();

        } catch(IOException ioe) {
            // handle exception
        }
    }
}