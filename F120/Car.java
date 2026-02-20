package F120;

import java.util.ArrayList;

public class Car
{
    private String model;
    private double mileage;
    private ArrayList<Double> mileages;
    
    public double getMileage()
    {
        return mileage;
    }
    public void setMileage(double userInputMileage)
    {
        mileage = userInputMileage;
    }
    public Car()
    {
        model = "Honda";
        mileage = 10000;
        mileages = new ArrayList<>();
    }
    public Car(String userInputModel, double userInputMileage)
    {
        model = userInputModel;
        mileage = userInputMileage;
        mileages = new ArrayList<>();
    }
    public void addMileage(double d)
    {
        mileages.add(d);
    }
    public void showMileages()
    {
        System.out.println(mileages);
    }
    public boolean isEmpty(double d)
    {
        if(d == 0)
        {
            return true;
        }
        return false;
    }
    public void testArray()
    {
        for(int i = 0; i < mileages.size(); i++)
        {
            if(isEmpty(mileages.get(i)))
            {
                mileages.set(i, 10000.0);
            }
        }
    }
}