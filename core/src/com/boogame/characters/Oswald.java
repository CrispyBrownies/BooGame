package com.boogame.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Oswald extends Character{
    // Properties for Oswald
    private static final Texture oswaldTexture = new Texture(Gdx.files.internal("Characters/Oswald/TX Player_test.png"));
    public static final Texture walkSheet = new Texture(Gdx.files.internal("Characters/Ghost/ghost-Sheet.png"));

    public Oswald(boolean isPlayer) {
        super(oswaldTexture);
        this.isPlayer = isPlayer;
        this.health = 100;
        this.speed = 1;
    }

    private void createAnimation() {
        final int FRAME_COLS = 4;
        TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth()/FRAME_COLS, walkSheet.getHeight());
        TextureRegion[] walkFrames = new TextureRegion[FRAME_COLS];
        for (int i = 0; i < FRAME_COLS; i++) {
            walkFrames[i] = tmp[0][i];
        }
        this.walkAnimation = new Animation<TextureRegion>(0.25f, walkFrames);
    }


}
