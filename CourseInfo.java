import java.util.Scanner;
public class CourseInfo {
  private String courseTitle;
  private String instructor;
  private int enrollment;

  public void printInfo() {
    System.out.println("Course title: " + courseTitle);
    System.out.println("Instructor: " + instructor);
    System.out.println("Enrollment: " + enrollment);
  }

  public void readInfo() {
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Enter course title: ");
    courseTitle = keyboard.nextLine( );
    System.out.print("Enter instructor name: ");
    instructor = keyboard.nextLine( );
    System.out.print("Enter enrollment: ");
    enrollment = keyboard.nextInt( );
    int[] gradeList = new int [enrollment];
    int grade = 0;
    int count = 0;
    while(count < enrollment){
    	System.out.println("Enter a Score: ");
    	grade = keyboard.nextInt( );
    	for(int i = 1 ; i < enrollment ; i++)
    	{    	
    		gradeList[i] += grade; 		
    	}
    	
    	count++;
    	
    }
  
   double averages = 0;
   for(int i = 0; i<gradeList.length;i++)
   {   
	   
	   averages = (gradeList[i] / enrollment);
   }
   System.out.println(averages);
    
  }
}