package inf112.skeleton.app;

import java.util.List;

import inf112.skeleton.app.objects.Board;
import inf112.skeleton.app.objects.Robot;
import inf112.skeleton.app.objects.interfaces.IDrawable;
import inf112.skeleton.app.objects.tiles.CBelt;
import inf112.skeleton.app.objects.tiles.FCBelt;
import inf112.skeleton.app.utilities.CardinalDirection;
import inf112.skeleton.app.utilities.CardinalityUtility;

public class GamePhase {
    /**
     * Run a new phase change
     */
    public static void runPhaseChange(Game game) {
        game.nextPhase();
        System.out.println("Running phase nr: " + game.getPhase());

        List<Player> players = game.getPlayers();

        for (Player p : players) {
            doFCBeltPhaseTurn(p, game.getBoard(), game);
        }
        for (Player p : players) {
            doPhaseTurn(p, game.getBoard(), game);
        }
    }

    /**
     * Run one step of the FCBelt phase turn.
     * 
     * @param p a player
     */
    private static void doFCBeltPhaseTurn(Player p, Board board, Game game) {
        Robot robot = p.getRobot();
        IDrawable tile = board.getTile(robot.getX(), robot.getY());

        if (tile instanceof FCBelt) {
            FCBelt fcbelt = (FCBelt) tile;
            GameMovement.moveInDirection(1, robot, board, fcbelt.getDirection(), game);
            IDrawable nextTile = board.getTile(robot.getX(), robot.getY());
            if (nextTile instanceof FCBelt) {
                FCBelt nextcbelt = (FCBelt) nextTile;

                if (CardinalityUtility.getRelativeRight(fcbelt.getDirection()) == nextcbelt.getDirection()) {
                    GameMovement.rotate(CardinalDirection.RIGHT, robot);
                }
                else if (CardinalityUtility.getRelativeLeft(fcbelt.getDirection()) == nextcbelt.getDirection()) {
                    GameMovement.rotate(CardinalDirection.LEFT, robot);
                }
            }
        }
    }

    /**
     * Do the whole phaseturn
     * 
     * @param p a player
     */
    private static void doPhaseTurn(Player p, Board board, Game game) {
        Robot robot = p.getRobot();
        IDrawable tile = board.getTile(robot.getX(), robot.getY());

        if (tile instanceof CBelt) {
            CBelt cbelt = (CBelt) tile;
            GameMovement.moveInDirection(1, robot, board, cbelt.getDirection(), game);
            IDrawable nextTile = board.getTile(robot.getX(), robot.getY());
            if (nextTile instanceof CBelt) {
                CBelt nextcbelt = (CBelt) nextTile;

                if (CardinalityUtility.getRelativeRight(cbelt.getDirection()) == nextcbelt.getDirection()) {
                    GameMovement.rotate(CardinalDirection.RIGHT, robot);
                }
                else if (CardinalityUtility.getRelativeLeft(cbelt.getDirection()) == nextcbelt.getDirection()) {
                    GameMovement.rotate(CardinalDirection.LEFT, robot);
                }
            }
        }
        if (tile instanceof FCBelt) {
            doFCBeltPhaseTurn(p, board, game);
        }
    }
}