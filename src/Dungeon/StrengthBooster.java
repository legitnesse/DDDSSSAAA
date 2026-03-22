public class StrengthBooster extends Item
{
    private static String[] names = {"Strength Potion"};

    public StrengthBooster(int amount)
    {
        super(getRandomName(), amount);
    }

    public void use(Character character)
    {
        character.setStrength(character.getStrength() + getAmount());
        System.out.println(character.getName() + " used a " + getName() + " and gained " + getAmount() + " strength!");
    }

    public static String getRandomName()
    {
        return names[GameUtility.random.nextInt(0, names.length)];
    }
}