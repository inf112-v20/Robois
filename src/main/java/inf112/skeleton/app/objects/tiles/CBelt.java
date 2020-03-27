package inf112.skeleton.app.objects.tiles;

/**
 * CBelt
 */
public class CBelt extends Belt {
    private int imageId;

    public CBelt(int type) {
        super(type);
        this.imageId = 40 + type;
    }

    @Override
    public Integer getImageId() {
        return this.imageId;
    }
}