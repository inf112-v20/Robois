package inf112.skeleton.app.objects.tiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import inf112.skeleton.app.objects.interfaces.IDrawable;
import inf112.skeleton.app.utilities.TextureReader;

public class Flag implements IDrawable {
    
    private TextureRegion tr;

    public Flag(Texture texture) {
        this.tr = TextureReader.getTextureRegion(0, 0, texture);
    }

    @Override
    public TextureRegion getImage() {
        return this.tr;
    }
}