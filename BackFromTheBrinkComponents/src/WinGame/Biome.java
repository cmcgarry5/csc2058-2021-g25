package WinGame;

public class Biome {
    private String biomeName;

    Biome(String nameSet) { setName(nameSet); }

    private void setName(String nameSet) {
        this.biomeName = nameSet;
    }
    public String getName() {
        return biomeName;
    }
}
