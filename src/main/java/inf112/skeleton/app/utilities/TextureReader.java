package inf112.skeleton.app.utilities;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * SpriteReader
 */
public class TextureReader {

	/**
	 * Returns a TextureRegion from a texture (A texture should be made up of 300x300 px
	 * images). 
	 * @param x
	 * @param y
	 * @param texture
	 * @return The TextureRegion in the specified coordinates.
	 */
    public static TextureRegion getTextureRegion(int x, int y, Texture texture){
        return new TextureRegion(texture, x*300, y*300, 300, 300);
    }

    /**
     * Get a HashMap with ID - TextureRegion pairs
     * @return HashMap<ID, TextureRegion>
     */
    public static HashMap<Integer, TextureRegion> getTextures(){
        Texture texture = new Texture(Gdx.files.internal("src/main/java/inf112/skeleton/app/assets/sprites/tiles.png"));
        HashMap<Integer, TextureRegion> textures = new HashMap<>();
        //Items
        textures.put(0, TextureReader.getTextureRegion(4, 0, texture)); // Floor
        textures.put(1, TextureReader.getTextureRegion(7, 0, texture)); // Wall 1
        textures.put(2, TextureReader.getTextureRegion(7, 1, texture)); // Wall 2
        textures.put(3, TextureReader.getTextureRegion(7, 2, texture)); // Wall 3
        textures.put(881, TextureReader.getTextureRegion(4, 15, texture)); // Robot Up
        return textures;
    }
}