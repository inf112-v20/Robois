package inf112.skeleton.app.objects;

import inf112.skeleton.app.objects.interfaces.IDrawable;
import inf112.skeleton.app.utilities.CardinalDirection;

/**
 * Robot
 */
public class Robot implements IDrawable {
    
    private CardinalDirection direction;
    private int x;
    private int y;

    public Robot() {
        this.direction = CardinalDirection.NORTH;
        this.x = 5;
        this.y = 7;
    }

    @Override
    public Integer getImageId() {
        return 881;
    }

    public CardinalDirection getDirection(){
        return this.direction;
    }
    public void setDirection(CardinalDirection dir){
        this.direction = dir;
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }

    public boolean move(CardinalDirection dir){
        switch (dir) {
            case NORTH:
                this.y++;
                break;
            case EAST:
                this.x++;
                break;
            case SOUTH:
                this.y--;
                break;
            case WEST:
                this.x--;
                break;
        }
        return true;
    }

    
}