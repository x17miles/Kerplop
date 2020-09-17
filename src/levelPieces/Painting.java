package levelPieces;

import gameEngine.Drawable;

public class Painting implements Drawable{
	protected char symbol = '*';
	private String name = "Painting";
	// Stores the piece location, which will be needed to interact
	// with the player. 
	private int location;
	public Painting(int location) {
		super();
		this.location = location;
	}
	@Override
	public void draw() {
		System.out.print(symbol);
	}
	
}
