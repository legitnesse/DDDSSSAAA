package F303;

public class LinkedListStackTester 
{
    public static void main(String[] args) 
    {
        LinkedListStack<String> lls = new LinkedListStack<>();
        lls.push("hello");
        lls.push("bruh");
        lls.print();
        lls.pop();
        lls.print();
        System.out.println(lls.getSize());
    }
    
}
