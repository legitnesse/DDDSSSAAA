package F122;

public class Squirtle extends Pokemon
{
   public Squirtle(String inputName)
    {
        super(inputName, 70);
    }
    public void printAttack(Pokemon target)
    {
        System.out.println(getName() + " Water Gunned " + target.getName() + " for 20 DMG.");
    }
    public void attack(Pokemon p)
    {
        p.setHP(p.getHP() - 20);
        printAttack(p);
    } 
}
