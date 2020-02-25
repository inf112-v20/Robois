package inf112.skeleton.app.objects.tiles;

import inf112.skeleton.app.objects.interfaces.IDrawable;

public class Spawn implements IDrawable {
    int imageId;

    public Spawn(int spawnNr) {
        this.imageId = spawnNr+10;
    }

    @Override
    public Integer getImageId() {
        return imageId;
    }

    @Override
    public boolean needBackground() {
        return false;
    }

}
