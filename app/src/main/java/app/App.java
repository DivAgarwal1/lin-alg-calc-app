
package app;

import app.screens.MainScreen;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.awt.*;

public class App extends Game {
    public ShapeRenderer renderer;
    public static final Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

    public static void main(String[] args) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Lin-Alg Calc App";
        config.height = d.height - 52; // for header
        config.width = d.width;
        config.samples = 3;
        config.resizable = false;
        config.initialBackgroundColor = new Color(0.12f, 0.12f, 0.12f, 1f);
        config.useGL30 = false;
        new LwjglApplication(new App(), config);
    }

    @Override
    public void create() {
        renderer = new ShapeRenderer();
        setScreen(new MainScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        renderer.dispose();
    }
}
