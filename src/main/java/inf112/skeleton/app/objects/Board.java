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
		this.fillStandardBoard(filename);
	}

	/**
	 * @throws FileNotFoundException
	 */
	private void fillStandardBoard(String filename) throws FileNotFoundException {
		CsvReader reader = new CsvReader(filename);
		int[][] boardids = reader.getBoardIds();

		this.width = reader.getWidth();
		this.height = reader.getHeight();
		this.board = new IDrawable[height][width];

		for (int y = 0; y < boardids.length; y++) {
			for (int x = 0; x < boardids[y].length; x++) {
				int b = boardids[y][x];

				if (b == 0) board[y][x] = new Floor();
				if (b >= 1 && b <=8){
					board[y][x] = new Wall(b);
				}
				if (b >= 11 && b <= 18){
					board[y][x] = new Spawn(b-10);
				}
				if (b >= 21 && b <= 34){
					board[y][x] = new Hole(b-20);
				}
				if (b >= 41 && b <= 64){
					board[y][x] = new CBelt(b-40);
				}
				if (b >= 71 && b <= 94){
					board[y][x] = new FCBelt(b-70);
				}
				if (b >= 101 && b <= 104){
					board[y][x] = new Laser(b-100, 1, x, y);
				}
				if (b >= 105 && b <= 108){
					board[y][x] = new Laser(b-100, 2, x, y);
				}
				if (b >= 111 && b <= 113){
					board[y][x] = new Beam(b-110, 1, x, y);
				}
				if (b >= 114 && b <= 116){
					board[y][x] = new Beam(b-110, 2, x, y);
				}
				if (b >= 121 && b <= 122){
					board[y][x] = new Gear(b-120);
				}
				if (b >= 131 && b <= 138){
					board[y][x] = new Pusher(b-130);
				}
				if (b >= 141 && b <= 144){
					board[y][x] = new Flag(b-140);
				}
				if (b == 151){
					board[y][x] = new Wrench(b-150, 1);
				}
				if (b == 152){
					board[y][x] = new Wrench(b-150, 2);
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
		Boolean canGoOut = true;
		if (getTile(x, y) instanceof Wall) {
			Wall w = (Wall) getTile(x, y);
			canGoOut = !w.getWallPositions().contains(dir);
		}else if (getTile(x, y) instanceof Pusher) {
			Pusher p = (Pusher) getTile(x, y);
			canGoOut = (p.getPusherWallPosition() != dir);
		}else if (getTile(x, y) instanceof Laser) {
			Laser l = (Laser) getTile(x, y);
			canGoOut = (l.getLaserWallPosition() != dir);
		}

		if (canGoOut) {
			Location loc = CardinalityUtility.getNextTile(x, y, dir);
			x = loc.getX();
			y = loc.getY();

			if (x > width - 1 || y > height - 1 || x < 0 || y < 0) {
				return true;
			}

			if (getTile(x, y) instanceof Wall) {
				Wall w = (Wall) getTile(x, y);
				return !w.getWallPositions().contains(CardinalityUtility.getOpposite(dir));
			} else if (getTile(x, y) instanceof Pusher) {
				Pusher p = (Pusher) getTile(x, y);
				return (p.getPusherWallPosition() != CardinalityUtility.getOpposite(dir));
			} else if (getTile(x, y) instanceof Laser) {
				Laser l = (Laser) getTile(x, y);
				return (l.getLaserWallPosition() != CardinalityUtility.getOpposite(dir));
			}
			return true;
		}
		return false;
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