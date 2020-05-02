package inf112.skeleton.app.ui_objects;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.Batch;

import inf112.skeleton.app.Game;

public class ProgramCardHand implements IRenderable {
    private int x, y, width, height, maxCapasity;
    Game game;
    List<ProgramCard> hand;
    

    public ProgramCardHand(int x, int y, int width, int height, Game game) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.game = game;
        this.maxCapasity = game.getCurrentPlayer().getHP();
        this.hand = new ArrayList<>();
    }

    public void addCard(ProgramCardType type, int priority) {
        try {
            if (this.hand.size() >= this.maxCapasity) throw new IndexOutOfBoundsException();
            int cardX = this.x + (this.width / 3)*(Math.floorMod(this.hand.size(), 3)) + (5*Math.floorMod(this.hand.size(), 3));
            
            int cardY = this.y;
            if (this.hand.size() > 6) {
                cardY += 310;
            } else if (this.hand.size() > 3) {
                cardY += 155;
            }

            ProgramCard c = new ProgramCard(cardX, cardY, this.width / 3, priority, type);
            this.hand.add(c);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("You have locked in all your cards.");
        }
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
        for (int x = 0; x < this.hand.size(); x++){
            this.hand.get(x).render(batch);
        }
    }

}