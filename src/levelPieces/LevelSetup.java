package levelPieces;
import java.util.ArrayList;

import gameEngine.Drawable;
import gameEngine.Moveable;

public class LevelSetup {
	private Drawable[] board;
	private ArrayList<Moveable> movingPieces;
	private ArrayList<GamePiece> interactingPieces;
	private int startLocation;
	
	public Drawable[] getBoard() {
		return board;
	}
	public ArrayList<Moveable> getMovingPieces() {
		return movingPieces;
	}
	public ArrayList<GamePiece> getInteractingPieces() {
		return interactingPieces;
	}
	public int getPlayerStartLoc() {
		return startLocation;
	}
	public void createLevel(int levelNum) {
		switch(levelNum) {
		case 2:
			movingPieces = new ArrayList<Moveable>();
			interactingPieces = new ArrayList<GamePiece>();
			GamePiece[] pieces2 = new GamePiece[21];
			Queen l2Queen1 = new Queen(3);
			Torch l2Torch1 = new Torch(1);
			Torch l2Torch2 = new Torch(7);
			Ninja l2Ninja1 = new Ninja(10);
			Ninja l2Ninja2 = new Ninja(17);
			Knight l2Knight1 = new Knight(18);
			Pleeb l2Pleeb1 = new Pleeb(5);
			movingPieces.add((Moveable) l2Queen1);
			movingPieces.add((Moveable) l2Ninja1);
			movingPieces.add((Moveable) l2Ninja2);
			movingPieces.add((Moveable) l2Knight1);
			interactingPieces.add(l2Queen1);
			interactingPieces.add(l2Torch1);
			interactingPieces.add(l2Torch2);
			interactingPieces.add(l2Ninja1);
			interactingPieces.add(l2Ninja2);
			interactingPieces.add(l2Knight1);
			interactingPieces.add(l2Pleeb1);
			board = new Drawable[21];
			board[3] = l2Queen1;
			board[1] = l2Torch1;
			board[7] = l2Torch2;
			board[10] = l2Ninja1;
			board[17] = l2Ninja2;
			board[18] = l2Knight1;
			board[5] = l2Pleeb1;
			board[12] = new Painting(12);
			board[13] = new Painting(13);
			board[14] = new Painting(14);
			startLocation = 4;
			
			break;
		case 1:
		default:
			//if(movingPieces.size() > 0) movingPieces.clear();
			//if(interactingPieces.size() > 0) interactingPieces.clear();
			movingPieces = new ArrayList<Moveable>();
			interactingPieces = new ArrayList<GamePiece>();
			Knight l1Knight1 = new Knight(3);
			Queen l1Queen1 = new Queen(18);
			Pleeb l1Pleeb1 = new Pleeb(7);
			Pleeb l1Pleeb2 = new Pleeb(15);
			Torch l1Torch1 = new Torch(12);
			movingPieces.add(l1Knight1);
			movingPieces.add(l1Queen1);
			interactingPieces.add(l1Knight1);
			interactingPieces.add(l1Queen1);
			interactingPieces.add(l1Pleeb1);
			interactingPieces.add(l1Pleeb2);
			interactingPieces.add(l1Torch1);
			board = new Drawable[21];
			board[3] = l1Knight1;
			board[18] = l1Queen1;
			board[7] = l1Pleeb1;
			board[15] = l1Pleeb2;
			board[17] = new Painting(17);
			board[20] = new Painting(19);
			board[12] = l1Torch1;
			startLocation = 11;
			;
			break;
		
		}
		
	} 
}
