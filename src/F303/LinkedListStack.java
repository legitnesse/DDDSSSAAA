package F303;

import F219.GenericDoublyCappedDoublyLinkedList;

public class LinkedListStack<T>
{
    private GenericDoublyCappedDoublyLinkedList<T> list;

    public LinkedListStack()
    {
        list = new GenericDoublyCappedDoublyLinkedList<T>();
    }
    
    public void push(T data)
    {
        list.add(data);
    }
    public T pop()
    {
        T data = (T) list.get(list.getSize() - 1);
        list.removeAt(list.getSize() - 1);
        return data;
    }
    public int getSize()
    {
        return list.getSize();
    }
    public void clear()
    {
        list = new GenericDoublyCappedDoublyLinkedList<>();
    }
    public void print()
    {
       list.print(); 
    }
    public boolean find(T data)
    {
        return list.find(data);
    }
}
