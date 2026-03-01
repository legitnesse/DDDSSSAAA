package F203;

public class StringBucket 
{
    private String[] bucket;
    private int currentBucketSize;

    public StringBucket()
    {
        bucket = new String[5];
        currentBucketSize = 0;
    }
    public int getCurrentBucketSize()
    {
        return currentBucketSize;
    }
    public void doubleBucketSize()
    {
        String[] temp = new String[bucket.length];
        for(int i = 0; i < bucket.length; i++)
        {
           temp[i] = bucket[i];
        }
        bucket = new String[bucket.length*2];
        for(int i = 0; i < temp.length; i++)
        {
            bucket[i] = temp[i];
        } 
    }
    public void addToBucket(String inputBucketElement)
    {
        if(currentBucketSize == bucket.length)
        {
            doubleBucketSize();
        }
        bucket[currentBucketSize] = inputBucketElement;
        currentBucketSize++;
    }
    public String getBucketElement(int inputBucketIndex)
    {
        return bucket[inputBucketIndex];
    }
    public void printBucket()
    {
        if(currentBucketSize == 0)
        {
            System.out.println("There are no elements in the bucket!");
        }
        else
        {
            System.out.print("[");
            for(int i = 0; i < currentBucketSize - 1; i++)
            {
                System.out.print(bucket[i] + ", ");
            }
            System.out.println(bucket[currentBucketSize - 1] + "]");
        }
    }
    public void clearBucket()
    {
        bucket = new String[5];
        currentBucketSize = 0;
    }
    public void removeBucketElement(int inputBucketIndex)
    {
        if(currentBucketSize != 0)
        {
            for(int i = inputBucketIndex; i < currentBucketSize - 1; i++)
            {
                bucket[i] = bucket[i + 1];
            }
            currentBucketSize--;
            bucket[currentBucketSize] = null;
        }
        
    }
    public void addBucketElement(String inputBucketElement, int inputBucketIndex)
    {
        if(inputBucketIndex >= bucket.length)
        {
            doubleBucketSize();
            bucket[inputBucketIndex] = inputBucketElement;

        }
        else
        {
            if(currentBucketSize >= bucket.length)
            {
                doubleBucketSize();
                bucket[inputBucketIndex] = inputBucketElement;
            }
            for(int i = currentBucketSize; i > inputBucketIndex; i--)
            {
                bucket[i] = bucket[i - 1];
            }
            bucket[inputBucketIndex] = inputBucketElement;
            currentBucketSize++;
        } 
    }
    public Boolean findBucketElement(String inputBucketElement)
    {
        for(int i = 0; i < bucket.length; i++)
        {
            if(bucket[i].equals(inputBucketElement))
            {
                return true;
            }
        }
        return false;
    }
}
