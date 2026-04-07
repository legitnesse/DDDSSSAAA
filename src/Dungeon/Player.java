public class Player extends Character
{
    private int numberOfEnemiesSlayed;
    public Player(String name)
    {
        super(name, 100, 20, 20, 0);
        numberOfEnemiesSlayed = 0;
    }

    public void print()
    {
        System.out.println(getName() + " has " + getHealth() + " health, " + getStrength() + " strength, " + getSpeed() + " speed, and " + getMoney() + " evil." + getName() + " has slayed " + numberOfEnemiesSlayed + " enemies.");
    }

    public void incrementNumberOfEnemiesSlayed()
    {
        numberOfEnemiesSlayed++;
    }
}