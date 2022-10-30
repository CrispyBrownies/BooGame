package com.boogame.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.boogame.characters.Character;
import com.boogame.characters.Ghost;
import com.boogame.characters.Oswald;

import java.util.ArrayList;


public class GameHarrisMapTest extends ApplicationAdapter {

    private MapObjects collisions;
    private OrthographicCamera camera;
//    private Texture playerTexture;
//    private Texture guruTexture;
    private SpriteBatch batch;
    private ArrayList<Character> players = new ArrayList<>();
    private ArrayList<Character> npcs = new ArrayList<>();
    // guru for testing purposes
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

//        playerTexture = new Texture(Gdx.files.internal("Characters/Oswald/TX Player_test.png"));
        players.add(new Oswald(true));
        players.get(0).setPosition(15, 80);

        // guru for testing purposes
//        guruTexture = new Texture(Gdx.files.internal("Map/halo.png"));

//        npc = new ArrayList<>();
        npcs.add(new Ghost(false));
//        npcs.add(new Sprite(guruTexture));
        npcs.get(0).setPosition(60, 90);

//        npc.get()
//        Sprite halo = npc.get(1);
////        npc.get(1).setPosition(15 ,100);
//        npc.get(1).setPosition(15-halo.getWidth()/2, 80-halo.getHeight()/2);
////        npc.get(1).scale(1.5f);
//        npc.get(1).scale(1.2f);



//        player.setPosition(w/2-player.getWidth()/2, h/2-player.getHeight()/2);

        tiledMap = new TmxMapLoader().load("demo.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
//        tiledMapRenderer.addSprite(player);

        collisions = tiledMap.getLayers().get("Collisions").getObjects();
//        System.out.println(player.getBoundingRectangle());

//        npc.sort((o1, o2)
//                -> o1.getY().compareTo(
//                o2.getY()));

//        for (Sprite s : npc) {
//            System.out.println(s.getY());
//        }

//        Player player1 = new Player(guruTexture);
//        player1

    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);

//        Vector2 oldPos = new Vector2(players.get(0).getX(), players.get(0).getY());
        // moves player
        players.get(0).move();
//        Sprite halo = npc.get(1);
//        npc.get(1).setPosition(player.getX()-halo.getWidth()/2 + player.getWidth()/2, player.getY()-halo.getHeight()/2 + player.getHeight()/2);
        // moves player back to old pos if collides
        players.get(0).checkCollision(collisions);

        camera.position.set(players.get(0).getX()+ players.get(0).getWidth()/2, players.get(0).getY()+ players.get(0).getHeight()/2, 0);
        camera.update();

        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();


        batch.begin();


        // sort npcs by min y
        // loop through npcs, store index and position


//        if (player.getY() >= npc.get(0).getY()) {
//            player.draw(batch);
//            npc.get(0).draw(batch);
//        } else {
//            npc.get(0).draw(batch);
//            player.draw(batch);
//        }
        players.get(0).draw(batch);
        npcs.get(0).draw(batch);

//        player.draw(batch);
//        guru.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        tiledMap.dispose();
//        players.dispose();
        batch.dispose();
    }

}