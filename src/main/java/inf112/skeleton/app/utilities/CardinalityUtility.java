package inf112.skeleton.app.utilities;

import inf112.skeleton.app.objects.abstracts.Location;

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

    public static Location getNextTile(int x, int y, CardinalDirection dir) {
        switch (dir) {
			case NORTH:
                y--;
				break;
			case SOUTH:
				y++;
				break;
			case WEST:
				x--;
				break;
			case EAST:
				x++;
				break;
			default:
                break;
        }
        return new Location(x, y);
    }
}