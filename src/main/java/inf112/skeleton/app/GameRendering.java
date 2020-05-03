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
import inf112.skeleton.app.ui_objects.InformationDisplay;
import inf112.skeleton.app.ui_objects.Panel;
import inf112.skeleton.app.ui_objects.ProgramCardHand;
import inf112.skeleton.app.ui_objects.ProgramCardLocked;
import inf112.skeleton.app.ui_objects.ProgramCardType;
import inf112.skeleton.app.ui_objects.UIBoard;
import inf112.skeleton.app.utilities.TextureReader;

public class GameRendering {
    private SpriteBatch batch;
    private BitmapFont font;
    private Board board;

    private TextureRegion[][] regions;
    private HashMap<Integer, TextureRegion> textures;

    private HashMap<Integer, Panel> scenes;
    private Integer currentScene;

    private TextureRegion bg;
    private TextureRegion frame;

    public GameRendering(Game game) {
        this.board = game.getBoard();
        this.batch = new SpriteBatch();
        this.font = new BitmapFont();
        this.font.setColor(Color.RED);
        this.scenes = new HashMap<>();
        this.bg = TextureReader.getSpecificTexture("src/main/java/inf112/skeleton/app/assets/sprites/ui_background.png", 1920, 1080);
        this.frame = TextureReader.getSpecificTexture("src/main/java/inf112/skeleton/app/assets/sprites/frame.png", 858, 860);
        
        try {
            this.textures = TextureReader.getTextures();
        } catch (IOException e) {
            e.printStackTrace();
        }

        createTextureRegions();

        // CREATING UI
        Panel mainGamePanel = new Panel(0, 0, 16*80, 9*80, null);
        scenes.put(0, mainGamePanel);
        currentScene = 0;

        mainGamePanel.addObject(new UIBoard(148, 155, 622, 622, game, this.regions, this.textures));
        
        mainGamePanel.addObject(new InformationDisplay(150, 100, 100, 100, game));
        
        ProgramCardLocked l = new ProgramCardLocked(900, 20, 500, 155);
        mainGamePanel.addObject(l);

        ProgramCardHand h = new ProgramCardHand(1000, 300, 300, 500, game, l);
        mainGamePanel.addObject(h);

        h.addCard(ProgramCardType.MOVE1, ProgramCardType.getRandomInt(ProgramCardType.MOVE1));
        h.addCard(ProgramCardType.MOVE3, ProgramCardType.getRandomInt(ProgramCardType.MOVE3));
        h.addCard(ProgramCardType.ROTATE_RIGTH, ProgramCardType.getRandomInt(ProgramCardType.ROTATE_RIGTH));
        h.addCard(ProgramCardType.ROTATE_LEFT, ProgramCardType.getRandomInt(ProgramCardType.ROTATE_LEFT));
        h.addCard(ProgramCardType.ROTATE_LEFT, ProgramCardType.getRandomInt(ProgramCardType.ROTATE_LEFT));
        h.addCard(ProgramCardType.ROTATE_RIGTH, ProgramCardType.getRandomInt(ProgramCardType.ROTATE_RIGTH));
        h.addCard(ProgramCardType.ROTATE_LEFT, ProgramCardType.getRandomInt(ProgramCardType.ROTATE_LEFT));
        h.addCard(ProgramCardType.ROTATE_RIGTH, ProgramCardType.getRandomInt(ProgramCardType.ROTATE_RIGTH));
        h.addCard(ProgramCardType.ROTATE_LEFT, ProgramCardType.getRandomInt(ProgramCardType.ROTATE_LEFT));
    }

    /**
     * Render can be seen as the main gameplay loop, this is where the graphics of
     * the game gets rendered.
     */
    public void render(){
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Temp background rendering
        this.batch.begin();
        Sprite s = new Sprite(this.bg);
        s.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        s.draw(batch);
        Sprite f = new Sprite(this.frame);
        f.setX(110);
        f.setY(103);
        f.setSize(700,710);
        f.draw(batch);
        this.batch.end();

        this.batch.begin();
        this.scenes.get(currentScene).render(this.batch);
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

    public void onMouseDown(int x, int y){
        this.scenes.get(currentScene).click(x, y);
    }
}