package inf112.skeleton.app.objects.tiles;

import inf112.skeleton.app.objects.interfaces.IDrawable;

public class Spawn implements IDrawable {
    int textureId;

    public Spawn(int spawnNr) {
        this.textureId = spawnNr + 10;
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
