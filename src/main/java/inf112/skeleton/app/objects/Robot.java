package inf112.skeleton.app.objects;

import inf112.skeleton.app.objects.interfaces.IDrawable;

public class Robot implements IDrawable {
    
    private int x;
    private int y;
    private int direction;

    public Robot(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.direction = d;
    }

    @Override
    public Integer getImageId() {
        return 881;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int getDirection(){
        return this.direction;
    }

    public boolean move(int l){
    	if (this.direction == 0) {
            this.y -= l;
        }
    	else if (this.direction == 1) {
            this.x += l;
        }
    	else if (this.direction == 2) {
            this.y += l;
        }
    	else if (this.direction == 3) {
            this.x -= l;
        } else{
            return false;
        }
        return true;
    }

    public void rotate(int i){
        this.direction = (this.direction+i % 4 + 4) % 4;
    }
	@Override
	public boolean needBackground() {
		return false;
	}

    
}