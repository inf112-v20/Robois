package inf112.skeleton.app.objects.tiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import inf112.skeleton.app.objects.interfaces.IDrawable;
import inf112.skeleton.app.utilities.TextureReader;

public class Floor implements IDrawable {

    private Integer textureId = 0;

    @Override
    public Integer getImageId() {
        return this.textureId;
    }
}