package F122;

public class Bulbasaur extends Pokemon
{
    public Bulbasaur(String inputName)
    {
        super(inputName, 70);
    }
    public void printAttack(Pokemon target)
    {
        System.out.println(getName() + " Leech Seeded " + target.getName() + " for 20 DMG.");
    }
    public void attack(Pokemon p)
    {
        p.setHP(p.getHP() - 20);
        printAttack(p);
    }
}
