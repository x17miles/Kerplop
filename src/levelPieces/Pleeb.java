package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Pleeb extends GamePiece {

	public Pleeb(int location) {
		super('p', "Pleeb", location);
		// TODO Auto-generated constructor stub
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		if(this.location == playerLocation) {
			System.out.println("A pleeb stands beside you. They just stare at you, but do nothing.");
		}
		return InteractionResult.NONE;
	}

}
