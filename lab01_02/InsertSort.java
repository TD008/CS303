import java.io.*;

public class InsertSort{
    
    public static int[] implementAlg(int[] arr){
        
        // Variables that are needed for the algorithm
        int[] sortedArr = arr;        
        int size = arr.length;
        int i;
        int j;
        int key;

        // For loop implementing the insertion sort algorithm. 
        for (j = 1; j < size; j++){
           
            key = sortedArr[j];

            i = j-1;

            while((i >= 0) && (sortedArr[i] > key)){

                sortedArr[i+1] = sortedArr[i];

                i = i-1;

            sortedArr[i+1] = key;

            }
        }

        return sortedArr;

    }

    public static boolean ensureSorted(int[] arr){
    // Method to test if an array is sorted correctly

        int length = arr.length;

        for (int i = 0; i < length - 1; i++){

            if (arr[i] > arr[i+1]){ return false; }

        }
        return true;
    }
}
