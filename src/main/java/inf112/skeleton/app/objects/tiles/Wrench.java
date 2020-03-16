package inf112.skeleton.app.objects.tiles;

import inf112.skeleton.app.objects.interfaces.IDrawable;

/**
 * Laser
 */
public class Wrench implements IDrawable {
    private int id;
    private int damage;

    public Wrench(int type, int damage) {
        this.id = 150 + type;
        this.damage = damage;
    }

    public Integer getDamage() {
        return this.damage;
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