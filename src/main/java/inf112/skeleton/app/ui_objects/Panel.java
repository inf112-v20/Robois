package inf112.skeleton.app.ui_objects;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.Batch;

import inf112.skeleton.app.objects.abstracts.Location;

public class Panel implements IRenderable {
    Location location;
    int width;
    int height;

    List<IRenderable> objects;

    public Panel(int x, int y, int width, int height, List<IRenderable> objects) {
        location = new Location(x, y);    
        this.width = width;
        this.height = height;
        if (objects != null) this.objects = objects;
        else this.objects = new ArrayList<>();
    }

    public void addObject(IRenderable r) {
        this.objects.add(r);
    }
    public List<IRenderable> getObjects() {
        return this.objects;
    }

    @Override
    public int getX() {
        return this.location.getX();
    }

    @Override
    public int getY() {
        return this.location.getY();
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
    }
}