package com.boogame.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.boogame.game.Helpers;
import java.util.Vector;

public class Character {

    protected Vector2 position;
    protected Vector2 velocity;
    protected Vector2 size;
    protected float health;
    protected float sizeScale;
    protected boolean alive;
    protected Texture characterTexture;
    protected float speed;
    protected Rectangle hitbox;

    private Helpers helpers;

    // Returns the intended ending position if move() is executed. Use this to check if next movement location is valid in game class.
    public Vector2 moveIntent() {
        Vector2 intendedPosition = position;
        return intendedPosition.add(velocity);
    }

    public void move() {
//        System.out.println(velocity);
        position.add(velocity);
    }

    public void damage(float damageValue) {
        health += damageValue;
        health = helpers.capValue(0, 100, health);
    }

    public Texture getCharacterTexture() {
        return characterTexture;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public float getSpeed() {
        return speed;
    }

    public Vector2 getSize() {
        return size;
    }
}
