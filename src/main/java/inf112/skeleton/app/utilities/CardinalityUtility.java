package inf112.skeleton.app.utilities;

import inf112.skeleton.app.objects.abstracts.Location;

/**
 * CardinalityUtility
 */
public class CardinalityUtility {

    /**
     * Get the oppisite direction of a cardinal direction.
     * 
     * @param dir direction to get inverse of
     * @return opposite direction.
     */
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

    /**
     * Get next tile in a direction from a x-y coordinate
     * 
     * @param x x-coordinate
     * @param y y-coordinate
     * @param dir direction to retrieve tile from
     * @return Location
     */
    public static Location getNextTile(int x, int y, CardinalDirection dir) {
        int newX = x;
        int newY = y;

        switch (dir) {
			case NORTH:
                newY--;
				break;
			case SOUTH:
                newY++;
				break;
			case WEST:
				newX--;
				break;
			case EAST:
                newX++;
				break;
			default:
                break;
        }
        return new Location(newX, newY);
    }
}