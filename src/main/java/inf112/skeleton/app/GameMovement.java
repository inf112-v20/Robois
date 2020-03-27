package inf112.skeleton.app;

import inf112.skeleton.app.objects.Board;
import inf112.skeleton.app.objects.interfaces.IMovable;
import inf112.skeleton.app.utilities.CardinalDirection;
import inf112.skeleton.app.utilities.CardinalityUtility;

/**
 * GameMovement
 */
public class GameMovement {

    public static void move(int steps, IMovable movable, Board board, Game game) {
        CardinalDirection dir = movable.getCardinalDirection();
        moveInDirection(steps, movable, board, dir, game);
    }

    public static void moveBackwards(int steps, IMovable movable, Board board, Game game) {
        CardinalDirection dir = CardinalityUtility.getOpposite(movable.getCardinalDirection());
        moveInDirection(steps, movable, board, dir, game);
    }

    public static boolean moveInDirection(int steps, IMovable movable, Board board, CardinalDirection dir, Game game) {
        if (steps != 0) {
            if (board.canGo(movable.getX(), movable.getY(), dir)) {
                if (board.isOutOfBounds(movable.getX(), movable.getY(), dir)) {
                    retrunToSpawn(movable);
                    return true;
                } else {
                    // This is here so that we can test without a game parameter.
                    if (game != null){
                        // Check if there is a robot
                        IMovable m = game.getMovable(movable.getX(), movable.getY(), dir);
                        if (m != null && !moveInDirection(1, m, board, dir, game)){
                                return false;
                        }
                    }
                    movable.move(dir);
                    move(steps - 1, movable, board, game);
                    return true;
                }
            }
        }
        return false;
    }

    public static void rotate(int rotation, IMovable movable) {
        // movable.rotate(rotation);
        //movable.setDirection(CardinalityUtility.getNewDirection(rotation, movable.getCardinalDirection()).value);
        movable.setDirection((movable.getDirection() + rotation % 4 + 4) % 4);
    }

    private static void retrunToSpawn(IMovable movable) {
        movable.setX(movable.getSpawnX());
        movable.setY(movable.getSpawnY());
    }
}