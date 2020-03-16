package inf112.skeleton.app.objects.tiles;

import inf112.skeleton.app.objects.interfaces.IDrawable;

/**
 * CBelt
 */
public class CBelt implements IDrawable {
    private int id;

    public CBelt(int type) {
        this.id = 40 + type;
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