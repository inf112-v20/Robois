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
        return getRelativeDirection(RelativeDirection.BACKWARDS, dir);
    }
    
    /**
     * Get the left direction relative to the given direction
     * 
     * @param dir direction robot is facing
     * @return CardinalDirection
     */
    public static CardinalDirection getRelativeLeft(CardinalDirection dir) {
        return getRelativeDirection(RelativeDirection.LEFT, dir);
    }
    
    /**
     * Get the right direction relative to the given direction
     * 
     * @param dir direction robot is facing
     * @return CardinalDirection
     */
    public static CardinalDirection getRelativeRight(CardinalDirection dir) {
        return getRelativeDirection(RelativeDirection.RIGHT, dir);
    }
    

    public static CardinalDirection getCardinalDirection (int dir) {
        switch (dir) {
            case 0:
                return CardinalDirection.NORTH;
            case 1:
                return CardinalDirection.EAST;
            case 2:
                return CardinalDirection.SOUTH;
            case 3:
                return CardinalDirection.WEST;
            default:
                return null;
        }
    }

    /**
     * Get the new direction robot is facing when rotating an amount relative to the direction dir
     * 
     * @param rotation what kind of rotation
     * @param dir direction robot is facing
     * @return CardinalDirection
     */
    public static CardinalDirection getRelativeDirection(RelativeDirection rotation, CardinalDirection dir) {
        return getCardinalDirection((dir.value + rotation.value % 4 + 4) % 4);
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