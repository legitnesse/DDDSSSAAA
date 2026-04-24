package F421;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import F331A.BinaryTree;

public class Algorithms 
{
    public static int linearSearch(int[] arr, int target)
    {
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == target)
            {
                return i;
            }
        }
        return -1;
    }
    public static <T> int linearSearch(ArrayList<T> arrList, T target)
    {
        Iterator<T> iterator = arrList.iterator();
        int index = 0;
        while(iterator.hasNext())
        {
            
            if(Objects.equals(iterator.next(), target))
            {
                return index;
            }
            index++;
        }
        return -1;
    }
    public static <T> int linearSearch(T[] arr, T target)
    {
        for(int i = 0; i < arr.length; i++)
        {
            if(Objects.equals(arr[i], target))
            {
                return i;
            }
        }
        return -1;
    }
    public static int linearBinarySearch(int[] arr, int target)
    {
        int lowerIndex = 0;
        int upperIndex = arr.length - 1;
        while(lowerIndex <= upperIndex)
        {
            if(arr[lowerIndex] == target)
            {
                return lowerIndex;
            }
            else if(arr[upperIndex] == target)
            {
                return upperIndex;
            }
            else
            {
                int middleIndex = lowerIndex + (upperIndex - lowerIndex) / 2;
                if(arr[middleIndex] == target)
                {
                    return middleIndex;
                }
                else if(arr[middleIndex] > target)
                {
                    upperIndex = middleIndex - 1;
                }
                else
                {
                    lowerIndex = middleIndex + 1;
                }
            }
        }
        return -1;
    }
    public static <T extends Comparable<? super T>> int linearBinarySearch(ArrayList<T> arrList, T target)
    {
        int lowerIndex = 0;
        int upperIndex = arrList.size() - 1;
        while(lowerIndex <= upperIndex)
        {
            if(Objects.equals(arrList.get(lowerIndex), target))
            {
                return lowerIndex;
            }
            else if(Objects.equals(arrList.get(upperIndex), target))
            {
                return upperIndex;
            }
            else
            {
                int middleIndex = lowerIndex + (upperIndex - lowerIndex) / 2;
                if(Objects.equals(arrList.get(middleIndex), target))
                {
                    return middleIndex;
                }
                else if(arrList.get(middleIndex).compareTo(target) > 0)
                {
                    upperIndex = middleIndex - 1;
                }
                else
                {
                    lowerIndex = middleIndex + 1;
                }
            }
        }
        return -1;
    }
    public static <T extends Comparable<? super T>> int linearBinarySearch(T[] arr, T target)
    {
        int lowerIndex = 0;
        int upperIndex = arr.length - 1;
        while(lowerIndex <= upperIndex)
        {
            if(Objects.equals(arr[lowerIndex], target))
            {
                return lowerIndex;
            }
            else if(Objects.equals(arr[upperIndex], target))
            {
                return upperIndex;
            }
            else
            {
                int middleIndex = lowerIndex + (upperIndex - lowerIndex) / 2;
                if(Objects.equals(arr[middleIndex], target))
                {
                    return middleIndex;
                }
                else if(arr[middleIndex].compareTo(target) > 0)
                {
                    upperIndex = middleIndex - 1;
                }
                else
                {
                    lowerIndex = middleIndex + 1;
                }
            }
        }
        return -1;
    }

    public static boolean binarySearchTree(int[] arr, int target)
    {
        BinaryTree<Integer> bt = new BinaryTree<>();
        for(int i : arr)
        {
            bt.add(i);
        }
        return bt.contains(target);
    }
    public static int recursiveBinarySearch(int[] arr, int target)
    {
        return recursiveBinarySearchHelper(arr, target, 0, arr.length - 1);
    }
    private static int recursiveBinarySearchHelper(int[] arr, int target, int lowerIndex, int upperIndex)
    {
        if(lowerIndex > upperIndex)
        {
            return -1;
        }
        else if(arr[lowerIndex] == target)
        {
            return lowerIndex;
        }
        else if(arr[upperIndex] == target)
        {
            return upperIndex;
        }
        else
        {
            int middleIndex = lowerIndex + (upperIndex - lowerIndex) / 2;
            if(arr[middleIndex] == target)
            {
                return middleIndex;
            }
            else if(arr[middleIndex] > target)
            {
                return recursiveBinarySearchHelper(arr, target, lowerIndex, middleIndex - 1);
            }
            else
            {
                return recursiveBinarySearchHelper(arr, target, middleIndex + 1, upperIndex);
            }
        }
    }
    public static void bubbleSort(int[] arr)
    {
        boolean hadSwap = true;
        while(hadSwap)
        {
            hadSwap = false;
            for(int i = 0; i < arr.length - 1; i++)
            {
                if(arr[i + 1] < arr[i])
                {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    hadSwap = true;
                }
            }
        }
    }

    public static <T extends Comparable<? super T>> void bubbleSort(ArrayList<T> arrList)
    {
        boolean hadSwap = true;
        while(hadSwap)
        {
            hadSwap = false;
            for(int i = 0; i < arrList.size() - 1; i++)
            {
                if(arrList.get(i + 1).compareTo(arrList.get(i)) < 0)
                {
                    T temp = arrList.get(i);
                    arrList.set(i, arrList.get(i + 1));
                    arrList.set(i + 1, temp);
                    hadSwap = true;
                }
            }
        }
    }
    public static <T extends Comparable<? super T>> void bubbleSort(T[] arr)
    { 
        boolean hadSwap = true;
        while(hadSwap)
        {
            hadSwap = false;
            for(int i = 0; i < arr.length - 1; i++)
            {
                if(arr[i + 1].compareTo(arr[i]) < 0)
                {
                    T temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    hadSwap = true;
                }
            }
        }
    }
    public static void insertionSort(int[] arr)
    {
        for(int i = 1; i < arr.length; i++)
        {
            int j = i - 1;
            int currentValue = arr[i];
            while(j >= 0 && arr[j] > currentValue)
            {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = currentValue;
        }
    }
    
    public static <T extends Comparable<? super T>> void insertionSort(ArrayList<T> arrList)
    {
        for(int i = 1; i < arrList.size(); i++)
        {
            int j = i - 1;
            T currentValue = arrList.get(i);
            while(j >= 0 && arrList.get(j).compareTo(currentValue) > 0)
            {
                arrList.set(j + 1, arrList.get(j));
                j--;
            }
            arrList.set(j + 1, currentValue);
        }
        
    }
    public static <T extends Comparable<? super T>> void insertionSort(T[] arr)
    {
        for(int i = 1; i < arr.length; i++)
        {
            int j = i - 1;
            T currentValue = arr[i];
            while(j >= 0 && arr[j].compareTo(currentValue) > 0)
            {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = currentValue;
        }
    }
    public static void selectionSort(int[] arr)
    {
        for(int i = 0; i < arr.length; i++)
        {
            int indexOfSmallestValue = i;
            for(int j = i + 1; j < arr.length; j++)
            {
                if(arr[j] < arr[indexOfSmallestValue])
                {
                    indexOfSmallestValue = j;
                }
            }
            if(indexOfSmallestValue != i)
            {
                int temp = arr[i];
                arr[i] = arr[indexOfSmallestValue];
                arr[indexOfSmallestValue] = temp;
            }
        }
    }
    public static <T extends Comparable<? super T>> void selectionSort(ArrayList<T> arrList)
    {
        for(int i = 0; i < arrList.size(); i++)
        {
            int indexOfSmallestValue = i;
            for(int j = i + 1; j < arrList.size(); j++)
            {
                if(arrList.get(j).compareTo(arrList.get(indexOfSmallestValue)) < 0)
                {
                    indexOfSmallestValue = j;
                }
            }
            if(indexOfSmallestValue != i)
            {
                T temp = arrList.get(i);
                arrList.set(i, arrList.get(indexOfSmallestValue));
                arrList.set(indexOfSmallestValue, temp);
            }
        }
    }
    public static <T extends Comparable<? super T>> void selectionSort(T[] arr)
    {
        for(int i = 0; i < arr.length; i++)
        {
            int indexOfSmallestValue = i;
            for(int j = i + 1; j < arr.length; j++)
            {
                if(arr[j].compareTo(arr[indexOfSmallestValue]) < 0)
                {
                    indexOfSmallestValue = j;
                }
            }
            if(indexOfSmallestValue != i)
            {
                T temp = arr[i];
                arr[i] = arr[indexOfSmallestValue];
                arr[indexOfSmallestValue] = temp;
            }
        }
    }
    public static void shellSort(int[] arr)
    {
        for(int stepSize = arr.length / 2; stepSize > 0; stepSize /= 2)
        {
            for(int i = 0; i < arr.length - stepSize; i++)
            {
                if(arr[i] > arr[i + stepSize])
                {
                    int temp = arr[i + stepSize];
                    int j;
                    for(j = i + stepSize; j > i; j--)
                    {
                        arr[j] = arr[j - 1];
                    }
                    arr[j] = temp;
                }
            }
        }
        
    }
    
}
