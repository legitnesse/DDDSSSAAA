package F421;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.ArrayList;

public class AlgorithmsTester 
{
    private static Random random = new Random();

    public static void randomlyInject(int[] arr, int randomBound)
    {
        for(int i = 0; i < arr.length; i++)
        {
            arr[i] = random.nextInt(randomBound);
        }
    }
    public static void randomlyInject(ArrayList<Integer> arrList, int size, int randomBound)
    {
        for(int i = 0; i < size; i++)
        {
            arrList.add(random.nextInt(randomBound));
        }
    }
    public static void addArrayContentToArrayList(int[] arr, ArrayList<Integer> arrList)
    {
        for(int i : arr)
        {
            arrList.add(i);
        }
    }
    public static void print(int[] arr)
    {
        System.out.println(Arrays.toString(arr));
    }
    public static <T> void print(ArrayList<T> arrList)
    {
        System.out.println(arrList.toString());
    }
    public static void testSortingAlgorithmsForArray(String whichSortingAlgorithm)
    {
        int[] arr = new int[10];
        randomlyInject(arr, 10);
        print(arr);
        if(Objects.equals(whichSortingAlgorithm, "bubble"))
        {
            Algorithms.bubbleSort(arr);
        }
        else if(Objects.equals(whichSortingAlgorithm, "insertion"))
        {
            Algorithms.insertionSort(arr);
        }
        else if(Objects.equals(whichSortingAlgorithm, "selection"))
        {
            Algorithms.selectionSort(arr);
        }
        else if(Objects.equals(whichSortingAlgorithm, "shell"))
        {
            Algorithms.shellSort(arr);
        }
        print(arr);
    }
    public static void testSortingAlgorithmsForArrayList(String whichSortingAlgorithm)
    {
        ArrayList<Integer> arrList = new ArrayList<>();
        randomlyInject(arrList, 10, 10);
        print(arrList);
        if(Objects.equals(whichSortingAlgorithm, "bubble"))
        {
            Algorithms.bubbleSort(arrList);
        }
        else if(Objects.equals(whichSortingAlgorithm, "insertion"))
        {
            Algorithms.insertionSort(arrList);
        }
        else if(Objects.equals(whichSortingAlgorithm, "selection"))
        {
            Algorithms.selectionSort(arrList);
        }
        print(arrList);
    }  
    public static void testSearchingAlgorithmForArray(String whichSearchingAlgorithm)
    {
        int[] arr = new int[10];
        randomlyInject(arr, 10);
        Algorithms.selectionSort(arr);
        print(arr);
        if(Objects.equals(whichSearchingAlgorithm, "lin"))
        {
            System.out.println(Algorithms.linearSearch(arr, 5));
        }
        else if(Objects.equals(whichSearchingAlgorithm, "linbin"))
        {
            System.out.println(Algorithms.linearBinarySearch(arr, 5));
        }
        else if(Objects.equals(whichSearchingAlgorithm, "bin"))
        {
            System.out.println(Algorithms.binarySearchTree(arr, 5));
        }
        else if(Objects.equals(whichSearchingAlgorithm, "recbin"))
        {
            System.out.println(Algorithms.recursiveBinarySearch(arr, 5));
        }
    }
    public static void testSearchingAlgorithmForArrayList(String whichSearchingAlgorithm)
    {
        ArrayList<Integer> arrList = new ArrayList<>();
        randomlyInject(arrList, 10, 10);
        print(arrList);
        if(Objects.equals(whichSearchingAlgorithm, "lin"))
        {
            System.out.println(Algorithms.linearSearch(arrList, 5));
        }
        else if(Objects.equals(whichSearchingAlgorithm, "linbin"))
        {
            System.out.println(Algorithms.linearBinarySearch(arrList, 5));
        }
    }
    public static void compareSearchingAlgorithmsForArrayVersusArrayList(String whichSearchingAlgorithm)
    {
        double[] timesForArray = new double[15];
        double[] timesForArrayList = new double[15];
        for(int i = 0; i < timesForArray.length; i++)
        {
            double sumForArray = 0;
            double sumForArrayList = 0;
            for(int trial = 0; trial < 10; trial++)
            {
                int[] arr = new int[(i + 1)* 1000];
                randomlyInject(arr,(i + 1)* 1000);
                ArrayList<Integer> arrList = new ArrayList<>();
                addArrayContentToArrayList(arr, arrList);
                if(!Objects.equals(whichSearchingAlgorithm, "lin"))
                {
                    Algorithms.selectionSort(arr);
                    Algorithms.selectionSort(arrList);
                }
                int target = random.nextInt((i + 1) * 500);
                sumForArray += getTimeForOneSearch(arr, target, whichSearchingAlgorithm);
                sumForArrayList += getTimeForOneSearch(arrList, target, whichSearchingAlgorithm);
            }
            timesForArray[i] = sumForArray / 10;
            timesForArrayList[i] = sumForArrayList / 10;
        }
        System.out.println("Averages of 10 trials for sizes 1,000 to 10,000 for Array: ");
        System.out.println(Arrays.toString(timesForArray));
        System.out.println("Averages of 10 trials for sizes 1,000 to 10,000 for Array List: ");
        System.out.println(Arrays.toString(timesForArrayList));
    }
    public static double getTimeForOneSearch(int[] arr, int target, String whichSearchingAlgorithm)
    {
        long start = System.currentTimeMillis();
        if(Objects.equals(whichSearchingAlgorithm, "lin"))
        {                
            Algorithms.linearSearch(arr, target);
        }
        else if(Objects.equals(whichSearchingAlgorithm, "linbin"))
        {
            Algorithms.linearBinarySearch(arr, target);     
        }
        return (System.currentTimeMillis() - start);
    }
    public static double getTimeForOneSearch(ArrayList<Integer> arrList, int target, String whichSearchingAlgorithm)
    {
        long start = System.currentTimeMillis();
        if(Objects.equals(whichSearchingAlgorithm, "lin"))
        {                
            Algorithms.linearSearch(arrList, target);
        }
        else if(Objects.equals(whichSearchingAlgorithm, "linbin"))
        {
            Algorithms.linearBinarySearch(arrList, target);     
        }
        return (System.currentTimeMillis() - start);
    }
    public static void compareSortingAlgorithmsForArrayVersusArrayList(String whichSortingAlgorithm)
    {
        double[] timesForArray = new double[10];
        double[] timesForArrayList = new double[10];
        for(int i = 0; i < timesForArray.length; i++)
        {
            double sumForArray = 0;
            double sumForArrayList = 0;
            for(int trial = 0; trial < 10; trial++)
            {
                int[] arr = new int[(i + 1)* 1000];
                randomlyInject(arr,(i + 1)* 1000);
                ArrayList<Integer> arrList = new ArrayList<>();
                addArrayContentToArrayList(arr, arrList);
                sumForArray += getTimeForOneSort(arr, whichSortingAlgorithm);
                sumForArrayList += getTimeForOneSort(arrList, whichSortingAlgorithm);
            }
            timesForArray[i] = sumForArray / 10;
            timesForArrayList[i] = sumForArrayList / 10; 
        }
        System.out.println("Averages of 10 trials for sizes 1,000 to 10,000 for Array: ");
        System.out.println(Arrays.toString(timesForArray));
        System.out.println("Averages of 10 trials for sizes 1,000 to 10,000 for Array List: ");
        System.out.println(Arrays.toString(timesForArrayList));
    }
    
    private static double getTimeForOneSort(int[] arr, String whichSortingAlgorithm)
    {
        long start = System.currentTimeMillis();
        if(Objects.equals(whichSortingAlgorithm, "bubble"))
        {                
            Algorithms.bubbleSort(arr);
        }
        else if(Objects.equals(whichSortingAlgorithm, "insertion"))
        {
            Algorithms.insertionSort(arr);            
        }
        else if(Objects.equals(whichSortingAlgorithm, "selection"))
        {
            Algorithms.selectionSort(arr);            
        }
        return (System.currentTimeMillis() - start);
    }
    private static double getTimeForOneSort(ArrayList<Integer> arrList, String whichSortingAlgorithm)
    {
        long start = System.currentTimeMillis();
        if(Objects.equals(whichSortingAlgorithm, "bubble"))
        {                
            Algorithms.bubbleSort(arrList);
        }
        else if(Objects.equals(whichSortingAlgorithm, "insertion"))
        {
            Algorithms.insertionSort(arrList);            
        }
        else if(Objects.equals(whichSortingAlgorithm, "selection"))
        {
            Algorithms.selectionSort(arrList);            
        }
        return (System.currentTimeMillis() - start);
    }
    public static void main (String[] args)
    {
        testSortingAlgorithmsForArray("shell");
    }
}
