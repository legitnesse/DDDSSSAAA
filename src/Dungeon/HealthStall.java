public class HealthStall extends Room
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
            player.setHealth(player.getHealth() + payment);
            System.out.println(player.getName() + " exchanged " + payment + " evil for " + payment + " health.");
        }
                
    }
    public void print()
    {
        if(doesHavePlayer())
        {
            System.out.print("[HealthY]");
        }
        else
        {
            System.out.print("[Health]");
        }
    }
}
