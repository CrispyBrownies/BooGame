package com.boogame.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.boogame.characters.Character;
import com.boogame.characters.Oswald;
import org.w3c.dom.Text;

public class Game extends ApplicationAdapter {

    private boolean gameOver = false;
    private Vector2 canvasSize = new Vector2(1920, 1080);

    private OrthographicCamera camera;
    private SpriteBatch batch;

    private Character player = new Character();
    private Rectangle background;

    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1920, 1080);
        batch = new SpriteBatch();

        player = new Oswald();
        background.height = 1920;
        background.height = 1080;
    }

    public void render () {

        ScreenUtils.clear(0, 0, 0.2f, 1);

        camera.update();

        batch.setProjectionMatrix(camera.combined);

    }

}
