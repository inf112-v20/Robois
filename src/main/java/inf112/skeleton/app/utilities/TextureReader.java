package inf112.skeleton.app.utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.google.gson.Gson;

/**
 * SpriteReader
 */
public class TextureReader {

    /**
     * Returns a TextureRegion from a texture (A texture should be made up of
     * 300x300 px images).
     * 
     * @param x
     * @param y
     * @param texture
     * @return The TextureRegion in the specified coordinates.
     */
    public static TextureRegion getTextureRegion(int x, int y, Texture texture) {
        return new TextureRegion(texture, x * 300, y * 300, 300, 300);
    }

    /**
     * Get a HashMap with ID - TextureRegion pairs
     * 
     * @return HashMap<ID, TextureRegion>
     * @throws IOException
     */
    public static HashMap<Integer, TextureRegion> getTextures() throws IOException {
        String tileSrc = "src/main/java/inf112/skeleton/app/assets/sprites/tiles.png";
        String jsonSrc = "src/main/java/inf112/skeleton/app/assets/sprites/tilelocation.json";

        Texture texture = new Texture(Gdx.files.internal(tileSrc));
        HashMap<Integer, TextureRegion> textures = new HashMap<>();

        JSONTexture[] jsonTextures = JSONToJSONTexture(jsonSrc);

        for (JSONTexture j : jsonTextures) {
            textures.put(j.id, TextureReader.getTextureRegion(j.x, j.y, texture));
        }

        return textures;
    }

    private static JSONTexture[] JSONToJSONTexture(String src) {
        JSONTexture[] jsonTextures;
        Gson gson = new Gson();
        try (Reader reader = new FileReader(src)) {
            // Convert JSON File to Java Object
            jsonTextures = gson.fromJson(reader, JSONTexture[].class);
            return jsonTextures;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}