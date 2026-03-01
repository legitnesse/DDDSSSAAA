package F219;

public class Node<T>
{
    private T data;
    private Node<T> nextNode;
    private Node<T> lastNode;

    public void setData(T data)
    {
        this.data = data;
    }
    public T getData()
    {
        return data;
    }
    public void setNextNode(Node<T> nextNode)
    {
        this.nextNode = nextNode;
    }
    public Node<T> getNextNode()
    {
        return nextNode;
    }
    public void setLastNode(Node<T> lastNode)
    {
        this.lastNode = lastNode;
    }
    public Node<T> getLastNode()
    {
        return lastNode;
    }
}
