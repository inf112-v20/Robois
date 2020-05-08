package inf112.skeleton.app;

import java.util.ArrayList;
import java.util.Iterator;
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
    //private static Boolean wonGame = null;

    /**
     * Run a new phase change
     */
    public static void runPhaseChange(Game game) {
        game.nextPhase();

        List<Player> players = game.getPlayers();
        List<Laser> lasers = game.getLasers();

        for (Player p : players) {
            if (p.getRobot() == null) continue;
            doFCBeltPhaseTurn(p, game.getBoard(), game);
        }
        for (Player p : players) {
            if (p.getRobot() == null) continue;
            doMovementPhaseTurn(p, game.getBoard(), game);
        }
        doLaserPhaseTurn(players, lasers, game.getBoard(), game);
        for (Player p : players) {
            if (p.getRobot() == null) continue;
            doRecoverPhaseTurn(p, game.getBoard(), game);
        }
        Iterator<Player> iter = players.iterator();

        while (iter.hasNext()) {
            Player p = iter.next();
        
            if (p.isDestroyed())
                p.respawn(game);
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
                    if (p.getFlags().size() == 1) {
                        p.pickupFlag(f);
                    }
                    break;
                case (3):
                    if (p.getFlags().size() == 2) {
                        p.pickupFlag(f);
                    }
                    break;
                case (4):
                    if (p.getFlags().size() == 3) {
                        p.pickupFlag(f);
                    }
                    break;
                default:
                    break;
            }
            if (p.getFlags().size() == game.getFlags().size()) {
                boolean won = p.equals(game.getCurrentPlayer()) ? true : false;
                setWonGame(game, won);
            }
            p.repair(1);
        }
        if (tile instanceof Wrench) {
            Wrench wrench = (Wrench) tile;
            p.repair(wrench.getDamage());
        }
    }

    private static void doLaserPhaseTurn(List<Player> players, List<Laser> lasers, Board board, Game game) {
        List<Beam> beams = new ArrayList<>();
        List<Laser> tempLasers = new ArrayList<>();
        for (Player p : players) {
            if (p.getRobot() == null) continue;
            Laser lt;
            if (!board.canGo(p.getRobot().getX(), p.getRobot().getY(), p.getRobot().getDirection())) {
                continue;
            }
            switch (p.getRobot().getDirection()) {
                case NORTH:
                    lt = new Laser(1, 1, p.getRobot().getX(), p.getRobot().getY()-1);
                    break;
                case EAST:
                    lt = new Laser(2, 1, p.getRobot().getX()+1, p.getRobot().getY());
                    break;
                case SOUTH:
                    lt = new Laser(3, 1, p.getRobot().getX(), p.getRobot().getY()+1);
                    break;
                case WEST:
                    lt = new Laser(4, 1, p.getRobot().getX()-1, p.getRobot().getY());
                    break;
                default:
                    lt = new Laser(1, 1, p.getRobot().getX(), p.getRobot().getY()-1);
                    break;
            }
            tempLasers.add(lt);
            lasers.add(lt);
        }
        for (Laser l : lasers) {
            beams.add(new Beam(l.getBeamid(), l.getDamage(), l.getX(), l.getY())); // A laser will always fire its first beam.
            Location prevTile = CardinalityUtility.getNextTile(l.getX(), l.getY(), CardinalityUtility.getOpposite(l.getLaserDirection()));
            if (game.getMovable(prevTile.getX(), prevTile.getY(), l.getLaserDirection()) == null) {
            getNextBeam(l, beams, board, game);
            }
            l.setBeams(beams);
        }

        for (Laser lt : tempLasers) {
            lasers.remove(lt);
        }

        for (Player p : players) {
            if (p.getRobot() == null) continue;
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

    public static void setWonGame(Game game, boolean won) {
        game.getGameRendering().setCurrentScene(2);
        game.setWonGame(won);
        game.getGameLoop().endGame();
    }
}