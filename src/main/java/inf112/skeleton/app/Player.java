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
    private int life;
    private int HP;
    private boolean destroyed = false;
    private ArrayList<Integer> flags = new ArrayList<>();

    public Player(int x, int y) {
        this.robot = new Robot(x, y, CardinalDirection.NORTH);
        this.spawnX = x;
        this.spawnY = y;
        this.HP = 10;
        this.life = 3;
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

    public void respawn(Game game) {
        life -= 1;
        if (life <= 0) {
            checkWin(game);
        } else {
            HP = 8;
            GameMovement.returnToSpawn(robot);
            if (this.equals(game.getCurrentPlayer())) {
                game.getGameRendering().resetLockedCards();
            }
            destroyed = false;
        }
    }

    public ArrayList<Integer> getFlags() {
        return flags;
    }

    public void pickupFlag(Flag f) {
        flags.add(f.getFlagNr());
    }

    public void repair(int dmg) {
        if (HP <= (10-dmg)) {
            this.HP += dmg;
        } else {
            HP = 10;
        }
        updateRobotSpawn();
    }

    private void updateRobotSpawn() {
        robot.setSpawnX(robot.getX());
        robot.setSpawnY(robot.getY());
    }

    public int getLife() {
        return life;
    }

    private void checkWin(Game game) {
        if (this.equals(game.getCurrentPlayer())) {
            GamePhase.setWonGame(game, false);
            return;
        } else {
            this.robot = null;
            if (game.allEnemiesAreDead()) {
                GamePhase.setWonGame(game, true);
            }
        }
    }

}