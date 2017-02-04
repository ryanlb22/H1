import java.io.*;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
//Ryan LEBON
//Homework 1 
//Software Design 338
public class SortedString{
    public static void main(String[ ] args)throws FileNotFoundException{
/*
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the path name: ");
        String inputFile =input.next();
        */
        Scanner lineReader = new Scanner(new File("t1.txt"));
/*
        Scanner output = new Scanner(System.in);
        System.out.println("Enter new path name: ");
        String outputFile = output.next();
        */
        PrintWriter linePrinter =  new PrintWriter("t1_result.txt");
        
        //number of lines in text file
        int numLines = 6;
        //two arrays to store the words
        String lineArray[] = new String[1000];
        String newArray[] = new String[numLines];

         System.out.println("Original Array: ");
        for (int i = 0; i < numLines;i++)
        {
            lineArray[i]=lineReader.nextLine();
            // create new array and add the line array to this list
            newArray[i]=lineArray[i];
            System.out.println(newArray[i]);
        }
        //sort the new array
        Arrays.sort(newArray);

        for(int a =0 ;a <numLines;a++)
        {
            //write the lines to the new text file
           linePrinter.println(newArray[a]);
        }

        //close the printer and readers after use
        linePrinter.close();
        lineReader.close();



    }
}