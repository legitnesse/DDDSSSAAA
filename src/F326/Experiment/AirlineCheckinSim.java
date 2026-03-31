package F326.Experiment;

import F326.Basic.*;

/** Simulate the check-in process of an airline.
*/
public class AirlineCheckinSim 
{
    // Data Fields
    /** Queue of frequent flyers. */
    private PassengerQueue frequentFlyerQueue = new PassengerQueue("Frequent Flyer");
    /** Queue of regular passengers. */
    private PassengerQueue regularPassengerQueue = new PassengerQueue("Regular Passenger");
    /** Maximum number of frequent flyers to be served before a regular passenger gets served. */
    private int frequentFlyerMax;
    /** Maximum time to service a passenger. */
    private int maxProcessingTime;
    /** Total simulated time. */
    private int totalTime;
    /** If set true, print additional output. */
    private boolean showAll;
    /** Simulated clock. */
    private int clock = 0;
    /** Time that the agent will be done with the current passenger.*/
    private int timeDone;
    /** Number of frequent flyers served since the last regular passenger was served. */
    private int frequentFlyersSinceRP;

        //My implementation based on their sample output
        public void enterData(int frequentFlyerArrivalRate, int regularPassengerArrivalRate, int frequentFlyerMax, int maxProcessingTime, int totalTime, boolean showAll)
        {
            frequentFlyerQueue.setArrivalRate(frequentFlyerArrivalRate / 60.0);
            regularPassengerQueue.setArrivalRate(regularPassengerArrivalRate / 60.0);
            this.frequentFlyerMax = frequentFlyerMax;
            this.maxProcessingTime = maxProcessingTime;
            Passenger.setMaxProcessingTime(maxProcessingTime);
            this.totalTime = totalTime;
            this.showAll = showAll;
        }

    private void runSimulation() 
    {
        for (clock = 0; clock < totalTime; clock++) 
        {
            frequentFlyerQueue.checkNewArrival(clock, showAll);
            regularPassengerQueue.checkNewArrival(clock, showAll);
            if (clock >= timeDone) 
            {
            startServe();
            }
        }
    }

    private void startServe() 
    {
            //This was <= but I changed it to <
            if (!frequentFlyerQueue.isEmpty() && ((frequentFlyersSinceRP < frequentFlyerMax) || regularPassengerQueue.isEmpty())) 
            {
                // Serve the next frequent flyer.
                frequentFlyersSinceRP++;
                timeDone = frequentFlyerQueue.update(clock, showAll);
            } 
        else if (!regularPassengerQueue.isEmpty()) 
        {
            // Serve the next regular passenger.
            frequentFlyersSinceRP = 0;
            timeDone = regularPassengerQueue.update(clock, showAll);
        } 
        else if (showAll) 
        {
            System.out.println("Time is " + clock + " server is idle");
        }
    }

    /** Method to show the statistics. */
    private void showStats() 
    {
        System.out.println("\nThe number of regular passengers served was " + regularPassengerQueue.getNumServed());
        double averageWaitingTime = (double) regularPassengerQueue.getTotalWait() / (double) regularPassengerQueue.getNumServed();
        System.out.println(" with an average waiting time of " + averageWaitingTime);
        System.out.println("The number of frequent flyers served was " + frequentFlyerQueue.getNumServed());
        averageWaitingTime = (double) frequentFlyerQueue.getTotalWait() / (double) frequentFlyerQueue.getNumServed();
        System.out.println(" with an average waiting time of " + averageWaitingTime);
        System.out.println("Passengers in frequent flyer queue: " + frequentFlyerQueue.size());
        System.out.println("Passengers in regular passenger queue: " + regularPassengerQueue.size());
    }

    private static void probeMaxArrivalRate()
    {
        AirlineCheckinSim sim;
        for(int generalArrivalRate = 5; generalArrivalRate <= 20; generalArrivalRate++)
        {
            double totalAverageFrequentFlyerWaitingTime = 0;
            double totalAverageRegularPassengerWaitingTime = 0;
            int totalFrequentFlyerQueueSize = 0;
            int totalRegularPassengerQueueSize = 0;
            for(int trial = 1; trial <= 5; trial++)
            {
                sim = new AirlineCheckinSim();
                
                sim.enterData(generalArrivalRate, generalArrivalRate, 1, 3, 1000, false);
                sim.runSimulation();
                totalAverageFrequentFlyerWaitingTime += (double) sim.frequentFlyerQueue.getTotalWait() / sim.frequentFlyerQueue.getNumServed();
                totalAverageRegularPassengerWaitingTime += (double) sim.regularPassengerQueue.getTotalWait() / sim.regularPassengerQueue.getNumServed();
                totalFrequentFlyerQueueSize += sim.frequentFlyerQueue.size();
                totalRegularPassengerQueueSize += sim.regularPassengerQueue.size();
                
                
            }
            double averageGeneralWaitingTime = ((totalAverageFrequentFlyerWaitingTime / 5) + (totalAverageRegularPassengerWaitingTime / 5)) / 2;
            System.out.println("The average waiting time for when " + generalArrivalRate + " frequent flyers and " + generalArrivalRate + " regular passengers arrived per hour was " + averageGeneralWaitingTime);
            double averageGeneralQueueSize = ((totalFrequentFlyerQueueSize / 5) + (totalRegularPassengerQueueSize / 5)) / 2;
            System.out.println("The average final queue size was " + averageGeneralQueueSize);
        }
    }
    private static void probePolicyEffect()
    {
        AirlineCheckinSim sim;
        for(int frequentFlyerMax = 1; frequentFlyerMax <= 5; frequentFlyerMax++)
        {
            int totalNumberOfFrequentFlyersServed = 0;
            int totalNumberOfRegularPassengersServed = 0;
            double totalAverageFrequentFlyerWait = 0;
            double totalAverageRegularPassengerWait = 0;
            

            for(int trial = 1; trial <= 5; trial++)
            {
                sim = new AirlineCheckinSim();
                sim.enterData(12, 12, frequentFlyerMax, 3, 1000, false);
                sim.runSimulation();
                
                totalNumberOfFrequentFlyersServed += sim.frequentFlyerQueue.getNumServed();
                totalNumberOfRegularPassengersServed += sim.regularPassengerQueue.getNumServed();
                totalAverageFrequentFlyerWait += (double) sim.frequentFlyerQueue.getTotalWait() / sim.frequentFlyerQueue.getNumServed();
                totalAverageRegularPassengerWait += (double) sim.regularPassengerQueue.getTotalWait() / sim.regularPassengerQueue.getNumServed();
            }
            
            double averageFrequentFlyerWait = totalAverageFrequentFlyerWait / 5.0;
            double averageRegularPassengerWait = totalAverageRegularPassengerWait / 5.0;
            double averageNumberOfFrequentFlyersServed = totalNumberOfFrequentFlyersServed / 5.0;
            double averageNumberOfRegularPassengersServed = totalNumberOfRegularPassengersServed / 5.0;
            System.out.println("The average number of regular passengers served was " + averageNumberOfRegularPassengersServed);
            System.out.println("with an average average waiting time of " + averageRegularPassengerWait);
            System.out.println("The average number of frequent flyers served was " + averageNumberOfFrequentFlyersServed);
            System.out.println("with an average average waiting time of " + averageFrequentFlyerWait);
            System.out.println("The policy is " + frequentFlyerMax + "\n");
        }
    }

    /** Main method.
    @param args Not used
    */
    public static void main(String args[]) 
    {
        //probeMaxArrivalRate();
        probePolicyEffect();
    }
}