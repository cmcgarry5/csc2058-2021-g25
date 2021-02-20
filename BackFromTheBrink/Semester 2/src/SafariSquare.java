public class SafariSquare extends Square {

    public SafariSquare(String name, int position) {
        super(name, position);
    }

    @Override
    public boolean isOwned() {
        return false;
    }


    public void execute(Player player) {
        System.out.println(StdIO.printSquareLandedOn(player, this.getName()));
        System.out.println(StdIO.printSafariSquare(player));
    }
}
