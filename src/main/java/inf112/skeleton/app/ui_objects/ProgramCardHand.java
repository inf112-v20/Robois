package inf112.skeleton.app.ui_objects;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.Batch;
import inf112.skeleton.app.Player;

public class ProgramCardHand implements IRenderable {
    private int x, y, width, height;

    ProgramCard[] Hand;

    public ProgramCardHand(int x, int y, int width, int height, Player currentPlayer) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        Hand = new ProgramCard[currentPlayer.getHP()];
    }

    private void ChooseCard(ProgramCard card) {
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
        // TODO Auto-generated method stub

    }

}