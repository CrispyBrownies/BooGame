package com.boogame.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

//public class Ghost extends Character{
//    // Properties for Ghost
//    private static final int FRAME_COLS = 4;
//
//    public Texture walkSheet;
//
//    public Ghost() {
//        this.alive = true;
//        this.health = 100;
//        this.position = new Vector2(100, 100);
//        this.velocity = new Vector2(0, 0);
//        this.speed = 1;
//        this.size = new Vector2(21, 44);
//        this.sizeScale = 1;
////        this.characterTexture = new Texture(Gdx.files.internal("Characters/Ghost/TX Player_test.png"));
//        this.hitbox = new Rectangle(this.position.x, this.position.y, this.size.x, this.size.y);
//
//        walkSheet = new Texture(Gdx.files.internal("Characters/Ghost/ghost-Sheet.png"));
//        TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth()/FRAME_COLS, walkSheet.getHeight());
//        TextureRegion[] walkFrames = new TextureRegion[FRAME_COLS];
//        for (int i = 0; i < FRAME_COLS; i++) {
//            walkFrames[i] = tmp[0][i];
//        }
//        this.walkAnimation = new Animation<TextureRegion>(0.25f, walkFrames);
//
//    }
//
//    // Oswald methods
//
//}
