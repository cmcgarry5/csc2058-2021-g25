package WinGame;

import java.util.ArrayList;

public class TestClass {

    static ArrayList<Square> Board = new ArrayList<>();

    static Square winSquare = new Square("BFTB", 0);
    static Square square1 = new Square("Square", 1);

    static ArrayList<Biome> Biomes = new ArrayList<>();
    static Biome biome1 = new Biome("Aquatic");

    public static void main(String[] args) {
        Board.add(winSquare);
        Board.add(square1);

        Piece piece = new Piece("Boat", 0);
        Player player = new Player("Joe Doe");
        player.setPiece(piece);

        Biomes.add(biome1);
        player.setBiomes(Biomes);

        player.setMaterial(1000);

        System.out.println("Player: " + player.getName() + "\nAt Position: " + Board.get(player.getPiece().getPos()).getName());
        System.out.println("Number of Biomes: " + player.getBiomes().size());
        System.out.println("Materials: " + player.getMaterial());

        if (checkWin(Biomes, player.getMaterial()))
            System.out.println("You win");
        else System.out.println("Insufficient resources.");
    }

    public static boolean checkWin(ArrayList<Biome> biomes, int materials)
    {
        if (biomes.size() > 0 && materials >= 1000)
            return true;
        else return false;
    }
}
