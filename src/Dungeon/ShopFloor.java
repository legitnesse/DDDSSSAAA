import java.util.ListIterator;

public class ShopFloor extends Floor
{
    private CircularDoublyLinkedList<Room> rooms;
    private ListIterator<Room> positionIterator;
    
    public ShopFloor(int floorNumber, Player player)
    {
        super(floorNumber, player);
        rooms = new CircularDoublyLinkedList<>();
        rooms.addFirst(new Entrance());
        rooms.addLast(new HealthStall());
        rooms.addLast(new StrengthStall());
        rooms.addLast(new SpeedStall());
        rooms.addLast(new Exit());

        positionIterator = rooms.listIterator();
        positionIterator.next().setHasPlayer(true);
    }

    public boolean processInput(String input)
    {
        if(input.equalsIgnoreCase("L"))
        {
            enterLeftRoom();
        }
        else if(input.equalsIgnoreCase("R"))
        {
            enterRightRoom();
        }
        else if(input.equalsIgnoreCase("PRINT"))
        {
            print();
            return true;
        }
        else
        {
            try
            {
                int payment = Integer.parseInt(input);
                Room currentRoom = getCurrentRoom();
                if(currentRoom instanceof HealthStall)
                {
                    ((HealthStall) currentRoom).purchase(payment, getPlayer());
                }
                else if(currentRoom instanceof StrengthStall)
                {
                    ((StrengthStall) currentRoom).purchase(payment, getPlayer());
                }
                else if(currentRoom instanceof SpeedStall)
                {
                    ((SpeedStall) currentRoom).purchase(payment, getPlayer());
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("That is not a valid input.");
            }
        }
        return true;
    }

    public void print()
    {
        for(Room room : rooms)
        {
            room.print();
        }
        System.out.println();
    }
    public void enterLeftRoom()
    {
        Room currentRoom = getCurrentRoom();
        currentRoom.setHasPlayer(false);
        Room leftRoom = getLeftRoom();
        leftRoom.setHasPlayer(true);
        positionIterator.previous();
    }
    public void enterRightRoom()
    {
        Room currentRoom = getCurrentRoom();
        currentRoom.setHasPlayer(false);
        Room rightRoom = getRightRoom();
        rightRoom.setHasPlayer(true);
        positionIterator.next();
    }
    public Room getCurrentRoom()
    {
        positionIterator.next();
        Room currentRoom = positionIterator.previous();
        return currentRoom;
    }
    public Room getLeftRoom()
    {
        Room leftRoom = positionIterator.previous();
        positionIterator.next();
        return leftRoom;
    }
    public Room getRightRoom()
    {
        Room rightRoom = positionIterator.next();
        positionIterator.previous();
        return rightRoom;
    }
}