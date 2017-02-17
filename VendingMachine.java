/*
 * Ryan LeBon
 * Software Design 338
 * Vending Machine Simulator
 * Created on 2/17/2017 
 * All rights reserved
 */
import java.util.Scanner;
public class VendingMachine {
	private Scanner input = new Scanner(System.in);
	private int serialNumber;
	private String locationMachine = "UNKNOWN";
	private int[] content = new int[4];
	private int[] soldContent = new int[4];
	private float[] money = new float[4];
	private float finalPrice;
	private int purchase;
	private int purchaseQuantity;
	private String[] products = new String[4];
	private String[] shoppingCart = new String[4];
	private double finalFinalPrice;
	
//sets items,serial number and location
	public VendingMachine(int i, String location) {
		// TODO Auto-generated constructor stub
		serialNumber = i;
		locationMachine = location;
		products[0] = "Water";
		products[1] = "Coffee";
		products[2] = "Sun Chips";
		products[3] = "Chocolate Bar";
	}
//displays info of the machine
	public void machineInfo(){
		System.out.println("Serial Number: " + serialNumber);
		System.out.println("Location: " + locationMachine);
		System.out.println("Contents:");
		System.out.println(" Water: " + content[0]);
		
		System.out.println(" Coffee: " + content[1]);
		System.out.println(" Sun Chips: " + content[2]);
		System.out.println(" Chocolate Bar: " + content[3]);
	}
	
	// sets location of machine
	public void setLocation(String location) {
		// TODO Auto-generated method stub
		locationMachine = location;	
	}
	
	//sets name for the machine
	public void setName(int newName) {
		// TODO Auto-generated method stub
		serialNumber = newName;	
	}
	
	//sets money for the items
	public void setMoneyItems(double i,double j, double k, double l){
		money[0] += i;
		money[1] += j;
		money[2] += k;
		money[3] += l;
	}
	//sets the value of items
	public void setItems(int i, int j, int k, int l) {
		// TODO Auto-generated method stub
		content[0] = i;
		content[1] = j;
		content[2] = k;
		content[3] = l;
	}
	//adds more values to the items
	public void addItems(int i, int j, int k, int l) {
		// TODO Auto-generated method stub
		content[0] += i;
		content[1] += j;
		content[2] += k;
		content[3] += l;
	}
	
	public void displayMenu() {
		// TODO Auto-generated method stub
		System.out.println("\n===== Vending Machine Menu =====");
		System.out.println("1. Water................$" + money[0]);
		System.out.println("2. Regular Coffee.......$" + money[1]);
		System.out.println("3. Sun Chips............$" + money[2]);
		System.out.println("4. Chocolate Bar........$" + money[3]);	
	}
	
	public void buyItem() {
		// TODO Auto-generated method stub
		System.out.println("\n=== Buy an Item ===");
		System.out.println("Select an item number");
		purchase = input.nextInt();
		if(purchase > 4 || purchase < 1)
		{
			System.out.println("Error value out of range!");
			buyItem();
		}
		System.out.println("How many do you want to buy?");
		purchaseQuantity = input.nextInt();
		if(purchaseQuantity > content[0] || purchaseQuantity > content[1] || purchaseQuantity > content[2] || purchaseQuantity > content[3])
		{
			System.out.println("Error way to much sh**!");
			buyItem();
		}
		
		switch(purchase){
		case 1: System.out.println("\n You selected Water." + " Quantity: " + purchaseQuantity);
				finalPrice = money[0]*purchaseQuantity;
				shoppingCart[0] = "Water";
				soldContent[0] += purchaseQuantity;
				System.out.println(shoppingCart[0]);
				System.out.printf("\nThe price is $" + "%.2f", finalPrice);
				content[0] -= purchaseQuantity;
				break;
		case 2: System.out.println("\nYou selected Regular Coffee." + " Quantity: " + purchaseQuantity);
				finalPrice = money[1]*purchaseQuantity;
				soldContent[1] += purchaseQuantity;
				shoppingCart[1] = "Regular Coffee";
				System.out.printf("\nThe price is $" + "%.2f",finalPrice);
				content[1] -= purchaseQuantity;
				break;
		case 3: System.out.println("\nYou selected Sun Chips." + " Quantity: " + purchaseQuantity);
				finalPrice = money[2]*purchaseQuantity;
				shoppingCart[2] = "Sun Chips";
				soldContent[2] += purchaseQuantity;
				System.out.printf("\nThe price is $" + "%.2f",finalPrice);
				content[2] -= purchaseQuantity;
				break;
		case 4: System.out.println("\nYou selected Chocolate Bar." + " Quantity: " + purchaseQuantity);
				finalPrice = money[3]*purchaseQuantity;
				soldContent[3] += purchaseQuantity;
				shoppingCart[3] ="Chocolate Bar";
				System.out.printf("\nThe price is $" + "%.2f",finalPrice);
				content[3] -= purchaseQuantity;
				break;
		
		}	
	}
	
	public void returnItem() {
		// TODO Auto-generated method stub
		char choice;
		System.out.println("\n=== Do you want to return an item? Y/N ===");
		choice = input.next(".").charAt(0);
		if(choice == 'Y' || choice == 'y')
		{
			displayMenu();
			System.out.println("\n What item do you want to return?");
			purchase = input.nextInt();
			System.out.println("\n How many items do you want to return?");
			purchaseQuantity = input.nextInt();
			switch(purchase){
					case 1: content[0] += purchaseQuantity;
							System.out.println("You returned Water." + " Quantity: " + purchaseQuantity);
							break;
					case 2: content[1] += purchaseQuantity; 
							System.out.println("You returned Regular Coffee." + " Quantity: " + purchaseQuantity);
							break;
					case 3: content[2] += purchaseQuantity;
							System.out.println("You returned Sun Chips." + " Quantity: " + purchaseQuantity);
							break;
					case 4: content[3] += purchaseQuantity;
							System.out.println("You returned Chocolate Bar." + " Quantity: " + purchaseQuantity);
							break;
			
			}
		}
		if(choice == 'N' || choice == 'n')
		{
			System.out.println("\nNo items returned");
		}	
	}
	public void payForItems(){
		float payment = 0;
		float rPayment = 0;
		System.out.println("\n\n=== Pay for items selected. ===");
		System.out.printf("The total price is $%.2f",finalPrice);
		System.out.print("\nEnter money amount:");
		payment = input.nextFloat();
		if(payment < finalPrice)
		{
			System.out.printf("Insufficient money. $%.2f",payment);
			System.out.print(" returned");
			System.out.println("\n=== Invalid payment. Try one more time. ===");
			payForItems();
		}
		else{
			rPayment = payment-finalPrice;
			System.out.printf("Sufficient money. $%.2f",rPayment);
			System.out.print(" returned");
		}
	}
	public void printReciept(){
		System.out.println("\n\n=== Print Receipt ===");
		double tax;
		for(int i = 0; i <shoppingCart.length;i++)
		{
			if(shoppingCart[0]=="Water")
			{
				
				System.out.print(shoppingCart[0] + ": " + money[0] +" X " + purchaseQuantity);
				System.out.printf(" = %.2f", finalPrice);
				tax = finalPrice * 0.1;
				System.out.println("\nTax (10.0%): $" + tax);
				finalFinalPrice = tax + finalPrice;
				System.out.println("Total: $"+finalFinalPrice);
				break;
			}
			if(shoppingCart[1]=="Regular Coffee")
			{
				System.out.print(shoppingCart[1] + ": " + money[1] + " X " + purchaseQuantity);
				System.out.printf(" = %.2f", finalPrice);
				tax = finalPrice * 0.1;
				System.out.println("\nTax (10.0%): $" + tax);
				finalFinalPrice = tax + finalPrice;
				System.out.println("Total: $"+finalFinalPrice);
				break;
			}
			if(shoppingCart[2]=="Sun Chips")
			{
				System.out.print(shoppingCart[2] + ": " + money[2] + " X " + purchaseQuantity);
				System.out.printf(" = %.2f", finalPrice);
				tax = finalPrice * 0.1;
				System.out.println("\nTax (10.0%): $" + tax);
				finalFinalPrice = tax + finalPrice;
				System.out.println("Total: $"+finalFinalPrice);
				break;
			}
			if(shoppingCart[3]=="Chocolate Bar")
			{
				System.out.print(shoppingCart[3] + ": " + money[3] + " X " + purchaseQuantity);
				System.out.printf(" = %.2f", finalPrice);
				tax = finalPrice * 0.1;
				System.out.println("\nTax (10.0%): $" + tax);
				finalFinalPrice = tax + finalPrice;
				System.out.println("Total: $" + finalFinalPrice);
				break;
			}	
		}
		
		
	}
	public void soldItems(){
		System.out.println("\n=== Machine Status ===");
		System.out.println("Serial Number: " + serialNumber);
		System.out.println("Location: " + locationMachine);
		System.out.println("Sold Items: ");
		System.out.println(" Water: " + soldContent[0]);
		System.out.println(" Coffee: " + soldContent[1]);
		System.out.println(" Sun Chips: " + soldContent[2]);
		System.out.println(" Chocolate Bar: "+ soldContent[3]);
		System.out.println("Current Contents:");
		System.out.println(" Water: " + content[0]);
		System.out.println(" Coffee: " + content[1]);
		System.out.println(" Sun Chips: " + content[2]);
		System.out.println(" Chocolate Bar: " + content[3]);
		System.out.println("Total Earning: $"+finalFinalPrice);
		System.out.println("\n===== Thank you! =====");
		
	}
}