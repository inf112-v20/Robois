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
import inf112.skeleton.app.objects.tiles.Flag;
import inf112.skeleton.app.objects.tiles.Spawn;
import inf112.skeleton.app.objects.tiles.Laser;
import inf112.skeleton.app.ui_objects.ProgramCard;
import inf112.skeleton.app.utilities.CardinalDirection;
import inf112.skeleton.app.utilities.CardinalityUtility;

/**
 * Where the main gameplay loop runs.
 */
public class Game extends InputAdapter implements ApplicationListener {
    private final boolean debugging = false;
    private Board board;
    private List<Player> players = new ArrayList<>();
    private List<Laser> lasers = new ArrayList<>();
    private List<Integer> flags = new ArrayList<>();
    private Player playablePlayer;
    private int phaseNr = 0;
    private boolean wonGame;

    private GameRendering gameRendering;
    private GameLoop gameLoop;

    @Override
    public void create() {
        try {
            board = new Board("b_re.csv");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        clearPreviousGame();

    }

    public void clearPreviousGame() {
        this.players.clear();
        this.lasers.clear();
        this.flags.clear();
        this.playablePlayer = null;
        this.phaseNr = 0;
        this.wonGame = false;

         // Add players / spawns to the board.
         for (int x = 0; x < board.getWidth(); x++) {
            for (int y = 0; y < board.getHeight(); y++) {
                if (board.getTile(x, y) instanceof Spawn) {
                    Player p = new Player(x, y);
                    if (playablePlayer == null)
                        playablePlayer = p;
                    players.add(p);
                }
                if (board.getTile(x, y) instanceof Laser) {
                    lasers.add((Laser) board.getTile(x, y));
                }
                if (board.getTile(x,y) instanceof Flag) {
                    flags.add(((Flag) board.getTile(x, y)).getFlagNr());
                }

            }
        }

        this.gameRendering = new GameRendering(this);
        GameInput gameInput = new GameInput(this, this.gameRendering);
        Gdx.input.setInputProcessor(gameInput);

        this.gameLoop = new GameLoop(this);
    }

    @Override
    public void dispose() {
        gameRendering.dispose();
    }

    /**
     * Render can be seen as the main gameplay loop, this is where the graphics of
     * the game gets rendered.
     */
    @Override
    public void render() {
        gameRendering.render();
        gameLoop.render();
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
            if (p.getRobot() == null) continue;
            Robot r = p.getRobot();
            Location l = CardinalityUtility.getNextTile(x, y, dir);
            if (r.getX() == l.getX() && r.getY() == l.getY()) {
                return r;
            }
        }
        return null;
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
        return Math.floorMod(this.phaseNr, 5)+1;
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

    /**
     * List of lasers
     * 
     * @return list of lasers.
     */
    public List<Laser> getLasers() {
        return this.lasers;
    }

    public Player getCurrentPlayer() {
		    return this.playablePlayer;
    }

    /**
     * List of flags
     *
     * @return list of flags.
     */
    public List<Integer> getFlags() {
        return flags;
    }

    public void startRound(ProgramCard[] hand) {
        this.gameLoop.startRound(hand);
    }

    public GameRendering getGameRendering() {
        return this.gameRendering;
    }

    public boolean wonGame() {
        return this.wonGame;
    }

    public void setWonGame(boolean b) {
        this.wonGame = b;
    }

    /**
     * @return the gameLoop
     */
    public GameLoop getGameLoop() {
        return this.gameLoop;
    }

	public void deletePlayer(Player player) {
        this.players.remove(player);
        if (this.allEnemiesAreDead()) {
            GamePhase.setWonGame(this, true);
        }
	}

	public boolean allEnemiesAreDead() {
        for (Player p : this.players) {
            if (!p.equals(this.getCurrentPlayer()) && p.getRobot() != null) {
                return false;
            }
        }    
        return true;   
    }
    
    public boolean getDebugging() {
        return debugging;
    }
}