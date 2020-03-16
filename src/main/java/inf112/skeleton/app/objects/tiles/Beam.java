package inf112.skeleton.app.objects.tiles;

import inf112.skeleton.app.objects.interfaces.IDrawable;

/**
 * Beam
 */
public class Beam implements IDrawable {
    private int id;
    private int damage;

    public Beam(int type, int damage) {
        this.id = 110 + type;
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