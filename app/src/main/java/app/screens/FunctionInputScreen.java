package app.screens;

import app.App;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.loaders.SkinLoader;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

import static app.App.d;

public class FunctionInputScreen extends ScreenAdapter {
    App game;

    public FunctionInputScreen(App game) {
        this.game = game;
    }


    @Override
    public void render(float delta) {
        super.render(delta);

        Gdx.gl.glClearColor(.25f, .25f, .25f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.renderer.begin(ShapeRenderer.ShapeType.Filled);
        game.renderer.setColor(Color.WHITE);
        game.renderer.rect(0, 0, d.width * 4f / 5f, d.height - 52);
        game.renderer.end();

        TextField textField = new TextField("Terms", new Skin());

        textField.setBounds(200, 200, 50 , 50);
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void hide() {
        super.hide();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
