package inf112.skeleton.app.utilities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * SpriteReader
 */
public class TextureReader {

    public static TextureRegion getTextureRegion(int x, int y, Texture texture){
        return new TextureRegion(texture, x*300, y*300, 300, 300);
    }
    
}