package inf112.skeleton.app.robottests;

import static org.junit.Assert.assertEquals;

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
        robot = new Robot();
        robotPositionX = robot.getX();
        robotPositionY = robot.getY();
    }

    @Test
    public void move1TileNorthOnUpKeyPress() {
        robot.move(CardinalDirection.NORTH);
        assertEquals(6, robot.getX()+1);
    }


}