package levelPieces;
import java.util.Random;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Ninja extends GamePiece implements Moveable {
	private int cycle;
	private Drawable tmpPiece;
	public Random rnd = new Random();
	public Ninja(int location) {
		super('N', "Ninja", location);
		cycle = 0;
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
		if(rnd.nextBoolean() && this.location != 20) {
			if(gameBoard[this.location + 1] != null) {
				tmpPiece = gameBoard[this.location + 1];
				gameBoard[this.location + 1] = this;
			}
			this.location++;
		} else {
			if(gameBoard[this.location - 1] != null) {
				tmpPiece = gameBoard[this.location - 1];
				gameBoard[this.location - 1] = this;
			}
			this.location--;
		}
	}

}
