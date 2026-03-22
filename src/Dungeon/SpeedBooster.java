public class SpeedBooster extends Item
{
    private static String[] names = {"Speed Potion"};

    public SpeedBooster(int amount)
    {
        super(getRandomName(), amount);
    }

    public void use(Character character)
    {
        character.setSpeed(character.getSpeed() + getAmount());
        System.out.println(character.getName() + " used a " + getName() + " and gained " + getAmount() + " speed!");
    }

    public static String getRandomName()
    {
        return names[GameUtility.random.nextInt(0, names.length)];
    }
    
}
