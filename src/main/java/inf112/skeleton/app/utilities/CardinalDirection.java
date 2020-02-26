package inf112.skeleton.app.utilities;

/**
 * CardinalDirection
 */
public enum CardinalDirection {
    NORTH(0), EAST(1), SOUTH(2), WEST(3);

    public final int value;

    CardinalDirection(int value) {
        this.value = value;
    }
}