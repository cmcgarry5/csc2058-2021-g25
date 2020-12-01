package WinGame;

import java.util.ArrayList;

public class Player {

    private String name;
    private Piece piece;
    private int material;
    private ArrayList<Biome> Biomes;

    Player(String nameSet){
        setName(nameSet);
    }

    private void setName(String nameSet) {
        this.name = nameSet;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public String getName() {
        return name;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public void setMaterial(int materials) {this.material = materials;}

    public int getMaterial() {return this.material;}

    public void setBiomes(ArrayList<Biome> biome) {this.Biomes = biome;}

    public ArrayList<Biome> getBiomes() {return this.Biomes;}

}
