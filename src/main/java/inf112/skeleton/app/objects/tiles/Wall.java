package inf112.skeleton.app.objects.tiles;

import inf112.skeleton.app.objects.interfaces.IDrawable;

public class Wall implements IDrawable {

    private Integer textureId = 1;
    
    public Wall(int type) {
		this.textureId = type;
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