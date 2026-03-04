package F303;

import F219.GenericCircularlyLinkedList;

public class LinkedListStack<T>
{
    private GenericCircularlyLinkedList<T> list;

    public LinkedListStack()
    {
        list = new GenericCircularlyLinkedList<T>();
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
        list = new GenericCircularlyLinkedList<>();
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
