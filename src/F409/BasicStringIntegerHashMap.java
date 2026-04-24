package F409;

import java.util.Iterator;
import java.util.LinkedList;
/*
we'll write offensively simple hashing function, key by string size
 */
public class BasicStringIntegerHashMap 
{
    private class Pair
    {
        private String key;
        private int value;

        public Pair(String key, int value)
        {
            this.key = key;
            this.value = value;
        }

        public String getKey()
        {
            return key;
        }
        public int getValue()
        {
            return value;
        }
    }
    
    //resize if too high
    private LinkedList<Pair>[] data;
    //if we use custom linklist we just add datakey data value
    //
    private int collisionCount;
    private int size;

    public BasicStringIntegerHashMap()
    {
        data = new LinkedList[16];
        for(int i = 0; i < data.length; i++)
        {
            data[i] = new LinkedList<>();
        }
    }

    public Object get(String key)
    {
        if(containsKey(key))
        {
            int index = hashFunction(key) % data.length;
            LinkedList<Pair> list = data[index];
            for(Pair p : list)
            {
                if(p.getKey().equals(key))
                {
                    return p.getValue();
                }
            }
        }
        return null;
    }

    public void put(String key, int value)
    {
        int index = hashFunction(key) % data.length;
        if(containsKey(key))
        {
            if((int) get(key) != value)
            {
                removeKey(key);
                data[index].add(new Pair(key, value));
            }
        }
        else
        {
            if(data[index].size() >= 1)
            {
                collisionCount++;
            }
            data[index].add(new Pair(key, value));
            size++;
        }
        
    }
    public boolean containsKey(String key)
    {
        int index = hashFunction(key) % data.length;
        LinkedList<Pair> list = data[index];
        for(Pair p : list)
        {
            if(p.getKey().equals(key))
            {
                return true;
            }
        }
        return false;

    }

    public boolean containsValue(int value)
    {
        for(int i = 0; i < data.length; i++)
        {
            for(Pair p : data[i])
            {
                if(p.getValue() == value)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public void removeKey(String key)
    {
        if(containsKey(key))
        {
            int index = hashFunction(key) % data.length;
            LinkedList<Pair> list = data[index];
            int positionOfKey = -1;
            for(Pair p : list)
            {
                positionOfKey++;
                if(p.getKey().equals(key))
                {
                    break;
                }
            }
            list.remove(positionOfKey);
            size--;
        }
    }

    public void dynamicResize()
    {
        if(collisionCount >= 8)
        {
            LinkedList<Pair>[] oldData = data;
            data = new LinkedList[oldData.length * 2];
            for(int i = 0; i < oldData.length; i++)
            {
                for(Pair p : data[i])
                {
                    put(p.getKey(), p.getValue());
                }
            }
        }

    }


    private int hashFunction(String key)
    {
        return key.length();
    }
}
