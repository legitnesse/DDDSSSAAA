public class MoneyBooster extends Item
{
    private static String[] names = {"Treasure chest"};
    public MoneyBooster(int amount)
    {
        super(getRandomName(), amount);
    }

    public void use(Character character)
    {
        character.setMoney(character.getMoney() + getAmount());
        System.out.println(character.getName() + " found a " + getName() + " worth " + getAmount() + " evil!");
    }

    public static String getRandomName()
    {
        return names[GameUtility.random.nextInt(0, names.length)];
    }
}
