package inf112.skeleton.app.objects.tiles;

import inf112.skeleton.app.objects.interfaces.IDrawable;

public class Hole implements IDrawable {
    
    private Integer textureId;

    public Hole(int type) {
        this.textureId = type+20;
    }

    @Override
    public Integer getImageId() {
        return textureId;
    }

    @Override
    public boolean needBackground() {
        return false;
    }

}