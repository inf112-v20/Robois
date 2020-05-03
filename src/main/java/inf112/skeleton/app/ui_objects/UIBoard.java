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
    private int tileSize;
    private Board board;
    private Game game;
    private boolean canClick = true;

    private TextureRegion[][] regions;
    private HashMap<Integer, TextureRegion> textures;

    public UIBoard(int x, int y, int width, int height, Game game, TextureRegion[][] regions, HashMap<Integer, TextureRegion> textures) {

        this.width = width;
        this.height = height;
        this.game = game;
        this.board = game.getBoard();
        this.regions = regions;
        this.textures = textures;

        if (this.width > this.height) {
            this.tileSize = this.width / this.board.getWidth();
            y += (this.height - this.regions.length*this.tileSize) / 2;
        } else {
            this.tileSize = this.height / this.board.getHeight();
            x += (this.width - this.regions[0].length*this.tileSize) / 2;
        }
        this.location = new Location(x, y);
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

    @Override
    public void render(Batch batch) {

        //Board
        for (int y = 0; y < this.regions.length; y++) {
            for (int x = 0; x < this.regions[y].length; x++) {
                int ym = this.regions.length - y - 1;
                if (this.board.getTile(x, y).needBackground()) {
                    renderTile(batch, y, x, ym, true);
                }
                renderTile(batch, y, x, ym, false);
            }
        }

        renderRobot(batch);
    }

    private void renderRobot(Batch batch) {
        // Robot
        for (Player player : game.getPlayers()) {
            Robot robot = player.getRobot();
            Sprite s = new Sprite(this.textures.get(robot.getImageId()));
            int ym = game.getBoard().getHeight() - robot.getY() - 1;
            s.setPosition(robot.getX() * this.tileSize + getX(), ym * this.tileSize + getY());
            s.setSize(this.tileSize, this.tileSize);
            rotateMovableObject(s, robot);
            s.draw(batch);
        }
    }

    private void renderTile(Batch batch, int y, int x, int ym, boolean floor) {
        TextureRegion r = floor ? this.textures.get(0) : this.regions[y][x];
        batch.draw(r, x * this.tileSize + getX(), ym * this.tileSize + getY(), this.tileSize, this.tileSize);
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

    @Override
    public boolean click(int x, int y) {
        return true;
    }

    @Override
    public boolean canClick() {
        return this.canClick;
    }

    @Override
    public void setCanClick(boolean b) {
        this.canClick = b;
    }
}