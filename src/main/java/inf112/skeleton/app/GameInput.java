package inf112.skeleton.app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

import inf112.skeleton.app.ui_objects.IRenderable;
import inf112.skeleton.app.ui_objects.ProgramCardHand;
import inf112.skeleton.app.utilities.RelativeDirection;

public class GameInput implements InputProcessor{
    private GameRendering gameRendering;
    private Game game;

    public GameInput(Game game, GameRendering gameRendering) {
        this.gameRendering = gameRendering;
        this.game = game;
    } 

    @Override
    public boolean keyDown(int keyCode) {
        if (keyCode == Input.Keys.W) {
            GameMovement.move(1, game.getCurrentRobot(), game.getBoard(), game);
            game.nextPlayer();
            return true;
        }
        if (keyCode == Input.Keys.D) {
            GameMovement.rotate(RelativeDirection.RIGHT, game.getCurrentRobot());
            game.nextPlayer();
            return true;
        }
        if (keyCode == Input.Keys.S) {
            GameMovement.moveBackwards(1, game.getCurrentRobot(), game.getBoard(), game);
            game.nextPlayer();
            return true;
        }
        if (keyCode == Input.Keys.A) {
            GameMovement.rotate(RelativeDirection.LEFT, game.getCurrentRobot());
            game.nextPlayer();
            return true;
        }
        if (keyCode == Input.Keys.SPACE) {
            GamePhase.runPhaseChange(game);
        }
        if (keyCode == Input.Keys.O) {
            for (IRenderable r : this.gameRendering.getCurrentPanel().getObjects()) {
                if (r instanceof ProgramCardHand) {
                    ProgramCardHand p = (ProgramCardHand) r;
                    p.getNewHand();
                }
            }
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (button == Input.Buttons.LEFT) {
            System.out.println(String.format("(%d, %d)", screenX, Gdx.graphics.getHeight() - screenY));
            this.gameRendering.onMouseDown(screenX, Gdx.graphics.getHeight() - screenY);
            return true;
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        // TODO Auto-generated method stub
        return false;
    }
}