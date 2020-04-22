package inf112.skeleton.app.ui_objects;

import java.util.HashMap;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import inf112.skeleton.app.Game;
import inf112.skeleton.app.Player;
import inf112.skeleton.app.objects.Board;
import inf112.skeleton.app.objects.Robot;
import inf112.skeleton.app.objects.abstracts.Location;
import inf112.skeleton.app.objects.interfaces.IMovable;
import inf112.skeleton.app.utilities.CardinalDirection;

public class UIBoard implements IRenderable {
    private Location location;
    private int width;
    private int height;
    private Board board;
    private Game game;

    private TextureRegion[][] regions;
    private HashMap<Integer, TextureRegion> textures;

    public UIBoard(int x, int y, int width, int height, Game game, TextureRegion[][] regions, HashMap<Integer, TextureRegion> textures) {
        this.location = new Location(x, y);
        this.width = width;
        this.height = height;
        this.game = game;
        this.board = game.getBoard();
        this.regions = regions;
        this.textures = textures;
    }

    @Override
    public int getX() {
        return this.location.getX();
    }

    @Override
    public int getY() {
        return this.location.getY();
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    //TODO: Make this look not horrible
    @Override
    public void render(Batch batch) {
        for (int y = 0; y < this.regions.length; y++) {
            for (int x = 0; x < this.regions[y].length; x++) {
                int ym = this.regions.length - y - 1;
                if (this.board.getTile(x, y).needBackground()) {
                    batch.draw(this.textures.get(0), x * (getWidth()/12) + getX(), ym * (getHeight()/12) + getY(), (getWidth()/12), (getHeight()/12));
                }
                batch.draw(this.regions[y][x], x * (getWidth()/12) + getX(), ym * (getHeight()/12) + getY(), (getWidth()/12), (getHeight()/12));
            }
        }
        for (Player player : game.getPlayers()) {
            Robot robot = player.getRobot();
            Sprite s = new Sprite(this.textures.get(robot.getImageId()));
            int ym = game.getBoard().getHeight() - robot.getY() - 1;
            s.setPosition(robot.getX() * (getWidth()/12) + getX(), ym * (getHeight()/12) + getY());
            s.setSize(getWidth()/12, getHeight()/12);
            rotateMovableObject(s, robot);
            s.draw(batch);
        }
    }

    /**
     * Rotates a movable object.
     * 
     * @param s The rotated sprite
     */
    private void rotateMovableObject(Sprite s, IMovable r) {
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
}