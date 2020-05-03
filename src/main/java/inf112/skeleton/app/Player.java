package inf112.skeleton.app;

import inf112.skeleton.app.objects.Robot;
import inf112.skeleton.app.objects.tiles.Flag;
import inf112.skeleton.app.utilities.CardinalDirection;

import java.util.ArrayList;

/**
 * Player
 */
public class Player {
    private Robot robot;
    private int spawnX;
    private int spawnY;
    private int HP;
    private boolean destroyed = false;
    private ArrayList<Integer> flags = new ArrayList<>();

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

    public void takeDamage(int dmg) {
        this.HP -= dmg;
        if (HP <= 0) {
            this.destroyed = true;
            HP = 0;
        }
    }

    public boolean isDestroyed() { 
        return this.destroyed;
    }

    public void respawn() {
        robot.setX(robot.getSpawnX());
        robot.setY(robot.getSpawnY());
        destroyed = false;
        HP = 9;
    }

    public ArrayList<Integer> getFlags() {
        return flags;
    }

    public void pickupFlag(Flag f) {
        flags.add(f.getFlagNr());
        updateRobotSpawn();
    }

    public void repair(int dmg) {
        if (HP <= (9-dmg)) {
            this.HP += dmg;
        } else {
            HP = 9;
        }
        updateRobotSpawn();
    }

    private void updateRobotSpawn() {
        robot.setSpawnX(robot.getX());
        robot.setSpawnY(robot.getY());
    }

}