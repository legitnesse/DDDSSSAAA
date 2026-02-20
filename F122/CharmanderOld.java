package F122;

public class CharmanderOld 
{
    private int HP;

    public CharmanderOld()
    {
        HP = 50;
    }

    public int getHP()
    {
        return HP;
    }
    public void setHP(int newHP)
    {
        HP = newHP;
    }
    public String scratch(CharmanderOld ch)
    {
        ch.setHP(ch.getHP() - 10);
        return(this + " scratched " + ch + " for 10 damage.");
    }
}
