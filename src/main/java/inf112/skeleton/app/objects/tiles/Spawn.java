package inf112.skeleton.app.objects.tiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import inf112.skeleton.app.objects.interfaces.IDrawable;
import inf112.skeleton.app.utilities.TextureReader;

public class Spawn implements IDrawable {
    
    private TextureRegion tr;
    private int spawnNumber;

    public Spawn(Texture texture, int spawnNumber) {
        this.spawnNumber = spawnNumber;
        if (spawnNumber < 5){
            this.tr = TextureReader.getTextureRegion(spawnNumber-1, 15, texture);
        } else {
            this.tr = TextureReader.getTextureRegion(spawnNumber-5, 16, texture);
        }
    }

    public int getSpawnNumber(){
        return this.spawnNumber;
    }

    @Override
    public TextureRegion getImage() {
        return this.tr;
    }
}