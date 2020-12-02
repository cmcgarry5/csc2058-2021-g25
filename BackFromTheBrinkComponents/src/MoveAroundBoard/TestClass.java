package MoveAroundBoard;
import java.util.ArrayList;
import java.util.Scanner;

public class TestClass {
	
	static Scanner input = new Scanner(System.in);
	
	//Creating Board
	static ArrayList<Square> Board = new ArrayList<Square>(); 
	
	//Creating Squares
	static Square square1 = new Square("Square1", 0);
	static Square square2 = new Square("Square2", 1);
	static Square square3 = new Square("Square3", 2);
	static Square square4 = new Square("Square4", 3);
	
	//Creating Dice
	static Dice dice = new Dice();
	
	//Variables to keep track of game state
	static int firstRoll;
	static int secondRoll;
	static int totalRoll; 
	static boolean doubleRoll;
	static int doubleCount;
	static int boardPos;
	
	public static void main(String[] args) {
		//Adding Squares to the board
		Board.add(square1);
		Board.add(square2);
		Board.add(square3);
		Board.add(square4);
		
		//Creating Player and Piece Objects
		Piece piece = new Piece("Car", 0);
		Player player = new Player("John Doe");
		player.setPiece(piece);
				
		
		System.out.println("Press Enter to start rolling ... ");
		input.nextLine();
		
		System.out.println("--------------------------------");
		//Displaying the current position of the Player
		System.out.println("Starting Position of Player: " + player.getName() + "\nPosition: " + Board.get(player.getPiece().getPos()).getSquareInfo() + "\n");
		
		//Rolling Dice and moving to new position using roll number
		dice.roll();
		firstRoll = (int)dice.getRoll();
		totalRoll += (int)dice.getRoll();
		
		dice.roll();
		secondRoll = (int)dice.getRoll();
		totalRoll += (int)dice.getRoll();
	
		//Displaying the Rolling Info
		System.out.println("First Roll = " + firstRoll + ", Second Roll = " + secondRoll + ", Total Roll = " + totalRoll + "\n");
		
		//Moving the Piece to the new position calculated in newBoardPos() - Preventing out of bounds
		boardPos = newBoardPos(totalRoll, player.getPiece().getPos());
		totalRoll = 0;
		player.getPiece().move(boardPos);
		
		//Displaying the new Position of the Player
		System.out.println("New position of Player: " + player.getName() + "\nLanded On: " + Board.get(player.getPiece().getPos()).getSquareInfo() + "\n");
		
		//Check to see if first dice roll is the same as the second dice roll ie a double
		if (firstRoll == secondRoll) {
			doubleRoll = true;
		}
		else {
			doubleRoll = false;
		}
		
		//Rolling again and moving to new position if they roll a double
		if (doubleRoll && doubleCount<2) {
			System.out.println("--------------------------------");
			System.out.println("Rolled a Double, rolling again...\n");
			doubleCount++;
			
			dice.roll();
			firstRoll = (int)dice.getRoll();
			totalRoll += (int)dice.getRoll();
			
			dice.roll();
			secondRoll = (int)dice.getRoll();
			totalRoll += (int)dice.getRoll();
			
			System.out.println("First Roll = " + firstRoll + ", Second Roll = " + secondRoll + ", Total Roll = " + totalRoll + "\n");
			
			boardPos = newBoardPos(totalRoll, player.getPiece().getPos());
			totalRoll = 0;
			player.getPiece().move(boardPos);
			
			System.out.println("New position of Player: " + player.getName() + "\nLanded On: " + Board.get(player.getPiece().getPos()).getSquareInfo() + "\n");
		}
		
		System.out.println("--------------------------------");
		//Using Square Index to move Player piece instantly to that square
		player.getPiece().move(square1);
		System.out.println("New position of Player: " + player.getName() + "\nLanded On: " + Board.get(player.getPiece().getPos()).getSquareInfo() + "\n");
		
		player.getPiece().move(square2);
		System.out.println("New position of Player: " + player.getName() + "\nLanded On: " + Board.get(player.getPiece().getPos()).getSquareInfo() + "\n");
	}
	
	public static int newBoardPos(int roll, int currentPos) {
		int boardSize = Board.size();
		int iter = 0;
		int newPos = 0;
		
		for (int pos = currentPos; iter<roll+1; pos++) {
			iter++;
			if(pos >= boardSize) {
				pos = 0;
			}
			newPos = pos;
		}
	
		return newPos;
	}
		
}
