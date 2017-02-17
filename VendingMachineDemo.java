/*
 * Ryan LeBon
 * Software Design 338
 * Vending Machine Simulator
 * Created on 2/17/2017 
 * All rights reserved
 */

public class VendingMachineDemo {
	public static void main(String[] args) {
			VendingMachine machine1 = new VendingMachine(100, "Bit Building");
			VendingMachine machine2 = new VendingMachine(200, "Library");
			System.out.println("===== Welcome to the CSUMB Vending Machine =====");
			machine1.machineInfo();
			System.out.println("");
			System.out.println("\n=== Compare Two Machines ===");
			System.out.println(machine1.equals(machine2));
			machine1.setMoneyItems(1.25,2.35,1.75,4.25);
			machine1.setLocation("BIT104");
			machine1.setName(50);
			
			machine1.setName(100);
			
			System.out.println("\n=== Machine Reset ===");
			
			machine1.setItems(4, 5, 5, 6); // Sets items of machine
			machine1.addItems(1,2,3,4); // A system admin can add items to the machine
			
			machine1.machineInfo();//displays the info of the machine
			machine1.displayMenu();//displays the menu for the machine
			machine1.buyItem();//prompts user to buy item
			machine1.returnItem();//prompts user to return item
			machine1.payForItems();//prompts user to pay for items
			machine1.printReciept();// prints the receipt with tax
			machine1.soldItems();//shows the items that are sold
		}
}