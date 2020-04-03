package inf112.skeleton.app.utilities;

/**
 * CardinalDirection
 */
public enum RelativeDirection {
    LEFT(-1), RIGHT(1),
    BACKWARDS(2);

    public final int value;

    RelativeDirection(int value) {
        this.value = value;
    }
}