package inf112.skeleton.app.objects;

import inf112.skeleton.app.objects.interfaces.IDrawable;

public class Board {

    private IDrawable[][] board;
    private int height;
    private int width;

    public Board() {
        this.width = 12;
        this.height = 12;
        this.board = new IDrawable[12][12];
        this.fillBoard();
    }

    private void fillBoard() {
        for (int i = 0; i < this.height; i++){
            for (int j = 0; j < this.width; j++){
                this.board[i][j] = new IDrawable(){
                    @Override
                    public String getImage() {
                        return null;
                    }
                };
            }
        }
    }

	public Integer getHeight() {
		return this.height;
	}

	public Integer getWidth() {
		return this.width;
	}

	public IDrawable getPosition(int i, int j) {
		return this.board[i][j];
	}
}