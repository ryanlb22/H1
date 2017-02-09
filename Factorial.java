import java.util.Scanner;

public class Factorial{
    public static void main(String[] args){
    	//Input a number using scanner
    	Scanner input = new Scanner(System.in);
    	System.out.println("Please enter a value: ");
    	int i = input.nextInt();
    	
    	//If statement to find if value is positive or negative
    	if(i < 1){
    		System.out.println("Error, please enter a positive value: ");
    		i =input.nextInt();	
    	}
    	
    	//Gets factorial of a value and prints out the product
    	int product = fact(i);
    	System.out.println(product);
}
    
    public static int fact(int k){
    	int product =1;
    	for(int i=1;i<=k;i++){
    		product = product * i;
    	}
    	return product; 
    }
}