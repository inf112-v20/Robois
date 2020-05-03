package inf112.skeleton.app.ui_objects;

public interface IClickable {
    boolean click(int x, int y);
    boolean canClick();
    void setCanClick(boolean b);
}
