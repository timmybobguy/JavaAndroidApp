package sokoban;

import java.awt.Point;

public class Placeable {

	protected Point location;
	protected char symbol;
	
	public Placeable(int x, int y) {
		
		this.location = new Point(x,y);
		
	}
	
	public String toString() {
		
		return String.valueOf(this.symbol);
		
	}
}
