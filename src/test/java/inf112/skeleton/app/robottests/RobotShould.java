package inf112.skeleton.app.robottests;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import inf112.skeleton.app.GameMovement;
import inf112.skeleton.app.objects.Board;
import inf112.skeleton.app.objects.Robot;

public class RobotShould {
	int robotX, robotY = 5;
	Robot robot = new Robot(robotX, robotY, 0);

	Board brd;

	@Before
	public void initialize() throws FileNotFoundException {
		brd = new Board();
	}

	private void checkMovement(int steps, int direction) {
		robot.setDirection(direction);
		GameMovement.move(steps, robot, brd);

		if (direction == 0) {
			assertEquals(robotY - steps, robot.getY());
		} else if (direction == 1) {
			assertEquals(robotX + steps, robot.getX());
		} else if (direction == 2) {
			assertEquals(robotY + steps, robot.getY());
		} else if (direction == 3) {
			assertEquals(robotX - steps, robot.getX());
		}
	}

	private void checkRotation(int rotation, int direction) {
		robot.setDirection(direction);
		robot.rotate(rotation);
		assertEquals((direction + rotation % 4 + 4) % 4, robot.getDirection());
	}

	/**
	 * MOVEMENT Move one forward in each direction
	 */
	@Test
	public void move1UpOnMove1Direction0() {
		checkMovement(1, 0);
	}

	@Test
	public void move1RightOnMove1Direction1() {
		checkMovement(1, 1);
	}

	@Test
	public void move1DownOnMove1Direction2() {
		checkMovement(1, 2);
	}

	@Test
	public void move1LeftOnMove1Direction3() {
		checkMovement(1, 3);
	}

	/**
	 * Move one backwards in each direction
	 */
	@Test
	public void move1DownOnMoveNEGATIVE1Direction0() {
		checkMovement(1, 0);
	}

	@Test
	public void move1LeftOnMoveNEGATIVE1Direction1() {
		checkMovement(1, 1);
	}

	@Test
	public void move1UpOnMoveNEGATIVE1Direction2() {
		checkMovement(1, 2);
	}

	@Test
	public void move1RightOnMoveNEGATIVE1Direction3() {
		checkMovement(1, 3);
	}

	/**
	 * Move two forward in each direction
	 */
	@Test
	public void move2UpOnMove2Direction0() {
		checkMovement(2, 0);
	}

	@Test
	public void move2RightOnMove2Direction1() {
		checkMovement(2, 1);
	}

	@Test
	public void move2DownOnMove2Direction2() {
		checkMovement(2, 2);
	}

	@Test
	public void move2LeftOnMove2Direction3() {
		checkMovement(2, 3);
	}

	/**
	 * Move three forward in each direction
	 */
	@Test
	public void move3UpOnMove3Direction0() {
		checkMovement(3, 0);
	}

	@Test
	public void move3RightOnMove3Direction1() {
		checkMovement(3, 1);
	}

	@Test
	public void move3DownOnMove3Direction2() {
		checkMovement(3, 2);
	}

	@Test
	public void move3LeftOnMove3Direction3() {
		checkMovement(3, 3);
	}

	/**
	 * ROTATION Clockwise rotation from each direction
	 */
	@Test
	public void rotate1ClockWiseOnRotate1Direction0() {
		checkRotation(1, 0);
	}

	@Test
	public void rotate1ClockWiseOnRotate1Direction1() {
		checkRotation(1, 1);
	}

	@Test
	public void rotate1ClockWiseOnRotate1Direction2() {
		checkRotation(1, 2);
	}

	@Test
	public void rotate1ClockWiseOnRotate1Direction3() {
		checkRotation(1, 3);
	}

	/**
	 * Counter-clockwise rotation from each direction
	 */
	@Test
	public void rotate1CounterClockWiseOnRotate1Direction0() {
		checkRotation(-1, 0);
	}

	@Test
	public void rotate1CounterClockWiseOnRotate1Direction1() {
		checkRotation(-1, 1);
	}

	@Test
	public void rotate1CounterClockWiseOnRotate1Direction2() {
		checkRotation(-1, 2);
	}

	@Test
	public void rotate1CounterClockWiseOnRotate1Direction3() {
		checkRotation(-1, 3);
	}
}