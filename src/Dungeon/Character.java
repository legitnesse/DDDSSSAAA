public class Character
{
    private String name;
    private int health;
    private int strength;
    private int speed;
    private int money;

    public Character(String name, int health, int strength, int speed, int money)
    {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.speed = speed;
        this.money = money;
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public int getHealth()
    {
        return health;
    }
    public void setHealth(int health)
    {
        this.health = health;
    }
    public int getStrength()
    {
        return strength;
    }
    public void setStrength(int strength)
    {
        this.strength = strength;
    }
    public int getSpeed()
    {
        return speed;
    }
    public void setSpeed(int speed)
    {
        this.speed = speed;
    }
    public int getMoney()
    {
        return money;
    }
    public void setMoney(int money)
    {
        this.money = money;
    }

    public static int battleOnce(Player player, Enemy enemy)
    {
        Character first;
        Character second;
        if(player.getSpeed() >= enemy.getSpeed())
        {
            first = player;
            second = enemy;
        }
        else
        {
            first = enemy;
            second = player;
        }

        double speedRatio = (double) first.getSpeed() / second.getSpeed();
        double successfulAttackProbability = speedRatio / 2;
        if(GameUtility.random.nextDouble() < successfulAttackProbability)
        {
            System.out.println(second.getName() + " failed to dodge the attack by " + first.getName() + ", lowering their health from " + second.getHealth() + " by " + first.getStrength() + " to " + (second.getHealth() - first.getStrength()));
            second.setHealth(second.getHealth() - first.getStrength());
        }
        else
        {
            System.out.println(second.getName() + " managed to dodge the attack by " + first.getName() + ".");
        }
        if(second.getHealth() <= 0)
        {
            System.out.println(second.getName() + " died.");
            if(second == enemy)
            {
                return 1;
            }
            else
            {
                return -1;
            }
        }
        else
        {
            successfulAttackProbability = (1 / speedRatio) / 2;
            if(GameUtility.random.nextDouble() < successfulAttackProbability)
            {
                System.out.println(first.getName() + " failed to dodge the attack by " + second.getName() + ", lowering their health from " + first.getHealth() + " by " + second.getStrength() + " to " + (first.getHealth() - second.getStrength()));
                first.setHealth(first.getHealth() - second.getStrength());
            }
            else
            {
                System.out.println(first.getName() + " managed to dodge the attack by " + second.getName());
            }
            if(first.getHealth() <= 0)
            {
                System.out.println(first.getName() + " died.");
                if(first == enemy)
                {
                    return 1;
                }
                else
                {
                    return -1;
                }
            }
        }
        return 0;
    }
}