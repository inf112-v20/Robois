package inf112.skeleton.app.objects.tiles;

import inf112.skeleton.app.objects.interfaces.IDrawable;

/**
 * FCBelt
 */
public class FCBelt implements IDrawable {
    private int id;

    public FCBelt(int type) {
        this.id = 70 + type;
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