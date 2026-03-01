package F226;

public class Deck<T> 
{
    public Object[] arr;
    private int size;

    public Deck()
    {
        arr = new Object[5];
        size = 0;
    }
    public int getSize()
    {
        return size;
    }
    public void push(T data)
    {
        ensureCapacity();
        arr[size] = data;
        size++;
    }
    private void ensureCapacity() {
        if(size == arr.length)
        {
            Object[] newArr = new Object[arr.length * 2];
            for(int i = 0; i < arr.length; i++)
            {
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
    }
    public T pop()
    {
        if(size == 0)
        {
            throw new RuntimeException("Cannot pop an empty stack");
        }
        T data = (T) arr[size - 1];
        arr[size - 1] = null;
        size--;            
        return data;
    }
    public Boolean find(T data)
    {
        Deck<T> newDeck = new Deck<T>();
        T poppedData = pop();
        newDeck.push(poppedData);
        Boolean doesNotHave = poppedData != data;
        while(doesNotHave && size != 0)
        {
            poppedData = pop();
            newDeck.push(poppedData);
            doesNotHave = poppedData != data;
        }
        while(newDeck.getSize() != 0)
        {
            this.push(newDeck.pop());
        }
        return !doesNotHave;
    }
    public void print()
    {
        Deck<T> newDeck = new Deck<T>();
        while(size != 0)
        {
            T poppedData = this.pop();
            newDeck.push(poppedData);
            System.out.println(poppedData);
        }
        while(newDeck.getSize() != 0)
        {
            this.push(newDeck.pop());
        }
    }
}
