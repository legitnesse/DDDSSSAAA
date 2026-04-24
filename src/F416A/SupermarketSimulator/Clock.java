package F416A.SupermarketSimulator;

//I decided that having a shared Clock object would be more convenient than passing around an integer clock field of the SupermarketSimulator class.
public class Clock 
{
    private int time;
    
    public Clock()
    {
        time = 0;
    }

    public int getTime()
    {
        return time;
    }
    public void increment()
    {
        time += 1;
    }
}
