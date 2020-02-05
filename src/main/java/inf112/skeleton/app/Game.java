package inf112.skeleton.app;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import inf112.skeleton.app.objects.Board;

public class Game implements ApplicationListener {
    private SpriteBatch batch;
    private BitmapFont font;
    private Board board;
    private TextureRegion[] regions;

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.RED);
        board = new Board();

        regions = new TextureRegion[board.getWidth()*board.getHeight()];

        int i = 0;
        for (int x = 0; x < board.getWidth(); x++){
            for (int y = 0; y < board.getHeight(); y++){        
                regions[i] = board.getTile(x, y).getImage();
                i++;
            }
        }

        
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        
        // TODO: Refactor this
        int x = 0;
        int y = 0;
        for (int i = 0; i < regions.length; i++) {
            batch.draw(regions[i], x*70, y*70, 70, 70);

            if (x < 11){
                x++;
            } else {
                x = 0;
                y++;
            }

            if (y > 11){
                y = 0;
            }
            
		}
		font.draw(batch, "FPS: " + Gdx.graphics.getFramesPerSecond(), 10, 20);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }
}