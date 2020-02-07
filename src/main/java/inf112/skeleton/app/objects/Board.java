package inf112.skeleton.app.objects;


import inf112.skeleton.app.objects.interfaces.IDrawable;
import inf112.skeleton.app.objects.tiles.Floor;

public class Board {

    private IDrawable[][] board;
    private int height;
    private int width;

    /**
     * Board constructor:
     * initialized the width to a 12x12 board (TODO: make this dynamic)
     */
    public Board(){
        this.width = 12;
        this.height = 12;
        this.board = new IDrawable[12][12];
        this.fillStandardBoard();

    }

    /**
     * Temporary method that fills the board with floor tiles.
     */
    private void fillStandardBoard() {
        for (int i = 0; i < this.height; i++){
            for (int j = 0; j < this.width; j++){
                this.setTile(i, j, new Floor());
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
		return this.board[x][y];
	}

	/**
	 * Replaces a tile in board at the x y position.
	 * @param x
	 * @param y
	 * @param tile
	 */
	public void setTile(int x, int y, IDrawable tile) {
        this.board[x][y] = tile;
	}
}