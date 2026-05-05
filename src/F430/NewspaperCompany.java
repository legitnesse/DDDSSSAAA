package F430;

import java.util.ArrayList;

public class NewspaperCompany 
{
    public ArrayList<canReceive> recipients;

    public NewspaperCompany()
    {
        recipients = new ArrayList<>();
    }

    public void registerObserver(canReceive o)
    {
        if(!recipients.contains(o))
        {
            recipients.add(o);
        }
    }
    public void unregisterObserver(canReceive o)
    {
        if(recipients.contains(o))
        {
            recipients.remove(o);
        }
    }
    public void notifyObservers(Newspaper n)
    {
        for(canReceive cr : recipients)
        {
            cr.update(n);
        }
    }
}
