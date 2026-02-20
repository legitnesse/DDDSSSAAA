package F203;

public class StringArrayListTrain 
{
    public String[] cars;
    public int currentNumberOfCars;
    
    public StringArrayListTrain()
    {
        cars = new String[5];
        currentNumberOfCars = 0;
    }
    public int getCurrentNumberOfCars()
    {
        return currentNumberOfCars;
    }
    public void doubleTrainCapacity()
    {
        String[] temp = new String[cars.length];
        for(int i = 0; i < cars.length; i++)
        {
            temp[i] = cars[i];
        }
        cars = new String[cars.length * 2];
        for(int i = 0; i < temp.length; i++)
        {
            cars[i] = temp[i];
        }       
    }
    public void addCar(String inputCarString)
    {
        if(currentNumberOfCars == cars.length)
        {
            doubleTrainCapacity();
        }
        cars[currentNumberOfCars] = inputCarString;
        currentNumberOfCars++;
    }
    public void addCar(String inputCarString, int newCarIndex)
    {
        if(newCarIndex > currentNumberOfCars)
        {
            return;
        }
        else if(newCarIndex == currentNumberOfCars)
        {
            addCar(inputCarString);
            return;
        }
        else
        {
            for(int i = currentNumberOfCars; i > newCarIndex; i--)
            {
                cars[i] = cars[i - 1];
            }
            cars[newCarIndex] = inputCarString;
            currentNumberOfCars++;
        }
    }
    public void removeCar()
    {
        cars[currentNumberOfCars] = null;
        currentNumberOfCars--;
    }
    public void removeCar(int oldCarIndex)
    {
        if(oldCarIndex > currentNumberOfCars)
        {
            return;
        }
        else if (oldCarIndex == currentNumberOfCars)
        {
            removeCar();
            return;
        }
        else
        {
            for(int i = oldCarIndex; i < currentNumberOfCars; i++)
            {
                cars[i] = cars[i + 1];
            }
            currentNumberOfCars--;
            return;
        }
    }
    public void replaceCar(String inputCarString, int newCarIndex)
    {
        cars[newCarIndex] = inputCarString;
    }
    public String getCar(int carIndex)
    {
        return cars[carIndex];
    }
    public String[] getCars()
    {
        return cars;
    }
    public void resetTrain()
    {
        cars = new String[5];
        currentNumberOfCars = 0;
    }
    public Boolean checkForCar(String inputCarString)
    {
        for(int i = 0; i < currentNumberOfCars; i++)
        {
            if(cars[i].equals(inputCarString))
            {
                return true;
            }
        }
        return false;
    }
    public int countCarType(String inputCarString)
    {
        int numberOfCarType = 0;
        for(int i = 0; i < currentNumberOfCars; i++)
        {
            if(cars[i].equals(inputCarString))
            {
                numberOfCarType++;
            }
        }
        return numberOfCarType;
    }
    public StringArrayListTrain cloneTrain()
    {
        StringArrayListTrain clonedTrain = new StringArrayListTrain();
        String[] clonedCars = new String[cars.length];
        for(int i = 0; i < currentNumberOfCars; i++)
        {
            clonedCars[i] = cars[i];
        }
        clonedTrain.cars = clonedCars;
        clonedTrain.currentNumberOfCars = this.currentNumberOfCars;
        return clonedTrain;
    }
    public void printTrain()
    {
        if(currentNumberOfCars == 0)
        {
            System.out.println("There are currently no cars on this train.");
        }
        if(currentNumberOfCars == 1)
        {
            System.out.println("[" + cars[currentNumberOfCars - 1] + "]");
        }
        else
        {
            System.out.print("[");
            for(int i = 0; i < currentNumberOfCars - 1; i++)
            {
                System.out.print(cars[i] + ", ");
            }
            System.out.println(cars[currentNumberOfCars - 1] + "]");
        }
    }
}
