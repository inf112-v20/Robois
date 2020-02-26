package inf112.skeleton.app;

import inf112.skeleton.app.objects.Board;
import inf112.skeleton.app.objects.interfaces.IMovable;
import inf112.skeleton.app.utilities.CardinalDirection;
import inf112.skeleton.app.utilities.CardinalityUtility;

/**
 * GameMovement
 */
public class GameMovement {

    public static void move(int steps, IMovable movable, Board board) {
        CardinalDirection dir = movable.getCardinalDirection();
        moveInDirection(steps, movable, board, dir);
    }

    public static void moveBackwards(int steps, IMovable movable, Board board) {
        CardinalDirection dir = CardinalityUtility.getOpposite(movable.getCardinalDirection());
        moveInDirection(steps, movable, board, dir);
    }

    private static void moveInDirection(int steps, IMovable movable, Board board, CardinalDirection dir) {
        if (steps != 0) {
            if (board.isOutOfBounds(movable.getX(), movable.getY(), dir)){
                retrunToSpawn(movable);
                return;
            }
            
            if (board.canGo(movable.getX(), movable.getY(), dir)) {

                movable.move(dir);
                move(steps - 1, movable, board);
            } else {
                
            }
        }
    }

    public static void rotate(int rotation, IMovable movable) {
        movable.rotate(rotation);
    }

    private static void retrunToSpawn(IMovable movable){
        movable.setX(movable.getSpawnX());
        movable.setY(movable.getSpawnY());
    }
}