package inf112.skeleton.app.objects.tiles;

import inf112.skeleton.app.objects.interfaces.IDrawable;

/**
 * Gear
 */
public class Gear implements IDrawable {
    private int id;

    public Gear(int type) {
        this.id = 120 + type;
    }

    @Override
    public Integer getImageId() {
        return this.id;
    }

    @Override
    public boolean needBackground() {
        return false;
    }
}
