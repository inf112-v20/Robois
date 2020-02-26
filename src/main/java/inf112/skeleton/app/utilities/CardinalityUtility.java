package inf112.skeleton.app.utilities;

/**
 * CardinalityUtility
 */
public class CardinalityUtility {

    public static CardinalDirection getOpposite(CardinalDirection dir) {
        switch (dir) {
            case NORTH:
                return CardinalDirection.SOUTH;
            case SOUTH:
                return CardinalDirection.NORTH;
            case EAST:
                return CardinalDirection.WEST;
            case WEST:
                return CardinalDirection.EAST;
            default:
                return null;
        }
    }
}