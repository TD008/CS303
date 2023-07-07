import java.io.*;

public class HeapSort{


    public static int[] heapSort(int[] A){
    // Method meant to be called when the heapSort algorithm is implemented. It 
    // starts by building a max heap by using the method bearing that name. It 
    // then works from the last node to the first switching them and calling 
    // maxHeapify on the new root node to fix what is then the single violation
    // of max heap
        
        buildMaxHeap(A);

        // Find the length of A for use in the loop below
        int lenA = A.length;

        for (int i = lenA - 1; i >= 0; i--){
            
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;


            // call maxHeapify to fix the single violation of max heap at 
            // index 0
            HeapSort.maxHeapify(A, 0, i);
        }

        return A;

    }
    
    public static void buildMaxHeap(int[] A){
    // Method to build the max heap from the initial unsorted array. It starts 
    // at the lenA/2-1 node because this gaurantees that the node that
    // we call maxHeapify on has max heaps at its left and right child nodes
    // because these nodes are always leaves
    

        // Find the length of A and also set the heapSize equal to that since they are
        // initially the same
        int lenA = A.length;
        //int heapSize = lenA;

        for (int i = lenA/2 -1; i >= 0; i--){
            HeapSort.maxHeapify(A, i, lenA);
        }
    }


    public static void maxHeapify(int[] A, int i, int n){
    // Method to fix a single violation of max heap. It finds the left and right
    // nodes of A[i] and switches A[i] with the larger of the two. It then
    // recursively calls itself to fix any violations of max heap resulting from 
    // that switch

    int l = 2*i+1;
    int r = 2*i+2;
    int largest = i;

    // If l exists and it is greater than A[i], then set l to largest. Else, 
    // set largest to r
    if (l < n && A[l] > A[largest]){

        largest = l;
    }

    // if A[r] exists and is greater than A[l], set largest to r
    if (r < n && A[r] > A[largest]){

        largest = r;
    }

    // If the largest index is not the parent node, switch the parent node 
    // and the largest node and call maxHeapify recursively to make sure that 
    // max heap is not violated.
    if (largest != i){
        int temp = A[i];
        A[i] = A[largest];
        A[largest] = temp;
        maxHeapify(A, largest, n);
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
