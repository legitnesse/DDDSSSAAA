public class StrengthStall extends Room
{
    public void purchase(int payment, Player player)
    {
        if(payment > player.getMoney())
        {
            System.out.println("You only have " + player.getMoney() + " evil.");
        }
        else
        {
            player.setMoney(player.getMoney() - payment);
            player.setStrength(player.getStrength() + payment);
        }
                
    }
    public void print()
    {
        if(doesHavePlayer())
        {
            System.out.print("[Strength^]");
        }
        else
        {
            System.out.print("[Strength]");
        }
    }
}
