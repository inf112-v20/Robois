package inf112.skeleton.app.ui_objects;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import inf112.skeleton.app.Game;
import inf112.skeleton.app.Player;
import inf112.skeleton.app.objects.Board;
import inf112.skeleton.app.objects.Robot;
import inf112.skeleton.app.objects.abstracts.Location;
import inf112.skeleton.app.objects.interfaces.IMovable;
import inf112.skeleton.app.objects.tiles.Beam;
import inf112.skeleton.app.objects.tiles.Laser;
import inf112.skeleton.app.utilities.CardinalDirection;
import inf112.skeleton.app.utilities.TextureReader;

public class UIBoard implements IRenderable {
    private Location location;
    private int width;
    private int height;
    private int tileSize;
    private Board board;
    private Game game;
    private boolean canClick = true;
    private boolean canRender = true;

    private TextureRegion[][] regions;
    private HashMap<Integer, TextureRegion> textures;
    
    private float timeSeconds = 0f;
    private float period = 0.5f;

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
        if (!canRender()) return;
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

        renderLaserBeams(batch);

        timeSeconds += Gdx.graphics.getRawDeltaTime();
        if(timeSeconds > period){
            timeSeconds-=period;
            for (Laser l : game.getLasers()) {
                l.setBeams(null);
            }
        }


        
        renderRobot(batch);
    }

    private void renderLaserBeams(Batch batch) {
        for (Laser l : game.getLasers()) {
            if (l.getBeams() != null){
                for (Beam b : l.getBeams()){
                    Sprite s = new Sprite(this.textures.get(b.getImageId()));
                    int ym = game.getBoard().getHeight() - b.getY() - 1;
                    s.setPosition(b.getX() * this.tileSize + getX(), ym * this.tileSize + getY());
                    s.setSize(this.tileSize, this.tileSize);
                    s.draw(batch);
                }
            } else {
                timeSeconds = 0f;
            }
        }
    }

    private void renderRobot(Batch batch) {
        // Robot
        for (Player player : game.getPlayers()) {
            Robot robot = player.getRobot();
            if (robot == null) continue;
            Sprite s;
            if (player.equals(game.getCurrentPlayer())) {
                s = new Sprite(TextureReader.getSpecificTexture("src/main/java/inf112/skeleton/app/assets/sprites/friendly_robot.png", 300, 300));
            }else {
                s = new Sprite(TextureReader.getSpecificTexture("src/main/java/inf112/skeleton/app/assets/sprites/enemy_robot.png", 300, 300));
            }
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

    
    @Override
    public boolean canRender() {
        return this.canRender;
    }

    @Override
    public void setCanRender(boolean r) {
        this.canRender = r;
    }
}