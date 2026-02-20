package F120;

public class CarTester 
{
   public static void main(String[] args) 
    {
        Car myCar = new Car("Toyota", 1000);
        myCar.addMileage(4.1);
        myCar.addMileage(0);
        myCar.addMileage(6.7);
        myCar.addMileage(6.9);
        myCar.addMileage(4.2);
        myCar.showMileages();
        myCar.testArray();
        myCar.showMileages();
    } 
}
