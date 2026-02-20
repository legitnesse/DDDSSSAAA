package F210A;

public class GenericArrayListTrainTester 
{
    public static void main(String[] args)
    {
        GenericArrayListTrain<String> stringTrain = new GenericArrayListTrain<>();
        stringTrain.addCar("A");
        stringTrain.addCar("B");
        stringTrain.addCar("C");
        stringTrain.addCar("D");
        stringTrain.addCar("E");
        stringTrain.addCar("F");
        GenericArrayListTrain<Double> doubleTrain = new GenericArrayListTrain<>();
        doubleTrain.addCar(1.2);
        doubleTrain.addCar(2.3);
        doubleTrain.addCar(3.4);
        doubleTrain.addCar(4.5);
        doubleTrain.addCar(5.6);
        doubleTrain.addCar(6.7);
        stringTrain.printTrain();
        doubleTrain.printTrain();
    }
}
