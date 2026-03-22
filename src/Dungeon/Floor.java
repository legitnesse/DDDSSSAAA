abstract class Floor 
{
    private int floorNumber;
    private Player player;

    public Floor(int floorNumber, Player player)
    {
        this.floorNumber = floorNumber;
        this.player = player;
    }

    abstract boolean processInput(String input);
    abstract void print();
    abstract Room getCurrentRoom();

    public int getFloorNumber() {
        return floorNumber;
    }
    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
}