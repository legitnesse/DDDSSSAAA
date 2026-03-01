package F212;

public class GenericLinkedListTrainTester 
{
    public static void main(String[] args) 
    {
        GenericLinkedListTrain<String> stringTrain = new GenericLinkedListTrain<>();
        stringTrain.addPassenger("A");
        stringTrain.addPassenger("B");
        stringTrain.addPassenger("C");
        stringTrain.addPassenger("D");
        stringTrain.addPassenger("E");
        stringTrain.addPassenger("F");
        stringTrain.printTrain();
        GenericLinkedListTrain<Double> doubleTrain = new GenericLinkedListTrain<>();
        doubleTrain.addPassenger(1.2);
        doubleTrain.addPassenger(2.3);
        doubleTrain.addPassenger(3.4);
        doubleTrain.addPassenger(4.5);
        doubleTrain.addPassenger(5.6);
        doubleTrain.addPassenger(6.7);
        doubleTrain.printTrain();
    }
}
