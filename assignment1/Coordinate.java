public class Coordinate implements Comparable<Coordinate>
{
    public int x, y;

    public Coordinate(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX() { return this.x; }

    public int getY() { return this.y; }

    public void setX(int x) { this.x = x; }

    public void setY(int y) { this.y = y; }

    @Override
    public int compareTo(Coordinate coord2)
    {

        final int DX = this.x - coord2.getX();
        final int DY = this.y - coord2.getY();

        if (DX != 0)
            return DX;
        else if(DY != 0)
            return DY;
        else
            return 0;
    }
}