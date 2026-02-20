package F212;

public class StringLinkedListTrain 
{
    private StringCabin headCabin;

    public StringLinkedListTrain()
    {
        headCabin = null;
    }
    public void addPassenger(String inputPassengerName)
    {
        if(headCabin == null)
        {
            headCabin = new StringCabin();
            headCabin.setPassengerName(inputPassengerName);
        }
        else
        {
            StringCabin currentCabin = headCabin;
            while(currentCabin.getNextCabin() != null)
            {
                currentCabin = currentCabin.getNextCabin();
            }
            currentCabin.setNextCabin(new StringCabin());
            currentCabin = currentCabin.getNextCabin();
            currentCabin.setPassengerName(inputPassengerName);
        }
    }
    public void printTrain()
    {
        System.out.println("These are the passengers currently aboard the train: ");
        StringCabin currentCabin = headCabin;
        while(currentCabin != null)
        {
            System.out.println(currentCabin.getPassengerName());
            currentCabin = currentCabin.getNextCabin();
        }
    }
}
