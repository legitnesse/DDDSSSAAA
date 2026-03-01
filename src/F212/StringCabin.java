package F212;

public class StringCabin 
{
    private String passengerName;
    private StringCabin nextCabin;

    public StringCabin()
    {
        passengerName = null;
        nextCabin = null;
    }

    public void setPassengerName(String inputPassengerName)
    {
        passengerName = inputPassengerName;
    }
    public String getPassengerName()
    {
        return passengerName;
    }
    public StringCabin getNextCabin()
    {
        return nextCabin;
    }
    public void setNextCabin(StringCabin inputCabin)
    {
        nextCabin = inputCabin;
    }
}
