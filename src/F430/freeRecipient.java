package F430;

public class freeRecipient implements canReceive
{
    private String name;
    public freeRecipient(String name)
    {
        this.name = name;
    }
    public void update(Object o)
    {
        if(o instanceof Newspaper && !((Newspaper)o).isForPremium())
        {
            System.out.println("To: " + name);
            System.out.println(((Newspaper)o).getContent());
        }
    }
}
