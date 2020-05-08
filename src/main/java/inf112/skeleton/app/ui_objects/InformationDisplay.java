package inf112.skeleton.app.ui_objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import inf112.skeleton.app.Game;
import inf112.skeleton.app.objects.abstracts.Location;

public class InformationDisplay implements IRenderable {
    private Location location;
    private int width;
    private int height;    
    private boolean canClick = true;
    private boolean canRender = true;
    private Game game;

    private BitmapFont font;

    public InformationDisplay(int x, int y, int width, int height, Game game) {
        location = new Location(x, y);    
        this.width = width;
        this.height = height;

        this.game = game;

        this.font = new BitmapFont();
        this.font.setColor(Color.GREEN);
        this.font.getData().setScale(1.5f);
    }

    @Override
    public int getX() {
        return this.location.getX();
    }

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
        String phase = String.format("Current Phase: %d", game.getPhase());
        font.draw(batch, phase, getX(), getY());
        font.draw(batch, String.format("HP: %d", game.getCurrentPlayer().getHP()), getX()+100, getY()-30);
        font.draw(batch, String.format("Lives: %d", game.getCurrentPlayer().getLife()), getX(), getY()-30);
    }

    @Override
    public boolean click(int x, int y) {
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