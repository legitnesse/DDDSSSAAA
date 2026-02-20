package F203;

public class StringArrayListTrainTester 
{
    public static void main(String[] args) 
    {
        StringArrayListTrain t = new StringArrayListTrain();
        t.addCar("A");
        System.out.println(t.getCurrentNumberOfCars());
        t.printTrain();
        t.addCar("B");
        System.out.println(t.getCurrentNumberOfCars());
        t.printTrain();
        t.addCar("C");
        System.out.println(t.getCurrentNumberOfCars());
        t.printTrain();
        t.addCar("D");
        System.out.println(t.getCurrentNumberOfCars());
        t.printTrain();
        t.addCar("Z", 4);
        System.out.println(t.getCurrentNumberOfCars());
        t.printTrain();
        t.addCar("E");
        System.out.println(t.getCurrentNumberOfCars());
        t.printTrain();
        t.replaceCar("E", 4);
        t.printTrain();
        System.out.println(t.countCarType("E"));
        System.out.println(t.checkForCar("C"));
        System.out.println(t.checkForCar("F"));
        StringArrayListTrain b = t.cloneTrain();
        b.replaceCar("F", 5);
        t.printTrain();
        b.printTrain();
    }
}
