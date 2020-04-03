package inf112.skeleton.app.utilities;

/**
 * CardinalDirection
 */
public enum CardinalDirection {
    NORTH(0), EAST(1), SOUTH(2), WEST(3),
    LEFT(-1), RIGHT(1),
    BACKWARDS(2);

    public final int value;

    CardinalDirection(int value) {
        this.value = value;
    }
}