package inf112.skeleton.app.ui_objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import inf112.skeleton.app.Game;
import inf112.skeleton.app.objects.abstracts.Location;

public class EndGameDisplay implements IRenderable {
    private Location location;
    private int width;
    private int height;
    private boolean canClick = true;
    private boolean canRender = true;
    private Game game;

    private BitmapFont font1;
    private BitmapFont font2;

    public EndGameDisplay(int x, int y, int width, int height, Game game) {
        location = new Location(x, y);    
        this.width = width;
        this.height = height;

        this.game = game;

        this.font1 = new BitmapFont();
        this.font1.setColor(Color.GREEN);
        this.font1.getData().setScale(3f);

        this.font2 = new BitmapFont();
        this.font2.setColor(Color.GREEN);
        this.font2.getData().setScale(2f);
    }

    @Override
    public int getX() { return this.location.getX(); }

    @Override
    public int getY() {
        return this.location.getY();
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
        if (game.wonGame()) {
            font1.draw(batch, "Victory!", getX()+40, getY()-100);
        } else {   
            font1.draw(batch, "Game Over", getX(), getY()-100);
        }
        font2.draw(batch, "Main Menu", getX()+40, getY()-200);
    }

    @Override
    public boolean click(int x, int y) {
        if (x >= getX()+40 && x < getX()+40 + getWidth() && y <= getY()-200 && y > getY()-200 - getHeight() && canClick()) {
            game.getGameRendering().setCurrentScene(1);
            game.clearPreviousGame();
        }
        return true;
    }

    @Override
    public boolean canClick() {
        return this.canClick;
    }

    @Override
    public void setCanClick(boolean b) {
        this.canClick = b;
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