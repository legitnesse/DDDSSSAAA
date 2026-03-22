public class Enemy extends Character
{
    public Enemy(int floorNumber)
    {
        super("Enemy", 50 + (int) Math.pow(floorNumber, 2) * 10, 20 + (int) Math.pow(floorNumber, 2) * 10, 20 + (int) Math.pow(floorNumber, 2) * 10, 20 + (int) Math.pow(floorNumber, 2) * 10);
    }
}