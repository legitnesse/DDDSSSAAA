public class ItemsFactory 
{
    public static CircularDoublyLinkedList<Item> makeItems(int floorNumber)
    {
        CircularDoublyLinkedList<Item> items = new CircularDoublyLinkedList<>();
        for(int i = 0; i < GameUtility.random.nextInt(4); i++)
        {
            int type = GameUtility.random.nextInt(4);
            if(type == 0)
            {
                items.addLast(new HealthBooster(10 * floorNumber + 10));
            }
            else if(type == 1)
            {
                items.addLast(new StrengthBooster(10 * floorNumber + 10));
            }
            else if(type == 2)
            {
                items.addLast(new SpeedBooster(10 * floorNumber + 10));
            }
            else
            {
                items.addLast(new MoneyBooster(10 * floorNumber + 10));
            }
        }
        return items;
    }
}
