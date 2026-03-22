package F319;

public class Person 
{
    private String name;
    private boolean isValued;
    
    public Person(String name, boolean isValued)
    {
        this.name = name;
        this.isValued = isValued;
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public boolean getValue()
    {
        return isValued;
    }
    public void setValue(boolean isValued)
    {
        this.isValued = isValued;
    }
}
