package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Knight extends GamePiece implements Moveable{
	private boolean isForward;
	private Drawable tmpPiece;
	public Knight(int location) {
		super('K', "Knight", location);
		isForward = true;
		// TODO Auto-generated constructor stub
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		if(Knight.this.location > 18 || Knight.this.location < 2) {isForward = !isForward;}
		if(!isForward) {
			if(tmpPiece != null) {
				gameBoard[this.location] = tmpPiece;
				tmpPiece = null;
			} else {
				gameBoard[this.location] = null;
			}
			if (gameBoard[this.location - 2] != null) {
				tmpPiece = gameBoard[this.location - 2];
			}
			gameBoard[this.location - 2] = this;
			Knight.this.location -= 2;
			
		}
		else {
			
			if(tmpPiece != null) {
				gameBoard[this.location] = tmpPiece;
				tmpPiece = null;
			} else {
				gameBoard[this.location] = null;
			}
			if (gameBoard[this.location + 2] != null) {
				tmpPiece = gameBoard[this.location + 2];
			}
			gameBoard[this.location + 2] = this;
			Knight.this.location += 2;
			
		}
	}

}
