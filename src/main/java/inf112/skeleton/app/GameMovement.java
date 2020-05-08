package inf112.skeleton.app;

import inf112.skeleton.app.objects.Board;
import inf112.skeleton.app.objects.interfaces.IMovable;
import inf112.skeleton.app.utilities.CardinalDirection;
import inf112.skeleton.app.utilities.RelativeDirection;
import inf112.skeleton.app.utilities.CardinalityUtility;

/**
 * GameMovement
 */
public class GameMovement {

    /**
     * Moves a movable object in the direction that object is facing.
     * 
     * @param steps     number of steps
     * @param movable   movable object
     * @param board     board object
     * @param game      game object
     */
    public static void move(int steps, IMovable movable, Board board, Game game) {
        CardinalDirection dir = movable.getDirection();
        moveInDirection(steps, movable, board, dir, game);
    }

    /**
     * Moves a movable object in the opposite direction of its own direction.
     * 
     * @param steps     number of steps
     * @param movable   movable object
     * @param board     board object
     * @param game      game object
     */
    public static void moveBackwards(int steps, IMovable movable, Board board, Game game) {
        CardinalDirection dir = CardinalityUtility.getOpposite(movable.getDirection());
        moveInDirection(steps, movable, board, dir, game);
    }

    /**
     * Move a movable in a specific direction.
     * 
     * @param steps     number of steps in a direction (Number of recursive calls).
     * @param movable   movable object
     * @param board     board object
     * @param dir       cardinal direction to move in.
     * @param game      game object
     */
    public static boolean moveInDirection(int steps, IMovable movable, Board board, CardinalDirection dir, Game game) {
        if (steps != 0) {
            if (board.canGo(movable.getX(), movable.getY(), dir)) {
                if (board.isOutOfBounds(movable.getX(), movable.getY(), dir)) {
                    // This is here so that we can test without a game parameter.
                    if (game != null){
                        for (Player p : game.getPlayers()) {
                            if ( p.getRobot() == movable) {
                                //need to use respawn from Player class so that all field will be updated.
                                p.respawn(game);
                                return true;
                            }
                        }
                    } else {
                        returnToSpawn(movable);
                    }
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

    /**
     * Rotates a movable object to a specific rotation specified by a rotation integer.
     * 
     * @param rotation  integer value of the rotation of the object 0-3.
     * @param movable   a movable object that implements the IMovable interface.
     */
    public static void rotate(RelativeDirection rotation, IMovable movable) {
        movable.setDirection(CardinalityUtility.getRelativeDirection(rotation, movable.getDirection()));

    /**
     * Returns a movable to its original spawn location.
     * 
     * @param movable   a movable object.
     */    }

    public static void returnToSpawn(IMovable movable) {
        movable.setX(movable.getSpawnX());
        movable.setY(movable.getSpawnY());
    }
}