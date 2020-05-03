package inf112.skeleton.app.ui_objects;

import com.badlogic.gdx.graphics.g2d.Batch;

public interface IRenderable extends IClickable {
    int getX();
    int getY();
    int getWidth();
    int getHeight();
    void render(Batch batch);
    boolean canRender();
    void setCanRender(boolean r);
}