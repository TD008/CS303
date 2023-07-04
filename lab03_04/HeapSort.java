import java.io.*;

public class HeapSort{

    public static void heapSort(int[] A){
        
        buildMaxHeap(A);

        // Find the length of A and also set the heapSize equal to that since they are
        // initially the same
        int lenA = A.length;
        int heapSize = lenA;

        for (int i = lenA; i >= 2; i--){
            
            A[0] = A[i];

            heapSize--;

            maxHeapify(A, 0);
        }

    }
    
    public static void buildMaxHeap(int[] A){

        // Find the length of A and also set the heapSize equal to that since they are
        // initially the same
        int lenA = A.length;
        int heapSize = lenA;


        for (int i = lenA/2; i >= 0; i--){
            maxHeapify(A, i);
        }
    }


    public static void maxHeapify(int[] A, int i){
    // Method incomplete



    }

}
