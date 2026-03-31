package F319;

import java.util.ArrayList;
import java.util.Random;

public class ObjectSlotMachine implements Iterator
{
    private class Coin
    {
        public Coin(){}
    }

    private ArrayList<Coin> coins;
    private Random random;
    private int numberOfWins;
    
    public ObjectSlotMachine()
    {
        coins = new ArrayList<>();
        for(int i = 0; i < 10; i++)
        {
            coins.add(new Coin());
        }
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
        return coins.size() > 0;
    }
    public Object next()
    {
        remove();
        if(random.nextDouble() < 0.2)
        {
            for(int i = 0; i < 2; i++)
            {
                coins.add(new Coin());
            }
            numberOfWins++;
            System.out.println("You gambled 1 coin away and won 2! You now have " + coins.size() + " coins!");
        }
        else
        {
            System.out.println("You gambled 1 coin away and lost! You now have " + coins.size() + " coins!");
        }
        return null;
    }
    public void remove()
    {
        coins.removeLast();
    }

}
