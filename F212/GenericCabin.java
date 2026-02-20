package F212;

public class GenericCabin<T>
{
    private T passenger;
    private GenericCabin<T> nextCabin;

    public void setPassenger(T inputPassenger)
    {
        passenger = inputPassenger;
    }
    public T getPassenger()
    {
        return passenger;
    }
    public void setNextCabin(GenericCabin<T> inputCabin)
    {
        nextCabin = inputCabin;
    }
    public GenericCabin<T> getNextCabin()
    {
        return nextCabin;
    }    
}
