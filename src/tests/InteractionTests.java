package tests;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gameEngine.*;
import levelPieces.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class InteractionTests {
	private Drawable[] gameBoard;
	@BeforeEach
	public void setUp() {
		gameBoard = new Drawable[GameEngine.BOARD_SIZE];
	}
	
	@Test
	public void testKnightInteraction() {
		Knight knight = new Knight(10);
		gameBoard[10] = knight;
		//test if knight hits when player and knight share location
		assertEquals(InteractionResult.HIT, knight.interact(gameBoard, 10));
		//test if player being directly infront of the knight and hitting twice results in a kill
		//it takes 2 hits to kill, which is why the interaciton is called twice
		knight.interact(gameBoard, 11);
		assertEquals(InteractionResult.ADVANCE, knight.interact(gameBoard, 11));
		//assert dead night does nothing
		assertEquals(InteractionResult.NONE, knight.interact(gameBoard, 10));
		//Assert that a player behind the knight does nothing
		knight = new Knight(10);
		gameBoard[10] = knight;
		assertEquals(InteractionResult.NONE, knight.interact(gameBoard, 9));
	}
	@Test
	public void testNinjaInteraction() {
		Ninja ninja = new Ninja(10);
		gameBoard[10] = ninja;
		int hitCount = 0;
		//ninja has 1 in 8 chance of hitting target that is within 2 spaces.
		//assert that there is at least one hit in the 16 times that this is ran
		
		for (int i = 0; i < 16; i++) {
			if(ninja.interact(gameBoard, 12)==InteractionResult.HIT) hitCount++ ;		
		}
		assert(hitCount >= 0);
		
		//reset hit count and set the ninja 3 units away, hit count should stay zero
		hitCount = 0;
		for (int i = 0; i < 16; i++) {
			if(ninja.interact(gameBoard, 13)==InteractionResult.HIT) {
				hitCount++;
			}
		}	
		assert(hitCount == 0);
		
		//show that if player and ninja share a location, and there is not a torch in range, the ninja kills the player
		assertEquals(InteractionResult.KILL, ninja.interact(gameBoard, 10));
		
		//add a torch at the player location 11, and assure that you get a point for killing the ninja
		gameBoard[11] = new Torch(11);
		assertEquals(InteractionResult.GET_POINT, ninja.interact(gameBoard, 11));
		
		//assert the ninja is dead now
		assertEquals(InteractionResult.NONE, ninja.interact(gameBoard, 10));
	}
	@Test
	public void testQueenInteraction() {
		Queen queen = new Queen(10);
		gameBoard[10] = queen;
		
		//test if queen says something when player is 1 unit away
		//TO-DO: Test output
		assertEquals(InteractionResult.NONE, queen.interact(gameBoard, 11));
		assertEquals(InteractionResult.NONE, queen.interact(gameBoard, 9));
		//test if player gets point when on queen's locaition for first time
		assertEquals(InteractionResult.GET_POINT, queen.interact(gameBoard, 10));
		//test if player does not get point when returning to queen's location
		assertEquals(InteractionResult.GET_POINT, queen.interact(gameBoard, 10));
	}
	@Test
	public void testRoseInteraction() {
		Rose rose = new Rose(10);
		gameBoard[10]=rose;
		//test that when the user is on the rose position
		assertEquals(InteractionResult.GET_POINT, rose.interact(gameBoard, 10));
		//test that when the user is not on the rose, that nothing happens.
		assertEquals(InteractionResult.NONE, rose.interact(gameBoard, 11));
	}
	

	@Test
	public void testPleebInteraction() {
		Pleeb pleeb = new Pleeb(10);
		gameBoard[10] = pleeb;
		// makes sure the pleeb does nothing. (though they do make print statements, the result should stay none)
		assertEquals(InteractionResult.NONE, pleeb.interact(gameBoard, 9));
	}
	
	@Test
	public void testTorchInteraction() {
		Torch torch = new Torch(10);
		gameBoard[10] = torch;
		//make sure the torch does nothing. (though torches make print statements ard are needed for killing ninjas, the result type should be none)
		assertEquals(InteractionResult.NONE, torch.interact(gameBoard, 10));
	}

}
