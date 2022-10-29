package com.boogame.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Oswald extends Character{
    // Properties for Oswald


    public Oswald() {
        this.alive = true;
        this.health = 100;
        this.position = new Vector2(100, 100);
        this.velocity = new Vector2(0, 0);
        this.speed = 0.51f;
        this.size = new Vector2(21, 44);
        this.sizeScale = 1;
        this.characterTexture = new Texture(Gdx.files.internal("Characters/Oswald/TX Player_test.png"));
        this.hitbox = new Rectangle(this.position.x, this.position.y, this.size.x, this.size.y);
    }

    // Oswald methods

}
