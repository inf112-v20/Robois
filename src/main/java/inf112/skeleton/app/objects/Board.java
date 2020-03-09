package inf112.skeleton.app.objects;

import java.io.FileNotFoundException;

import inf112.skeleton.app.objects.abstracts.Location;
import inf112.skeleton.app.objects.interfaces.IDrawable;
import inf112.skeleton.app.objects.tiles.*;
import inf112.skeleton.app.utilities.CardinalDirection;
import inf112.skeleton.app.utilities.CardinalityUtility;
import inf112.skeleton.app.utilities.CsvReader;

public class Board {

	private IDrawable[][] board;
	private int height;
	private int width;

	/**
	 * Board constructor: initialized the width to a 12x12 board (TODO: make this
	 * dynamic)
	 * 
	 * @throws FileNotFoundException
	 */
	public Board(String filename) throws FileNotFoundException {
		this.width = 12;
		this.height = 12;
		this.board = new IDrawable[12][12];
		this.fillStandardBoard(filename);
	}

	/**
	 * @throws FileNotFoundException
	 */
	private void fillStandardBoard(String filename) throws FileNotFoundException {
		CsvReader reader = new CsvReader(filename);
		int[][] boardids = reader.getBoardIds();

		for (int y = 0; y < boardids.length; y++) {
			for (int x = 0; x < boardids[y].length; x++) {
				switch (boardids[y][x]) {
					case 0:
						board[y][x] = new Floor();
						break;
					case 1:
						board[y][x] = new Wall(1);
						break;
					case 2:
						board[y][x] = new Wall(2);
						break;
					case 3:
						board[y][x] = new Wall(3);
						break;
					case 4:
						board[y][x] = new Wall(4);
						break;
					case 5:
						board[y][x] = new Wall(5);
						break;
					case 6:
						board[y][x] = new Wall(6);
						break;
					case 7:
						board[y][x] = new Wall(7);
						break;
					case 8:
						board[y][x] = new Wall(8);
						break;
					case 11:
						board[y][x] = new Spawn(1);
						break;
					case 21:
						board[y][x] = new Hole(1);
						break;
				}
			}
		}
	}

	public Integer getHeight() {
		return this.height;
	}

	public Integer getWidth() {
		return this.width;
	}

	/**
	 * Get an IDrawable object from board
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public IDrawable getTile(int x, int y) {
		return this.board[y][x];
	}

	/**
	 * Replaces a tile in board at the x y position.
	 * 
	 * @param x
	 * @param y
	 * @param tile
	 */
	public void setTile(int x, int y, IDrawable tile) {
		this.board[y][x] = tile;
	}

	public boolean canGo(int x, int y, CardinalDirection dir) {
		if (getTile(x, y) instanceof Wall) {
			Wall w = (Wall) getTile(x, y);
			return !w.getWallPositions().contains(dir);
		}

		Location loc = CardinalityUtility.getNextTile(x, y, dir);
		x = loc.getX();
		y = loc.getY();

		if (x > width - 1 || y > height - 1 || x < 0 || y < 0) {
			return true;
		}

		if (getTile(x, y) instanceof Wall) {
			Wall w = (Wall) getTile(x, y);
			return !w.getWallPositions().contains(CardinalityUtility.getOpposite(dir));
		}
		return true;
	}

	public boolean isOutOfBounds(int x, int y, CardinalDirection dir) {
		Location loc = CardinalityUtility.getNextTile(x, y, dir);
		x = loc.getX();
		y = loc.getY();
		if ((x >= this.getWidth()) || (x < 0) || (y >= this.getHeight()) || (y < 0)) {
			return true;
		}
		return (getTile(x, y) instanceof Hole);
	}
}