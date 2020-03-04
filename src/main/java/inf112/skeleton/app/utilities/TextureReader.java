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
        textures.put(4, TextureReader.getTextureRegion(7, 3, texture)); // Wall 4
        textures.put(5, TextureReader.getTextureRegion(6, 2, texture)); // Wall 5
        textures.put(6, TextureReader.getTextureRegion(6, 3, texture)); // Wall 6
        textures.put(7, TextureReader.getTextureRegion(5, 3, texture)); // Wall 7
        textures.put(8, TextureReader.getTextureRegion(4, 3, texture)); // Wall 8
        textures.put(21, TextureReader.getTextureRegion(2, 11, texture)); // Hole 1
        textures.put(22, TextureReader.getTextureRegion(5, 14, texture)); // Hole 2
        textures.put(23, TextureReader.getTextureRegion(4, 13, texture)); // Hole 3
        textures.put(24, TextureReader.getTextureRegion(5, 13, texture)); // Hole 4
        textures.put(25, TextureReader.getTextureRegion(4, 14, texture)); // Hole 5
        textures.put(26, TextureReader.getTextureRegion(2, 13, texture)); // Hole 6
        textures.put(27, TextureReader.getTextureRegion(2, 14, texture)); // Hole 7
        textures.put(28, TextureReader.getTextureRegion(0, 14, texture)); // Hole 8
        textures.put(29, TextureReader.getTextureRegion(0, 13, texture)); // Hole 9
        textures.put(30, TextureReader.getTextureRegion(1, 13, texture)); // Hole 10
        textures.put(31, TextureReader.getTextureRegion(3, 13, texture)); // Hole 11
        textures.put(32, TextureReader.getTextureRegion(1, 14, texture)); // Hole 12
        textures.put(33, TextureReader.getTextureRegion(3, 14, texture)); // Hole 13
        textures.put(34, TextureReader.getTextureRegion(3, 11, texture)); // Hole 14
        textures.put(11, TextureReader.getTextureRegion(0, 15, texture)); // Spawn 1
        textures.put(881, TextureReader.getTextureRegion(4, 15, texture)); // Robot Up
        
        return textures;
    }
}