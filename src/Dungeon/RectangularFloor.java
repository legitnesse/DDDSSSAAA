public class RectangularFloor extends Floor
{
    private Room[][] rooms;
    private int rowOfCurrentRoom;
    private int columnOfCurrentRoom;
    private int floorNumber;
    private Player player;

    public RectangularFloor(int floorNumber, Player player)
    {
        super(floorNumber, player);
        rooms = new Room[GameUtility.random.nextInt(3, 7)][GameUtility.random.nextInt(3, 7)];
        for(int row = 0; row < rooms.length; row++)
        {
            for(int column = 0; column < rooms[0].length; column++)
            {
                rooms[row][column] = new ContentRoom(floorNumber);
            }
        }
        rooms[0][0] = new Entrance();
        rooms[0][0].setHasPlayer(true);
        rooms[rooms.length - 1][rooms[0].length -1] = new Exit();
        for(int row = 0; row < rooms.length; row++)
        {
            for(int column = 0; column < rooms[0].length; column++)
            {
                if(rooms[row][column] instanceof ContentRoom)
                {
                    if(GameUtility.random.nextDouble() < 0.4)
                    {
                        ((ContentRoom)rooms[row][column]).setEnemy(new Enemy(floorNumber));
                    }
                    ((ContentRoom)rooms[row][column]).setItems(ItemsFactory.makeItems(floorNumber));
                }
            }
        }
    }
    public boolean processInput(String input)
    {
        if(input.equalsIgnoreCase("L"))
        {
            if(columnOfCurrentRoom != 0)
            {
                Room leftRoom = rooms[rowOfCurrentRoom][columnOfCurrentRoom - 1];
                if(leftRoom instanceof ContentRoom)
                {
                    Enemy leftEnemy = ((ContentRoom)leftRoom).getEnemy();
                    if(leftEnemy != null)
                    {
                        int battleResult = Character.battleOnce(getPlayer(), leftEnemy);
                        if(battleResult == -1)
                        {
                            rooms[rowOfCurrentRoom][columnOfCurrentRoom].setHasPlayer(false);
                            return false;
                        }
                        else if(battleResult == 0)
                        {
                            return true;
                        }
                        else
                        {
                            ((ContentRoom)leftRoom).setEnemy(null);
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
            else
            {
                return true;
            }
        }
        else if(input.equalsIgnoreCase("R"))
        {
            if(columnOfCurrentRoom != rooms[0].length - 1)
            {
                Room rightRoom = rooms[rowOfCurrentRoom][columnOfCurrentRoom + 1];
                if(rightRoom instanceof ContentRoom)
                {
                    Enemy rightEnemy = ((ContentRoom)rightRoom).getEnemy();
                    if(rightEnemy != null)
                    {
                        int battleResult = Character.battleOnce(getPlayer(), rightEnemy);
                        if(battleResult == -1)
                        {
                            rooms[rowOfCurrentRoom][columnOfCurrentRoom].setHasPlayer(false);
                            return false;
                        }
                        else if(battleResult == 0)
                        {
                            return true;
                        }
                        else
                        {
                            ((ContentRoom)rightRoom).setEnemy(null);
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
            else
            {
                return true;
            }
        }
        else if(input.equalsIgnoreCase("U"))
        {
            if(rowOfCurrentRoom != 0)
            {
                Room upRoom = rooms[rowOfCurrentRoom - 1][columnOfCurrentRoom];
                if(upRoom instanceof ContentRoom)
                {
                    Enemy upEnemy = ((ContentRoom)upRoom).getEnemy();
                    if(upEnemy != null)
                    {
                        int battleResult = Character.battleOnce(getPlayer(), upEnemy);
                        if(battleResult == -1)
                        {
                            rooms[rowOfCurrentRoom][columnOfCurrentRoom].setHasPlayer(false);
                            return false;
                        }
                        else if(battleResult == 0)
                        {
                            return true;
                        }
                        else
                        {
                            ((ContentRoom)upRoom).setEnemy(null);
                            enterUpRoom();
                            print();
                            return true;
                        }
                    }
                    else
                    {
                        enterUpRoom();
                        print();
                        return true;
                    }
                }
                else
                {
                    enterUpRoom();
                    print();
                    return true;
                }
            }
            else
            {
                return true;
            }
        }
        else if(input.equalsIgnoreCase("D"))
        {
            if(rowOfCurrentRoom != rooms.length - 1)
            {
                Room downRoom = rooms[rowOfCurrentRoom + 1][columnOfCurrentRoom];
                if(downRoom instanceof ContentRoom)
                {
                    Enemy downEnemy = ((ContentRoom)downRoom).getEnemy();
                    if(downEnemy != null)
                    {
                        int battleResult = Character.battleOnce(getPlayer(), downEnemy);
                        if(battleResult == -1)
                        {
                            rooms[rowOfCurrentRoom][columnOfCurrentRoom].setHasPlayer(false);
                            return false;
                        }
                        else if(battleResult == 0)
                        {
                            return true;
                        }
                        else
                        {
                            ((ContentRoom)downRoom).setEnemy(null);
                            enterDownRoom();
                            print();
                            return true;
                        }
                    }
                    else
                    {
                        enterDownRoom();
                        print();
                        return true;
                    }
                }
                else
                {
                    enterDownRoom();
                    print();
                    return true;
                }
            }
            else
            {
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
        for(int row = 0; row < rooms.length; row++)
        {
            for(int column = 0; column < rooms[0].length; column++)
            {
                rooms[row][column].print();
            }
            System.out.println();
        }
        
    }

    public Room getCurrentRoom()
    {
        return rooms[rowOfCurrentRoom][columnOfCurrentRoom];
    }

    public void enterLeftRoom()
    {
        rooms[rowOfCurrentRoom][columnOfCurrentRoom].setHasPlayer(false);
        rooms[rowOfCurrentRoom][columnOfCurrentRoom - 1].setHasPlayer(true);
        columnOfCurrentRoom--;
        if(rooms[rowOfCurrentRoom][columnOfCurrentRoom] instanceof ContentRoom)
        {
            collectItems((ContentRoom)rooms[rowOfCurrentRoom][columnOfCurrentRoom]);
        }
        
    }
    public void enterRightRoom()
    {
        rooms[rowOfCurrentRoom][columnOfCurrentRoom].setHasPlayer(false);
        rooms[rowOfCurrentRoom][columnOfCurrentRoom + 1].setHasPlayer(true);
        columnOfCurrentRoom++;
        if(rooms[rowOfCurrentRoom][columnOfCurrentRoom] instanceof ContentRoom)
        {
            collectItems((ContentRoom)rooms[rowOfCurrentRoom][columnOfCurrentRoom]);
        }
    }
    public void enterUpRoom()
    {
        rooms[rowOfCurrentRoom][columnOfCurrentRoom].setHasPlayer(false);
        rooms[rowOfCurrentRoom - 1][columnOfCurrentRoom].setHasPlayer(true);
        rowOfCurrentRoom--;
        if(rooms[rowOfCurrentRoom][columnOfCurrentRoom] instanceof ContentRoom)
        {
            collectItems((ContentRoom)rooms[rowOfCurrentRoom][columnOfCurrentRoom]);
        }
    }
    public void enterDownRoom()
    {
        rooms[rowOfCurrentRoom][columnOfCurrentRoom].setHasPlayer(false);
        rooms[rowOfCurrentRoom + 1][columnOfCurrentRoom].setHasPlayer(true);
        rowOfCurrentRoom++;
        if(rooms[rowOfCurrentRoom][columnOfCurrentRoom] instanceof ContentRoom)
        {
            collectItems((ContentRoom)rooms[rowOfCurrentRoom][columnOfCurrentRoom]);
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
}
