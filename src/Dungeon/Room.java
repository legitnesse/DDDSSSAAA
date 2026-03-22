abstract class Room 
{
    private boolean hasPlayer;
    
    public Room(){}

    public void print(){}
    
    public boolean doesHavePlayer() {
        return hasPlayer;
    }

    public void setHasPlayer(boolean hasPlayer) {
        this.hasPlayer = hasPlayer;
    }
}
