package com.boogame.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.boogame.map.objects.Plant;
import com.boogame.map.tiles.Floor;
import com.boogame.map.tiles.Structure;

import java.awt.*;


public class GameHarrisMapTest extends ApplicationAdapter {

    private OrthographicCamera camera;
    private TiledMap tiledMap;

    private SpriteBatch batch;

    private OrthogonalTiledMapRenderer mapRenderer;


    private Texture playerTexture;
    private Rectangle player;

    private double zoom = 1;

    @Override
    public void create() {

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        tiledMap = new TmxMapLoader().load("demo.tmx");
        float unitScale = 1 / 16f;
        mapRenderer = new OrthogonalTiledMapRenderer(tiledMap, unitScale);

        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 60, 40);
        zoom = 0.2;
        camera.zoom -= 0.5;

        playerTexture = new Texture(Gdx.files.internal("Characters/Oswald/TX Player_test.png"));
//        playerTexture.
        player = new Rectangle();
        player.width = playerTexture.getWidth();
        player.height = playerTexture.getHeight();
//        player.x = (int) w/2 - (int) player.getWidth()/2;
//        player.y = (int) h/2 - (int) player.getHeight()/2;
        player.x = 500;
        player.y = 500;
    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.position.set((float) (player.getX()/32), (float) (player.getY()/32), 0);
//        System.out.println(player.getX()+ ", "+player.getY());
//        System.out.println("cam pos: "+ camera.position.toString());

        camera.update();
        mapRenderer.setView(camera);
        mapRenderer.render();
        batch.begin();
//        int zoom = 1;
        batch.draw(playerTexture, (float) player.x, (float) player.y, (float) (playerTexture.getWidth()/zoom), (float) (camera.viewportHeight/zoom));
        batch.end();
    }

    @Override
    public void dispose() {
        tiledMap.dispose();
        playerTexture.dispose();
        mapRenderer.dispose();
        batch.dispose();
    }
}
