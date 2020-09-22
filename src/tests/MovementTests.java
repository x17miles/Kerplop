package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import gameEngine.*;
import levelPieces.*;
class MovementTests {
	private Drawable[] gameBoard;
	@BeforeEach
	public void setUp() {
		gameBoard = new Drawable[GameEngine.BOARD_SIZE];
	}
	
	@Test
	public void testNinjaGeneralMovement() {
		Ninja ninja = new Ninja(10);
		gameBoard[10] = ninja;
		//Random Movement
		//   Make sure the ninja's position changes in an empty board, w/ player at 0
		ninja.move(gameBoard, 0);
		assert(10 != ninja.getLocation());
		// Make sure moves go both ways
		boolean backwards = false;
		boolean forwards = false;
		int prevPosition = ninja.getLocation();
		for(int i = 0; i < 10; i++) {
			ninja.move(gameBoard, 0);
			if(ninja.getLocation() > prevPosition) forwards = true;
			if(ninja.getLocation() < prevPosition) backwards = true;
			prevPosition = ninja.getLocation();
		}
		assert(forwards);
		assert(backwards);
		
	}
	@Test
	public void testNinjaBoundaryMovement() {
		// test that when the ninja is at the edge 0 and the end of the board, that they either move 1 unit away from the edge or stay at the edge
		for(int i = 0; i < 10; i++) {
			gameBoard = new Drawable[GameEngine.BOARD_SIZE];
			Ninja ninja1 = new Ninja(0);
			Ninja ninja2 = new Ninja(GameEngine.BOARD_SIZE-1);
			gameBoard[0] = ninja1;
			gameBoard[GameEngine.BOARD_SIZE-1] = ninja2;
			
			ninja1.move(gameBoard, 10);
			ninja2.move(gameBoard, 10);
			assert(1 == ninja1.getLocation() || 0 ==ninja1.getLocation());
			assert(GameEngine.BOARD_SIZE-2 == ninja2.getLocation() || GameEngine.BOARD_SIZE-1 == ninja2.getLocation());
		}
		
	}
	@Test
	public void testNinjaOverlapMovement(){
		//surround the ninja w/ paintings, due to overlap rules, the ninja's location should not change.
		Ninja ninja = new Ninja(10);
		gameBoard[10] = ninja;
		gameBoard[9] = new Painting(9);
		gameBoard[11] = new Painting(11);
		
		ninja.move(gameBoard, 0);
		assertEquals(10, ninja.getLocation());
		
	}
	@Test
	public void testNinjaDeadMovement() {
		//if the ninja is dead, they should not move
		Ninja ninja = new Ninja(10);
		gameBoard[10] = ninja;
		gameBoard[11] = new Torch(11);
		ninja.interact(gameBoard, 11);
		ninja.move(gameBoard, 11);
		assertEquals(10, ninja.getLocation());
	}
	
	@Test
	public void testKnightForwardMovement() {
		Knight k = new Knight(10);
		gameBoard[10] = k;
		for(int i = 0; i < 20; ++i) {
			int tmp = k.getLocation();
			k.move(gameBoard, 10);
			assert(Math.abs(k.getLocation() - tmp) == 2); // checks for movement on even-indexed tiles
		}
		k.setLocation(1 + k.getLocation()); // changes location from even-indexed tile to odd-indexed tile
		for(int i = 0; i < 20; ++i) {
			int tmp = k.getLocation();
			k.move(gameBoard, 10);
			assert(Math.abs(k.getLocation() - tmp) == 2); // checks for odd tile movement
		}
	}

	@Test
	public void testKnightOverlapMovement() {
		// the knight can only move 2 spaces at a time and should be stuck if blocked by 2 other pieces due to overlap rules
		Knight knight = new Knight(10);
		gameBoard[10] = knight;
		gameBoard[8] = new Painting(8);
		gameBoard[12] = new Painting(12);
		knight.move(gameBoard, 0);
		assertEquals(10, knight.getLocation());
	}
	@Test
	public void testKnightDeadMovement() {
		//after 2 hits to the knight, the knight should be dead and therefore unable to move
		Knight knight = new Knight(10);
		gameBoard[10] = knight;
		knight.interact(gameBoard, 11);
		knight.interact(gameBoard, 11);
		knight.move(gameBoard, 0);
		assertEquals(10, knight.getLocation());
	}
}
