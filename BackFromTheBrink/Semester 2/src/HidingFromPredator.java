import java.util.Scanner;
public class HidingFromPredator extends Square {
    Scanner sc = new Scanner(System.in);
    //Player player1 = new Player("xyz");
    public int roll;

    public HidingFromPredator(String newName, int nextPos) {
        super(newName, nextPos);
    }

    public void hidingFromPredator() {
        System.out.println("You are hiding from a predator!/nChoose how you want to escape:");
        System.out.println("1 - Roll for double\n2 - pay for camoflauge (cost:50)\n3 - Use WildCard ("+/*getNumberOfWildcards()+*/" available)");
        int choice = sc.nextInt();
        Dice roll = new Dice();

        if(choice == 1) {
            //roll.tryDouble(player1);
        }

        else if(choice == 2) {
            //Inventory.deductPlayerMaterials(50); // error
            System.out.println("Camoflauge bought, you have escaped for now");
            roll.getRollValue();
        }
        else if(choice == 3) {
            //Inventory.removeCard(escape); // error
            System.out.println("WildCard used, "+/*getNumberOfWildCards()+*/" card(s) remaining");
            roll.getRollValue();
        }
        else {
            System.out.println("invalid input, retry");
            choice = sc.nextInt();
        }
    }

    @Override
    public boolean isOwned() {
        return false;
    }

    @Override
    public void execute(Player player) {

    }
}

