package v1;

import java.util.ArrayList;

public class Board {
	
	private static ArrayList<WildCard> allWildCards;
	private static ArrayList<Sqaure> allSquares;
	private static ArrayList<Player> allPlayers;
	
	public Board(ArrayList<Sqaure> allSquares,ArrayList<WildCard> allWildCards, ArrayList<Player> allPlayers) {
		this.allWildCards = allWildCards;
		this.allSquares = allSquares;
		this.allPlayers = allPlayers;
		
	}

}
