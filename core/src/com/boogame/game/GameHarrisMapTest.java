package com.boogame.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.boogame.characters.Player;


public class GameHarrisMapTest extends ApplicationAdapter {

    private MapObjects collisions;
    private OrthographicCamera camera;
    private Texture playerTexture;
    private SpriteBatch batch;
    private Player player;
    private TiledMap tiledMap;
    private TiledMapRenderer tiledMapRenderer;


    @Override
    public void create() {

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false);
//        camera.zoom-=0.5f;
        camera.update();

        tiledMap = new TmxMapLoader().load("demo.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);

        playerTexture = new Texture(Gdx.files.internal("Characters/Oswald/TX Player_test.png"));
        player = new Player(playerTexture);
        player.setPosition(15, 80);
//        player.setPosition(w/2-player.getWidth()/2, h/2-player.getHeight()/2);

        collisions = tiledMap.getLayers().get("Collisions").getObjects();
    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);

        Vector2 oldPos = new Vector2(player.getX(), player.getY());
        player.inputMovement();
        player.checkCollision(oldPos, collisions);

        camera.position.set(player.getX(), player.getY(), 0);
        camera.update();

        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();

        batch.begin();
        player.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        tiledMap.dispose();
        playerTexture.dispose();
        batch.dispose();
    }

}