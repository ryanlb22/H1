import java.util.Scanner;
public class gameTools {
	public Scanner input = new Scanner(System.in);
	public char player1 = 'X';
	public char comp2 = 'O';
	public char[][] tictactoeBoard = new char[3][3];
	//http://www.java2s.com/Code/C/Data-Type/AsimpleTicTacToegame.htm
	
//Start the Questions	
	public void beginQuestions(){
		System.out.println("==== Welcome to Tic-Tac-Toe Game ====");
		System.out.println("Do you want to start first? Y/N");
		char question1 = input.next(".").charAt(0);
		if(question1 == 'Y' || question1 == 'y')
		{
			System.out.println("Player Starts First");
		}
		if(question1 == 'N' || question1=='n')
		{
			System.out.println("Computer Starts First");
			
		}
		System.out.println("Ok! Your character is X and computer character is O");
		
	}
// Set all of the board to 0
	public void initBoard(){
		for(int i = 0;i<3;i++)
		{
			for(int j = 0;j<3;j++)
			{
				tictactoeBoard[i][j] = ' ';
			}
		}
	}
// Get a move from the player
	public void playerMove(){
		int x,y;
		System.out.println("Enter X,Y coordinates for your move: ");
		x = input.nextInt();
		y = input.nextInt();
		x--;
		y--;
		if(tictactoeBoard[x][y] != ' ')
		{
			System.out.println("Invalid move, try again. \n");
			playerMove();
		}
		else{
			tictactoeBoard[x][y]='X';
		}
		
	}
// Get a move from the computer
	public void computerMove(){
		int i,j = 0;
		for(i=0;i<3;i++){
			for(j=0;j<3;j++)
				if(tictactoeBoard[i][j]==' ') break;
			if(tictactoeBoard[i][j]==' ')break;
		}
		if(i*j==9){
			System.out.println("Draw \n");
			System.exit(0);
		}
		else{
			tictactoeBoard[i][j] = 'O';
		}
	}

	public void displayBoard(){
		for(int t=0; t<3;t++)
		{
			System.out.printf(" %c | %c | %c ",tictactoeBoard[t][0],
					tictactoeBoard[t][1],tictactoeBoard[t][2]);
			if(t!=2)
			{
				System.out.printf("\n---|---|---\n");
			}
			System.out.printf("\n");
		}
	}
	
	public char checkBoard(){
		int i = 0;
		for(i = 0; i<3 ; i++){
			if(tictactoeBoard[i][0] == tictactoeBoard[i][1]&& 
					tictactoeBoard[i][0] == tictactoeBoard[i][2])
				return tictactoeBoard[i][0];
		}
		for(i = 0; i<3 ; i++){
			if(tictactoeBoard[0][i] == tictactoeBoard[1][i]&& 
					tictactoeBoard[0][i] == tictactoeBoard[2][i])
				return tictactoeBoard[0][i];
		}
		if(tictactoeBoard[0][0]==tictactoeBoard[1][1]&&
				tictactoeBoard[1][1]==tictactoeBoard[2][2])
			return tictactoeBoard[0][0];
		if(tictactoeBoard[0][2]==tictactoeBoard[1][1]&&
				tictactoeBoard[1][1]==tictactoeBoard[2][0])
			return tictactoeBoard[0][2];
	
	
		
		return ' ';
	}
}
