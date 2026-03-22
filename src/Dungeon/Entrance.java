public class Entrance extends Room
{
    public void print()
    {
        if(doesHavePlayer())
        {
            System.out.print("[IY]");
        }
        else
        {
            System.out.print("[I]");
        }
    }
}
