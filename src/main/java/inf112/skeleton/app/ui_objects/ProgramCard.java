package inf112.skeleton.app.ui_objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import inf112.skeleton.app.utilities.TextureReader;

public class ProgramCard implements IRenderable {
    int x, y, width, height, priority;

    TextureRegion r;
    BitmapFont priorityFont;

    public ProgramCard(int x, int y, int width, int priority, ProgramCardType type) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = (int) (width * ( 17f/11f));
        this.priority = priority;
        
        this.priorityFont = new BitmapFont();
        this.priorityFont.setColor(Color.GREEN);

        this.r = TextureReader.getSpecificTexture(type.src, width, height);
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public void render(Batch batch) {
        this.r.setRegionWidth(getWidth());
        this.r.setRegionHeight(getHeight());
        batch.draw(this.r, getX(), getY(), getWidth(), getHeight());

        priorityFont.draw(batch, Integer.toString(this.priority), getX()+getWidth()-45, getY()+getHeight()-18);
    }
}