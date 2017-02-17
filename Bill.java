import java.util.Scanner;

public class Bill {
  private int hours; 
  private int minutes;
  private double fee; 

  public void inputTimeWorked() {
    System.out.println("Enter number of full hours worked");
    System.out.println("followed by number of minutes:");
    Scanner keyboard = new Scanner(System.in);
    hours = keyboard.nextInt();
    minutes = keyboard.nextInt();
  }

  private double computeFee(int hoursWorked, int minutesWorked) {
    minutesWorked = hoursWorked*60 + minutesWorked;
    int quarterHours = minutesWorked/15;  //Any remaining fraction of a
                                          // quarter hour is not charged for.
    return quarterHours*150.0;
  }

  public void updateFee() {
    fee = computeFee(hours, minutes);
  }

  public void outputBill(){
    System.out.println("Time worked: ");
    System.out.println(hours + " hours and " + minutes + " minutes");
    System.out.println("Rate: $" + 150.0 + " per quarter hour.");
    System.out.println("Amount due: $" + fee);
  }
}