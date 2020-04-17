package inf112.skeleton.app;

import com.badlogic.gdx.graphics.Color;

import java.io.IOException;
import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import inf112.skeleton.app.objects.Board;
import inf112.skeleton.app.objects.Robot;
import inf112.skeleton.app.utilities.CardinalDirection;
import inf112.skeleton.app.utilities.TextureReader;

public class GameRendering {
    private Game game;
    private SpriteBatch batch;
    private BitmapFont font;
    private Board board;
    private TextureRegion[][] regions;
    private HashMap<Integer, TextureRegion> textures;

    public GameRendering(Game game) {
        this.game = game;
        this.board = game.getBoard();
        this.batch = new SpriteBatch();
        this.font = new BitmapFont();
        this.font.setColor(Color.RED);
        
        try {
            this.textures = TextureReader.getTextures();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        createTextureRegions();
    }

    /**
     * Render can be seen as the main gameplay loop, this is where the graphics of
     * the game gets rendered.
     */
    public void render(){
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        // Rendering the background
        this.batch.begin();
        renderBoard();
        this.batch.end();

        // Rendering the Robot
        this.batch.begin();
        for (Player player : game.getPlayers()) {
            Robot robot = player.getRobot();
            Sprite s = new Sprite(this.textures.get(robot.getImageId()));
            int ym = game.getBoard().getHeight() - robot.getY() - 1;
            s.setPosition(robot.getX() * 70, ym * 70);
            s.setSize(70, 70);
            rotateRobot(s, robot);
            s.draw(batch);
        }
        this.batch.end();
    }

    
    /**
     * Creates a one dimensional list of texture regions that is used to render the
     * board (background).
     */
    private void createTextureRegions() {
        regions = new TextureRegion[board.getHeight()][board.getWidth()];
        for (int x = 0; x < board.getWidth(); x++) {
            for (int y = 0; y < board.getHeight(); y++) {
                this.regions[y][x] = this.textures.get(this.board.getTile(x, y).getImageId());
            }
        }
    }

    
    /**
     * Render the board (background)
     */
    private void renderBoard() {
        for (int y = 0; y < this.regions.length; y++) {
            for (int x = 0; x < this.regions[y].length; x++) {
                int ym = this.regions.length - y - 1;
                if (this.board.getTile(x, y).needBackground()) {
                    batch.draw(this.textures.get(0), x * 70, ym * 70, 70, 70);
                }
                batch.draw(this.regions[y][x], x * 70, ym * 70, 70, 70);
            }
        }
        font.draw(batch, "FPS: " + Gdx.graphics.getFramesPerSecond(), 10, 20);
    }
    
    /**
     * Rotates the robot sprite depending on the cardinal direction of the robot
     * 
     * @param s The robot sprite
     */
    private void rotateRobot(Sprite s, Robot r) {
        if (r.getDirection() == CardinalDirection.EAST) {
            s.rotate90(true);
        }
        if (r.getDirection() == CardinalDirection.SOUTH) {
            s.flip(false, true);
        }
        if (r.getDirection() == CardinalDirection.WEST) {
            s.rotate90(false);
        }
    }

    public void dispose(){
        batch.dispose();
        font.dispose();
    }
}