package inf112.skeleton.app.objects.tiles;

import inf112.skeleton.app.objects.interfaces.IDrawable;

/**
 * Gear
 */
public class Flag implements IDrawable {
    private int id;

    public Flag(int type) {
        this.id = 140 + type;
    }

    public Integer getFlagNr() { return (this.id - 140); }

    @Override
    public Integer getImageId() {
        return this.id;
    }

    @Override
    public boolean needBackground() {
        return true;
    }
}
