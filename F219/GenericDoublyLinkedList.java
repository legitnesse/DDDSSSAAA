package F219;

/**
 * Hellooo
 */
public class GenericDoublyLinkedList<T>
{
    private Node<T> head;
    private int size;

    GenericDoublyLinkedList()
    {
        head = null;    
        size = 0;
    }
    public void add(T data)
    {
        if(head == null)
        {
            head = new Node<T>();
            head.setData(data);
        }
        else
        {
            Node<T> currentNode = head;
            Boolean hasNext = currentNode.getNextNode() != null;
            while(hasNext)
            {
                currentNode = currentNode.getNextNode();
                hasNext = currentNode.getNextNode() != null;
            }
            currentNode.setNextNode(new Node<T>());
            currentNode.getNextNode().setLastNode(currentNode);
            currentNode.getNextNode().setData(data);
        }
        size++;
    }
    public void removeAt(int index)
    {
        if(index == 0)
        {
            head = head.getNextNode();
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
                currentNode.getLastNode().setNextNode(null);
            }
            else
            {
                currentNode.getLastNode().setNextNode(currentNode.getNextNode());
                currentNode.getNextNode().setLastNode(currentNode.getLastNode());
            }
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
        }
        else
        {
            if(currentNode.getNextNode() == null)
            {
                currentNode = currentNode.getLastNode();
                currentNode.setNextNode(null);
            }
            else
            {
                currentNode.getLastNode().setNextNode(currentNode.getNextNode());
                currentNode.getNextNode().setLastNode(currentNode.getLastNode());
            }
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
        Node<T> currentNode = head;
        Boolean hasNext = currentNode.getNextNode() != null;
        while(hasNext)
        {
            currentNode = currentNode.getNextNode();
            hasNext = currentNode.getNextNode() != null;
        }
        while(currentNode != null)
        {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getLastNode();
        }
    }
}
