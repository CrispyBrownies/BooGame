package com.boogame.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.boogame.characters.Player;

import java.util.ArrayList;


public class GameHarrisMapTest extends ApplicationAdapter {

    private MapObjects collisions;
    private OrthographicCamera camera;
    private Texture playerTexture;
    private Texture guruTexture;
    private SpriteBatch batch;
    private Player player;
    // guru for testing purposes
    private ArrayList<Sprite> npc;
    private TiledMap tiledMap;
    private OrthogonalTiledMapRenderer tiledMapRenderer;


    @Override
    public void create() {

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false);
        camera.zoom-=0.65f;
        camera.update();

        playerTexture = new Texture(Gdx.files.internal("Characters/Oswald/TX Player_test.png"));
        player = new Player(playerTexture);
        player.setPosition(15, 80);

        // guru for testing purposes
        guruTexture = new Texture(Gdx.files.internal("Map/halo.png"));

        npc = new ArrayList<>();
        npc.add(new Sprite(playerTexture));
        npc.add(new Sprite(guruTexture));
        npc.get(0).setPosition(60, 90);
        Sprite halo = npc.get(1);
//        npc.get(1).setPosition(15 ,100);
        npc.get(1).setPosition(15-halo.getWidth()/2, 80-halo.getHeight()/2);
        npc.get(1).scale(1.2f);


//        player.setPosition(w/2-player.getWidth()/2, h/2-player.getHeight()/2);

        tiledMap = new TmxMapLoader().load("demo.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
//        tiledMapRenderer.addSprite(player);

        collisions = tiledMap.getLayers().get("Collisions").getObjects();
        System.out.println(player.getBoundingRectangle());

//        npc.sort((o1, o2)
//                -> o1.getY().compareTo(
//                o2.getY()));

        for (Sprite s : npc) {
            System.out.println(s.getY());
        }
    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);

        Vector2 oldPos = new Vector2(player.getX(), player.getY());
        // moves player
        player.inputMovement();
        Sprite halo = npc.get(1);
        npc.get(1).setPosition(player.getX()-halo.getWidth()/2 + player.getWidth()/2, player.getY()-halo.getHeight()/2 + player.getHeight()/2);
        // moves player back to old pos if collides
        player.checkCollision(oldPos, collisions);

        camera.position.set(player.getX()+player.getWidth()/2, player.getY()+player.getHeight()/2, 0);
        camera.update();

        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();




        batch.begin();


        // sort npcs by min y
        // loop through npcs, store index and position


        if (player.getY() >= npc.get(0).getY()) {
            player.draw(batch);
            npc.get(0).draw(batch);
        } else {
            npc.get(0).draw(batch);
            player.draw(batch);
        }

        npc.get(1).draw(batch);

//        player.draw(batch);
//        guru.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        tiledMap.dispose();
        playerTexture.dispose();
        batch.dispose();
    }

}