package F430;

public class NewspaperTester 
{
    public static void main(String[] args) 
    {
        freeRecipient fred = new freeRecipient("Fred");
        premiumRecipient pratt = new premiumRecipient("Pratt");
        NewspaperCompany npc = new NewspaperCompany();
        npc.registerObserver(fred);
        npc.registerObserver(pratt);
        npc.notifyObservers(new Newspaper("hi yall are yall getting this message", false));
        npc.notifyObservers(new Newspaper("hi yall are yall getting this premium message", true));
    }
}
