package F430;

public class premiumRecipient implements canReceive
{
    private String name;
    public premiumRecipient(String name)
    {
        this.name = name;
    }
    public void update(Object o)
    {
        if(o instanceof Newspaper)
        {
            System.out.println("To: " + name);
            System.out.println(((Newspaper)o).getContent());
        }
    }
}
