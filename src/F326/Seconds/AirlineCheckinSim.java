package F326.Seconds;

import java.util.Scanner;

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
        public void enterData()
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Expected number of frequent flyer arrivals per hour: ");
            int frequentFlyerArrivalRate = scanner.nextInt();
            frequentFlyerQueue.setArrivalRate((double) frequentFlyerArrivalRate / 3600);
            System.out.println("Expected number of regular passenger arrivals per hour: ");
            int regularPassengerArrivalRate = scanner.nextInt();
            regularPassengerQueue.setArrivalRate((double) regularPassengerArrivalRate / 3600);
            System.out.println("The maximum number of frequent flyers served between regular passengers: ");
            int frequentFlyerMax = scanner.nextInt();
            this.frequentFlyerMax = frequentFlyerMax;
            System.out.println("Maximum service time in minutes: ");
            int maxProcessingTime = scanner.nextInt() * 60;
            this.maxProcessingTime = maxProcessingTime;
            Passenger.setMaxProcessingTime(maxProcessingTime);
            System.out.println("The total simulation time in minutes: ");
            int totalTime = scanner.nextInt() * 60;
            this.totalTime = totalTime;
            System.out.println("Display second-by-second trace of simulation (Y or N): ");
            String showAllChoice = scanner.next();
            if(showAllChoice.equalsIgnoreCase("Y"))
            {
                this.showAll = true;
            }
            if(showAllChoice.equalsIgnoreCase("N"))
            {
                this.showAll = false;
            }
            scanner.close();
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
            //Is this supposed to be <=? I think it should be <
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
            int minute = clock / 60;
            int second = clock % 60;
            System.out.println("Time is " + minute + "m" + second + "s: server is idle");
        }
    }

    /** Method to show the statistics. */
    private void showStats() 
    {
        System.out.println("\nThe number of regular passengers served was " + regularPassengerQueue.getNumServed());
        double averageWaitingTime = (double) regularPassengerQueue.getTotalWait() / (double) regularPassengerQueue.getNumServed();
        System.out.println(" with an average waiting time of " + averageWaitingTime / 60 + "m");
        System.out.println("The number of frequent flyers served was " + frequentFlyerQueue.getNumServed());
        averageWaitingTime = (double) frequentFlyerQueue.getTotalWait() / (double) frequentFlyerQueue.getNumServed();
        System.out.println(" with an average waiting time of " + averageWaitingTime / 60 + "m");
        System.out.println("Passengers in frequent flyer queue: " + frequentFlyerQueue.size());
        System.out.println("Passengers in regular passenger queue: " + regularPassengerQueue.size());
    }

    /** Main method.
    @param args Not used
    */
    public static void main(String args[]) 
    {
        AirlineCheckinSim sim = new AirlineCheckinSim();
        sim.enterData();
        sim.runSimulation();
        sim.showStats();
        System.exit(0);
    }
}
