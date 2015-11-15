public class Point
{
    int x;
    int y;
    
    public Point()
    {
        x = 0;
        y = 0;
    }
    
    public Point(int X, int Y)
    {
        this.x = X;
        this.y = Y;
    }
    
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    
    public void setX(int X)
    {
        this.x = X;
    }
    public void setY(int Y)
    {
        this.y = Y;
    }
}
