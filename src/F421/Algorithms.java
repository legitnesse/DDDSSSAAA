package F421;

import java.util.ArrayList;
import F331A.BinaryTree;

public class Algorithms 
{
    public static int linearSearch(int[] arr, int target)
    {
        for(int i = 0; i < arr.length; i++)
        {
            if(target == arr[i])
            {
                return i;
            }
        }
        return -1;
    }
    public static int linearSearch(ArrayList<Integer> arr, int target)
    {
        int i = 0;
        for(int x : arr)
        {
            if(target == x)
            {
                return i;
            }
            i++;
        }
        return -1;
    }
    public static int iterativeBinarySearch(int[] arr, int target)
    {
        int lowerIndex = 0;
        int upperIndex = arr.length - 1;
        while(lowerIndex <= upperIndex)
        {
            if(target == arr[lowerIndex])
            {
                return lowerIndex;
            }
            if(target == arr[upperIndex])
            {
                return upperIndex;
            }
            int middleIndex = lowerIndex + (upperIndex - lowerIndex) / 2;
            if(target == arr[middleIndex])
            {
                return middleIndex;
            }
            else if(target < arr[middleIndex])
            {
                upperIndex = middleIndex - 1;
            }
            else
            {
                lowerIndex = middleIndex + 1;
            }
        }
        return -1;
    }
    public static int iterativeBinarySearch(ArrayList<Integer> arr, int target)
    {
        int lowerIndex = 0;
        int upperIndex = arr.size() - 1;
        while(lowerIndex <= upperIndex)
        {
            if(target == arr.get(lowerIndex))
            {
                return lowerIndex;
            }
            if(target == arr.get(upperIndex))
            {
                return upperIndex;
            }
            int middleIndex = lowerIndex + (upperIndex - lowerIndex) / 2;
            if(target == arr.get(middleIndex))
            {
                return middleIndex;
            }
            else if(target < arr.get(middleIndex))
            {
                upperIndex = middleIndex - 1;
            }
            else
            {
                lowerIndex = middleIndex + 1;
            }
        }
        return -1;
    }
    public static int recursiveBinarySearch(int[] arr, int target)
    {
        return recursiveBinarySearch(arr, target, 0, arr.length - 1);
    }
    public static int recursiveBinarySearch(int[] arr, int target, int lowerIndex, int upperIndex)
    {
        if(upperIndex < lowerIndex)
        {
            return -1;
        }
        if(target == arr[lowerIndex])
        {
            return lowerIndex;
        }
        if(target == arr[upperIndex])
        {
            return upperIndex;
        }
        int middleIndex = lowerIndex + (upperIndex - lowerIndex) / 2;
        if(target == arr[middleIndex])
        {
            return middleIndex;
        }
        else if(target < arr[middleIndex])
        {
            return recursiveBinarySearch(arr, target, lowerIndex, middleIndex - 1);
        }
        else
        {
            return recursiveBinarySearch(arr, target, middleIndex + 1, upperIndex);
        }
    }
    public static int recursiveBinarySearch(ArrayList<Integer> arr, int target)
    {
        return recursiveBinarySearch(arr, target, 0, arr.size() - 1);
    }
    public static int recursiveBinarySearch(ArrayList<Integer> arr, int target, int lowerIndex, int upperIndex)
    {
        if(upperIndex < lowerIndex)
        {
            return -1;
        }
        if(target == arr.get(lowerIndex))
        {
            return lowerIndex;
        }
        if(target == arr.get(upperIndex))
        {
            return upperIndex;
        }
        int middleIndex = lowerIndex + (upperIndex - lowerIndex) / 2;
        if(target == arr.get(middleIndex))
        {
            return middleIndex;
        }
        else if(target < arr.get(middleIndex))
        {
            return recursiveBinarySearch(arr, target, lowerIndex, middleIndex - 1);
        }
        else
        {
            return recursiveBinarySearch(arr, target, middleIndex + 1, upperIndex);
        }
    }
    public static boolean binaryTreeSearch(int[] arr, int target)
    {
        BinaryTree<Integer> bt = new BinaryTree<>();
        for(int i : arr)
        {
            bt.add(i);
        }
        return bt.contains(target);
    }
    public static boolean binaryTreeSearch(ArrayList<Integer> arr, int target)
    {
        BinaryTree<Integer> bt = new BinaryTree<>();
        for(int i : arr)
        {
            bt.add(i);
        }
        return bt.contains(target);
    }
    public static void bubbleSort(int[] arr)
    {
        boolean neededSwap = true;
        while(neededSwap)
        {
            neededSwap = false;
            for(int i = 0; i < arr.length - 1; i++)
            {
                if(arr[i] > arr[i + 1])
                {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    neededSwap = true;
                }
            }
        }
    }
    public static void bubbleSort(ArrayList<Integer> arr)
    {
        boolean neededSwap = true;
        while(neededSwap)
        {
            neededSwap = false;
            for(int i = 0; i < arr.size() - 1; i++)
            {
                if(arr.get(i) > arr.get(i + 1))
                {
                    int temp = arr.get(i);
                    arr.set(i, arr.get(i + 1));
                    arr.set(i + 1, temp);
                    neededSwap = true;
                }
            }
        }
    }
    public static void insertionSort(int[] arr)
    {
        for(int i = 1; i < arr.length; i++)
        {
            int currentValue = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > currentValue)
            {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = currentValue;
        }
    }
    public static void insertionSort(ArrayList<Integer> arr)
    {
        for(int i = 1; i < arr.size(); i++)
        {
            int currentValue = arr.get(i);
            int j = i - 1;
            while(j >= 0 && arr.get(j) > currentValue)
            {
                arr.set(j + 1, arr.get(j));
                j--;
            }
            arr.set(j + 1, currentValue);
        }
    }
    public static void selectionSort(int[] arr)
    {
        for(int i = 0; i < arr.length; i++)
        {
            int minimumValueIndex = i;
            for(int j = i + 1; j < arr.length; j++)
            {
                if(arr[j] < arr[minimumValueIndex])
                {
                    minimumValueIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minimumValueIndex];
            arr[minimumValueIndex] = temp;
        }
    }
    public static void selectionSort(ArrayList<Integer> arr)
    {
        for(int i = 0; i < arr.size(); i++)
        {
            int minimumValueIndex = i;
            for(int j = i + 1; j < arr.size(); j++)
            {
                if(arr.get(j) < arr.get(minimumValueIndex))
                {
                    minimumValueIndex = j;
                }
            }
            int temp = arr.get(i);
            arr.set(i, arr.get(minimumValueIndex));
            arr.set(minimumValueIndex, temp);
        }
    }
    public static void shellSort(int[] arr)
    {
        for(int stepSize = arr.length / 2; stepSize > 0; stepSize /= 2)
        {
            for(int i = stepSize; i < arr.length; i++)
            {
                int currentValue = arr[i];
                int j = i - stepSize;
                while(j >= 0 && arr[j] > currentValue)
                {
                    arr[j + stepSize] = arr[j];
                    j -= stepSize;
                }
                arr[j + stepSize] = currentValue;
            }
        }
    }
    public static void shellSort(ArrayList<Integer> arr)
    {
        for(int stepSize = arr.size() / 2; stepSize > 0; stepSize /= 2)
        {
            for(int i = stepSize; i < arr.size(); i++)
            {
                int currentValue = arr.get(i);
                int j = i - stepSize;
                while(j >= 0 && arr.get(j) > currentValue)
                {
                    arr.set(j + stepSize, arr.get(j));
                    j -= stepSize;
                }
                arr.set(j + stepSize, currentValue);
            }
        }
    }
    public static void mergeSort(int[] arr)
    {
        if(arr.length <= 1)
        {
            return;
        }
        int[] aux = new int[arr.length];
        mergeSort(arr, aux, 0, arr.length - 1);
    }
    private static void mergeSort(int[] arr, int[] aux, int lowerIndex, int upperIndex)
    {
        if(lowerIndex >= upperIndex)
        {
            return;
        }
        int middleIndex = lowerIndex + (upperIndex - lowerIndex) / 2;
        mergeSort(arr, aux, lowerIndex, middleIndex);
        mergeSort(arr, aux, middleIndex + 1, upperIndex);
        merge(arr, aux, lowerIndex, middleIndex, upperIndex);
    }
    private static void merge(int[] arr, int[] aux, int lowerIndex, int middleIndex, int upperIndex)
    {
        for(int k = lowerIndex; k <= upperIndex; k++)
        {
            aux[k] = arr[k];
        }
        int i = lowerIndex;
        int j = middleIndex + 1;
        int k = lowerIndex;
        while(i <= middleIndex && j <= upperIndex)
        {
            if(aux[i] <= aux[j])
            {
                arr[k++] = aux[i++];
            }
            else
            {
                arr[k++] = aux[j++];
            }
        }
        while(i <= middleIndex)
        {
            arr[k++] = aux[i++];
        }
        while(j <= upperIndex)
        {
            arr[k++] = aux[j++];
        }
    }
    public static void mergeSort(ArrayList<Integer> arr)
    {
        if(arr.size() <= 1)
        {
            return;
        }
        ArrayList<Integer> aux = new ArrayList<>(arr);
        mergeSort(arr, aux, 0, arr.size() - 1);
    }
    private static void mergeSort(ArrayList<Integer> arr, ArrayList<Integer> aux, int lowerIndex, int upperIndex)
    {
        if(lowerIndex >= upperIndex)
        {
            return;
        }
        int middleIndex = lowerIndex + (upperIndex - lowerIndex) / 2;
        mergeSort(arr, aux, lowerIndex, middleIndex);
        mergeSort(arr, aux, middleIndex + 1, upperIndex);
        merge(arr, aux, lowerIndex, middleIndex, upperIndex);
    }
    private static void merge(ArrayList<Integer> arr, ArrayList<Integer> aux, int lowerIndex, int middleIndex, int upperIndex)
    {
        for(int k = lowerIndex; k <= upperIndex; k++)
        {
            aux.set(k, arr.get(k));
        }
        int i = lowerIndex;
        int j = middleIndex + 1;
        int k = lowerIndex;
        while(i <= middleIndex && j <= upperIndex)
        {
            if(aux.get(i) <= aux.get(j))
            {
                arr.set(k++, aux.get(i++));
            }
            else
            {
                arr.set(k++, aux.get(j++));
            }
        }
        while(i <= middleIndex)
        {
            arr.set(k++, aux.get(i++));
        }
        while(j <= upperIndex)
        {
            arr.set(k++, aux.get(j++));
        }
    }
    public static void quickSort(int[] arr)
    {
        quickSort(arr, 0, arr.length - 1);
    }
    public static void quickSort(int[] arr, int lowerIndex, int upperIndex)
    {
        if(lowerIndex < upperIndex)
        {
            int p = partition(arr, lowerIndex, upperIndex);
            quickSort(arr, lowerIndex, p - 1);
            quickSort(arr, p + 1, upperIndex);
        }
    }
    public static int partition(int[] arr, int lowerIndex, int upperIndex)
    {
        int pivotValue = arr[upperIndex];
        int i = lowerIndex - 1;
        for(int j = i + 1; j < upperIndex + 1; j++)
        {
            if(arr[j] < pivotValue)
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = pivotValue;
        arr[upperIndex] = temp;
        return i + 1;
    }
    public static void quickSort(ArrayList<Integer> arr)
    {
        quickSort(arr, 0, arr.size() - 1);
    }
    public static void quickSort(ArrayList<Integer> arr, int lowerIndex, int upperIndex)
    {
        if(lowerIndex < upperIndex)
        {
            int p = partition(arr, lowerIndex, upperIndex);
            quickSort(arr, lowerIndex, p - 1);
            quickSort(arr, p + 1, upperIndex);
        }
    }
    public static int partition(ArrayList<Integer> arr, int lowerIndex, int upperIndex)
    {
        int pivotValue = arr.get(upperIndex);
        int i = lowerIndex - 1;
        for(int j = i + 1; j < upperIndex + 1; j++)
        {
            if(arr.get(j) < pivotValue)
            {
                i++;
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
        int temp = arr.get(i + 1);
        arr.set(i + 1, pivotValue);
        arr.set(upperIndex, temp);
        return i + 1;
    }
}
