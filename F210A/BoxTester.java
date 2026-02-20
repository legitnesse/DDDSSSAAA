package F210A;

public class BoxTester 
{
    public static void main(String[] args) 
    {
        Box<String> b1 = new Box<>();
        b1.setObject("Hello, World!");
        
        Box<Integer> b2 = new Box<>();
        b2.setObject(67);

        System.out.println(b1.getObject());
        System.out.println(b2.getObject());
    }
}
