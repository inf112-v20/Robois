package inf112.skeleton.app.ui_objects;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.Batch;

public class ProgramCardLocked implements IRenderable {
    private int x, y, width, height;

    List<ProgramCard> lockedCards;

    public ProgramCardLocked(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        lockedCards = new ArrayList<>();
    }

    public void addCard(ProgramCardType type, int priority) {
        try {
            if (this.lockedCards.size() >= 5) throw new IndexOutOfBoundsException();
            ProgramCard c = new ProgramCard(this.x + (this.width / 5)*this.lockedCards.size() + (5*this.lockedCards.size()), this.y, this.width / 5, priority, type);
            this.lockedCards.add(c);
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
        for (int x = 0; x < this.lockedCards.size(); x++){
            this.lockedCards.get(x).render(batch);
        }
    }

}