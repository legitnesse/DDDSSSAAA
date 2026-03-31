public class ContentRoom extends Room
{
    private Enemy enemy;
    private CircularDoublyLinkedList<Item> items;

    public ContentRoom(int floor)
    {
        if(GameUtility.random.nextInt(0, 100) < 50)
        {
            enemy = new Enemy(floor);
        }
        else
        {
            enemy = null;
        }
        
        items = new CircularDoublyLinkedList<Item>();
        int numberOfItems = GameUtility.random.nextInt(0, 3);
        for(int i = 0; i < numberOfItems; i++)
        {
            int itemType = GameUtility.random.nextInt(0, 4);
            int amount = GameUtility.random.nextInt(10, 21) * (floor + 10);
            if(itemType == 0)
            {
                items.addLast(new HealthBooster(amount));
            }
            else if(itemType == 1)
            {
                items.addLast(new StrengthBooster(amount));
            }
            else if(itemType == 2)
            {
                items.addLast(new SpeedBooster(amount));
            }
            else
            {
                items.addLast(new MoneyBooster(amount));
            }
        }
    }

    public void print()
    {
        System.out.print("[");
        if(doesHavePlayer())
        {
            System.out.print("Y");
        }
        else if(enemy != null)
        {
            System.out.print("X");
        }
        else 
        {
            System.out.print(" ");
        }
        System.out.print("]");
    }
    
    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public CircularDoublyLinkedList<Item> getItems() {
        return items;
    }

    public void setItems(CircularDoublyLinkedList<Item> items) {
        this.items = items;
    }
}