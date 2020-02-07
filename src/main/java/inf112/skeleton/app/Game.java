package inf112.skeleton.app;

import java.util.HashMap;

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
import inf112.skeleton.app.utilities.CardinalDirection;
import inf112.skeleton.app.utilities.TextureReader;

public class Game extends InputAdapter implements ApplicationListener {
    private SpriteBatch batch;
    private BitmapFont font;
    private Board board;
    private HashMap<Integer, TextureRegion> textures;
    private TextureRegion[] regions;
    private Robot robot;

    @Override
    public void create() {
    	Gdx.input.setInputProcessor(this);
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.RED);
        board = new Board();
        this.textures = TextureReader.getTextures();
        createTextureRegions();
        robot = new Robot();
    }

    private void createTextureRegions() {
        regions = new TextureRegion[board.getWidth()*board.getHeight()];
        int i = 0;
        for (int x = 0; x < board.getWidth(); x++){
            for (int y = 0; y < board.getHeight(); y++){        
                this.regions[i] = this.textures.get(this.board.getTile(x, y).getImageId());
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
    public boolean keyUp(int keyCode) {
    	if (keyCode == Input.Keys.W) {
    		this.robot.move(CardinalDirection.NORTH);
        	return true;
    	}
    	if (keyCode == Input.Keys.D) {
    		this.robot.move(CardinalDirection.EAST);
        	return true;
    	}
    	if (keyCode == Input.Keys.S) {
    		this.robot.move(CardinalDirection.SOUTH);
        	return true;
    	}
    	if (keyCode == Input.Keys.A) {
    		this.robot.move(CardinalDirection.WEST);
        	return true;
    	}
    	
    	return false;
    	
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        renderBoard();
        batch.end();

        batch.begin();
        TextureRegion robot = this.textures.get(this.robot.getImageId());
        Sprite s = new Sprite(robot);
        s.setPosition(this.robot.getX()*70, this.robot.getY()*70);
        s.setSize(70, 70);
        rotateRobot(s);
        s.draw(batch);
        
        batch.end();

    }
    
    private void rotateRobot(Sprite s) {
        switch (this.robot.getDirection()) {
	    	case NORTH:
	    		break;
	    	case WEST:
	            s.rotate90(false);
	            break;
	    	case SOUTH:		
	    		s.flip(false, true);
	            break;
	    	case EAST:
	            s.rotate90(true);
	    		break;
        }
    }

    private void renderBoard() {
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