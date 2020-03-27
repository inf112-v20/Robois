package inf112.skeleton.app.objects.tiles;

/**
 * FCBelt
 */
public class FCBelt extends Belt {
    private int id;

    public FCBelt(int type) {
        super(type);
        this.id = 70 + type;
    }

    @Override
    public Integer getImageId() {
        return this.id;
    }
}