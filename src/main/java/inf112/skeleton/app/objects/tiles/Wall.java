package inf112.skeleton.app.objects.tiles;

import java.util.Arrays;
import java.util.List;

import inf112.skeleton.app.objects.interfaces.IDrawable;
import inf112.skeleton.app.utilities.CardinalDirection;

public class Wall implements IDrawable {

    private Integer textureId = 1;
    private List<CardinalDirection> wallPosition;

    public Wall(int type) {
        switch (type) {
            case 1:
                wallPosition = Arrays.asList(CardinalDirection.EAST, CardinalDirection.SOUTH);
                break;
            case 2:
                wallPosition = Arrays.asList(CardinalDirection.EAST, CardinalDirection.NORTH);
                break;
            case 3:
                wallPosition = Arrays.asList(CardinalDirection.WEST, CardinalDirection.NORTH);
                break;
            case 4:
                wallPosition = Arrays.asList(CardinalDirection.WEST, CardinalDirection.SOUTH);
                break;
            case 5:
                wallPosition = Arrays.asList(CardinalDirection.EAST);
                break;
            case 6:
                wallPosition = Arrays.asList(CardinalDirection.NORTH);
                break;
            case 7:
                wallPosition = Arrays.asList(CardinalDirection.WEST);
                break;
            case 8:
                wallPosition = Arrays.asList(CardinalDirection.SOUTH);
                break;
        }
        this.textureId = type;
    }

    public List<CardinalDirection> getWallPositions() {
        return this.wallPosition;
    }

    @Override
    public Integer getImageId() {
        return this.textureId;
    }

    @Override
    public boolean needBackground() {
        return true;
    }
}