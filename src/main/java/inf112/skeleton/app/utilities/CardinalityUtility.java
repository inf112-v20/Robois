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

    public static CardinalDirection getNewDirection(int rotation, CardinalDirection direction){
        int x = (direction.value + rotation % 4 + 4) % 4;
        switch (x){
            case 0:
                return CardinalDirection.NORTH;
            case 1:
                return CardinalDirection.EAST;
            case 2:
                return CardinalDirection.SOUTH;
            case 3:
                return CardinalDirection.EAST;
            default:
                return null;
        }
    }
}