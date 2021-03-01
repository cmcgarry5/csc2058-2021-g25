import java.util.Scanner;
public class HidingFromPredator extends Square {

    public HidingFromPredator(String newName, int nextPos) {

        super(newName, nextPos);
    }

    @Override
    public boolean isOwned() {
        return false;
    }

    @Override
    public void execute(Player player) {

    }
}

