
import java.util.*;
import java.io.*;

public class Utilities
{
    /**
     * Returns the distance between two coordinate points
     *
     * @param  coord1 First point
     * @param  coord2 Second point
     * @return double the distance between the two points
     */
    public static double distanceFormula(Coordinate coord1, Coordinate coord2)
    {
        double x = coord2.getX() - coord1.getX();
        double y = coord2.getY() - coord1.getY();
        double dist = Math.sqrt(Math.pow(x,2.0) + Math.pow(y,2.0));

        return dist;
    }

    /**
     * Reads a file with inputs coordinates and stores the
     * coordinates in a list
     *
     * @param  fin  The file containing the input coordinates
     * @return List The list of coordinates
     */
    public static List<Coordinate> readFile(File fin) throws IOException
    {
        List<Coordinate> coordinateList = new ArrayList<Coordinate>();

        FileInputStream fis = new FileInputStream(fin);

        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line = null;
        while ((line = br.readLine()) != null) {
            String[] coord = line.split(" ");
            double x = Double.parseDouble(coord[0]);
            double y = Double.parseDouble(coord[1]);

            coordinateList.add(new Coordinate(x,y));
        }

        br.close();

        Collections.sort(coordinateList, Coordinate.compareX);

        return coordinateList;
    }

    /**
     * Prints a list of pairs of coordinates and the
     * distance between them to the console console
     *
     * @param  dist             The distance between every pair of
     *                          coordinates in the list
     * @param  foundCoordinates A list of coordinates
     */
    public static void printPoints(double dist, List<Pair<Coordinate,Coordinate>> foundCoordinates)
    {
        // output matching format given in assignment
        System.out.println(dist);
        for (int i = 0; i < foundCoordinates.size(); i++) {
            Coordinate coord1 = foundCoordinates.get(i).getL();
            Coordinate coord2 = foundCoordinates.get(i).getR();

            System.out.println(coord1 + " " + coord2);
        }
    }
    /**
     * Prints a set of pairs of coordinates and the
     * distance between them to the console console
     *
     * @param  dist             The distance between every pair of
     *                          coordinates in the list
     * @param  foundCoordinates A set of coordinates
     */
    public static void printPoints(double dist, Set<Pair<Coordinate,Coordinate>> foundCoordinates)
    {
        // output matching format given in assignment
        System.out.println(dist);
        for (Pair<Coordinate,Coordinate> i : foundCoordinates) {
            Coordinate coord1 = i.getL();
            Coordinate coord2 = i.getR();

            System.out.println(coord1 + " " + coord2);
        }
    }
}
