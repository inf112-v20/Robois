package inf112.skeleton.app;

import com.badlogic.gdx.graphics.Color;

import java.io.IOException;
import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import inf112.skeleton.app.objects.Board;
import inf112.skeleton.app.ui_objects.Panel;
import inf112.skeleton.app.ui_objects.ProgramCard;
import inf112.skeleton.app.ui_objects.ProgramCardType;
import inf112.skeleton.app.ui_objects.UIBoard;
import inf112.skeleton.app.utilities.TextureReader;

public class GameRendering {
    private SpriteBatch batch;
    private BitmapFont font;
    private Board board;

    private TextureRegion[][] regions;
    private HashMap<Integer, TextureRegion> textures;

    Panel mainGamePanel;

    public GameRendering(Game game) {
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

        mainGamePanel = new Panel(0, 0, 16*80, 9*80, null);
        mainGamePanel.addObject(new UIBoard(40, 230, 55*12, 55*12, game, this.regions, this.textures));
        mainGamePanel.addObject(new ProgramCard(500, 200, 100, 432, ProgramCardType.MOVE1));
        mainGamePanel.addObject(new ProgramCard(650, 200, 100, 512, ProgramCardType.MOVE2));
        mainGamePanel.addObject(new ProgramCard(800, 200, 100, 32, ProgramCardType.MOVE3));
    }

    /**
     * Render can be seen as the main gameplay loop, this is where the graphics of
     * the game gets rendered.
     */
    public void render(){
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        this.batch.begin();
        this.mainGamePanel.render(this.batch);
        this.batch.end();

        this.batch.begin();
        font.draw(batch, "FPS: " + Gdx.graphics.getFramesPerSecond(), 10, 20);
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

    public void dispose(){
        batch.dispose();
        font.dispose();
    }
}