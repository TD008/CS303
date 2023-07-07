// 
// Davis_Trenton_Lab01
//
// Written by Trenton Davis on 06202023
//
// Sources:
// https://www.geeksforgeeks.org/how-to-write-data-into-excel-sheet-using-java/
// https://www.geeksforgeeks.org/writing-a-csv-file-in-java-using-opencsv/

// Package imports
import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;

public class Lab03_04_driver{
	
    public static void main(String[] args){
        

        // Calling the readArrFiles method which will read in our data files
        // with the arrays in them and place them in a list of arrays
        List<int[]> arraysList =  readArrFiles(".//data");

        // Find the size of the list of arrays for use in the loop below
        int listSize = arraysList.size();
        
        System.out.println("Heap Sort:");

        // For loop to iterate through each array that is in arrayList and call 
        // the InsertSort.implementAlg method on it to sort the arrays
        for(int i = 0; i < listSize; i++){

            // Find the length of the array we are sorting
            int len = arraysList.get(i).length;

            System.out.println("Length:" + len);

            // Find the current time which will mark the start time of the sorting algorithm
            long startTime = System.nanoTime();

            int[] A = arraysList.get(i);

            // Implement the insertion sort algorithm from the InsertSort class
            int[] arr2 = HeapSort.heapSort(A);

            // Find the current time again which will mark the end time of the 
            // sorting algorithm and subtract the start time to find the elapsed
            // time
            long endTime = System.nanoTime();
            long elapsedTime = (endTime - startTime) ; // Time in nanoseconds
        
            System.out.println("Time: " + elapsedTime);
            
            if (HeapSort.ensureSorted(arr2)){

                System.out.println("Sorted correctly");
            }
        }

        System.out.println("Quick Sort:");

        // For loop to iterate through each array that is in arrayList and call 
        // the MergeSort.merge method on it to sort the arrays
        for(int i = 0; i < listSize; i++){

            // Find the length of the array we are sorting
            int len = arraysList.get(i).length;

            System.out.println("Length:" + len);

            // Find the current time which will mark the start time of the sorting algorithm
            long startTime = System.nanoTime();

            // Getting the real and temp arrays for the merge sort method call below
            int [] A = arraysList.get(i);
            int[] temp = new int[A.length];

            // Implement the insertion sort algorithm from the InsertSort class
            HeapSort.heapSort(A);

            // Find the current time again which will mark the end time of the 
            // sorting algorithm and subtract the start time to find the elapsed
            // time
            long endTime = System.nanoTime();
            long elapsedTime = (endTime - startTime) ; // Time in nanoseconds
        
            System.out.println("Time: " + elapsedTime);
            
            if (HeapSort.ensureSorted(A)){

                System.out.println("Sorted correctly");
            }
        }
    	
	}	


    public static List<int[]> readArrFiles(String arrPath){

        // Create an object of type File using the path to the directory
        // that holds the array files that we will use. Each array file in that
        // directory is then stored in a list of type File using the .listFiles 
        // method that is associated with the first File object that was created 
        File directory = new File(arrPath);
        File[] arrFiles = directory.listFiles();

        // Initialize the list of int arrays that will hold the contents of each file
        List<int[]> arrList = new ArrayList<>();

        // For loop to iterate through the files and store their values into an array
        // and then store the arrays in a list
        for (File file: arrFiles){

            if (file.isFile()){

                try{

                    // Getting the path of the file using the File.getPath() method
                    //String strPath = file.getPath();
                    
                    // Convert the string path of the file into a Path object
                   // Path path = Paths.get(strPath);
                    String strArr = new String(Files.readAllBytes(Paths.get(file.getPath()))); 
                    // Create a new string that holds the contents of the file. The
                    // readAllBytes method takes a Path object and returns a byte
                    // array which is passed to the String constructor to make a 
                    // string object
                    //String strArr = new String(Files.readAllBytes(path));

                    String[] strVals = strArr.split(","); 

                    int svLen = strVals.length;

                    int[] intVals = new int[svLen]; 

                    for (int i = 0; i<svLen; i++) {
                        intVals[i] = Integer.parseInt(strVals[i].trim());
                    }

                    // Add the int array we made above to our list of arrays
                    arrList.add(intVals);


                } catch(IOException e){
                    e.printStackTrace();
                }
            }
        }

        return arrList;
    }
}



		
