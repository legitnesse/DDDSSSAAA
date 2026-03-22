package F219;

public class GenericDoublyCappedDoublyLinkedListTester 
{
    public static void main(String[] args) 
    {
        GenericDoublyCappedDoublyLinkedList<String> gcll = new GenericDoublyCappedDoublyLinkedList<>();
        gcll.add("A");
        gcll.add("B");
        gcll.add("C");
        gcll.print();
        gcll.reversePrint();
    }
}
