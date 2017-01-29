public class Coordinate
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

    public int compareTo(Coordinate compareCoord) {

        final int DX = this.x - compareCoord.getX();
        final int DY = this.y - compareCoord.getY();

        if (DX != 0)
            return DX;
        else if(DY != 0)
            return DY;
        else
            return 0;
    }
}