package F414;

import java.util.LinkedList;

public class ExperimentalStringIntegerHashMap 
{
    private LinkedList<Pair>[] array;
    private int whichHashFunction;
    private int numberOfMappings;
    private int numberOfCollisions;
    private static final int smallPrime = 31;
    private static final int largePrime = 29791;

    public ExperimentalStringIntegerHashMap(int whichHashFunction)
    {
        array = new LinkedList[10];
        for(int i = 0; i < array.length; i++)
        {
            array[i] = new LinkedList<>();
        }
        this.whichHashFunction = whichHashFunction;
    }

    private int hash(String key)
    {
        if(whichHashFunction == 1)
        {
            return key.length();
        }
        else if(whichHashFunction == 2)
        {
            return key.length() % array.length;
        }
        else if(whichHashFunction == 3)
        {
            int sum = 0;
            for(int i = 0; i < key.length(); i++)
            {
                sum += smallPrime * i + (int) key.charAt(i);
            }
            return sum % largePrime;
        }
        else
        {
            int sum = 0;
            for(int i = 0; i < key.length(); i++)
            {
                sum ^= (int) key.charAt(i) * smallPrime;
                sum *= largePrime;
            }
            return sum;
        }
    }

    public void put(String key, int value)
    {
        int index = Math.floorMod(hash(key), array.length);
        for(Pair p : array[index])
        {
            if(p.key.equals(key))
            {
                p.value = value;
                return;
            }
        }
        if(array[index].size() > 0)
        {
            numberOfCollisions++;
        }
        array[index].add(new Pair(key, value));
        numberOfMappings++;
    }

    public Object putIfAbsent(String key, int value)
    {
        int index = Math.floorMod(hash(key), array.length);
        for(Pair p : array[index])
        {
            if(p.key.equals(key))
            {
                return p.value;
            }
        }
        if(array[index].size() > 0)
        {
            numberOfCollisions++;
        }
        array[index].add(new Pair(key, value));
        numberOfMappings++;
        return null;
    }

    public Object get(String key)
    {
        int index = Math.floorMod(hash(key), array.length);
        for(Pair p : array[index])
        {
            if(p.key.equals(key))
            {
                return p.value;
            }
        }
        return null;
    }

    public Object remove(String key)
    {
        int index = Math.floorMod(hash(key), array.length);
        Pair toBeRemoved = null;
        for(Pair p : array[index])
        {
            if(p.key.equals(key))
            {
                toBeRemoved = p;
            }
        }
        if(toBeRemoved != null)
        {
            int value = toBeRemoved.value;
            array[index].remove(toBeRemoved);
            numberOfMappings--;
            return value;

        }
        return null;
    }

    public boolean remove(String key, int value)
    {
        int index = Math.floorMod(hash(key), array.length);
        Pair toBeRemoved = null;
        for(Pair p : array[index])
        {
            if(p.key.equals(key))
            {
                if(p.value == value)
                {
                    toBeRemoved = p;
                    break;
                }
            }
        }
        if(toBeRemoved != null)
        {
            array[index].remove(toBeRemoved);
            numberOfMappings--;
            return true;
        }
        return false;
    }

    public Object replace(String key, int value)
    {
        int index = Math.floorMod(hash(key), array.length);
        for(Pair p : array[index])
        {
            if(p.key.equals(key))
            {
                int returned = p.value;
                p.value = value;
                return returned;
            }
        } 
        return null;
    }

    public boolean replace(String key, int oldValue, int newValue)
    {
        int index = Math.floorMod(hash(key), array.length);
        for(Pair p : array[index])
        {
            if(p.key.equals(key))
            {
                if(p.value == oldValue)
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
        LinkedList<Pair>[] oldArray = array;
        array = new LinkedList[oldArray.length * 2];
        for(int i = 0; i < array.length; i++)
        {
            array[i] = new LinkedList<>();
        }
        numberOfCollisions = 0;
        numberOfMappings = 0;
        for(LinkedList<Pair> l : oldArray)
        {
            for(Pair p : l)
            {
                put(p.key, p.value);
            }
        }
        
    }

    public void reHash() 
    {
        LinkedList<Pair>[] oldArray = array;
        array = new LinkedList[oldArray.length];
        for(int i = 0; i < array.length; i++)
        {
            array[i] = new LinkedList<>();
        }
        numberOfCollisions = 0;
        numberOfMappings = 0;
        for(LinkedList<Pair> l : oldArray)
        {
            for(Pair p : l)
            {
                put(p.key, p.value);
            }
        }
    }

    public boolean containsKey(String key)
    {
        int index = Math.floorMod(hash(key), array.length);
        for(Pair p : array[index])
        {
            if(p.key.equals(key))
            {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(int value)
    {
        for(LinkedList<Pair> l : array)
        {
            for(Pair p : l)
            {
                if(p.value == value)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public void clear()
    {
        array = new LinkedList[10];
        for(int i = 0; i < array.length; i++)
        {
            array[i] = new LinkedList<>();
        }
        numberOfCollisions = 0;
        numberOfMappings = 0; 
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
        public String key;
        public int value;

        public Pair(String key, int value)
        {
            this.key = key;
            this.value = value;
        }
    }
}
