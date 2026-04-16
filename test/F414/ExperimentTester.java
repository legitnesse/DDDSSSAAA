package F414;

import java.util.Random;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ExperimentTester 
{
    private static final String[] keys = createKeys();
    @Test
    public void testAll4HashMaps()
    {
        testHashMap(new ExperimentalStringIntegerHashMap(1));
        testHashMap(new ExperimentalStringIntegerHashMap(2));
        testHashMap(new ExperimentalStringIntegerHashMap(3));
        testHashMap(new ExperimentalStringIntegerHashMap(4));

    }
    public void testHashMap(ExperimentalStringIntegerHashMap ehm)
    {
        testPutAndContainsAndGet(ehm);        
        testSize(ehm);
        testResize(ehm);
        testPutSameKeyDifferentValueAndReplace(ehm);
        testGetNotKey(ehm);
        testRemove(ehm);
        testRehash(ehm); 
    }

    public void testPutAndContainsAndGet(ExperimentalStringIntegerHashMap ehm)
    {
        for(int i = 0; i < keys.length; i++)
        {
            ehm.put(keys[i], i);
        }
        for(int i = 0; i < keys.length; i++)
        {
            assertEquals(true, ehm.containsKey(keys[i]));
            assertEquals(true, ehm.containsValue(i));
        }
        for(int i = 0; i < keys.length; i++)
        {
            assertEquals(i, ehm.get(keys[i]));
        }  
    }

    public void testSize(ExperimentalStringIntegerHashMap ehm)
    {
        assertEquals(100, ehm.size());
    }

    public void testGetNotKey(ExperimentalStringIntegerHashMap ehm)
    {
        assertEquals(null, ehm.get("timothy"));
    }
    
    public void testPutSameKeyDifferentValueAndReplace(ExperimentalStringIntegerHashMap ehm)
    {
        int oldSize = ehm.size();
        int oldValue = (int) ehm.get(keys[99]);
        ehm.put(keys[99], 67);
        assertEquals(oldSize, ehm.size());
        assertNotEquals(oldValue, ehm.get(keys[99]));
        ehm.replace(keys[99], oldValue);
    }

    public void testRemove(ExperimentalStringIntegerHashMap ehm)
    {
        for(int i = 0; i < keys.length / 2; i++)
        {
            ehm.remove(keys[i]);
        }
        for(int i = 0; i < keys.length / 2; i++)
        {
            assertEquals(null, ehm.get(keys[i]));
        }
        for(int i = keys.length / 2; i < keys.length; i++)
        {
            assertEquals(Integer.toString(i), i, ehm.get(keys[i]));
        }
    }
    public void testResize(ExperimentalStringIntegerHashMap ehm)
    {
        ehm.resize();
        testPutAndContainsAndGet(ehm);
    }
    public void testRehash(ExperimentalStringIntegerHashMap ehm)
    {
        ehm.reHash();
        testPutAndContainsAndGet(ehm);
    }

    

    public static String[] createKeys() 
    {
        Random random = new Random();
        String[] keys = new String[100];
        char[] chars = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','1','2','3','4','5','6','7','8','9', '0'};
        for(int i = 0; i < 100; i++)
        {
            int numberOfCharacters = random.nextInt(21) + 5;
            StringBuilder keyBuilder = new StringBuilder();
            for(int j = 0; j < numberOfCharacters; j++)
            {
                keyBuilder.append(chars[random.nextInt(62)]);
            }
            keys[i] = keyBuilder.toString();
        }
        return keys;
    }
}
