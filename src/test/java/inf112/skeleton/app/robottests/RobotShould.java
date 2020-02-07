package inf112.skeleton.app.robottests;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import inf112.skeleton.app.objects.Robot;
import inf112.skeleton.app.utilities.CardinalDirection;

public class RobotShould {
    Robot robot;
    int robotPositionX;
    int robotPositionY;


    @Before
    public void instatiateRobot() {
        robot = new Robot(0, 0);
        robotPositionX = robot.getX();
        robotPositionY = robot.getY();
    }

    @Test
    public void move1TileNorthOnUpKeyPress() {
        robot.move(CardinalDirection.NORTH);
        assertEquals(1, robot.getY());
    }
    
    @Test
    public void canMoveInAllDirections() {

    	int x = robot.getY();
    	int y = robot.getX();
    	
    	Random rnd = new Random();
    	for (int i = 0; i < 100; i++) {
    		switch(rnd.nextInt(4)) {
    		case 0:
    	        robot.move(CardinalDirection.NORTH);
    	        y++;
    		case 1:
    	        robot.move(CardinalDirection.EAST);
    	        x++;
    		case 2:
    	        robot.move(CardinalDirection.SOUTH);
    	        y--;
    		case 3: 
    	        robot.move(CardinalDirection.WEST);
    	        x--;
    			
    		}
    	}

        assertEquals(x, robot.getX());
        assertEquals(y, robot.getY());
        
    }
    


}