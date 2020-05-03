package inf112.skeleton.app.objects.tiles;

import inf112.skeleton.app.objects.interfaces.IDrawable;
import inf112.skeleton.app.utilities.CardinalDirection;

/**
 * Gear
 */
public class Pusher implements IDrawable {
    private int id;
    private CardinalDirection pusherWallPosition;
    private int active = 0; //Indicates what phases the pushers should be active. 0 for even rounds, 1 for odd.

    public Pusher(int type) {
        switch (type) {
            case 1: case 2:
                pusherWallPosition = CardinalDirection.SOUTH;
                break;
            case 3: case 4:
                pusherWallPosition = CardinalDirection.WEST;
                break;
            case 5: case 6:
                pusherWallPosition = CardinalDirection.NORTH;
                break;
            case 7: case 8:
                pusherWallPosition = CardinalDirection.EAST;
                break;
            default:
                break;
        }
        switch (type) {
            case 1: case 3: case 5: case 7:
                active = 1;
                break;
            default:
                break;
        }
        this.id = 130 + type;
    }

    public int getActive() {return this.active;}

    public CardinalDirection getPusherWallPosition() {
        return this.pusherWallPosition;
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