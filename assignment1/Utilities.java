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
    public static List<Coordinate> readFile(File fin) throws IOException
    {
        List<Coordinate> coordinateList = new ArrayList<Coordinate>();

        FileInputStream fis = new FileInputStream(fin);

        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line = null;
        while ((line = br.readLine()) != null) {
            String[] coord = line.split(" ");
            int a = Integer.parseInt(coord[0]);
            int b = Integer.parseInt(coord[1]);

            coordinateList.add(new Coordinate(a,b));
        }

        br.close();

        Collections.sort(coordinateList);

        return coordinateList;
    }

    public static void printPoints(double smallestDist, List<Pair<Coordinate,Coordinate>> foundCoordinates)
    {
        // output matching format given in assignment
        System.out.println(smallestDist);
        for (int i = 0; i < foundCoordinates.size(); i++) {
            Coordinate coord1 = foundCoordinates.get(i).getL();
            Coordinate coord2 = foundCoordinates.get(i).getR();

            System.out.println(coord1 + " " + coord2);
        }
    }
}
