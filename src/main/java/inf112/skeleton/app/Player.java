package inf112.skeleton.app;

import inf112.skeleton.app.objects.Robot;
import inf112.skeleton.app.utilities.CardinalDirection;

/**
 * Player
 */
public class Player {
    private Robot robot;
    private int spawnX;
    private int spawnY;
    private int HP;

    public Player(int x, int y) {
        this.robot = new Robot(x, y, CardinalDirection.NORTH);
        this.spawnX = x;
        this.spawnY = y;
        this.HP = 9;
    }

    public Robot getRobot() {
        return this.robot;
    }

    public int getSpawnX() {
        return this.spawnX;
    }

    public int getSpawnY() {
        return this.spawnY;
    }

    public int getHP() {
        return this.HP;
    }
}