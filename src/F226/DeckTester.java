package F226;

public class DeckTester 
{
    public static void main(String[] args) 
    {
        Deck<Integer> d = new Deck<>();
        d.push(1);
        d.push(2);
        d.push(3);
        d.push(4);
        d.push(5);
        d.push(6);
        d.pop();
        d.print();
    }
}
