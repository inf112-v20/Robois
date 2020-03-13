package inf112.skeleton.app.objects.tiles;

import inf112.skeleton.app.objects.interfaces.IDrawable;

/**
 * CBelt
 */
public class Beam implements IDrawable {
    int id;
    int damage;

    public Beam(int type, int damage) {
        this.id = 110 + type;
        this.damage = damage;
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