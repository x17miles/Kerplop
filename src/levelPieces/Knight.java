package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Knight extends GamePiece implements Moveable{
	private boolean isForward;
	private int life = 2;
	private boolean dead = false;
	public Knight(int location) {
		super('K', "Knight", location);
		isForward = true;
		// TODO Auto-generated constructor stub
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// If dead, do nothing
		if (dead) return InteractionResult.NONE;
		// If you are 1 space in front and knight is moving toward you, you hit him, if knight hit 2 times, he dies and you advance
		if((playerLocation - this.location == 1 && isForward) || (playerLocation - this.location == -1 && !isForward)) {
			System.out.println("You hit the knight!");
			this.life -= 1;
			if (this.life == 0) {
				System.out.println("You killed the Knight! Impressive!");
				dead = true;
				return InteractionResult.ADVANCE;
			}
		} else if (this.location == playerLocation) {
			//if you land directly on knight's space, he hits you
			return InteractionResult.HIT;
		}
		return InteractionResult.NONE;
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		//Knight will continue in a direction moving 2 spaces at a time unless he hits an object or a well. At which point, the knight tries reversing
		//if there is nowhere to go, the position stays the same.
		if(this.location > 18 || this.location < 2) {isForward = !isForward;}
		gameBoard[this.location] = null;
		//if knight is dead, don't display him.
		if(dead) return;
		if(!isForward && gameBoard[this.location -2] == null) {
			Knight.this.location -= 2;
		} else if ( this.location <= 18 && gameBoard[this.location + 2] == null) {
			Knight.this.location += 2;
		} else if ( this.location >= 2 && gameBoard[this.location -2] == null) {
			this.location -=2;
			isForward = !isForward;
		}
		gameBoard[this.location] = this;
	}

}
