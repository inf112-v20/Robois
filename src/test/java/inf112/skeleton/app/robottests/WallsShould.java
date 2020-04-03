package inf112.skeleton.app.robottests;

import inf112.skeleton.app.GameMovement;
import inf112.skeleton.app.objects.Board;
import inf112.skeleton.app.objects.Robot;
import inf112.skeleton.app.objects.tiles.Wall;
import inf112.skeleton.app.utilities.CardinalDirection;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class WallsShould {
    private int robotX, robotY;
    private Robot robot;
    private Board brd;

    @Before
    public void initialize() throws FileNotFoundException {
        robotX = robotY = 5;
        robot = new Robot(robotX, robotY, CardinalDirection.NORTH);
        brd = new Board("bt.csv");
    }

    private void checkMovement(int steps, CardinalDirection direction) {
        robot.setDirection(direction);
        GameMovement.move(steps, robot, brd, null);

        if (direction == CardinalDirection.NORTH) {
            assertEquals(robotY - steps, robot.getY());
        } else if (direction == CardinalDirection.EAST) {
            assertEquals(robotX + steps, robot.getX());
        } else if (direction == CardinalDirection.SOUTH) {
            assertEquals(robotY + steps, robot.getY());
        } else if (direction == CardinalDirection.WEST) {
            assertEquals(robotX - steps, robot.getX());
        }
    }

    /**
     * WALL-HANDLING
     */
    private void checkWallInteraction(CardinalDirection direction, boolean inWallTile, int wallId) {
        robot.setDirection(direction);
        Wall wall = new Wall(wallId);
        if (!inWallTile) {
            GameMovement.moveBackwards(1, robot, brd, null);
            brd.setTile(robotX, robotY, wall);
            robotX = robot.getX();
            robotY = robot.getY();
        } else {
            brd.setTile(robotX, robotY, wall);
        }
        GameMovement.move(1, robot, brd, null);
        checkMovement(0, direction);
    }

    /**
     * IN WALL TILE
     *
     * Can't move through wall in north direction
     */
    @Test
    public void stopRobotMoveDirectionNORTHinWallTileTrueWallId6() {
        checkWallInteraction(CardinalDirection.NORTH, true, 6);
    }

    @Test
    public void stopRobotMoveDirectionNORTHinWallTileTrueWallId2() {
        checkWallInteraction(CardinalDirection.NORTH, true, 2);
    }

    @Test
    public void stopRobotMoveDirectionNORTHinWallTileTrueWallId3() {
        checkWallInteraction(CardinalDirection.NORTH, true, 3);
    }

    /**
     * Can't move through wall in east direction
     */
    @Test
    public void stopRobotMoveDirectionEASTinWallTileTrueWallId5() {
        checkWallInteraction(CardinalDirection.EAST, true, 5);
    }

    @Test
    public void stopRobotMoveDirectionEASTinWallTileTrueWallId1() {
        checkWallInteraction(CardinalDirection.EAST, true, 1);
    }

    @Test
    public void stopRobotMoveDirectionEASTinWallTileTrueWallId2() {
        checkWallInteraction(CardinalDirection.EAST, true, 2);
    }

    /**
     * Can't move through wall in south direction
     */
    @Test
    public void stopRobotMoveDirectionSOUTHinWallTileTrueWallId8() {
        checkWallInteraction(CardinalDirection.SOUTH, true, 8);
    }

    @Test
    public void stopRobotMoveDirectionSOUTHinWallTileTrueWallId1() {
        checkWallInteraction(CardinalDirection.SOUTH, true, 1);
    }

    @Test
    public void stopRobotMoveDirectionSOUTHinWallTileTrueWallId4() {
        checkWallInteraction(CardinalDirection.SOUTH, true, 4);
    }

    /**
     * Can't move through wall in west direction
     */
    @Test
    public void stopRobotMoveDirectionWESTinWallTileTrueWallId7() {
        checkWallInteraction(CardinalDirection.WEST, true, 7);
    }

    @Test
    public void stopRobotMoveDirectionWESTinWallTileTrueWallId3() {
        checkWallInteraction(CardinalDirection.WEST, true, 3);
    }

    @Test
    public void stopRobotMoveDirectionWESTinWallTileTrueWallId4() {
        checkWallInteraction(CardinalDirection.WEST, true, 4);
    }

    /**
     * NOT IN WALL TILE
     *
     * Can't move through wall in north direction
     */
    @Test
    public void stopRobotMoveDirectionNORTHinWallTileFalseWallId6() {
        checkWallInteraction(CardinalDirection.NORTH, false, 8);
    }

    @Test
    public void stopRobotMoveDirectionNORTHinWallTileFalseWallId2() {
        checkWallInteraction(CardinalDirection.NORTH, false, 1);
    }

    @Test
    public void stopRobotMoveDirectionNORTHinWallTileFalseWallId3() {
        checkWallInteraction(CardinalDirection.NORTH, false, 4);
    }

    /**
     * Can't move through wall in east direction
     */
    @Test
    public void stopRobotMoveDirectionEASTinWallTileFalseWallId5() {
        checkWallInteraction(CardinalDirection.EAST, false, 7);
    }

    @Test
    public void stopRobotMoveDirectionEASTinWallTileFalseWallId1() {
        checkWallInteraction(CardinalDirection.EAST, false, 3);
    }

    @Test
    public void stopRobotMoveDirectionEASTinWallTileFalseWallId2() {
        checkWallInteraction(CardinalDirection.EAST, false, 4);
    }

    /**
     * Can't move through wall in south direction
     */
    @Test
    public void stopRobotMoveDirectionSOUTHinWallTileFalseWallId8() {
        checkWallInteraction(CardinalDirection.SOUTH, false, 6);
    }

    @Test
    public void stopRobotMoveDirectionSOUTHinWallTileFalseWallId1() {
        checkWallInteraction(CardinalDirection.SOUTH, false, 2);
    }

    @Test
    public void stopRobotMoveDirectionSOUTHinWallTileFalseWallId4() {
        checkWallInteraction(CardinalDirection.SOUTH, false, 3);
    }

    /**
     * Can't move through wall in west direction
     */
    @Test
    public void stopRobotMoveDirectionWESTinWallTileFalseWallId7() {
        checkWallInteraction(CardinalDirection.WEST, false, 5);
    }

    @Test
    public void stopRobotMoveDirectionWESTinWallTileFalseWallId3() {
        checkWallInteraction(CardinalDirection.WEST, false, 1);
    }

    @Test
    public void stopRobotMoveDirectionWESTinWallTileFalseWallId4() {
        checkWallInteraction(CardinalDirection.WEST, false, 2);
    }
}
