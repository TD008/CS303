import java.io.*;
import java.lang.Math;

public class MergeSort{
    
    public static void mergeSort(int[] A, int[] temp, int p, int r){
    // p and r are the beginning and end indexes respectively that we are splitting

        if (p < r){

            // Find the middle index of the array and split the array based on that
            // index. mergeSort is called recursively on both of these new arrays
            int q = ((p + r) / 2);
            mergeSort(A, temp, p, q);
            mergeSort(A, temp, q+1, r);
            merge(A, temp, p, q, r);
        }
    }

    public static void merge(int[] A, int[] temp, int p, int q, int r){

        int i = p;
        int j = q + 1;

        // Fill the temp array
        for (int k = p; k <= r; k++){
            
            temp[k] = A[k];
        }

        // Merge the arrays
        for (int k = p; k <= r; k++){

            if(i>q){
                
                A[k] = temp[j];
                j++; 
            
            }else if (j > r) {

                A[k] = temp[i];
                i++;

            }else if (temp[j] < temp[i]){

                A[k] = temp[j];
                j++;
            
            }else {

                A[k] = temp[i];
                i++;
            } 
        }
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
