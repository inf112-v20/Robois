package inf112.skeleton.app;

import com.badlogic.gdx.Input;

public class GameInput {
    /**
     * Execute a keyUp keyCode
     * 
     * @param keyCode
     * @param game
     * @return
     */
    public static boolean executeKeyUp(int keyCode, Game game) {
        if (keyCode == Input.Keys.W) {
            GameMovement.move(1, game.getCurrentRobot(), game.getBoard(), game);
            game.nextPlayer();
            return true;
        }
        if (keyCode == Input.Keys.D) {
            GameMovement.rotate(1, game.getCurrentRobot());
            game.nextPlayer();
            return true;
        }
        if (keyCode == Input.Keys.S) {
            GameMovement.moveBackwards(1, game.getCurrentRobot(), game.getBoard(), game);
            game.nextPlayer();
            return true;
        }
        if (keyCode == Input.Keys.A) {
            GameMovement.rotate(-1, game.getCurrentRobot());
            game.nextPlayer();
            return true;
        }
        if (keyCode == Input.Keys.SPACE) {
            GamePhase.runPhaseChange(game);
        }
        return false;
    }
}