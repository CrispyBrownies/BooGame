package com.boogame.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	// textures
	private Texture tilesetGrassTexture;
	private Texture playerTexture;

	// camera
	private OrthographicCamera camera;

	private Rectangle player;
	private Rectangle tile;

	private SpriteBatch batch;

	
	@Override
	public void create () {
		tilesetGrassTexture = new Texture(Gdx.files.internal("Map/TX Tileset Grass.png"));
		playerTexture = new Texture(Gdx.files.internal("Characters/Oswald/TX Player_test.png"));

		// create player object
		player = new Rectangle();
		player.width = 21;
		player.height = 44;
		player.x = 1920/2 - player.width/2;
		player.y = 1080/2 - player.height/2;

		// background
		tile = new Rectangle();
		tile.height = 256;
		tile.width = 256;
		tile.x = 1920/2 - tile.width/2;
		tile.y = 1080/2 - tile.height/2;

		// create camera
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1920, 1080);
		batch = new SpriteBatch();

	}

	@Override
	public void render () {

		ScreenUtils.clear(0,0,0.2f, 1);

		camera.update();

		batch.setProjectionMatrix(camera.combined);

		batch.begin();
		batch.draw(tilesetGrassTexture, tile.x, tile.y);
		batch.draw(playerTexture, player.x, player.y);

		batch.end();

		// process user input
		/*


		 */

		// make sure player stays within screen bounds
		if (player.x < 0) player.x = 0;
		if (player.x > 1920-player.width) player.x = 1920 - player.width;

		if (player.y < 0) player.y = 0;
		if (player.y > 1080-player.height) player.y = 1080 - player.height;




	}
	
	@Override
	public void dispose () {
		tilesetGrassTexture.dispose();
		playerTexture.dispose();
		batch.dispose();
	}
}
