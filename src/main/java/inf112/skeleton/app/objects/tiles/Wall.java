package inf112.skeleton.app.objects.tiles;

import inf112.skeleton.app.objects.interfaces.IDrawable;

public class Wall implements IDrawable {

    private Integer textureId = 1;
    
    public Wall(int type) {
    	switch (type) {
    	case 1:
    		this.textureId = 1;
    		break;
    	case 2:
    		this.textureId = 2;
    		break;
    	case 3:
    		this.textureId = 3;
    		break;
    	}
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