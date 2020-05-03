package inf112.skeleton.app;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
    public static void main(String[] args) {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "Robo Rally";
        int s = 100;
        cfg.width = (16 * s);
        cfg.height = (9 * s);
        cfg.resizable = false;
        
        new LwjglApplication(new Game(), cfg);
    }
}