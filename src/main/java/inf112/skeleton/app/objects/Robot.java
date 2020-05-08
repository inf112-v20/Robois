
package inf112.skeleton.app.objects;

import inf112.skeleton.app.objects.interfaces.IDrawable;
import inf112.skeleton.app.objects.interfaces.IMovable;
import inf112.skeleton.app.utilities.CardinalDirection;

public class Robot implements IDrawable, IMovable {

    private int x;
    private int y;
    private int spawnX;
    private int spawnY;
    private CardinalDirection direction;

    public Robot(int x, int y, CardinalDirection d) {
        this.x = this.spawnX = x;
        this.y = this.spawnY = y;
        this.direction = d;
    }

    @Override
    public Integer getImageId() {
        return 881;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public CardinalDirection getDirection() {
        return this.direction;
    }

    public void setDirection(CardinalDirection dir) {
        this.direction = dir;
    }

    @Override
    public boolean needBackground() {
        return false;
    }

    @Override
    public boolean move() {
        return moveOneTile(this.direction);
    }

    @Override
    public boolean move(CardinalDirection dir) {
        return moveOneTile(dir);
    }

    private boolean moveOneTile(CardinalDirection direction) {
        switch (direction) {
            case NORTH:
                this.y -= 1;
                return true;
            case EAST:
                this.x += 1;
                return true;
            case SOUTH:
                this.y += 1;
                return true;
            case WEST:
                this.x -= 1;
                return true;
            default:
                return false;
        }
    }

    @Override
    public int getSpawnX() {
        return this.spawnX;
    }

    @Override
    public int getSpawnY() {
        return this.spawnY;
    }

    @Override
    public void setSpawnX( int x ) { this.spawnX = x; }

    @Override
    public void setSpawnY( int y ) { this.spawnY = y; }
}