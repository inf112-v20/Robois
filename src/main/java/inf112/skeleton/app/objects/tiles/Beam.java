package inf112.skeleton.app.objects.tiles;

import inf112.skeleton.app.objects.interfaces.IDrawable;

/**
 * Beam
 */
public class Beam implements IDrawable {
    private int id;
    private int damage;
    private Boolean vertical = true;
    private int x;
    private int y;

    public Beam(int type, int damage, int x, int y) {
        if (type == 2 || type == 5) {
            vertical = false;
        }
        this.id = 110 + type;
        this.damage = damage;
        this.x = x;
        this.y = y;
    }

    /**
     * @return the vertical
     */
    public Boolean getVertical() {
        return this.vertical;
    }

    /**
     * @return the damage
     */
    public int getDamage() {
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

    @Override
    public Integer getImageId() {
        return this.id;
    }

    @Override
    public boolean needBackground() {
        return true;
    }
}