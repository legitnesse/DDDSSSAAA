public class HealthBooster extends Item
{
    private static String[] names = {"Health Potion"};

    public HealthBooster(int amount)
    {
        super(getRandomName(), amount);
    }

    public void use(Character character)
    {
        character.setHealth(character.getHealth() + getAmount());
        System.out.println(character.getName() + " used a " + getName() + " and gained " + getAmount() + " health!");
    }

    public static String getRandomName()
    {
        return names[GameUtility.random.nextInt(0, names.length)];
    }
}