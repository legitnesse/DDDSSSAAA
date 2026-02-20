package F129;

public class Kart implements Measurable
{
    private /*static*/ int numWheels;
    
    public Kart()
    {
        numWheels = 4;
    }
    public void setNumWheels(int nw)
    {
        numWheels = nw;
    }
    public int getNumWheels()
    {
        return numWheels;
    }
    public void tirePops()
    {
        numWheels--;
    }
    @Override
    public void measure()
    {
        System.out.println("wheels");
    }
}
