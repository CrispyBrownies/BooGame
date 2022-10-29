package com.boogame.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.boogame.characters.Character;
import com.boogame.characters.Ghost;
import com.boogame.characters.Oswald;
import org.w3c.dom.Text;

public class Game extends ApplicationAdapter {

    private boolean gameOver = false;
    private Vector2 canvasSize = new Vector2(1920, 1080);

    private SpriteBatch batch;

    private Character player = new Character();
    private Character enemy = new Character();
    private Rectangle background = new Rectangle();
    private Texture backgroundTexture;
    private final PlayerController playerController = new PlayerController();

    private Camera camera;
    private float stateTime;

    public void create() {

        backgroundTexture = new Texture(Gdx.files.internal("Map/test_background.jpg"));

        batch = new SpriteBatch();

        player = new Oswald();
        enemy = new Ghost();

        camera = new Camera(canvasSize, player.getSize());
        background.height = 1920;
        background.width = 1080;
        background.x = 0;
        background.y = 0;

        stateTime = 0f;
    }

    public void render () {

        ScreenUtils.clear(0,0,0.2f, 1);

        playerController.processUserInput(player);
        player.move();

        stateTime += Gdx.graphics.getDeltaTime();;
        TextureRegion currentFrame = enemy.getWalkAnimation().getKeyFrame(stateTime, true);

        camera.follow(player.getPosition(), player.getSize());
        camera.update();
        batch.setProjectionMatrix(camera.getCombined());

        batch.begin();
        batch.draw(backgroundTexture, background.x, background.y);
        Vector2 playerPos = player.getPosition();
        Vector2 enemyPos = enemy.getPosition();
        batch.draw(currentFrame, enemyPos.x, enemyPos.y);
        batch.draw(player.getCharacterTexture(), playerPos.x, playerPos.y);
        batch.end();

    }

}
