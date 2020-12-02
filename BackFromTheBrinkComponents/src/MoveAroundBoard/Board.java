package MoveAroundBoard;
import java.util.ArrayList;

public class Board {
	private ArrayList<Square> contents = new ArrayList<Square>();
	
	Board(){
	}
	
	public void addSquare(Square square) {
		contents.add(square);
	}
	
	public Square getSquare(int pos) {
		return contents.get(pos);
	}
	
	public int size() {
		return contents.size();
	}
}
