public class SpeedStall extends Room
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
            player.setSpeed(player.getSpeed() + payment);
            System.out.println(player.getName() + " exchanged " + payment + " evil for " + payment + " speed.");
        }
                
    }
    public void print()
    {
        if(doesHavePlayer())
        {
            System.out.print("[SpeedY]");
        }
        else
        {
            System.out.print("[Speed]");
        }
    }
}
