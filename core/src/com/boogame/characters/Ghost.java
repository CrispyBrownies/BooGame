package com.boogame.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Ghost extends Character{
    // Properties for Ghost
    public int stacks;
    private static final Texture ghostTexture = new Texture(Gdx.files.internal("Characters/Oswald/guru2.png"));
    public static final Texture walkSheet = new Texture(Gdx.files.internal("Characters/Ghost/ghost-Sheet.png"));
    public Ghost(boolean isPlayer) {
        super(ghostTexture);
        this.isPlayer = isPlayer;
        this.health = 100;
        this.speed = 1;
        this.stacks = 0;
        createAnimation();
    }

    private void createAnimation() {
        final int FRAME_COLS = 4;
        TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth()/FRAME_COLS, walkSheet.getHeight());
        TextureRegion[] walkFrames = new TextureRegion[FRAME_COLS];
        for (int i = 0; i < FRAME_COLS; i++) {
            walkFrames[i] = tmp[0][i];
        }
        this.walkAnimation = new Animation<>(0.25f, walkFrames);
    }

    public void eat() {
        this.stacks++;
        this.setScale(1+(this.stacks*0.1f));
    }

}
