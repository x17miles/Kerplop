package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Torch extends GamePiece {

	public Torch(int location) {
		super('t', "Torch", location);
		// TODO Auto-generated constructor stub
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if(playerLocation == this.location) System.out.println("You stand in the light of a torch.");
		return InteractionResult.NONE;
	}

}
