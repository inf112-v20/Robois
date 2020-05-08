package inf112.skeleton.app.ui_objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import inf112.skeleton.app.utilities.TextureReader;

public class ProgramCard implements IRenderable {
    // Create getters and setters
    public int x, y, width, height, priority;
    private ProgramCardType type;

    private boolean canClick = true;
    private boolean canRender = true;

    private TextureRegion r;
    private BitmapFont priorityFont;

    public ProgramCard(int x, int y, int width, int priority, ProgramCardType type) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = (int) (width * ( 17f/11f));
        this.priority = priority;
        this.type = type;
        
        this.priorityFont = new BitmapFont();
        this.priorityFont.setColor(Color.GREEN);
        this.priorityFont.getData().setScale((int) width/100f);

        this.r = TextureReader.getSpecificTexture(type.src, 99, 155);
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
        if (!canRender()) return;
        batch.draw(this.r, getX(), getY(), getWidth(), getHeight());
        int startX;
        if (Integer.toString(this.priority).length() > 2) {
            startX = (int) (getX()+(getWidth()/1.75f));
        } else {
            startX = (int) (getX()+(getWidth()/1.63f));
        }
        priorityFont.draw(batch, Integer.toString(this.priority), startX, (int) (getY()+getHeight()/1.125f));
    }

    @Override
    public boolean click(int x, int y) {
        if (x >= getX() && x < getX() + getWidth() && y >= getY() && y < getY() + getHeight() && canClick()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean canClick() {
        return this.canClick;
    }

    @Override
    public void setCanClick(boolean b) {
        this.canClick = b;
    }

    public ProgramCardType getType(){
        return this.type;
    }
    public int getPriority(){
        return this.priority;
    }
    
    @Override
    public boolean canRender() {
        return this.canRender;
    }

    @Override
    public void setCanRender(boolean r) {
        this.canRender = r;
    }
}