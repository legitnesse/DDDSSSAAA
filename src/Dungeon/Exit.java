public class Exit extends Room
{
    public void print()
    {
        if(doesHavePlayer())
        {
            System.out.print("[YO]");
        }
        else
        {
            System.out.print("[O]");
        }
    }
}
