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
        }
                
    }
    public void print()
    {
        System.out.print("[Speed]");
    }
}
