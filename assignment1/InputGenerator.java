import java.util.*;
import java.io.*;

public class InputGenerator
{
    public static void main(String[] args)
    {
        if (args.length < 2) {
            System.out.println("Usage: java InputGenerator [n] [FileName]");
            return;
        }

        int n = Integer.parseInt(args[0]);
        Random rn = new Random();
        try {
            PrintWriter writer = new PrintWriter(args[1], "UTF-8");
            for (int i = 0; i < n; i++) {
                int x = rn.nextInt(10);
                int y = rn.nextInt(10);

                writer.println(x + " " + y);
            }
            writer.close();

        } catch(IOException ioe) {
            // handle exception
        }
    }
}