package inf112.skeleton.app.objects.tiles;

import java.util.List;

import inf112.skeleton.app.objects.interfaces.IDrawable;
import inf112.skeleton.app.utilities.CardinalDirection;

/**
 * Laser
 */
public class Laser implements IDrawable {
    private int id;
    private CardinalDirection laserWallPosition;
    private CardinalDirection laserDirection;
    private int damage;
    private int beamid;
    private int x;
    private int y;
    private List<Beam> beams;

    public Laser(int type, int damage, int x, int y) {
        switch (type) {
            case 1: case 5:
                laserDirection = CardinalDirection.NORTH;
                laserWallPosition = CardinalDirection.SOUTH;
                if (type == 1) { 
                    beamid = 2; } 
                else { beamid = 5; }
                break;
            case 2: case 6:
                laserDirection = CardinalDirection.EAST;
                laserWallPosition = CardinalDirection.WEST;
                if (type == 2) { 
                    beamid = 1; } 
                else { beamid = 4; }
                break;
            case 3: case 7:
                laserDirection = CardinalDirection.SOUTH;
                laserWallPosition = CardinalDirection.NORTH;
                if (type == 3) { 
                    beamid = 2; } 
                else { beamid = 5; }
                break;
            case 4: case 8:
                laserDirection = CardinalDirection.WEST;
                laserWallPosition = CardinalDirection.EAST;
                if (type == 4) {
                    beamid = 1; } 
                else { beamid = 4; }
                break;
            default:
                break;
        }
        this.id = 100 + type;
        this.damage = damage;
        this.x = x;
        this.y = y;
        this.beams = null;
    }

    /**
     * @return the laserDirection
     */
    public CardinalDirection getLaserDirection() {
        return laserDirection;
    }

    /**
     * @return the beamid
     */
    public int getBeamid() {
        return beamid;
    }

    /**
     * @return the damage
     */
    public Integer getDamage() {
        return this.damage;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    public CardinalDirection getLaserWallPosition() {
        return this.laserWallPosition;
    }

    @Override
    public Integer getImageId() {
        return this.id;
    }

    @Override
    public boolean needBackground() {
        return true;
    }

    public List<Beam> getBeams() {
        return this.beams;
    }

    public void setBeams(List<Beam> beams) {
        this.beams = beams;
    }
}