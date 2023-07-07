import Java.io.*;

public class QuickSort{

   public static int[] quickSort(int[] A, int p, int r){

        if (p<r){
            
            q = QuickSort.partition(A, p, r);
            QuickSort.quickSort(A, p, q-1);
            QuickSort.quickSort(A, q+1, r);

        }

        return A;
   }

   public static partition(int[] A, int p, int r){

       int x = A[r];
       int i = p-1;

       for (int j = p; j< r; j++){

           if (A[j] <= x){

               i ++;

               int temp = arr[i];
               arr[i] = arr[j];
               arr[j] = temp;
           }
       }

       int temp = arr[i + 1];
       arr[i + 1] = arr[r];
       arr[r] = temp;

       return i + 1;
   }

}
