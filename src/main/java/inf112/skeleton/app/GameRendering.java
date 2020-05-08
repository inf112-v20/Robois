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

import inf112.skeleton.app.ui_objects.*;

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
    private TextureRegion startbg;

    public GameRendering(Game game) {
        this.board = game.getBoard();
        this.batch = new SpriteBatch();
        this.font = new BitmapFont();
        this.font.setColor(Color.RED);
        this.scenes = new HashMap<>();
        this.bg = TextureReader.getSpecificTexture("src/main/java/inf112/skeleton/app/assets/sprites/ui_background.png", 1920, 1080);
        this.frame = TextureReader.getSpecificTexture("src/main/java/inf112/skeleton/app/assets/sprites/frame.png", 858, 860);
        this.startbg = TextureReader.getSpecificTexture("src/main/java/inf112/skeleton/app/assets/sprites/pad.png", 820, 1100);
        
        try {
            this.textures = TextureReader.getTextures();
        } catch (IOException e) {
            e.printStackTrace();
        }

        createTextureRegions();

        // CREATING UI
        Panel mainGamePanel = new Panel(0, 0, 16*80, 9*80, null);
        scenes.put(0, mainGamePanel);
        this.currentScene = 0;

        mainGamePanel.addObject(new UIBoard(148, 155, 622, 622, game, this.regions, this.textures));
        
        mainGamePanel.addObject(new InformationDisplay(150, 100, 100, 100, game));
        
        ProgramCardLocked l = new ProgramCardLocked(900, 20, 500, 155);
        mainGamePanel.addObject(l);

        ProgramCardHand h = new ProgramCardHand(1000, 300, 300, 500, game, l);
        mainGamePanel.addObject(h);

        l.setHand(h);

        //START GAME - Usikker på dette
        Panel startGamePanel = new Panel(0, 0, 16*80, 9*80, null);
        scenes.put(1, startGamePanel);

        //END GAME
        Panel endGamePanel = new Panel(0, 0, 16*80, 9*80, null);
        scenes.put(2, endGamePanel);

        endGamePanel.addObject(new EndGameDisplay(350, 600, 140, 25, game));
        
        String src = "src/main/java/inf112/skeleton/app/assets/sprites/arrow_button.png";
        mainGamePanel.addObject(new StartRoundButton(820, 65, 600, 600, 0.1f, src, game, l));
    }

    /**
     * Render can be seen as the main gameplay loop, this is where the graphics of
     * the game gets rendered.
     */
    public void render(){
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        this.batch.begin();
        switch (currentScene) {
            case 1:
                Sprite s = new Sprite(this.startbg);
                s.setSize(1600, 900);
                s.draw(batch);
                break;
            default:
                // Temp background rendering
                Sprite b = new Sprite(this.bg);
                b.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
                b.draw(batch);
                Sprite f = new Sprite(this.frame);
                f.setX(110);
                f.setY(103);
                f.setSize(700, 710);
                f.draw(batch);
                break;
        }
        this.batch.end();

        this.batch.begin();
        getCurrentScene().render(this.batch);
        this.batch.end();

        this.batch.begin();
        Sprite f = new Sprite(this.frame);
        f.setX(110);
        f.setY(103);
        f.setSize(700,710);
        f.draw(batch);
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

    public Panel getCurrentScene() {
        return this.scenes.get(currentScene);
    }

    public void setCurrentScene(int scene) { this.currentScene = scene; }
  
    public void resetCards() {
        for (IRenderable r : this.getCurrentScene().getObjects()) {
            if (r instanceof ProgramCardHand) {
                ProgramCardHand p = (ProgramCardHand) r;
                p.getNewHand();
            }
        }
    }
}