package app.screens;

import app.App;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import org.checkerframework.checker.units.qual.C;
import structures.Function;

import java.util.ArrayList;

import static app.App.*;

public class MainScreen extends ScreenAdapter {
    App game;
    ArrayList<Function> functions = new ArrayList<>();
    
    public MainScreen(App game) {
        this.game = game;
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int x, int y, int pointer, int button) {
                // TODO: 3/16/2022 fix y bounds
                if (Gdx.input.getX() > d.width*4f/5f + 20
                && Gdx.input.getX() < d.width - 20
                && d.height - Gdx.input.getY() > d.height - 52 - 20
                && d.height - Gdx.input.getY() < d.height - 52 - 20 + 60) {
                    game.setScreen(new FunctionInputScreen(game));
                }
                return true;
            }
        });
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        Gdx.gl.glClearColor(.25f, .25f, .25f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.renderer.begin(ShapeRenderer.ShapeType.Filled);
        game.renderer.setColor(Color.WHITE);
        game.renderer.rect(0, 0, d.width*4f/5f, d.height - 52);
        game.renderer.end();

        game.renderer.begin(ShapeRenderer.ShapeType.Line);
        for (float i = 0; i < 11; i++) {
            game.renderer.setColor(Color.BLUE);
            game.renderer.line(20 + i/10f*(d.width*4f/5f-40), 20, 20 + i/10f*(d.width*4f/5f-40), d.height - 52 - 20);
        }

        for (float i = 0; i < 11; i++) {
            game.renderer.setColor(Color.BLUE);
            game.renderer.line(20, 20 + i/10f*(d.height-52 - 40), (d.width*4f/5f-20), 20 + i/10f*(d.height-52 - 40));
        }
        game.renderer.end();

        game.renderer.begin(ShapeRenderer.ShapeType.Filled);
        game.renderer.setColor(Color.BLACK);
        game.renderer.circle(20 + 5/10f*(d.width*4f/5f-40), 20 + 5/10f*(d.height-52 - 40), 5);
        game.renderer.end();

        game.renderer.begin(ShapeRenderer.ShapeType.Filled);
        game.renderer.setColor(new Color(Color.GREEN));
        game.renderer.rect(d.width*4f/5f + 20, d.height - 52 - 20, d.width - 20 - (d.width*4f/5f + 20), -60);
        game.renderer.end();
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
