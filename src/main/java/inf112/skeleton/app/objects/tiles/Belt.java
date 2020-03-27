package inf112.skeleton.app.objects.tiles;

import inf112.skeleton.app.objects.interfaces.IDrawable;
import inf112.skeleton.app.utilities.CardinalDirection;

/**
 * CBelt
 */
public class Belt implements IDrawable {
    private int imageId;
    private CardinalDirection direction;

    private final int DIR_NORTH[] = { 3, 8, 9, 13, 19, 23 };
    private final int DIR_EAST[] = { 2, 5, 12, 14, 17, 20 };
    private final int DIR_SOUTH[] = { 1, 6, 10, 15, 18, 21 };
    private final int DIR_WEST[] = { 4, 7, 11, 16, 22, 24 };

    public Belt(int type) {

        if (contains(DIR_NORTH, type)) {
            this.direction = CardinalDirection.NORTH;
        }
        if (contains(DIR_EAST, type)) {
            this.direction = CardinalDirection.EAST;
        }
        if (contains(DIR_SOUTH, type)) {
            this.direction = CardinalDirection.SOUTH;
        }
        if (contains(DIR_WEST, type)) {
            this.direction = CardinalDirection.WEST;
        }
    }

    public static boolean contains(final int[] array, final int v) {
        for (int i : array) {
            if (i == v) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer getImageId() {
        return this.imageId;
    }

    @Override
    public boolean needBackground() {
        return false;
    }

    public CardinalDirection getDirection() {
        return this.direction;
    }
}