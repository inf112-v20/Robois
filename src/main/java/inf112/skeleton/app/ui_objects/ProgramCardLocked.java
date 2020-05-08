package inf112.skeleton.app.ui_objects;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.Batch;

import inf112.skeleton.app.Game;

public class ProgramCardLocked implements IRenderable {
    private int x, y, width, height;
    private boolean canRender = true;
    private ProgramCard[] lockedCards;

    private ProgramCardHand hand;

    private Game game;

    public ProgramCardLocked(int x, int y, int width, int height, Game game) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        lockedCards = new ProgramCard[5];
        this.game = game;
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
            lockedCards[i].x = this.x + (this.width / 5)*i + (24*i);
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
        if (!canClick()) return false;
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

	public ProgramCard[] getCards() {
		return this.lockedCards;
	}

	public void removeAll() {
        for (int i = 0; i < this.lockedCards.length; i++) {
            this.lockedCards[i] = null;
        }
	}

	public void updateHand() {
        List<Integer> toBeLocked = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            if (game.getCurrentPlayer().getHP() <= i){
                toBeLocked.add(i);
            } else {
                lockedCards[i-1] = null;
            }
        }

        lockCard(toBeLocked);
	}   

    private void lockCard(List<Integer> i) {
        for (int j = 0; j < lockedCards.length; j++) {
            if (lockedCards[j] == null) continue;
            lockedCards[j].setCanClick(true);
        }
        for (int x : i) {
            if (lockedCards[x-1] == null) continue;
            lockedCards[x-1].setCanClick(false);
        }
        
    }

	public boolean isFull() {
		for (int i = 0; i < lockedCards.length; i++) {
            if (lockedCards[i] == null) return false;
        }
        return true;
	}

}