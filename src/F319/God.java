package F319;

public class God 
{
    private int secretNumber = 6;

    private static God theOneTrueGod = new God();

    private God(){}
    
    public int getSecretNumber()
    {
        return secretNumber;
    }
    public static God getGod()
    {
        if(theOneTrueGod == null)
        {
            theOneTrueGod = new God();
        }
        return theOneTrueGod;
    }
    
}
