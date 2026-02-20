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
            size++;
            tail = head;
        }
        else
        {
            tail.setNextNode(new Node<T>());
            tail.getNextNode().setLastNode(tail);
            tail = tail.getNextNode();
            tail.setData(data);
            size++;
        }
    }
    public void removeAt(int index)
    {
        if(index == 0)
        {
            head = head.getNextNode();
            size--;
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
            if(currentNode.getNextNode() == null)
            {
                currentNode = currentNode.getLastNode();
                currentNode.setNextNode(null);
            }
            else
            {
                Node<T> tempNode = currentNode;
                currentNode = currentNode.getLastNode();
                currentNode.setNextNode(currentNode.getNextNode().getNextNode());
                currentNode = currentNode.getNextNode();
                currentNode.setLastNode(tempNode.getLastNode());
                size--;
            }
        }
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
            size--;  
        }
        else
        {
            if(currentNode == tail)
            {
                tail.getLastNode().setNextNode(null);
                size--;
            }
            else
            {
                Node<T> tempNode = currentNode;
                currentNode = currentNode.getLastNode();
                currentNode.setNextNode(currentNode.getNextNode().getNextNode());
                currentNode = currentNode.getNextNode();
                currentNode.setLastNode(tempNode.getLastNode());
                size--;
            }
        }
    
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
    public void print()
    {
        Node<T> currentNode = head;
        while(currentNode != null)
        {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNextNode();
        }
    }
}
