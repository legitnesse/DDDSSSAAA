package F212;

public class GenericLinkedListTrain<T>
{
    private GenericCabin<T> headCabin;

    public GenericLinkedListTrain()
    {
        headCabin = null;
    }

    public void addPassenger(T inputPassenger)
    {
        if(headCabin == null)
        {
            headCabin = new GenericCabin<T>();
            headCabin.setPassenger(inputPassenger);
        }
        else
        {
            GenericCabin<T> currentCabin = headCabin;
            while(currentCabin.getNextCabin() != null)
            {
                currentCabin = currentCabin.getNextCabin();
            }
            currentCabin.setNextCabin(new GenericCabin<T>());
            currentCabin = currentCabin.getNextCabin();
            currentCabin.setPassenger(inputPassenger);
        }
    }
    public void printTrain()
    {
        System.out.println("These are the current passengers aboard the train:");
        GenericCabin<T> currentCabin = headCabin;
        while(currentCabin != null)
        {
            System.out.println(currentCabin.getPassenger());
            currentCabin = currentCabin.getNextCabin();
        }
    }
}
