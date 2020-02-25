package inf112.skeleton.app.robottests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import inf112.skeleton.app.objects.Robot;

public class RobotShould {
    Robot robot;
	
	/** 
	 * MOVEMENT
	 * Move one forward in each direction
	 */
    @Test
    public void move1UpOnMove1Direction0() {
		robot = new Robot(5, 5, 0);		
        robot.move(1);
        assertEquals(6, robot.getY());
	}
	
	@Test
    public void move1RightOnMove1Direction1() {
		robot = new Robot(5, 5, 1);		
        robot.move(1);
        assertEquals(6, robot.getX());
	}
	
	@Test
    public void move1DownOnMove1Direction2() {
		robot = new Robot(5, 5, 2);
        robot.move(1);
        assertEquals(4, robot.getY());
	}
	
	@Test
    public void move1LeftOnMove1Direction3() {
		robot = new Robot(5, 5, 3);
        robot.move(1);
        assertEquals(4, robot.getX());
	}
	
	/** 
	 * Move one backwards in each direction
	 */
    @Test
    public void move1DownOnMoveNEGATIVE1Direction0() {
		robot = new Robot(5, 5, 0);		
        robot.move(-1);
        assertEquals(4, robot.getY());
	}
	
	@Test
    public void move1LeftOnMoveNEGATIVE1Direction1() {
		robot = new Robot(5, 5, 1);		
        robot.move(-1);
        assertEquals(4, robot.getX());
	}
	
	@Test
    public void move1UpOnMoveNEGATIVE1Direction2() {
		robot = new Robot(5, 5, 2);
        robot.move(-1);
        assertEquals(6, robot.getY());
	}
	
	@Test
    public void move1RightOnMoveNEGATIVE1Direction3() {
		robot = new Robot(5, 5, 3);
        robot.move(-1);
        assertEquals(6, robot.getX());
    }

	/** 
	 * Move two forward in each direction
	 */
    @Test
    public void move2UpOnMove1Direction0() {
		robot = new Robot(5, 5, 0);		
        robot.move(2);
        assertEquals(7, robot.getY());
	}
	
	@Test
    public void move2RightOnMove1Direction1() {
		robot = new Robot(5, 5, 1);		
        robot.move(2);
        assertEquals(7, robot.getX());
	}
	
	@Test
    public void move2DownOnMove1Direction2() {
		robot = new Robot(5, 5, 2);
        robot.move(2);
        assertEquals(3, robot.getY());
	}
	
	@Test
    public void move2LeftOnMove1Direction3() {
		robot = new Robot(5, 5, 3);
        robot.move(2);
        assertEquals(3, robot.getX());
	}

	/** 
	 * Move three forward in each direction
	 */
    @Test
    public void move3UpOnMove1Direction0() {
		robot = new Robot(5, 5, 0);		
        robot.move(3);
        assertEquals(8, robot.getY());
	}
	
	@Test
    public void move3RightOnMove1Direction1() {
		robot = new Robot(5, 5, 1);		
        robot.move(3);
        assertEquals(8, robot.getX());
	}
	
	@Test
    public void move3DownOnMove1Direction2() {
		robot = new Robot(5, 5, 2);
        robot.move(3);
        assertEquals(2, robot.getY());
	}
	
	@Test
    public void move3LeftOnMove1Direction3() {
		robot = new Robot(5, 5, 3);
        robot.move(3);
        assertEquals(2, robot.getX());
	}

	/** 
	 * ROTATION
	 * Clockwise rotation from each direction
	 */
	@Test
    public void rotate1ClockWiseOnRotate1Direction0() {
		robot = new Robot(5, 5, 0);
        robot.rotate(1);
        assertEquals(1, robot.getDirection());
	}

	@Test
    public void rotate1ClockWiseOnRotate1Direction1() {
		robot = new Robot(5, 5, 1);
        robot.rotate(1);
        assertEquals(2, robot.getDirection());
	}

	@Test
    public void rotate1ClockWiseOnRotate1Direction2() {
		robot = new Robot(5, 5, 2);
        robot.rotate(1);
        assertEquals(3, robot.getDirection());
	}

	@Test
    public void rotate1ClockWiseOnRotate1Direction3() {
		robot = new Robot(5, 5, 3);
        robot.rotate(1);
        assertEquals(0, robot.getDirection());
	}

	/** 
	 * Counter-clockwise rotation from each direction
	 */
	@Test
    public void rotate1CounterClockWiseOnRotate1Direction0() {
		robot = new Robot(5, 5, 0);
        robot.rotate(-1);
        assertEquals(3, robot.getDirection());
	}

	@Test
    public void rotate1CounterClockWiseOnRotate1Direction1() {
		robot = new Robot(5, 5, 1);
        robot.rotate(-1);
        assertEquals(0, robot.getDirection());
	}

	@Test
    public void rotate1CounterClockWiseOnRotate1Direction2() {
		robot = new Robot(5, 5, 2);
        robot.rotate(-1);
        assertEquals(1, robot.getDirection());
	}

	@Test
    public void rotate1CounterClockWiseOnRotate1Direction3() {
		robot = new Robot(5, 5, 3);
        robot.rotate(-1);
        assertEquals(2, robot.getDirection());
	}
}