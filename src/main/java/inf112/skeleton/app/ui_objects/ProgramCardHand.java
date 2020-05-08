package inf112.skeleton.app.ui_objects;

import com.badlogic.gdx.graphics.g2d.Batch;

import inf112.skeleton.app.Game;

public class ProgramCardHand implements IRenderable {
    private int x, y, width, height;
    private boolean canRender = true;
    private ProgramCard[] hand;
    private ProgramCardLocked lockedHand;
    private Game game;
    

    public ProgramCardHand(int x, int y, int width, int height, Game game, ProgramCardLocked lockedHand) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.lockedHand = lockedHand;
        this.hand = new ProgramCard[9];
        this.game = game;
        getNewHand();
        reDraw();
    }

    public void addCard(ProgramCard c) {
        for (int x = 8; x >= 0; x--) { 
            if (hand[x] == null){
                hand[x] = c;
                return;
            }
        }
    }

    public void removeCard(ProgramCard c) {
        for (int i = 0; i < this.hand.length; i++){ 
            if (this.hand[i] == c) {
                this.hand[i] = null;
            }
        }
    }

    public void reDraw() {
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] == null) continue;
            int cardX = this.x + (this.width / 3)*(Math.floorMod(i, 3)) + (5*Math.floorMod(i, 3));
            int cardY = this.y;
            if (i >= 6) {
                cardY += 310;
            } else if (i > 2) {
                cardY += 155;
            }
            hand[i].x = cardX;
            hand[i].y = cardY;
            hand[i].width = this.width / 3;
        }
    }
    private int getMaxCapasity() {
        return game.getCurrentPlayer().getHP()-1;
    }

    public void getNewHand() {
        for (int i = 0; i < hand.length; i++) {
            hand[i] = null;
        }
        for (int x = 0; x < getMaxCapasity(); x++){
            ProgramCardType t = ProgramCardType.getRandomCard();
            
            addCard(new ProgramCard(1, 1, this.width / 3, ProgramCardType.getRandomInt(t), t));
        }
        reDraw();
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
        for (int x = 0; x < this.hand.length; x++){
            if (this.hand[x] == null) continue;
            this.hand[x].render(batch);
        }
    }

    @Override
    public boolean click(int x, int y) {
        if (!canClick()) return false;
        for (int i = 0; i < this.hand.length; i++){
            if (this.hand[i] != null && this.hand[i].click(x, y) && this.lockedHand.canAddCard()) {
                this.lockedHand.addCard(this.hand[i]);
                removeCard(this.hand[i]);
                this.lockedHand.reDraw();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean canClick() {
        return !game.getGameLoop().getExecutingRound();
    }

    @Override
    public void setCanClick(boolean b) {
        return;
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