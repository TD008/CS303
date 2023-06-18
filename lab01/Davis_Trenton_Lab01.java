import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Davis_Trenton_Lab01{
	
    public static void main(String[] args){
        
        int[] arr = {1, 3, 2, 5, 7, 3, 2};

        readArrFiles(".//data");
        

    	
	}	


    public static void readArrFiles(String arrPath){

        System.out.print("message");

        // Create an object of type File using the path to the directory
        // that holds the array files that we will use. Each array file in that
        // directory is then stored in a list of type File using the .listFiles 
        // method that is associated with the first File object that was created 
        File directory = new File(arrPath);
        File[] arrFiles = directory.listFiles();

        for (File file: files){
            if (file.isFile()){
                try{
                    String strArr = new String(Files.readAllBytes(Paths.get
                                (file.getPath())));

                    List<String> array = new ArrayList<>(Arrays.asList(strArr.split
                                (",")));

                    System.out.println("Array from file " + file.getName() +
                            ": " + array);

                } catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }


        /*try{
            FileReader fr = new FileReader(arrPath);
        } catch(FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
       */
}




		
