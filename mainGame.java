import java.util.Scanner;

public class mainGame {
	public static void main(String[] args){
		gameTools newGame = new gameTools();
		
		char complete = ' ';
		newGame.beginQuestions();
		newGame.initBoard();
		do{
			newGame.displayBoard();
			newGame.playerMove();
			complete = newGame.checkBoard();
			if(complete!= ' ') break;
			newGame.computerMove();
			complete = newGame.checkBoard();
		}while(complete == ' ');
		
		if(complete == 'X')
		{
			System.out.println("You won!\n");
		}
		else{
			System.out.println("Computer wins! \n");
		}
		newGame.displayBoard();
	}
}
