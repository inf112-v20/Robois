package inf112.skeleton.app.objects.tiles;

import inf112.skeleton.app.objects.interfaces.IDrawable;
import inf112.skeleton.app.utilities.RelativeDirection;

/**
 * Gear
 */
public class Gear implements IDrawable {
    private int id;
    private RelativeDirection rotation;

    public Gear(int type) {
        switch (type) {
            case 1:
                rotation = RelativeDirection.RIGHT;
                break;
            case 2:
                rotation = RelativeDirection.LEFT;
                break;
            default:
                break;
        }
        this.id = 120 + type;
    }

    public RelativeDirection getRotation() {
        return this.rotation;
    }

    @Override
    public Integer getImageId() {
        return this.id;
    }

    @Override
    public boolean needBackground() {
        return false;
    }
}
