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

    int getDirection();

    void setDirection(int dir);

    CardinalDirection getCardinalDirection();

    boolean move();

    boolean move(CardinalDirection dir);

    int getSpawnX();

    int getSpawnY();

    int getSpawnDirection();
}