package inf112.skeleton.app.ui_objects;

import com.badlogic.gdx.Gdx;
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

    private float timeSeconds = 0f;
    private float period = 1.2f;


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

        String text = String.format("> Current Phase: %d  |  HP: %d  |  Lives: %d", game.getPhase(), game.getCurrentPlayer().getHP(), game.getCurrentPlayer().getLife());
        font.draw(batch, text, getX(), getY());

        timeSeconds += Gdx.graphics.getRawDeltaTime();
        if(timeSeconds > period){
            timeSeconds-=period;
        } else if (timeSeconds > period/2){
            font.draw(batch, String.format("> Flags: %d_", game.getCurrentPlayer().getFlags().size()), getX(), getY()-30);
        }else{
            font.draw(batch, String.format("> Flags: %d", game.getCurrentPlayer().getFlags().size()), getX(), getY()-30);
        }
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