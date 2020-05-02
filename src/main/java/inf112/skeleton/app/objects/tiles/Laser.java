package inf112.skeleton.app.objects.tiles;

import inf112.skeleton.app.objects.interfaces.IDrawable;
import inf112.skeleton.app.utilities.CardinalDirection;

/**
 * Laser
 */
public class Laser implements IDrawable {
    private int id;
    private CardinalDirection laserWallPosition;
    private int damage;

    public Laser(int type, int damage) {
        switch (type) {
            case 1: case 5:
                laserWallPosition = CardinalDirection.SOUTH;
                break;
            case 2: case 6:
                laserWallPosition = CardinalDirection.WEST;
                break;
            case 3: case 7:
                laserWallPosition = CardinalDirection.NORTH;
                break;
            case 4: case 8:
                laserWallPosition = CardinalDirection.EAST;
                break;
        }
        this.id = 100 + type;
        this.damage = damage;
    }

    public Integer getDamage() {
        return this.damage;
    }

    public CardinalDirection getLaserWallPosition() {
        return this.laserWallPosition;
    }

    @Override
    public Integer getImageId() {
        return this.id;
    }

    @Override
    public boolean needBackground() {
        return true;
    }
}