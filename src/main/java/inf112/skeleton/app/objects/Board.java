package inf112.skeleton.app.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import inf112.skeleton.app.objects.interfaces.IDrawable;
import inf112.skeleton.app.objects.tiles.Spawn;
import inf112.skeleton.app.objects.tiles.Wall;

public class Board {

    private IDrawable[][] board;
    private int height;
    private int width;
    private Texture texture;


    public Board(){
        this.width = 12;
        this.height = 12;
        this.board = new IDrawable[12][12];
        this.texture = new Texture(Gdx.files.internal("src/main/java/inf112/skeleton/app/assets/sprites/tiles.png"));
        this.fillStandardBoard();

    }

    private void fillStandardBoard() {
        for (int i = 0; i < this.height; i++){
            for (int j = 0; j < this.width; j++){
                this.setTile(i, j, new Wall(this.texture));
            }
        }

        this.setTile(3, 3, new Spawn(this.texture, 1));
        this.setTile(6, 1, new Spawn(this.texture, 2));
        this.setTile(7, 9, new Spawn(this.texture, 3));
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