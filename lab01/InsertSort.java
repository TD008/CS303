import java.io.*;

public class InsertSort{
    
    public static int[] implementAlg(int[] arr){
        
        
        int size = arr.length;
        int i;
        int j;
        int key;

        for (j = 0; j < size; j++){
           
            key = arr[j];

            i = j-1;

            while((i > 0) && (arr[i] > key)){

                arr[i+1] = arr[i];
                i = i-1;

            arr[i+1] = key;
                
        Return arr;

            }
        }
    }
}
