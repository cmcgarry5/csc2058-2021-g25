
public abstract class Square {

	private String name; // Instance name
	private int position; // Instance position
	private static int nextPos = 0; // Gives preset position to new made squares
	static final int SQUAREMAX = 38; // limits squares max number

	// Constructor
	public Square(String newName, int nextPos) {
		this.name = newName;
		this.position = nextPos;
		nextPos++;
	}

	/*
	 * Allows user to set name no current validation
	 */
	private void setName(String newName) {
		name = newName;
	}

	/*
	 * Sets the integer position of the square on the board need to add validaton to
	 * make postitons int unique
	 */

	private void setPos(int newPos) {
		position = newPos;
	}

	/*
	 * Creates a string output of squares info
	 */
	public String getSquareInfo() {
		String info = "";
		info += name + "\n";
		info += position + "\n";
		return info;
	}

	/*
	 * Returns square name
	 */
	public String getName() {
		return name;
	}

	/*
	 * Returns position of Square instance
	 */
	public int getPos() {
		return position;
	}

	/*
	 * Returns square name
	 */
	public static int getNextPos() {
		return nextPos;
	}


	public abstract boolean isOwned();

    public abstract void execute(Player player);

}
