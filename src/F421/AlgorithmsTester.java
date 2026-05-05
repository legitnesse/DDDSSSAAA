package F421;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.ArrayList;
import F331A.BinaryTree;

public class AlgorithmsTester 
{
    private static Random random = new Random();
    private static final long timeBudgetInNanoseconds = 300_000_000L;
    
    //Vestige from when I had a toggle for nanoTime or currentTimeMillis
    private static long getCurrentTime()
    {
        return System.nanoTime();
    }

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
        else if(Objects.equals(whichSortingAlgorithm, "merge"))
        {
            Algorithms.mergeSort(arr);
        }
        else if(Objects.equals(whichSortingAlgorithm, "quick"))
        {
            Algorithms.quickSort(arr);
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
        else if(Objects.equals(whichSortingAlgorithm, "shell"))
        {
            Algorithms.shellSort(arrList);
        }
        else if(Objects.equals(whichSortingAlgorithm, "merge"))
        {
            Algorithms.mergeSort(arrList);
        }
        else if(Objects.equals(whichSortingAlgorithm, "quick"))
        {
            Algorithms.quickSort(arrList);
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
        else if(Objects.equals(whichSearchingAlgorithm, "itbin"))
        {
            System.out.println(Algorithms.iterativeBinarySearch(arr, 5));
        }
        else if(Objects.equals(whichSearchingAlgorithm, "bintree"))
        {
            System.out.println(Algorithms.binaryTreeSearch(arr, 5));
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
        else if(Objects.equals(whichSearchingAlgorithm, "itbin"))
        {
            System.out.println(Algorithms.iterativeBinarySearch(arrList, 5));
        }
        else if(Objects.equals(whichSearchingAlgorithm, "bintree"))
        {
            System.out.println(Algorithms.binaryTreeSearch(arrList, 5));
        }
        else if(Objects.equals(whichSearchingAlgorithm, "recbin"))
        {
            System.out.println(Algorithms.recursiveBinarySearch(arrList, 5));
        }
    }
    
    public static double getTimeForOneSearch(int[] arr, int target, String whichSearchingAlgorithm)
    {
        long start = getCurrentTime();
        if(Objects.equals(whichSearchingAlgorithm, "lin"))
        {
            System.out.println(Algorithms.linearSearch(arr, target));
        }
        else if(Objects.equals(whichSearchingAlgorithm, "itbin"))
        {
            System.out.println(Algorithms.iterativeBinarySearch(arr, target));
        }
        else if(Objects.equals(whichSearchingAlgorithm, "bintree"))
        {
            System.out.println(Algorithms.binaryTreeSearch(arr, target));
        }
        else if(Objects.equals(whichSearchingAlgorithm, "recbin"))
        {
            System.out.println(Algorithms.recursiveBinarySearch(arr, target));
        }
        return (getCurrentTime() - start);
    }

    public static double getTimeForOneSearch(ArrayList<Integer> arrList, int target, String whichSearchingAlgorithm)
    {
        long start = getCurrentTime();
        if(Objects.equals(whichSearchingAlgorithm, "lin"))
        {
            System.out.println(Algorithms.linearSearch(arrList, target));
        }
        else if(Objects.equals(whichSearchingAlgorithm, "itbin"))
        {
            System.out.println(Algorithms.iterativeBinarySearch(arrList, target));
        }
        else if(Objects.equals(whichSearchingAlgorithm, "bintree"))
        {
            System.out.println(Algorithms.binaryTreeSearch(arrList, target));
        }
        else if(Objects.equals(whichSearchingAlgorithm, "recbin"))
        {
            System.out.println(Algorithms.recursiveBinarySearch(arrList, target));
        }
        return (getCurrentTime() - start);
    }
    
    private static void runSortingAlgorithm(int[] arr, String whichSortingAlgorithm)
    {
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
        else if(Objects.equals(whichSortingAlgorithm, "merge"))
        {
            Algorithms.mergeSort(arr);
        }
        else if(Objects.equals(whichSortingAlgorithm, "quick"))
        {
            Algorithms.quickSort(arr);
        }
    }

    private static void runSortingAlgorithm(ArrayList<Integer> arrList, String whichSortingAlgorithm)
    {
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
        else if(Objects.equals(whichSortingAlgorithm, "shell"))
        {
            Algorithms.shellSort(arrList);
        }
        else if(Objects.equals(whichSortingAlgorithm, "merge"))
        {
            Algorithms.mergeSort(arrList);
        }
        else if(Objects.equals(whichSortingAlgorithm, "quick"))
        {
            Algorithms.quickSort(arrList);
        }
    }

    private static int countSortsInOneMeasurementForArray(int[] baseArr, String whichSortingAlgorithm)
    {
        long duration = timeBudgetInNanoseconds;
        long elapsedSortTime = 0;
        int count = 0;
        while(elapsedSortTime < duration)
        {
            int[] arr = Arrays.copyOf(baseArr, baseArr.length);
            long sortStart = getCurrentTime();
            runSortingAlgorithm(arr, whichSortingAlgorithm);
            elapsedSortTime += (getCurrentTime() - sortStart);
            count++;
        }
        return count;
    }
    
    private static int countSortsInOneMeasurementForArrayList(ArrayList<Integer> baseArrList, String whichSortingAlgorithm)
    {
        long duration = timeBudgetInNanoseconds;
        long elapsedSortTime = 0;
        int count = 0;
        while(elapsedSortTime < duration)
        {
            ArrayList<Integer> arrList = new ArrayList<>(baseArrList);
            long sortStart = getCurrentTime();
            runSortingAlgorithm(arrList, whichSortingAlgorithm);
            elapsedSortTime += (getCurrentTime() - sortStart);
            count++;
        }
        return count;
    }
    //Runs the sorting algorithm a given number of times on arrays of a given size to induce JVM warmup optimization
    private static void performWarmupsForOneSize(int size, int warmupSorts, String whichSortingAlgorithm)
    {
        for(int i = 0; i < warmupSorts; i++)
        {
            int[] arr = new int[size];
            randomlyInject(arr, size);
            ArrayList<Integer> arrList = new ArrayList<>();
            addArrayContentToArrayList(arr, arrList);
            runSortingAlgorithm(arr, whichSortingAlgorithm);
            runSortingAlgorithm(arrList, whichSortingAlgorithm);
        }
    }
    //Gives the average of 3 number of sorts completed in a 0.3 second window for various array sizes after 25 warm up runs on arrays of size 1k
    public static void compareSortingAlgorithmsForArrayVersusArrayList(String whichSortingAlgorithm)
    {
        int warmupSorts = 25;
        int numberOfTrials = 3;
        int[] sizes = new int[] {1000, 2000, 4000, 8000, 16000};
        double[] averageSortsForArray = new double[sizes.length];
        double[] averageSortsForArrayList = new double[sizes.length];

        performWarmupsForOneSize(1000, warmupSorts, whichSortingAlgorithm);

        for(int i = 0; i < sizes.length; i++)
        {
            int size = sizes[i];
            double sumForArray = 0;
            double sumForArrayList = 0;
            for(int trial = 0; trial < numberOfTrials; trial++)
            {
                int[] baseArr = new int[size];
                randomlyInject(baseArr, size);
                ArrayList<Integer> baseArrList = new ArrayList<>();
                addArrayContentToArrayList(baseArr, baseArrList);
                sumForArray += countSortsInOneMeasurementForArray(baseArr, whichSortingAlgorithm);
                sumForArrayList += countSortsInOneMeasurementForArrayList(baseArrList, whichSortingAlgorithm);
            }
            averageSortsForArray[i] = sumForArray / numberOfTrials;
            averageSortsForArrayList[i] = sumForArrayList / numberOfTrials;
        }
        System.out.println("Average sorts completed in 0.3 seconds after " + warmupSorts + " warmup sorts for sizes 1,000, 2,000, 4,000, 8,000, and 16,000 for Array: ");
        System.out.println(Arrays.toString(averageSortsForArray));
        System.out.println("Average sorts completed in 0.3 seconds after " + warmupSorts + " warmup sorts for sizes 1,000, 2,000, 4,000, 8,000, and 16,000 for Array List: ");
        System.out.println(Arrays.toString(averageSortsForArrayList));
    }

    //Gives the average of 3 number of searches completed in a 0.3 second window
    public static void compareSearchingAlgorithmsForArrayVersusArrayList(String searchingAlgorithmNickName)
    {
        int numberOfTrials = 3;
        int[] baseArr = new int[16000];
        randomlyInject(baseArr, 16000);
        ArrayList<Integer> baseArrList = new ArrayList<>();
        addArrayContentToArrayList(baseArr, baseArrList);
        
        if(Objects.equals(searchingAlgorithmNickName, "bintree"))
        {
            BinaryTree<Integer> binaryTree_Array = new BinaryTree<>();
            for(int x : baseArr) 
            {
                binaryTree_Array.add(x);
            }
            BinaryTree<Integer> binaryTree_ArrayList = new BinaryTree<>();
            for(int x : baseArrList) 
            {
                binaryTree_ArrayList.add(x);
            }
            double[] numberOfSearchesPerTrial_Array = new double[numberOfTrials];
            double[] numberOfSearchesPerTrial_ArrayList = new double[numberOfTrials];

            for(int trial = 0; trial < numberOfTrials; trial++)
            {
                long duration_Array = 0;
                int count_Array = 0;
                long start_Array = getCurrentTime();
                while(duration_Array < timeBudgetInNanoseconds)
                {
                    int target = random.nextInt(16000);
                    binaryTree_Array.contains(target);
                    count_Array++;
                    duration_Array = getCurrentTime() - start_Array;
                }
                numberOfSearchesPerTrial_Array[trial] = count_Array;

                long duration_ArrayList = 0;
                int count_ArrayList = 0;
                long start_ArrayList = getCurrentTime();
                while(duration_ArrayList < timeBudgetInNanoseconds)
                {
                    int target = random.nextInt(16000);
                    binaryTree_ArrayList.contains(target);
                    count_ArrayList++;
                    duration_ArrayList = getCurrentTime() - start_ArrayList;
                }
                numberOfSearchesPerTrial_ArrayList[trial] = count_ArrayList;
            }

            double averageNumberOfSearches_Array = 0;
            double averageNumberOfSearches_ArrayList = 0;
            for(int i = 0; i < numberOfTrials; i++)
            {
                averageNumberOfSearches_Array += numberOfSearchesPerTrial_Array[i];
                averageNumberOfSearches_ArrayList += numberOfSearchesPerTrial_ArrayList[i];
            }
            averageNumberOfSearches_Array /= numberOfTrials;
            averageNumberOfSearches_ArrayList /= numberOfTrials;

            System.out.println("Search counts: 3 trials of 0.3s for bintree");
            System.out.println("  Array: " + Arrays.toString(numberOfSearchesPerTrial_Array));
            System.out.println("  ArrayList: " + Arrays.toString(numberOfSearchesPerTrial_ArrayList));
            System.out.println("Average searches per trial:");
            System.out.println("  Array: " + averageNumberOfSearches_Array);
            System.out.println("  ArrayList: " + averageNumberOfSearches_ArrayList);
            return;
        }
        else if(!Objects.equals(searchingAlgorithmNickName, "lin"))
        {
            Algorithms.quickSort(baseArr);
            Algorithms.quickSort(baseArrList);
        }
        
        double[] averageNumberOfSearchesPerTrial_Array = new double[numberOfTrials];
        double[] numberOfSearchesPerTrial_ArrayList = new double[numberOfTrials];
        
        for(int trial = 0; trial < numberOfTrials; trial++)
        {
            long duration_Array = 0;
            int count_Array = 0;
            long start_Array = getCurrentTime();
            while(duration_Array < timeBudgetInNanoseconds)
            {
                int target = random.nextInt(16000);
                if(Objects.equals(searchingAlgorithmNickName, "lin"))
                {
                    Algorithms.linearSearch(baseArr, target);
                }
                else if(Objects.equals(searchingAlgorithmNickName, "itbin"))
                {
                    Algorithms.iterativeBinarySearch(baseArr, target);
                }
                else if(Objects.equals(searchingAlgorithmNickName, "recbin"))
                {
                    Algorithms.recursiveBinarySearch(baseArr, target);
                }
                count_Array++;
                duration_Array = getCurrentTime() - start_Array;
            }
            averageNumberOfSearchesPerTrial_Array[trial] = count_Array;
            
            long duration_ArrayList = 0;
            int count_ArrayList = 0;
            long start_ArrayList = getCurrentTime();
            while(duration_ArrayList < timeBudgetInNanoseconds)
            {
                int target = random.nextInt(16000);
                if(Objects.equals(searchingAlgorithmNickName, "lin"))
                {
                    Algorithms.linearSearch(baseArrList, target);
                }
                else if(Objects.equals(searchingAlgorithmNickName, "itbin"))
                {
                    Algorithms.iterativeBinarySearch(baseArrList, target);
                }
                else if(Objects.equals(searchingAlgorithmNickName, "recbin"))
                {
                    Algorithms.recursiveBinarySearch(baseArrList, target);
                }
                count_ArrayList++;
                duration_ArrayList = getCurrentTime() - start_ArrayList;
            }
            numberOfSearchesPerTrial_ArrayList[trial] = count_ArrayList;
        }
        
        double averageNumberOfSearches_Array = 0;
        double averageNumberOfSearches_ArrayList = 0;
        for(int i = 0; i < numberOfTrials; i++)
        {
            averageNumberOfSearches_Array += averageNumberOfSearchesPerTrial_Array[i];
            averageNumberOfSearches_ArrayList += numberOfSearchesPerTrial_ArrayList[i];
        }
        averageNumberOfSearches_Array /= numberOfTrials;
        averageNumberOfSearches_ArrayList /= numberOfTrials;
        
        System.out.println("Algorithm: " + searchingAlgorithmNickName + " on 10k array");
        System.out.println("Searches completed in 3 trials of 0.3s:");
        System.out.println("  Array: " + Arrays.toString(averageNumberOfSearchesPerTrial_Array));
        System.out.println("  ArrayList: " + Arrays.toString(numberOfSearchesPerTrial_ArrayList));
        System.out.println("Average searches per 0.3s trial:");
        System.out.println("  Array: " + averageNumberOfSearches_Array);
        System.out.println("  ArrayList: " + averageNumberOfSearches_ArrayList);
    }
    
    //Gives the average of 3 number of completed binary tree builds in a 0.3 second window
    public static void measureBinaryTreeBuildThroughput()
    {
        int numberOftrials = 3;
        int[] baseArr = new int[16000];
        randomlyInject(baseArr, 16000);
        ArrayList<Integer> baseArrList = new ArrayList<>();
        addArrayContentToArrayList(baseArr, baseArrList);
        
        double[] treesPerTrial_Array = new double[numberOftrials];
        double[] treesPerTrial_ArrayList = new double[numberOftrials];
        
        for(int trial = 0; trial < numberOftrials; trial++)
        {
            long duration_Array = 0;
            int count_Array = 0;
            long start_Array = getCurrentTime();
            while(duration_Array < timeBudgetInNanoseconds)
            {
                BinaryTree<Integer> bt = new BinaryTree<>();
                for(int x : baseArr)
                {
                    bt.add(x);
                }
                count_Array++;
                duration_Array = getCurrentTime() - start_Array;
            }
            treesPerTrial_Array[trial] = count_Array;
            
            long duration_ArrayList = 0;
            int count_ArrayList = 0;
            long start_ArrayList = getCurrentTime();
            while(duration_ArrayList < timeBudgetInNanoseconds)
            {
                BinaryTree<Integer> bt = new BinaryTree<>();
                for(int x : baseArrList)
                {
                    bt.add(x);
                }
                count_ArrayList++;
                duration_ArrayList = getCurrentTime() - start_ArrayList;
            }
            treesPerTrial_ArrayList[trial] = count_ArrayList;
        }
        
        double averageNumberOfTrees_Array = 0;
        double averageNumberOfTrees_ArrayList = 0;
        for(int i = 0; i < numberOftrials; i++)
        {
            averageNumberOfTrees_Array += treesPerTrial_Array[i];
            averageNumberOfTrees_ArrayList += treesPerTrial_ArrayList[i];
        }
        averageNumberOfTrees_Array /= numberOftrials;
        averageNumberOfTrees_ArrayList /= numberOftrials;
        
        System.out.println("Binary Tree Build Throughput on 16k data:");
        System.out.println("Trees built in 3 trials of 0.3s:");
        System.out.println("  Array: " + Arrays.toString(treesPerTrial_Array));
        System.out.println("  ArrayList: " + Arrays.toString(treesPerTrial_ArrayList));
        System.out.println("Average trees per 0.3s trial:");
        System.out.println("  Array: " + averageNumberOfTrees_Array);
        System.out.println("  ArrayList: " + averageNumberOfTrees_ArrayList);
    }
    
    public static void main (String[] args)
    {
        compareSortingAlgorithmsForArrayVersusArrayList("quick");
    }
}
