import java.util.Comparator;

public class Coordinate implements Comparable<Coordinate>
{
    public double x, y;

    public Coordinate(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public double getX() { return this.x; }
    public double getY() { return this.y; }

    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        } else if(obj instanceof Coordinate) {
            Coordinate coord2 = (Coordinate) obj;
            if((coord2.getX() == this.getX() && coord2.getY() == this.getY()))
                return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        double k1 = Double.hashCode(this.getX());
        double k2 = Double.hashCode(this.getY());

        // Canton pairing function
        return (int) (0.5 * (k1 + k2) * (k1 + k2 + 1) + k2);
    }

    @Override
    public int compareTo(Coordinate coord2)
    {
        final double DX = this.getX() - coord2.getX();
        final double DY = this.getY() - coord2.getY();

             if(DX > 0) { return  1; }
        else if(DX < 0) { return -1; }
        else if(DY > 0) { return  1; }
        else if(DY < 0) { return -1; }
        else            { return  0; }
    }

    public static Comparator<Coordinate> compareX = new Comparator<Coordinate>()
    {
        public int compare(Coordinate coord1, Coordinate coord2)
        {
            final double DX = coord1.getX() - coord2.getX();
            final double DY = coord1.getY() - coord2.getY();

                 if(DX > 0) { return  1; }
            else if(DX < 0) { return -1; }
            else if(DY > 0) { return  1; }
            else if(DY < 0) { return -1; }
            else            { return  0; }
        }
    };

    public static Comparator<Coordinate> compareY = new Comparator<Coordinate>()
    {
        public int compare(Coordinate coord1, Coordinate coord2)
        {
            final double DX = coord1.getX() - coord2.getX();
            final double DY = coord1.getY() - coord2.getY();

                 if(DY > 0) { return  1; }
            else if(DY < 0) { return -1; }
            else if(DX > 0) { return  1; }
            else if(DX < 0) { return -1; }
            else            { return  0; }
        }
    };

    @Override
    public String toString()
    {
        return this.x + " " + this.y;
    }
}
