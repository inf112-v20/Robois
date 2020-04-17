package inf112.skeleton.app;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;

import inf112.skeleton.app.objects.Board;
import inf112.skeleton.app.objects.Robot;
import inf112.skeleton.app.objects.abstracts.Location;
import inf112.skeleton.app.objects.interfaces.IMovable;
import inf112.skeleton.app.objects.tiles.Spawn;
import inf112.skeleton.app.utilities.CardinalDirection;
import inf112.skeleton.app.utilities.CardinalityUtility;

/**
 * Where the main gameplay loop runs.
 */
public class Game extends InputAdapter implements ApplicationListener {
    private Board board;
    private List<Player> players = new ArrayList<>();
    private int r = 0;
    private int phaseNr = 0;

    private GameRendering gameRendering;

    @Override
    public void create() {
        Gdx.input.setInputProcessor(this);
        try {
            board = new Board("b1.csv");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        this.gameRendering = new GameRendering(this);

        // Add players / spawns to the board.
        for (int x = 0; x < board.getWidth(); x++) {
            for (int y = 0; y < board.getHeight(); y++) {
                if (board.getTile(x, y) instanceof Spawn) {
                    players.add(new Player(x, y));
                }
            }
        }
    }

    @Override
    public void dispose() {
        gameRendering.dispose();
    }

    /**
     * The keyUp function is Override so that we can implement cardinal movement to
     * the game.
     * 
     * @param keyCode The key code of the input to be executed.
     */
    @Override
    public boolean keyUp(int keyCode) {
        return GameInput.executeKeyUp(keyCode, this);
    }

    /**
     * Render can be seen as the main gameplay loop, this is where the graphics of
     * the game gets rendered.
     */
    @Override
    public void render() {
        gameRendering.render();
    }

    @Override
    public void resize(int width, int height) {
        Gdx.graphics.setWindowedMode(width, height);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    /**
     * Get a movable (robot) from in a specific location.
     * 
     * @param x   x-coordinate
     * @param y   y-coordinate
     * @param dir direction from x-y-coordinate
     */
    public IMovable getMovable(int x, int y, CardinalDirection dir) {
        for (Player p : this.players) {
            Robot r = p.getRobot();
            Location l = CardinalityUtility.getNextTile(x, y, dir);
            if (r.getX() == l.getX() && r.getY() == l.getY()) {
                return r;
            }
        }
        return null;
    }

    /**
     * Update the current player variable to the next player
     */
    public void nextPlayer() {
        this.r = (this.r + 1) % this.players.size();
    }

    /**
     * Get the current robot in use.
     * 
     * @return the current robot.
     */
    public IMovable getCurrentRobot() {
        return players.get(r).getRobot();
    }

    /**
     * Increment the phase number to the next one.
     */
    public void nextPhase() {
        this.phaseNr++;
    }

    /**
     * Get the current phase the game is on.
     * 
     * @return the current phase
     */
    public int getPhase() {
        return this.phaseNr;
    }

    /**
     * Get the game's board.
     * 
     * @return the game's board
     */
    public Board getBoard() {
        return this.board;
    }

    /**
     * List of players
     * 
     * @return list of players.
     */
    public List<Player> getPlayers() {
        return this.players;
    }
}