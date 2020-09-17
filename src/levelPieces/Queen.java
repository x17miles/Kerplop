package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Queen extends GamePiece implements Moveable{
	private boolean cycle;
	private Drawable tmpPiece;
	public Queen(int location) {
		super('Q', "Queen", location);
		cycle = true;
		// TODO Auto-generated constructor stub
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		if (tmpPiece != null) {
			gameBoard[this.location] = tmpPiece;
			tmpPiece = null;
		} else {
			gameBoard[this.location] = null;
		}
		if(cycle) {
			if (gameBoard[this.location + 1] != null && !(gameBoard[this.location + 1] instanceof Moveable)) {
				tmpPiece = gameBoard[this.location + 1];
			}
			gameBoard[this.location + 1] = this;
			this.location++;
			
		}
		else {
			if (gameBoard[this.location - 1] != null && !(gameBoard[this.location + 1] instanceof Moveable)) {
				tmpPiece = gameBoard[this.location - 1];
			}
			gameBoard[this.location -1] = this;
			this.location--;
		}
		cycle = !cycle;
	}

}
