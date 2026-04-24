package F416A.SupermarketSimulator;

import java.util.LinkedList;

public class Checkout
    {
        private LinkedList<Customer> line;
        private int timeWhenDoneWithCurrentCustomer = 0;
        private int totalNumberOfCustomers = 0;
        private int totalNumberOfCustomersServed = 0;
        private int totalNumberOfItems = 0;
        private int totalNumberOfItemsProcessed = 0;
        private int totalSecondsOfWait = 0;
        private int maximumLineLength = 0;
        private int totalSecondsOfFreeTime = 0;
        private Clock clock;

        public Checkout(Clock clock)
        {
            line = new LinkedList<>();
            this.clock = clock;
        }

        public void addCustomer(Customer c)
        {
            line.add(c);
            totalNumberOfCustomers++;
            totalNumberOfItems += c.getNumberOfItems();
        }
        public void simulateOneSecond()
        {
            int currentLineLength = line.size();
            if(currentLineLength > maximumLineLength)
            {
                maximumLineLength = currentLineLength;
            }
            if(currentLineLength > 0) 
            {
                if (clock.getTime() >= timeWhenDoneWithCurrentCustomer) 
                {
                    Customer c = line.remove();
                    serve(c);
                }
            }
            else
            {
                totalSecondsOfFreeTime++;
            }
        }

        //One could argue that this implementation is unrealistic because it counts all the items as processed before any time has passed, instead of processing 1 item every 5 seconds, but I'm too lazy to implement that right now.
        public void serve(Customer c)
        {
            timeWhenDoneWithCurrentCustomer = c.getNumberOfItems() * 5 + clock.getTime();
            totalSecondsOfWait += clock.getTime() - c.getSecondOfArrival();
            totalNumberOfCustomersServed++;
            totalNumberOfItemsProcessed += c.getNumberOfItems();
        }

        //I wrote this like a week ago at this point and this technique for reporting stats is intriguing to say the least.
        public double[] getStats()
        {
            double averageWaitingTimeInSeconds;
            if(totalNumberOfCustomersServed == 0)
            {
                averageWaitingTimeInSeconds = 0;
            }
            else
            {
                averageWaitingTimeInSeconds = totalSecondsOfWait / totalNumberOfCustomersServed;
            }
            double[] stats = {totalNumberOfCustomers, totalNumberOfCustomersServed, totalNumberOfItems, totalNumberOfItemsProcessed, averageWaitingTimeInSeconds, totalSecondsOfFreeTime, maximumLineLength};
            return stats;
        }

        public int getLineLength()
        {
            return line.size();
        }
        public int getTotalNumberOfCustomers() 
        {
            return totalNumberOfCustomers;
        }
        public int getTotalNumberOfCustomersServed() 
        {
            return totalNumberOfCustomersServed;
        }
        public int getTotalNumberOfItems() 
        {
            return totalNumberOfItems;
        }
        public int getTotalNumberOfItemsProcessed() 
        {
            return totalNumberOfItemsProcessed;
        }
        public int getTotalSecondsOfWait() 
        {
            return totalSecondsOfWait;
        }
        public int getMaximumLineLength() 
        {
            return maximumLineLength;
        }
        public int getTotalSecondsOfFreeTime() 
        {
            return totalSecondsOfFreeTime;
        }        
    }
