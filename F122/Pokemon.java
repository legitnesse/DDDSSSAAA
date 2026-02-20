package F122;

public class Pokemon 
{
    private String name;
    private int HP;

    public Pokemon(String inputName, int inputHP)
    {
        name = inputName;
        HP = inputHP;
    }
    public int getHP()
    {
        return HP;
    }
    public void setHP(int newHP)
    {
        HP = newHP;
    }
    public void printHP()
    {
        System.out.println(getName() + " has " + getHP() + " HP.");
    }
    public String getName()
    {
        return name;
    }
    public void attack(Pokemon p)
    {
        
    }    
    public Boolean equals(Pokemon p)
    {
        if(HP == p.getHP() && getClass() == p.getClass())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public String toString()
    {
        return getClass().toString().substring(6);
    }
    public int compare(Object o)
    {
        Pokemon p2 = (Pokemon) o;
        if(HP < p2.getHP())
        {
            return -1;
        }
        else if (HP > p2.getHP())
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}
