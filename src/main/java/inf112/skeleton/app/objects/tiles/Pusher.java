package inf112.skeleton.app.objects.tiles;

import inf112.skeleton.app.objects.interfaces.IDrawable;

/**
 * Gear
 */
public class Pusher implements IDrawable {
    private int id;

    public Pusher(int type) {
        this.id = 130 + type;
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