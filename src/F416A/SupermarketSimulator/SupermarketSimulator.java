package F416A.SupermarketSimulator;

import java.util.Random;

public class SupermarketSimulator 
{
    private Checkout[] superCheckouts;
    private Checkout[] expressCheckouts;
    private Checkout[] standardCheckouts;
    private double averageNumberOfCustomersPerSecond;
    private int maximumNumberOfItemsForCustomer;
    private int maximumNumberOfItemsForSuperCheckout;
    private int maximumNumberOfItemsForExpressCheckout;
    private int numberOfSecondsOfSimulationTime;
    private Clock clock = new Clock();
    private Random random = new Random();

    public SupermarketSimulator(int numberOfSuperCheckouts, int numberOfExpressCheckouts, int numberOfStandardCheckouts, int averageNumberOfCustomersPerHour, int maximumNumberOfItemsForCustomer, int maximumNumberOfItemsForSuperCheckout, int maximumNumberOfItemsForExpressCheckout, int numberOfHoursOfSimulationTime)
    {
        superCheckouts = new Checkout[numberOfSuperCheckouts];
        for(int i = 0; i < superCheckouts.length; i++)
        {
            superCheckouts[i] = new Checkout(clock);
        }
        expressCheckouts = new Checkout[numberOfExpressCheckouts];
        for(int i = 0; i < expressCheckouts.length; i++)
        {
            expressCheckouts[i] = new Checkout(clock);
        }
        standardCheckouts = new Checkout[numberOfStandardCheckouts];
        for(int i = 0; i < standardCheckouts.length; i++)
        {
            standardCheckouts[i] = new Checkout(clock);
        }
        this.averageNumberOfCustomersPerSecond = averageNumberOfCustomersPerHour / 3600.0;
        this.maximumNumberOfItemsForCustomer = maximumNumberOfItemsForCustomer;
        this.maximumNumberOfItemsForSuperCheckout = maximumNumberOfItemsForSuperCheckout;
        this.maximumNumberOfItemsForExpressCheckout = maximumNumberOfItemsForExpressCheckout;
        this.numberOfSecondsOfSimulationTime = numberOfHoursOfSimulationTime * 3600;
    }

    public void simulate()
    {
        while(clock.getTime() <= numberOfSecondsOfSimulationTime)
        {
            simulateOneSecond();
            clock.increment();
        }
    }
    public void simulateOneSecond()
    {
        if(random.nextDouble() < averageNumberOfCustomersPerSecond)
        {
            processNewCustomer();
        }
        for(Checkout c : superCheckouts)
        {
            c.simulateOneSecond();
        }
        for(Checkout c : expressCheckouts)
        {
            c.simulateOneSecond();
        }
        for(Checkout c : standardCheckouts)
        {
            c.simulateOneSecond();
        }
    }

    public void printReport()
    {
        System.out.println("The parameters of the supermarket simulation were:");
        System.out.println("Number of Super Express checkouts: " + superCheckouts.length);
        System.out.println("Number of Express checkouts: " + expressCheckouts.length);
        System.out.println("Number of Standard checkouts: " + standardCheckouts.length);
        System.out.println("Average number of customers per hour: " + averageNumberOfCustomersPerSecond * 3600);
        System.out.println("Maximum possible number of items for a customer: " + maximumNumberOfItemsForCustomer);
        System.out.println("Maximum number of items able to enter Super Express checkout: " + maximumNumberOfItemsForSuperCheckout);
        System.out.println("Maximum number of items able to enter Express checkout: " + maximumNumberOfItemsForExpressCheckout);
        System.out.println("Runtime in hours: " + numberOfSecondsOfSimulationTime / 3600);
        System.out.println();

        System.out.println("The statistics of the supermarket simulation were:");
        double[] overallStats = {0, 0, 0, 0, 0, 0, 0};
        System.out.println("For the Super Express checkouts:");
        printStats(superCheckouts, overallStats);
        System.out.println("For the Express checkouts:");
        printStats(expressCheckouts, overallStats);
        System.out.println("For the Standard checkouts:");
        printStats(standardCheckouts, overallStats);
        int totalNumberOfCheckouts = superCheckouts.length + expressCheckouts.length + standardCheckouts.length;
        for(int i = 0; i < overallStats.length; i++)
        {
            overallStats[i] /= totalNumberOfCheckouts;
        }
        System.out.println("For all checkouts:");
        System.out.println("Average number of customers who entered: " + String.format("%.2f", overallStats[0]));
        System.out.println("Average number of customers who were served: " + String.format("%.2f", overallStats[1]));
        System.out.println("Average number of items entered: " + String.format("%.2f", overallStats[2]));
        System.out.println("Average number of items processed: " + String.format("%.2f", overallStats[3]));
        System.out.println("Average seconds of average waiting time: " + String.format("%.2f", overallStats[4]));
        System.out.println("Average seconds of free time: " + String.format("%.2f", overallStats[5]));
        System.out.println("Average maximum number of customers at once: " + String.format("%.2f", overallStats[6]));
    }

    private void printStats(Checkout[] checkouts, double[] overallStats)
    {
        for(int i = 0; i < checkouts.length; i++)
        {
            double[] stats = checkouts[i].getStats();
            System.out.println("For checkout number " + (i + 1) + ":");
            System.out.println("Total number of customers who entered: " + stats[0]);
            overallStats[0] += stats[0];
            System.out.println("Total number of customers who were served: " + stats[1]);
            overallStats[1] += stats[1];
            System.out.println("Total number of items entered: " + stats[2]);
            overallStats[2] += stats[2];
            System.out.println("Total number of items processed: " + stats[3]);
            overallStats[3] += stats[3];
            System.out.println("Seconds of average waiting time: " + stats[4]);
            overallStats[4] += stats[4];
            System.out.println("Seconds of free time: " + stats[5]);
            overallStats[5] += stats[5];
            System.out.println("Maximum number of customers at once: " + stats[6]);
            overallStats[6] += stats[6];
            System.out.println();
        }
    }


    public void processNewCustomer()
    {
        Customer c = new Customer(clock.getTime(), maximumNumberOfItemsForCustomer, random);
        if(c.getNumberOfItems() <= maximumNumberOfItemsForSuperCheckout)
        {
            int whichSuperCheckout = OneOfTheseCheckoutsAreEmpty(superCheckouts);
            if(whichSuperCheckout == -1)
            {
                int whichExpressCheckout = OneOfTheseCheckoutsAreEmpty(expressCheckouts);
                if(whichExpressCheckout == -1)
                {
                    int whichStandardCheckout = OneOfTheseCheckoutsAreEmpty(standardCheckouts);
                    if(whichStandardCheckout == -1)
                    {
                        superCheckouts[shortestCheckout(superCheckouts)].addCustomer(c);
                    }
                    else
                    {
                        standardCheckouts[whichStandardCheckout].addCustomer(c);
                    }
                }
                else
                {
                    expressCheckouts[whichExpressCheckout].addCustomer(c);
                }
            }
            else
            {
                superCheckouts[whichSuperCheckout].addCustomer(c);
            }
            
        }
        else if(c.getNumberOfItems() <= maximumNumberOfItemsForExpressCheckout)
        {
            int whichExpressCheckout = OneOfTheseCheckoutsAreEmpty(expressCheckouts);
                if(whichExpressCheckout == -1)
                {
                    int whichStandardCheckout = OneOfTheseCheckoutsAreEmpty(standardCheckouts);
                    if(whichStandardCheckout == -1)
                    {
                        expressCheckouts[shortestCheckout(expressCheckouts)].addCustomer(c);
                    }
                    else
                    {
                        standardCheckouts[whichStandardCheckout].addCustomer(c);
                    }
                }
                else
                {
                    expressCheckouts[whichExpressCheckout].addCustomer(c);
                }
        }
        else
        {
            standardCheckouts[shortestCheckout(standardCheckouts)].addCustomer(c);
        }
    }
    
    //These are 2 helper methods when we determine which line for a customer to enter.
    private int shortestCheckout(Checkout[] checkouts)
    {
        int indexOfShortestCheckout = 0;
        int lengthOfShortestCheckout = checkouts[0].getLineLength();
        for(int i = 1; i < checkouts.length; i++)
        {
            int lengthOfCurrentCheckout = checkouts[i].getLineLength();
            if(lengthOfCurrentCheckout < lengthOfShortestCheckout)
            {
                indexOfShortestCheckout = i;
                lengthOfShortestCheckout = lengthOfCurrentCheckout;
            }
        }
        return indexOfShortestCheckout;

    }
    private int OneOfTheseCheckoutsAreEmpty(Checkout[] checkouts)
    {
        for(int i = 0; i < checkouts.length; i++)
        {
            if(checkouts[i].getLineLength() == 0)
            {
                return i;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        SupermarketSimulator s = new SupermarketSimulator(1,2, 3, 120, 25, 10, 15, 3);
        s.simulate();
        s.printReport();
    }
}
