package inf112.skeleton.app.ui_objects;

import com.badlogic.gdx.graphics.g2d.Batch;

public class ProgramCardLocked implements IRenderable {
    private int x, y, width, height;
    boolean canClick = true;
    boolean canRender = true;
    ProgramCard[] lockedCards;

    ProgramCardHand hand;

    public ProgramCardLocked(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        lockedCards = new ProgramCard[5];
    }

    public void addCard(ProgramCard c) {
        for (int x = 0; x < lockedCards.length; x++) { 
            if (lockedCards[x] == null){
                lockedCards[x] = c;
                return;
            }
        }
    }
    public void removeCard(ProgramCard c) {
        for (int i = 0; i < this.lockedCards.length; i++){ 
            if (this.lockedCards[i] == c) {
                this.lockedCards[i] = null;
            }
        }
    }
    
    public void reDraw() {
        for (int i = 0; i < lockedCards.length; i++) {
            if (lockedCards[i] == null) continue;
            lockedCards[i].x = this.x + (this.width / 5)*i + (5*i);
            lockedCards[i].y = this.y;
            lockedCards[i].width = this.width / 5;
        }
    }

    public void setHand(ProgramCardHand hand) {
        this.hand = hand;
    }

    public boolean canAddCard() {
        for (int x = 0; x < lockedCards.length; x++) {
            if (lockedCards[x] == null) return true;
        }
        return false;
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
        for (int x = 0; x < this.lockedCards.length; x++){
            if (this.lockedCards[x] == null) continue;
            this.lockedCards[x].render(batch);
        }
    }

    @Override
    public boolean click(int x, int y) {
        for (int i = 0; i < this.lockedCards.length; i++){
            if (this.lockedCards[i] != null && this.lockedCards[i].click(x, y)) {
                this.hand.addCard(this.lockedCards[i]);
                removeCard(this.lockedCards[i]);
                this.hand.reDraw();
                return true;
            }
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

    
    @Override
    public boolean canRender() {
        return this.canRender;
    }

    @Override
    public void setCanRender(boolean r) {
        this.canRender = r;
    }

}