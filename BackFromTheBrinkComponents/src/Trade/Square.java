package Trade;

public class Square {
	
	private String name;
	private int position;
	
	Square(String namePick, int pos){
		setName(namePick);
		setPos(pos);
	}

	private void setName(String namePick) {
		this.name = namePick;
	}
	
	private void setPos(int pos) {
		this.position = pos;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPos() {
		return this.position;
	}
}
