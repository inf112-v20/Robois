package inf112.skeleton.app.utilities;

import java.util.HashMap;

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

    public static HashMap<Integer, TextureRegion> getTextures(){
        Texture texture = new Texture(Gdx.files.internal("src/main/java/inf112/skeleton/app/assets/sprites/tiles.png"));
        HashMap<Integer, TextureRegion> textures = new HashMap<>();
        //Items
        textures.put(0, TextureReader.getTextureRegion(4, 0, texture)); // Floor
        textures.put(881, TextureReader.getTextureRegion(4, 15, texture)); // Robot Up
        return textures;
    }
}