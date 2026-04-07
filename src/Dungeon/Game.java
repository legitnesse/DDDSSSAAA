import java.util.ListIterator;

public class Game 
{
    private Player player;
    private CircularDoublyLinkedList<Floor> floors;
    private ListIterator<Floor> positionIterator;
    private int currentFloor;

    public Game(String playerName)
    {
        player = new Player(playerName);
        floors = new CircularDoublyLinkedList<>();
        positionIterator = floors.listIterator();
        currentFloor = 0;
        if(GameUtility.random.nextDouble() < 0.5)
        {
            floors.addLast(new CircularFloor(currentFloor, player));
        }
        else
        {
            floors.addLast(new RectangularFloor(currentFloor, player));
        }
        positionIterator.next();
    }

    public boolean processInput(String input)
    {
        if(input.equalsIgnoreCase("EXIT"))
        {
            if(getCurrentFloor().getCurrentRoom() instanceof Entrance)
            {
                if(currentFloor == 0)
                {
                    System.out.println("You cannot exit the dungeon.");
                }
                else
                {
                    positionIterator.previous();
                    currentFloor--;
                    getCurrentFloor().print();
                }
            }
            else if(getCurrentFloor().getCurrentRoom() instanceof Exit)
            {
                if(currentFloor == floors.size() - 1)
                {
                    addNextFloor(currentFloor + 1);
                }
                positionIterator.next();
                currentFloor++;
                getCurrentFloor().print();
                
            }
            System.out.println(player.getName() + " is on floor " + currentFloor);
        }
        else if(input.equalsIgnoreCase("STATS"))
        {
            player.print();
        }
        else
        {
            return getCurrentFloor().processInput(input);
        }
        return true;
    }

    public Floor getCurrentFloor()
    {
        positionIterator.next();
        Floor currentFloor = positionIterator.previous();
        return currentFloor;
    }
    public Floor getPreviousFloor()
    {
        Floor previousFloor = positionIterator.previous();
        positionIterator.next();
        return previousFloor;
    }
    public Floor getNextFloor()
    {
        Floor nextFloor = positionIterator.next();
        positionIterator.previous();
        return nextFloor;
    }

    private void addNextFloor(int nextFloorNumber)
    {
        if(floors.size() % 6 == 0)
        {
            floors.addLast(new ShopFloor(nextFloorNumber, player));
        }
        else if(GameUtility.random.nextDouble() < 0.5)
        {
            floors.addLast(new CircularFloor(nextFloorNumber, player));
        }
        else
        {
            floors.addLast(new RectangularFloor(nextFloorNumber, player));
        }
    }

    public Player getPlayer()
    {
        return player;
    }
}
