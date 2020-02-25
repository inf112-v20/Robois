package inf112.skeleton.app;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import inf112.skeleton.app.objects.Board;
import inf112.skeleton.app.objects.Robot;
import inf112.skeleton.app.utilities.TextureReader;

/**
 * Where the main gameplay loop runs.
 */
public class Game extends InputAdapter implements ApplicationListener {
    private SpriteBatch batch;
    private BitmapFont font;
    private Board board;
    private HashMap<Integer, TextureRegion> textures;
    private TextureRegion[][] regions;
    private Robot robot;

    @Override
    public void create() {
    	Gdx.input.setInputProcessor(this);
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.RED);
        try {
			board = new Board();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        this.textures = TextureReader.getTextures();
        createTextureRegions();
        robot = new Robot(5, 5, 0);
    }

    /**
     * Creates a one dimensional list of texture 
     * regions that is used to render the board (background).
     */
    private void createTextureRegions() {
        regions = new TextureRegion[board.getHeight()][board.getWidth()];
        for (int x = 0; x < board.getWidth(); x++){
            for (int y = 0; y < board.getHeight(); y++){        
                this.regions[y][x] = this.textures.get(this.board.getTile(x, y).getImageId());
            }
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }
    
    /**
     * The keyUp function is Override so that we can
     * implement cardinal movement to the game.
     * 
     * @param keyCode The key code of the input to be executed.
     */
    @Override
    public boolean keyUp(int keyCode) {
    	if (keyCode == Input.Keys.W) {
    		this.robot.move(1);
        	return true;
    	}
    	if (keyCode == Input.Keys.D) {
    		this.robot.rotate(1);
        	return true;
    	}
    	if (keyCode == Input.Keys.S) {
    		this.robot.move(-1);
        	return true;
    	}
    	if (keyCode == Input.Keys.A) {
    		this.robot.rotate(-1);
        	return true;
    	}
    	return false;
    }

    /**
     * Render can be seen as the main gameplay loop, this is where
     * the graphics of the game gets rendered.
     */
    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Rendering the background
        batch.begin();
        renderBoard();
        batch.end();

        // Rendering the Robot
        batch.begin();
        Sprite s = new Sprite(this.textures.get(this.robot.getImageId()));
        s.setPosition(this.robot.getX()*70, this.robot.getY()*70);
        s.setSize(70, 70);
        rotateRobot(s, robot);
        s.draw(batch);
        batch.end();
    }
    
    /**
     * Rotates  the robot sprite depending on the 
     * cardinal direction of the robot
     * 
     * @param s The robot sprite
     */
    private void rotateRobot(Sprite s, Robot r) {
        if (r.getDirection() == 1) {
            s.rotate90(true);
        }
        if (r.getDirection() == 2) {
            s.flip(false, true);
        }
        if (r.getDirection() == 3) {
            s.rotate90(false);
        }
    }

    /**
     * Render the board (background)
     */
    private void renderBoard() {
    	for (int y = 0; y < this.regions.length; y++) {
    		for (int x = 0; x < this.regions[y].length; x++) {
    			if (this.board.getTile(x, y).needBackground()) {
        			batch.draw(this.textures.get(0), x*70, y*70, 70, 70);
    			}
    			batch.draw(this.regions[y][x], x*70, y*70, 70, 70);
    		}
    	}
		font.draw(batch, "FPS: " + Gdx.graphics.getFramesPerSecond(), 10, 20);
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