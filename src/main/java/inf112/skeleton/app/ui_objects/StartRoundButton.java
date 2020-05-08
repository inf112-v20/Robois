package inf112.skeleton.app.ui_objects;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import inf112.skeleton.app.Game;
import inf112.skeleton.app.utilities.TextureReader;

public class StartRoundButton implements IRenderable {
    private int x, y, w, h;
    private Game game;
    private ProgramCardLocked hand;
    
    private TextureRegion r;

    public StartRoundButton(int x, int y, int w, int h, float scale, String src, Game game, ProgramCardLocked hand) {
        this.x = x;
        this.y = y;
        this.w = (int)(w*scale);
        this.h = (int)(h*scale);
        this.game = game;
        this.hand = hand;
        this.r = TextureReader.getSpecificTexture(src, w, h);
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
        return this.w;
    }

    @Override
    public int getHeight() {
        return this.h;
    }

    @Override
    public void render(Batch batch) {
        if (!canRender()) return;
        Sprite s = new Sprite(r);
        s.setPosition(getX(), getY());
        s.setSize(getWidth(), getHeight());
        s.draw(batch);
    }

    @Override
    public boolean canRender() {
        return true;
    }

    @Override
    public void setCanRender(boolean r) {

    }

    @Override
    public boolean click(int x, int y) {
        if (x >= getX() && x < getX() + getWidth() && y >= getY() && y < getY() + getHeight() && canClick()) {
            System.out.println("Clicked");
            game.startRound(this.hand.getCards());
            this.hand.removeAll();
            return true;
        }
        return false;
    }

    @Override
    public boolean canClick() {
        return true;
    }

    @Override
    public void setCanClick(boolean b) {

    }
    
}