package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Rose extends GamePiece {

	public Rose(int location) {
		super('@', "Rose", location);
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (playerLocation == this.location) {
			return InteractionResult.GET_POINT;
		}
		return InteractionResult.NONE;
	}

}
