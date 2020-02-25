package inf112.skeleton.app.objects;


import java.io.FileNotFoundException;

import inf112.skeleton.app.objects.interfaces.IDrawable;
import inf112.skeleton.app.objects.tiles.Floor;
import inf112.skeleton.app.objects.tiles.Wall;
import inf112.skeleton.app.utilities.CsvReader;

public class Board {

    private IDrawable[][] board;
    private int height;
    private int width;

    /**
     * Board constructor:
     * initialized the width to a 12x12 board (TODO: make this dynamic)
     * @throws FileNotFoundException 
     */
    public Board() throws FileNotFoundException{
        this.width = 12;
        this.height = 12;
        this.board = new IDrawable[12][12];
        this.fillStandardBoard();

    }

    /**
     * Temporary method that fills the board with floor tiles.
     * @throws FileNotFoundException 
     */
    private void fillStandardBoard() throws FileNotFoundException {
    	CsvReader reader = new CsvReader("src/main/java/inf112/skeleton/app/assets/boards/b0.csv");
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
	 * @param x
	 * @param y
	 * @return
	 */
	public IDrawable getTile(int x, int y) {
		return this.board[y][x];
	}

	/**
	 * Replaces a tile in board at the x y position.
	 * @param x
	 * @param y
	 * @param tile
	 */
	public void setTile(int x, int y, IDrawable tile) {
        this.board[y][x] = tile;
	}
}