package com.boogame.characters;

import com.badlogic.gdx.math.Vector2;
import com.boogame.game.Helpers;
import java.util.Vector;

public class Character {

    protected Vector2 position;
    protected Vector2 velocity;
    protected float health;
    protected float sizeScale;
    protected boolean alive;

    private Helpers helpers;

    // Returns the intended ending position if move() is executed. Use this to check if next movement location is valid in game class.
    public Vector2 moveIntent() {
        Vector2 intendedPosition = position;
        return intendedPosition.add(velocity);
    }

    public void move() {
        position.add(velocity);
    }

    public void damage(float damageValue) {
        health += damageValue;
        health = helpers.capValue(0, 100, health);
    }

}
