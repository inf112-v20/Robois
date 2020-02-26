
package inf112.skeleton.app.objects;

import inf112.skeleton.app.objects.interfaces.IDrawable;
import inf112.skeleton.app.objects.interfaces.IMovable;
import inf112.skeleton.app.utilities.CardinalDirection;

public class Robot implements IDrawable, IMovable {

    private int x;
    private int y;
    private int direction;

    public Robot(int x, int y, int d) {
        this.x = x;
        this.y = y;
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

    public int getDirection() {
        return this.direction;
    }

    public void setDirection(int dir) {
        this.direction = dir;
    }

    @Override
    public boolean needBackground() {
        return false;
    }

    public CardinalDirection getCardinalDirection() {
        switch (this.direction) {
            case 0:
                return CardinalDirection.NORTH;
            case 1:
                return CardinalDirection.EAST;
            case 2:
                return CardinalDirection.SOUTH;
            case 3:
                return CardinalDirection.WEST;
            default:
                return null;
        }
    }

    @Override
    public boolean move() {
        return moveOneTile(this.direction);
    }

    @Override
    public boolean move(CardinalDirection dir) {
        return moveOneTile(dir.value);
    }

    private boolean moveOneTile(int direction) {
        switch (direction) {
            case 0:
                this.y -= 1;
                return true;
            case 1:
                this.x += 1;
                return true;
            case 2:
                this.y += 1;
                return true;
            case 3:
                this.x -= 1;
                return true;
            default:
                return false;
        }
    }

    public void rotate(int i) {
        this.direction = (this.direction + i % 4 + 4) % 4;
    }
}