import java.util.ListIterator;

public class CircularFloor extends Floor
{
    CircularDoublyLinkedList<Room> rooms;
    ListIterator<Room> positionIterator;
    private int numberOfRooms;

    public CircularFloor(int floorNumber, Player player)
    {
        super(floorNumber, player);
        rooms = new CircularDoublyLinkedList<Room>();
        
        ListIterator<Room> roomsIterator = rooms.listIterator();
        numberOfRooms = GameUtility.random.nextInt(10, 25);
        rooms.addFirst(new Entrance());
        for(int i = 0; i < numberOfRooms; i++)
        {
            rooms.addLast(new ContentRoom(floorNumber));
            if(i == numberOfRooms/2)
            {
                rooms.addLast(new Exit());
            }
        }
        Room room = roomsIterator.next();
        room.setHasPlayer(true);
        while(roomsIterator.hasNext())
        {
            room = roomsIterator.next();
            if(room instanceof ContentRoom)
            {
                if(GameUtility.random.nextDouble() < 0.4)
                {
                    ((ContentRoom) room).setEnemy(new Enemy(floorNumber));
                }
                ((ContentRoom) room).setItems(ItemsFactory.makeItems(floorNumber));
            }
            
        }
        positionIterator = rooms.listIterator();
        positionIterator.next();
    }

    public boolean processInput(String input)
    {
        if(input.equalsIgnoreCase("L"))
        {   
            Room leftRoom = getLeftRoom();
            if(leftRoom instanceof ContentRoom)
            {
                Enemy leftEnemy = ((ContentRoom) leftRoom).getEnemy();
                if(leftEnemy != null)
                {
                    int battleResult = Character.battleOnce(getPlayer(), leftEnemy);
                    if(battleResult == -1)
                    {
                        Room currentRoom = getCurrentRoom();
                        currentRoom.setHasPlayer(false);
                        print();
                        return false;
                    }
                    else if(battleResult == 0)
                    {
                        return true;
                    }
                    else
                    {
                        ((ContentRoom) leftRoom).setEnemy(null);
                        enterLeftRoom();
                        print();
                        return true;
                    }
                }
                else
                {
                    enterLeftRoom();
                    print();
                    return true;
                }
            }
            else
            {
                enterLeftRoom();    
                print();              
                return true;
            }
        }
        else if(input.equalsIgnoreCase("R"))
        {
            Room rightRoom = getRightRoom();
            if(rightRoom instanceof ContentRoom)
            {                        
                Enemy rightEnemy = ((ContentRoom) rightRoom).getEnemy();
                if(rightEnemy != null)                    
                {
                    int battleResult = Character.battleOnce(getPlayer(), rightEnemy);
                    if(battleResult == -1)
                    {
                        Room currentRoom = getCurrentRoom();
                        currentRoom.setHasPlayer(false);                            
                        return false;
                    }
                    else if(battleResult == 0)
                    {
                        return true;
                    }
                    else                        
                    {                                
                        ((ContentRoom) rightRoom).setEnemy(null);
                        enterRightRoom();
                        print();
                        return true;
                    }
                }
                else                    
                {
                    enterRightRoom();
                    print();
                    return true;
                }
            }                
            else
            {
                enterRightRoom();         
                print();               
                return true;
            }
        } 
        else if(input.equalsIgnoreCase("PRINT"))
        {
            print();
            return true;
        }
        else
        {
            return true;
        }     
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
        if(leftRoom instanceof ContentRoom)
        {
            collectItems((ContentRoom) leftRoom);
        }
    }
    public void enterRightRoom()
    {
        Room currentRoom = getCurrentRoom();
        currentRoom.setHasPlayer(false);
        Room rightRoom = getRightRoom();
        rightRoom.setHasPlayer(true);
        positionIterator.next();
        if(rightRoom instanceof ContentRoom)
        {
            collectItems((ContentRoom) rightRoom);
        }
    }
    public void collectItems(ContentRoom room)
    {
        if(room.getItems() != null)
        {
            for(Item item : room.getItems())
            {
                item.use(getPlayer());
            }
            room.setItems(null);
        }
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