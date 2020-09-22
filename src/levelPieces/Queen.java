package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Queen extends GamePiece implements Moveable{
	private boolean cycle;
	private boolean pointAqd;
	private Drawable tmpPiece;
	public Queen(int location) {
		super('Q', "Queen", location);
		cycle = true;
		// TODO Auto-generated constructor stub
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		if(Math.abs(playerLocation - this.location) == 1) {
			System.out.println("The queen says 'Come closer hero!'");
			return InteractionResult.NONE;
		}
		if(playerLocation == this.location && !pointAqd) {
			this.pointAqd = false;
			return InteractionResult.GET_POINT;
		}
		return InteractionResult.NONE;
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		gameBoard[this.location] = null;
		if(cycle && gameBoard[this.location + 1] == null) {
			this.location++;
		}
		else if (gameBoard[this.location -1] == null) {
			
			this.location--;
		}
		gameBoard[this.location] = this;
		cycle = !cycle;
	}

}
