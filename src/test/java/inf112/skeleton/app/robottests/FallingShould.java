package inf112.skeleton.app.robottests;

import inf112.skeleton.app.GameMovement;
import inf112.skeleton.app.objects.Board;
import inf112.skeleton.app.objects.Robot;
import inf112.skeleton.app.objects.tiles.Hole;
import inf112.skeleton.app.utilities.CardinalDirection;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class FallingShould {
    private int robotX, robotY;
    private Robot robot;
    private Board brd;

    @Before
    public void initialize() throws FileNotFoundException {
        robotX = robotY = 5;
        robot = new Robot(robotX, robotY, CardinalDirection.NORTH);
        brd = new Board("bt.csv");
    }

    private void checkRespawnOnOutOfBounds(int x, int y, CardinalDirection direction) {
        robot.setDirection(direction);
        robot.setX(x);
        robot.setY(y);
        GameMovement.move(1, robot, brd, null);

        if (direction == CardinalDirection.NORTH) {
            assertEquals(robot.getSpawnY(), robot.getY());
        } else if (direction == CardinalDirection.EAST) {
            assertEquals(robot.getSpawnX(), robot.getX());
        } else if (direction == CardinalDirection.SOUTH) {
            assertEquals(robot.getSpawnY(), robot.getY());
        } else if (direction == CardinalDirection.WEST) {
            assertEquals(robot.getSpawnX(), robot.getX());
        }
    }

    /**
     * FALLING OUT OF BOUNDS
     */
    @Test
    public void respawnRobotX0Y0OnMoveDirectionNORTH(){
        checkRespawnOnOutOfBounds(0, 0, CardinalDirection.NORTH);
    }

    @Test
    public void respawnRobotX0Y0OnMoveDirectionWEST(){
        checkRespawnOnOutOfBounds(0, 0, CardinalDirection.WEST);
    }

    @Test
    public void respawnRobotX11Y11OnMoveDirectionSOUTH(){
        checkRespawnOnOutOfBounds(11, 11, CardinalDirection.SOUTH);
    }

    @Test
    public void respawnRobotX11Y11OnMoveDirectionEAST(){
        checkRespawnOnOutOfBounds(11, 11, CardinalDirection.EAST);
    }


    /**
     * FALLING IN HOLE
     */
    @Test
    public void respawnRobotOnMovingIntoHole(){
        Hole hole = new Hole(1);
        brd.setTile(robotX, robotY-1, hole);
        checkRespawnOnOutOfBounds(robotX, robotY, CardinalDirection.NORTH);
    }
}
