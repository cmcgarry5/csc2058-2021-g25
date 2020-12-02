package WinGame;

import java.util.ArrayList;

public class TestClass {

    // Declaring Class Variables
    static ArrayList<Square> Board = new ArrayList<>();

    static Square winSquare = new Square("BFTB", 0);
    static Square square1 = new Square("Square", 1);

    static ArrayList<Biome> Biomes = new ArrayList<>();
    static Biome biome1 = new Biome("Aquatic");

    public static void main(String[] args) {
        // Adding winSquare and and 'normal' square to board instance
        Board.add(winSquare);
        Board.add(square1);

        // Initialising player and piece objects
        Piece piece = new Piece("Boat", 0);
        Player player = new Player("Joe Doe");
        player.setPiece(piece);

        // Add biome instance to Biomes arraylist
        Biomes.add(biome1);
        player.setBiomes(Biomes);

        player.setMaterial(100);

        // Print player, Biomes, materials
        System.out.println("Player: " + player.getName() + "\nAt Position: " + Board.get(player.getPiece().getPos()).getName());
        System.out.println("Biomes: ");
        for (int i = 0; i < player.getBiomes().size(); i++)
            System.out.println(i+1 + ") " + player.getBiomes().get(i).getName());
        System.out.println("Materials: " + player.getMaterial());

        // Conditional for winning
        if (checkWin(player))
            System.out.println("Congratulations! You win!!");
        else System.out.println("Insufficient resources to win.");
    }

    // Checks if player has enough biomes and materials to win
    public static boolean checkWin(Player player)
    {
        if (player.getBiomes().size() > 0 && player.getMaterial() >= 1000)
            return true;
        else return false;
    }
}
