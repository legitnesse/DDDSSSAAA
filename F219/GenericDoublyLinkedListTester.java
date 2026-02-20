package F219;

public class GenericDoublyLinkedListTester
{
   public static void main(String[] args) 
    {
        GenericDoublyLinkedList<String> gdll = new GenericDoublyLinkedList<>();
        gdll.add("A");
        gdll.add("B");
        gdll.add("C");
        gdll.remove("C");
        gdll.print();
        System.out.println(gdll.get(0));
    } 
}
