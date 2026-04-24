package F416A.SupermarketSimulator;

import java.util.Random;

public class Customer 
    {
        private int secondOfArrival;
        private int numberOfItems;

        public Customer(int time, int maximumNumberOfItemsForCustomer, Random random)
        {
            this.secondOfArrival = time;
            numberOfItems = random.nextInt(maximumNumberOfItemsForCustomer - 1) + 1;
        }

        public int getSecondOfArrival() 
        {
            return secondOfArrival;
        }
        public int getNumberOfItems() 
        {
            return numberOfItems;
        }
    }   