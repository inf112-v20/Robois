package inf112.skeleton.app.objects.tiles;

import inf112.skeleton.app.objects.interfaces.IDrawable;

/**
 * CBelt
 */
public class Laser implements IDrawable {
    int id;
    int damage;

    public Laser(int type, int damage) {
        this.id = 100 + type;
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