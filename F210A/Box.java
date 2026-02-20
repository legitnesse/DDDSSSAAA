package F210A;

public class Box<T>
{
    T obj;

    public void setObject(T inputObj)
    {
        obj = inputObj;
    }
    public T getObject()
    {
        return obj;
    }
}
