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
    public int compareTo(Coordinate coord2)
    {
        final double DX = this.x - coord2.getX();
        final double DY = this.y - coord2.getY();

        if (DX > 0)
            return 1;
        else if(DX < 0)
            return -1;
        else if(DY > 0)
            return 1;
        else if(DY < 0)
            return -1;
        else
            return 0;
    }

    @Override
    public String toString()
    {
        return this.x + " " + this.y;
    }
}