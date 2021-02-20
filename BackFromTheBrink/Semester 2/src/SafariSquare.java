public class SafariSquare extends Square {
    private StdIO IO = new StdIO();

    public SafariSquare(String name, int position) {
        super(name, position);
    }

    @Override
    public boolean isOwned() {
        return false;
    }


    public void execute(Player player) {
        System.out.println(IO.printSquareLandedOn(player, this.getName()));
        System.out.println(IO.printSafariSquare(player));
    }
}
