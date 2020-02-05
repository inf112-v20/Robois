package inf112.skeleton.app.objects;

import inf112.skeleton.app.objects.interfaces.IDrawable;
import inf112.skeleton.app.objects.tiles.Wall;

public class Board {

    private IDrawable[][] board;
    private int height;
    private int width;

    public Board() {
        this.width = 12;
        this.height = 12;
        this.board = new IDrawable[12][12];
        this.fillStandardBoard();
    }

    private void fillStandardBoard() {
        for (int i = 0; i < this.height; i++){
            for (int j = 0; j < this.width; j++){
                this.setTile(i, j, new Wall());
            }
        }
    }

	public Integer getHeight() {
		return this.height;
	}

	public Integer getWidth() {
		return this.width;
	}

	public IDrawable getTile(int i, int j) {
		return this.board[i][j];
	}

	public void setTile(int i, int j, IDrawable tile) {
        this.board[i][j] = tile;
	}
}