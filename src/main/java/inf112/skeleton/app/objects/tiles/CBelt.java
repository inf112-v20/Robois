package inf112.skeleton.app.objects.tiles;

import inf112.skeleton.app.objects.interfaces.IDrawable;
import inf112.skeleton.app.utilities.CardinalDirection;

/**
 * CBelt
 */
public class CBelt implements IDrawable {
    private int imageId;
    private CardinalDirection direction;
    private CardinalDirection rotate;

    final int type;
    final int DIR_NORTH[] = {3,8,9,13,19,23};
    final int DIR_EAST[] = {2,5,12,14,17,20};
    final int DIR_SOUTH[] = {1,6,10,15,18,21};
    final int DIR_WEST[] = {4,7,11,16,22,24};
    final int TURN_LEFT[] = {4,3,2,1};
    final int TURN_RIGHT[] = {5,6,7,8};

    public CBelt(int type) {
        this.type = type;
        this.imageId = 40 + type;
        
        if (contains(DIR_NORTH, type)){
            this.direction = CardinalDirection.NORTH;
        }
        if (contains(DIR_EAST, type)){
            this.direction = CardinalDirection.EAST;
        }
        if (contains(DIR_SOUTH, type)){
            this.direction = CardinalDirection.SOUTH;
        }
        if (contains(DIR_WEST, type)){
            this.direction = CardinalDirection.WEST;
        }

        if (contains(TURN_LEFT, type)){
            this.rotate = CardinalDirection.LEFT;
        }
        if (contains(TURN_RIGHT, type)){
            this.rotate = CardinalDirection.RIGHT;
        }
    }

    public static boolean contains(final int[] array, final int v) {
        for(int i : array){
            if(i == v){
                return true;
            }
        }
        return false;
    }
    @Override
    public Integer getImageId() {
        return this.imageId;
    }

    @Override
    public boolean needBackground() {
        return false;
    }

    public CardinalDirection getDirection(){
        return this.direction;
    }

    public CardinalDirection getRotation(){
        return this.rotate;
    } 
}