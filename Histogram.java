import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Histogram {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("How many input values [max:30]?");
		int values = input.nextInt();
		
		if(values > 30 || values < 0)
		{
			System.out.println("Error please enter a value less than 30...");
			values = input.nextInt();
		}
		
		System.out.println("Enter " + values + " numbers");
		int[] numList = new int[values];
		int[] numList2 = new int[values];
		
		int temp = 0;
		for(int i = 0 ; i < numList.length ; i++ ){
			numList[i] = input.nextInt();
			numList2[i] += numList[i];
		}
		
		Arrays.sort(numList2);
		
		for(int g = 0; g<numList2.length ;g++)
		{
			System.out.println(numList2[g]);
			
		}
		
		System.out.println("Length of array: " + numList2.length);
		int[] occurence = new int[numList2.length];
		for(int a = 0 ; a < numList2.length -1 ; a++){
			if(numList2[a]==numList2[a+1])
			{
				temp = numList2[a];
				occurence[temp]++;
			}
		}
		//System.out.println(occurence[1]);
		
		
		System.out.println("Number" + "		"+ "Occurences");
		
		/*for(int a = 0 ; a < numList2.length ; a++){
			if(occurence[a]>0 && occurence[a]==1){
				System.out.println(numList2[a]+"		" + occurence[a]);
			}
			else if(occurence[a]>=2){
			System.out.println(numList2[a]+"		" + occurence[a]);
			
			} 
		}*/
		for(int j =0; j<numList2.length;j++){
			System.out.println(numList2[j]+"     "+occurence[j]);
		}
		
	}
}

