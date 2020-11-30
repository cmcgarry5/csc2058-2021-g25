package MoveAroundBoard;
import java.util.ArrayList;

public class TestClass {

	static ArrayList<Square> Board = new ArrayList<Square>(); 
	
	static Square square1 = new Square("Square1", 0);
	static Square square2 = new Square("Square2", 1);
	static Square square3 = new Square("Square3", 2);
	static Square square4 = new Square("Square4", 3);
	
	static Dice dice = new Dice();
	
	static int firstRoll;
	static int secondRoll;
	static int totalRoll; 
	
	public static void main(String[] args) {
		Board.add(square1);
		Board.add(square2);
		Board.add(square3);
		Board.add(square4);
		
		//Rolling Dice and moving to new position using roll number
		Piece piece = new Piece("Car", 0);
		Player player = new Player("John Doe");
		player.setPiece(piece);
		
		System.out.println("Starting Position of Player: " + player.getName() + "\nPosition: " + Board.get(player.getPiece().getPos()).getName() + "\n");
		
		dice.roll();
		firstRoll = (int)dice.getRoll();
		totalRoll += (int)dice.getRoll();
		
		dice.roll();
		secondRoll = (int)dice.getRoll();
		totalRoll += (int)dice.getRoll();
		
		System.out.println("First Roll = " + firstRoll + ", Second Roll = " + secondRoll + ", Total Roll = " + totalRoll + "\n");
		
		int boardPos = newBoardPos(totalRoll, piece.getPos());
		player.getPiece().move(boardPos);
		
		System.out.println("New position of Player: " + player.getName() + "\nLanded On: " + Board.get(player.getPiece().getPos()).getName() + "\n");
		
		//Using Square Index to move Player piece instantly to that square
		player.getPiece().move(square1);
		System.out.println("New position of Player: " + player.getName() + "\nLanded On: " + Board.get(player.getPiece().getPos()).getName() + "\n");
		
		player.getPiece().move(square2);
		System.out.println("New position of Player: " + player.getName() + "\nLanded On: " + Board.get(player.getPiece().getPos()).getName() + "\n");
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
