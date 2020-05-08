package inf112.skeleton.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import inf112.skeleton.app.objects.Board;
import inf112.skeleton.app.objects.Robot;
import inf112.skeleton.app.objects.abstracts.Location;
import inf112.skeleton.app.objects.interfaces.IDrawable;
import inf112.skeleton.app.objects.tiles.Beam;
import inf112.skeleton.app.objects.tiles.CBelt;
import inf112.skeleton.app.objects.tiles.FCBelt;
import inf112.skeleton.app.objects.tiles.Flag;
import inf112.skeleton.app.objects.tiles.Gear;
import inf112.skeleton.app.objects.tiles.Laser;
import inf112.skeleton.app.objects.tiles.Pusher;
import inf112.skeleton.app.objects.tiles.Wrench;
import inf112.skeleton.app.utilities.RelativeDirection;
import inf112.skeleton.app.utilities.CardinalityUtility;

public class GamePhase {
    private static Boolean wonGame = null;

    /**
     * Run a new phase change
     */
    public static void runPhaseChange(Game game) {
        game.nextPhase();
        System.out.println("Running phase nr: " + game.getPhase());

        List<Player> players = game.getPlayers();
        List<Laser> lasers = game.getLasers();

        for (Player p : players) {
            doFCBeltPhaseTurn(p, game.getBoard(), game);
        }
        for (Player p : players) {
            doMovementPhaseTurn(p, game.getBoard(), game);
        }
        doLaserPhaseTurn(players, lasers, game.getBoard(), game);
        for (Player p : players) {
            doRecoverPhaseTurn(p, game.getBoard(), game);
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
                    GameMovement.rotate(RelativeDirection.RIGHT, robot);
                }
                else if (CardinalityUtility.getRelativeLeft(fcbelt.getDirection()) == nextcbelt.getDirection()) {
                    GameMovement.rotate(RelativeDirection.LEFT, robot);
                }
            }
        }
    }

    /**
     * Do the whole phaseturn
     * 
     * @param p a player
     */
    private static void doMovementPhaseTurn(Player p, Board board, Game game) {
        Robot robot = p.getRobot();
        IDrawable tile = board.getTile(robot.getX(), robot.getY());

        if (tile instanceof CBelt) {
            CBelt cbelt = (CBelt) tile;
            GameMovement.moveInDirection(1, robot, board, cbelt.getDirection(), game);
            IDrawable nextTile = board.getTile(robot.getX(), robot.getY());
            if (nextTile instanceof CBelt) {
                CBelt nextcbelt = (CBelt) nextTile;

                if (CardinalityUtility.getRelativeRight(cbelt.getDirection()) == nextcbelt.getDirection()) {
                    GameMovement.rotate(RelativeDirection.RIGHT, robot);
                }
                else if (CardinalityUtility.getRelativeLeft(cbelt.getDirection()) == nextcbelt.getDirection()) {
                    GameMovement.rotate(RelativeDirection.LEFT, robot);
                }
            }
        }
        if (tile instanceof FCBelt) {
            doFCBeltPhaseTurn(p, board, game);
        }
        if (tile instanceof Pusher) {
            Pusher pusher = (Pusher) tile;
            if (pusher.getActive() == (game.getPhase() % 2)) {
                GameMovement.moveInDirection(1, robot, board, CardinalityUtility.getOpposite(pusher.getPusherWallPosition()), game);
            }
        }
        if (tile instanceof Gear) {
            Gear gear = (Gear) tile;
            GameMovement.rotate(gear.getRotation(), robot);
        }
    }

    private static void doRecoverPhaseTurn (Player p, Board board, Game game) {
        Robot robot = p.getRobot();
        IDrawable tile = board.getTile(robot.getX(), robot.getY());

        if (tile instanceof Flag) {
            Flag f = (Flag) tile;
            int flagNr = f.getFlagNr();
            switch (flagNr) {
                case (1):
                    if (p.getFlags().isEmpty()) {
                        p.pickupFlag(f);
                    }
                    break;
                case (2):
                    if (p.getFlags().contains(1)) {
                        p.pickupFlag(f);
                    }
                    break;
                case (3):
                    if (p.getFlags().containsAll(Arrays.asList(1,2))) {
                        p.pickupFlag(f);
                    }
                    break;
                case (4):
                    if (p.getFlags().containsAll(Arrays.asList(1,2,3))) {
                        p.pickupFlag(f);
                    }
                default:
                    break;
            }
            if (p.getFlags().size() == game.getFlags().size()) {
                setWonGame(true);
            }
            p.repair(1);
        }
        if (tile instanceof Wrench) {
            Wrench wrench = (Wrench) tile;
            p.repair(wrench.getDamage());
        }
        if (p.isDestroyed()) {
            p.respawn();
        }
    }

    private static void doLaserPhaseTurn(List<Player> players, List<Laser> lasers, Board board, Game game) {
        List<Beam> beams = new ArrayList<>();
        for (Laser l : lasers) {
            beams.add(new Beam(l.getBeamid(), l.getDamage(), l.getX(), l.getY())); // A laser will always fire its first beam.
            Location prevTile = CardinalityUtility.getNextTile(l.getX(), l.getY(), CardinalityUtility.getOpposite(l.getLaserDirection()));
            if (game.getMovable(prevTile.getX(), prevTile.getY(), l.getLaserDirection()) == null) {
            getNextBeam(l, beams, board, game);
            }
            l.setBeams(beams);
        }

        /* List<String> locations = new ArrayList<>();
            for (Beam b : beams) {
                locations.add(Integer.toString(b.getX()) + "." + Integer.toString(b.getY()));
            }
        System.out.println(locations); */

        for (Player p : players) {
            Robot robot = p.getRobot();
            for (Beam b : beams) {
                if (robot.getX() == b.getX() && robot.getY() == b.getY()) {
                    p.takeDamage(b.getDamage());
                }
            }
        }
    }

    private static List<Beam> getNextBeam(Laser l, List<Beam> beams, Board board, Game game) {
        Beam lastBeam = beams.get(beams.size()-1);
        if (lastBeam.getX() < 0 || lastBeam.getY() < 0) return beams;
        if (lastBeam.getX() >= board.getWidth() || lastBeam.getY() >= board.getHeight()) return beams;

        if (board.canGo(lastBeam.getX(), lastBeam.getY(), l.getLaserDirection())) {
            Location nextTile = CardinalityUtility.getNextTile(lastBeam.getX(), lastBeam.getY(), l.getLaserDirection());
            beams.add(new Beam(l.getBeamid(), l.getDamage(), nextTile.getX(), nextTile.getY()));
            if (game.getMovable(lastBeam.getX(), lastBeam.getY(), l.getLaserDirection()) == null) {
                getNextBeam(l, beams, board, game);
                return null;
            }
        }
        return beams;
    }

    public static void setWonGame(boolean won) {
        GameRendering.setCurrentScene(2);
        wonGame = won;
    }
}