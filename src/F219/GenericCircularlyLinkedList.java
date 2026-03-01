package F219;

public class GenericCircularlyLinkedList<T>
{
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public GenericCircularlyLinkedList()
    {
        head = null;
        tail = null;
        size = 0;
    }
    public void add(T data)
    {
        if(head == null)
        {
            head = new Node<T>();
            head.setData(data);
            tail = head;
        }
        else
        {
            tail.setNextNode(new Node<T>());
            tail.getNextNode().setLastNode(tail);
            tail = tail.getNextNode();
            tail.setData(data);
        }
        size++;
    }
    public void removeAt(int index)
    {
        if(index == 0)
        {
            head = head.getNextNode();
            head.setLastNode(null);
        }
        else if(index == size - 1)
        {
            tail = tail.getLastNode();
            tail.setNextNode(null);
        }
        else
        {
            int currentIndex = 0;
            Node<T> currentNode = head;
            while(currentIndex != index)
            {
                currentNode = currentNode.getNextNode();
                currentIndex++;
            }
            currentNode.getLastNode().setNextNode(currentNode.getNextNode());
            currentNode.getNextNode().setLastNode(currentNode.getLastNode());
        }
        size--;
    }
    public void remove(T data)
    {
        Node<T> currentNode = head;
        while(currentNode.getData() != data)
        {
            currentNode = currentNode.getNextNode();
        }
        if(currentNode == head)
        {
            head = head.getNextNode(); 
            head.setLastNode(null);
        }
        else if(currentNode == tail) 
        {
            tail = tail.getLastNode();
            tail.setNextNode(null);
        }
        else
        {
            currentNode.getLastNode().setNextNode(currentNode.getNextNode());
            currentNode.getNextNode().setLastNode(currentNode.getLastNode());            
        }
        size--;
    }
    public T get(int index)
    {
        int currentIndex = 0;
        Node<T> currentNode = head;
        while(currentIndex != index)
        {
            currentNode = currentNode.getNextNode();
            currentIndex++;
        }
        return currentNode.getData();
    }
    public int getSize()
    {
        return size;
    }
    public void print()
    {
        Node<T> currentNode = head;
        while(currentNode != null)
        {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNextNode();
        }
    }
    public void reversePrint()
    {
        Node<T> currentNode = tail;
        while(currentNode != null)
        {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getLastNode();
        }
    }
}
