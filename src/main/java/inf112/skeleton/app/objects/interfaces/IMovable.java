package inf112.skeleton.app.objects.interfaces;

import inf112.skeleton.app.utilities.CardinalDirection;

/**
 * IMovable
 */
public interface IMovable {
    int getX();

    int getY();

    void setX(int x);

    void setY(int y);

    CardinalDirection getDirection();

    void setDirection(CardinalDirection dir);

    boolean move();

    boolean move(CardinalDirection dir);

    int getSpawnX();

    int getSpawnY();

    void setSpawnX(int x);

    void setSpawnY(int y);
}