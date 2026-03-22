package F319;

import java.util.Random;

public class PrimitiveSlotMachine implements Iterator
{
    private Random random;
    private int numberOfCoins;
    private int numberOfWins;

    public PrimitiveSlotMachine()
    {
        numberOfCoins = 10;
        random = new Random();
        numberOfWins = 0;
    }

    public void pullSlotMachine()
    {
        while(hasNext())
        {
            next();
        }
        System.out.println("You won " + numberOfWins + " times!");
    }

    public boolean hasNext()
    {
        return numberOfCoins > 0;
    }
    public Object next()
    {
        if(random.nextDouble() < 0.2)
        {
            numberOfCoins++;
            numberOfWins++;
            System.out.println("You gambled 1 coin away to win 2! You now have " + numberOfCoins + " coins!");
        }
        else
        {
            remove();
            System.out.println("You gambled 1 coin away to win 0! You now have " + numberOfCoins + " coins!");
        }
        return null;
    }
    public void remove()
    {
        numberOfCoins--;
    }
}
