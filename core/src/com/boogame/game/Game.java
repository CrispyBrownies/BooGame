package com.boogame.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import org.w3c.dom.Text;

public class Game extends ApplicationAdapter {

    private boolean gameOver = false;

    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Rectangle player;

    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1920, 1080);
        batch = new SpriteBatch();

        player = new Rectangle();
        player.width = 128;
        player.height = 192;
        player.x = 1920/2 - player.width/2;
        player.y = 1080/2 - player.height/2;
    }

    public void render () {

        ScreenUtils.clear(0, 0, 0.2f, 1);

        camera.update();

        batch.setProjectionMatrix(camera.combined);

    }

}
