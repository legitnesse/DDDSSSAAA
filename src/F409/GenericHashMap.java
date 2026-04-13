package F409;

import java.util.LinkedList;

public class GenericHashMap<K, V>
{
    private LinkedList<Pair>[] x;
    private int numberOfMappings;
    private int numberOfCollisions;

    public GenericHashMap()
    {
        x = new LinkedList[10];
        for(int i = 0; i < x.length; i++)
        {
            x[i] = new LinkedList<>();
        }
    }

    public void put(K key, V value)
    {
        int index = Math.floorMod(key.hashCode(), x.length);
        for(Pair p : x[index])
        {
            if(p.key.equals(key))
            {
                p.value = value;
                return;
            }
        }
        if(x[index].size() > 0)
        {
            numberOfCollisions++;
        }
        x[index].add(new Pair(key, value));
        numberOfMappings++;
    }

    public V putIfAbsent(K key, V value)
    {
        int index = Math.floorMod(key.hashCode(), x.length);
        for(Pair p : x[index])
        {
            if(p.key.equals(key))
            {
                if(p.value == null)
                {
                    p.value = value;
                    return null;
                }
                else
                {
                    return p.value;
                }    
            }
        }
        if(x[index].size() > 0)
        {
            numberOfCollisions++;
        }
        x[index].add(new Pair(key, value));
        numberOfMappings++;
        return null;
    }

    public V get(K key)
    {
        int index = Math.floorMod(key.hashCode(), x.length);
        for(Pair p : x[index])
        {
            if(p.key.equals(key))
            {
                return p.value;
            }
        }
        return null;
    }

    public V remove(K key)
    {
        int index = Math.floorMod(key.hashCode(), x.length);
        for(Pair p : x[index])
        {
            if(p.key.equals(key))
            {
                V value = p.value;
                x[index].remove(p);
                numberOfMappings--;
                return value;
            }
        }
        return null;
    }

    public boolean remove(K key, V value)
    {
        int index = Math.floorMod(key.hashCode(), x.length); 
        for(Pair p : x[index])
        {
            if(p.key.equals(key))
            {
                if(p.value.equals(value))
                {
                    x[index].remove(p);
                    numberOfMappings--;
                    return true;
                }
            }
        }
        return false;
    }

    public V replace(K key, V value)
    {
        int index = Math.floorMod(key.hashCode(), x.length); 
        for(Pair p : x[index])
        {
            if(p.key.equals(key))
            {
                if(!p.value.equals(value))
                {
                    p.value = value;
                    return p.value;
                }
            }
        } 
        return null;
    }

    public boolean replace(K key, V oldValue, V newValue)
    {
        int index = Math.floorMod(key.hashCode(), x.length);
        for(Pair p : x[index])
        {
            if(p.key.equals(key))
            {
                if(p.value.equals(oldValue))
                {
                    p.value = newValue;
                    return true;
                }
            }
        } 
        return false;
    }

    public void resize()
    {
        LinkedList<Pair>[] oldX = x;
        x = new LinkedList[oldX.length * 2];
        for(LinkedList<Pair> l : oldX)
        {
            for(Pair p : l)
            {
                put(p.key, p.value);
            }
        }
    }

    public boolean containsKey(K key)
    {
        int index = Math.floorMod(key.hashCode(), x.length);
        for(Pair p : x[index])
        {
            if(p.key.equals(key))
            {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(V value)
    {
        for(LinkedList<Pair> l : x)
        {
            for(Pair p : l)
            {
                if(p.value.equals(value))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public void clear()
    {
        x = new LinkedList[10];
    }

    public boolean isEmpty()
    {
        return numberOfMappings == 0;
    }
    
    public int size()
    {
        return numberOfMappings;
    }

    private class Pair
    {
        public K key;
        public V value;

        public Pair(K key, V value)
        {
            this.key = key;
            this.value = value;
        }
    }
}
