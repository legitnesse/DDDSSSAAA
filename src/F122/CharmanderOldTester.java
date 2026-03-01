package F122;

public class CharmanderOldTester 
{
    public static void main(String[] args) {
        CharmanderOld ch1 = new CharmanderOld();
        CharmanderOld ch2 = new CharmanderOld();

        System.out.println("ch1 HP: " + ch1.getHP());
        System.out.println("ch2 HP: " + ch2.getHP());

        System.out.println(ch1.scratch(ch2));
        System.out.println(ch1.scratch(ch2));
        System.out.println(ch1.scratch(ch2));


        System.out.println("ch1 HP: " + ch1.getHP());
        System.out.println("ch2 HP: " + ch2.getHP());
    }
}
