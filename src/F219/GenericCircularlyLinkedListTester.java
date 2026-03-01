package F219;

public class GenericCircularlyLinkedListTester 
{
    public static void main(String[] args) 
    {
        GenericCircularlyLinkedList<String> gcll = new GenericCircularlyLinkedList<>();
        gcll.add("A");
        gcll.add("B");
        gcll.add("C");
        gcll.print();
        gcll.reversePrint();
    }
}
