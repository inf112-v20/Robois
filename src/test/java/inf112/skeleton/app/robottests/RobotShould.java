package inf112.skeleton.app.robottests;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import inf112.skeleton.app.GameMovement;
import inf112.skeleton.app.objects.Board;
import inf112.skeleton.app.objects.Robot;
import inf112.skeleton.app.objects.tiles.Wall;
import inf112.skeleton.app.utilities.CardinalDirection;

public class RobotShould {
	int robotX, robotY;
	Robot robot;
	Board brd;

	@Before
	public void initialize() throws FileNotFoundException {
		robotX = robotY = 5;
		robot = new Robot(robotX, robotY, 0);
		brd = new Board("b0.csv");
	}

	/**
	 * MOVEMENT
	 */
	private void checkMovement(int steps, CardinalDirection direction) {
		robot.setDirection(direction.value);
		GameMovement.move(steps, robot, brd);

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
	 * Move one forward in each direction
	 */
	@Test
	public void move1UpOnMove1Direction0() {
		checkMovement(1, CardinalDirection.NORTH);
	}

	@Test
	public void move1RightOnMove1Direction1() {
		checkMovement(1, CardinalDirection.EAST);
	}

	@Test
	public void move1DownOnMove1Direction2() {
		checkMovement(1, CardinalDirection.SOUTH);
	}

	@Test
	public void move1LeftOnMove1Direction3() {
		checkMovement(1, CardinalDirection.WEST);
	}

	/**
	 * Move one backwards in each direction
	 */
	@Test
	public void move1DownOnMoveNEGATIVE1Direction0() {
		checkMovement(1, CardinalDirection.NORTH);
	}

	@Test
	public void move1LeftOnMoveNEGATIVE1Direction1() {
		checkMovement(1, CardinalDirection.EAST);
	}

	@Test
	public void move1UpOnMoveNEGATIVE1Direction2() {
		checkMovement(1, CardinalDirection.SOUTH);
	}

	@Test
	public void move1RightOnMoveNEGATIVE1Direction3() {
		checkMovement(1, CardinalDirection.WEST);
	}

	/**
	 * Move two forward in each direction
	 */
	@Test
	public void move2UpOnMove2Direction0() {
		checkMovement(2, CardinalDirection.NORTH);
	}

	@Test
	public void move2RightOnMove2Direction1() {
		checkMovement(2, CardinalDirection.EAST);
	}

	@Test
	public void move2DownOnMove2Direction2() {
		checkMovement(2, CardinalDirection.SOUTH);
	}

	@Test
	public void move2LeftOnMove2Direction3() {
		checkMovement(2, CardinalDirection.WEST);
	}

	/**
	 * Move three forward in each direction
	 */
	@Test
	public void move3UpOnMove3Direction0() {
		checkMovement(3, CardinalDirection.NORTH);
	}

	@Test
	public void move3RightOnMove3Direction1() {
		checkMovement(3, CardinalDirection.EAST);
	}

	@Test
	public void move3DownOnMove3Direction2() {
		checkMovement(3, CardinalDirection.SOUTH);
	}

	@Test
	public void move3LeftOnMove3Direction3() {
		checkMovement(3, CardinalDirection.WEST);
	}

	/**
	 * ROTATION
	 */
	private void checkRotation(int rotation, CardinalDirection direction) {
		robot.setDirection(direction.value);
		GameMovement.rotate(rotation, robot);
		assertEquals((direction.value + rotation % 4 + 4) % 4, robot.getDirection());
	}

	/**
	 * Clockwise rotation from each direction
	 */
	@Test
	public void rotate1ClockWiseOnRotate1Direction0() {
		checkRotation(1, CardinalDirection.NORTH);
	}

	@Test
	public void rotate1ClockWiseOnRotate1Direction1() {
		checkRotation(1, CardinalDirection.EAST);
	}

	@Test
	public void rotate1ClockWiseOnRotate1Direction2() {
		checkRotation(1, CardinalDirection.SOUTH);
	}

	@Test
	public void rotate1ClockWiseOnRotate1Direction3() {
		checkRotation(1, CardinalDirection.WEST);
	}

	/**
	 * Counter-clockwise rotation from each direction
	 */
	@Test
	public void rotate1CounterClockWiseOnRotate1Direction0() {
		checkRotation(-1, CardinalDirection.NORTH);
	}

	@Test
	public void rotate1CounterClockWiseOnRotate1Direction1() {
		checkRotation(-1, CardinalDirection.EAST);
	}

	@Test
	public void rotate1CounterClockWiseOnRotate1Direction2() {
		checkRotation(-1, CardinalDirection.SOUTH);
	}

	@Test
	public void rotate1CounterClockWiseOnRotate1Direction3() {
		checkRotation(-1, CardinalDirection.WEST);
	}

	/**
	 * WALL-HANDLING
	 */
	private void checkWallInteraction(CardinalDirection direction, boolean inWallTile, int wallId) {
		robot.setDirection(direction.value);
		Wall wall = new Wall(wallId);
		if (!inWallTile) {
			GameMovement.moveBackwards(1, robot, brd);
			brd.setTile(robotX, robotY, wall);
			robotX = robot.getX();
			robotY = robot.getY();
		} else {
			brd.setTile(robotX, robotY, wall);
		}
		GameMovement.move(1, robot, brd);
		checkMovement(0, direction);
	}

	/**
	 * IN WALL TILE
	 * 
	 * Can't move through wall in north direction
	 */
	@Test
	public void notMoveOnDirectionNORTHinWallTileTrueWallId6() {
		checkWallInteraction(CardinalDirection.NORTH, true, 6);
	}

	@Test
	public void notMoveOnDirectionNORTHinWallTileTrueWallId2() {
		checkWallInteraction(CardinalDirection.NORTH, true, 2);
	}

	@Test
	public void notMoveOnDirectionNORTHinWallTileTrueWallId3() {
		checkWallInteraction(CardinalDirection.NORTH, true, 3);
	}

	/**
	 * Can't move through wall in east direction
	 */
	@Test
	public void notMoveOnDirectionEASTinWallTileTrueWallId5() {
		checkWallInteraction(CardinalDirection.EAST, true, 5);
	}

	@Test
	public void notMoveOnDirectionEASTinWallTileTrueWallId1() {
		checkWallInteraction(CardinalDirection.EAST, true, 1);
	}

	@Test
	public void notMoveOnDirectionEASTinWallTileTrueWallId2() {
		checkWallInteraction(CardinalDirection.EAST, true, 2);
	}

	/**
	 * Can't move through wall in south direction
	 */
	@Test
	public void notMoveOnDirectionSOUTHinWallTileTrueWallId8() {
		checkWallInteraction(CardinalDirection.SOUTH, true, 8);
	}

	@Test
	public void notMoveOnDirectionSOUTHinWallTileTrueWallId1() {
		checkWallInteraction(CardinalDirection.SOUTH, true, 1);
	}

	@Test
	public void notMoveOnDirectionSOUTHinWallTileTrueWallId4() {
		checkWallInteraction(CardinalDirection.SOUTH, true, 4);
	}

	/**
	 * Can't move through wall in west direction
	 */
	@Test
	public void notMoveOnDirectionWESTinWallTileTrueWallId7() {
		checkWallInteraction(CardinalDirection.WEST, true, 7);
	}

	@Test
	public void notMoveOnDirectionWESTinWallTileTrueWallId3() {
		checkWallInteraction(CardinalDirection.WEST, true, 3);
	}

	@Test
	public void notMoveOnDirectionWESTinWallTileTrueWallId4() {
		checkWallInteraction(CardinalDirection.WEST, true, 4);
	}

	/**
	 * NOT IN WALL TILE
	 * 
	 * Can't move through wall in north direction
	 */
	@Test
	public void notMoveOnDirectionNORTHinWallTileFalseWallId6() {
		checkWallInteraction(CardinalDirection.NORTH, false, 8);
	}

	@Test
	public void notMoveOnDirectionNORTHinWallTileFalseWallId2() {
		checkWallInteraction(CardinalDirection.NORTH, false, 1);
	}

	@Test
	public void notMoveOnDirectionNORTHinWallTileFalseWallId3() {
		checkWallInteraction(CardinalDirection.NORTH, false, 4);
	}

	/**
	 * Can't move through wall in east direction
	 */
	@Test
	public void notMoveOnDirectionEASTinWallTileFalseWallId5() {
		checkWallInteraction(CardinalDirection.EAST, false, 7);
	}

	@Test
	public void notMoveOnDirectionEASTinWallTileFalseWallId1() {
		checkWallInteraction(CardinalDirection.EAST, false, 3);
	}

	@Test
	public void notMoveOnDirectionEASTinWallTileFalseWallId2() {
		checkWallInteraction(CardinalDirection.EAST, false, 4);
	}

	/**
	 * Can't move through wall in south direction
	 */
	@Test
	public void notMoveOnDirectionSOUTHinWallTileFalseWallId8() {
		checkWallInteraction(CardinalDirection.SOUTH, false, 6);
	}

	@Test
	public void notMoveOnDirectionSOUTHinWallTileFalseWallId1() {
		checkWallInteraction(CardinalDirection.SOUTH, false, 2);
	}

	@Test
	public void notMoveOnDirectionSOUTHinWallTileFalseWallId4() {
		checkWallInteraction(CardinalDirection.SOUTH, false, 3);
	}

	/**
	 * Can't move through wall in west direction
	 */
	@Test
	public void notMoveOnDirectionWESTinWallTileFalseWallId7() {
		checkWallInteraction(CardinalDirection.WEST, false, 5);
	}

	@Test
	public void notMoveOnDirectionWESTinWallTileFalseWallId3() {
		checkWallInteraction(CardinalDirection.WEST, false, 1);
	}

	@Test
	public void notMoveOnDirectionWESTinWallTileFalseWallId4() {
		checkWallInteraction(CardinalDirection.WEST, false, 2);
	}

	/**
	 * MOVEMENT OUT OF BOUND
	 */
	private void checkRespawnOnOutOfBounds(int x, int y, CardinalDirection direction) {
		robot.setDirection(direction.value);
		robot.setX(x);
		robot.setY(y);
		GameMovement.move(1, robot, brd);

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

	@Test
	public void respawnOnX0Y0DirectionNORTH(){
		checkRespawnOnOutOfBounds(0, 0, CardinalDirection.NORTH);
	}

	@Test
	public void respawnOnX0Y0DirectionWEST(){
		checkRespawnOnOutOfBounds(0, 0, CardinalDirection.WEST);
	}

	@Test
	public void respawnOnX11Y11DirectionSOUTH(){
		checkRespawnOnOutOfBounds(11, 11, CardinalDirection.SOUTH);
	}

	@Test
	public void respawnOnX11Y11DirectionEAST(){
		checkRespawnOnOutOfBounds(11, 11, CardinalDirection.EAST);
	}
}