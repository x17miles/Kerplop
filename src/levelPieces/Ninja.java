package levelPieces;
import java.util.Random;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Ninja extends GamePiece implements Moveable {
	private boolean dead = false;
	private int cycle;
	public Random rnd = new Random();
	public Ninja(int location) {
		super('N', "Ninja", location);
		cycle = 0;
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// if the ninja is dead, do nothing
		if (dead) return InteractionResult.NONE;
		// if player on torch and ninja is within 1 space, player kills the ninja
		if(gameBoard[playerLocation] instanceof Torch && Math.abs(this.location - playerLocation) <= 1) {
			System.out.println("You killed a ninja in the light of the Torch.");
			dead = true;
			return InteractionResult.GET_POINT;
		}
		//1 in 8 chance that ninja throws out a knife, which may hit a player
		if(rnd.nextBoolean() && rnd.nextBoolean() && rnd.nextBoolean()) {
			if (Math.abs(playerLocation - this.location) <= 2) {
				System.out.println("A throwing knife hit you in the arm. Where did it come from?");
				return InteractionResult.HIT;
			}
		}
		// if player can't see ninja (i.e. they don't have a torch), the player gets kileld by the ninja
		if(playerLocation == this.location) {
			return InteractionResult.KILL;
		}
		return null;
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		//do nothing if ninja dead
		gameBoard[this.location] = null;
		if(dead) return;
		//move randomly by 1 space, aside from jumping on something else or hitting the bounds of the level
		if(rnd.nextBoolean() && this.location != 20 && gameBoard[this.location+1] == null) {
			this.location++;
		} else if ( this.location > 0 && gameBoard[this.location - 1] == null){
			this.location--;
		}
		gameBoard[this.location] = this;
	}

}
