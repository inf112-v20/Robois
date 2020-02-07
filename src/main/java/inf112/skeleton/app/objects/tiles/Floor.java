package inf112.skeleton.app.objects.tiles;

import inf112.skeleton.app.objects.interfaces.IDrawable;

public class Floor implements IDrawable {

    private Integer textureId = 0;

    @Override
    public Integer getImageId() {
        return this.textureId;
    }
}