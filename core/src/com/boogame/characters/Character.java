package com.boogame.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.boogame.game.Helpers;
import java.util.Vector;

public abstract class Character extends Sprite {

    protected float health;
    protected boolean alive;
    protected float speed;
    protected Animation<TextureRegion> walkAnimation;
    private Helpers helpers;

    public boolean isPlayer;
    private Vector2 oldPos = new Vector2(0,0);

    public Character(Texture texture) {
        super(texture, 0, 0, texture.getWidth(), texture.getHeight());
        this.alive = true;
    }

    // Returns the intended ending position if move() is executed. Use this to check if next movement location is valid in game class.

    public void checkCollision(MapObjects collisions) {

        for (int i = 0; i < collisions.getCount(); i++) {
            MapObject mapObject = collisions.get(i);
            if (mapObject instanceof RectangleMapObject) {
                RectangleMapObject rectangleMapObject = (RectangleMapObject) mapObject;
                Rectangle rectangle = rectangleMapObject.getRectangle();

                float lowerY = rectangle.getY();
                float upperY = rectangle.getY() + rectangle.getHeight();
                float lowerX = rectangle.getX();
                float upperX = rectangle.getX() + rectangle.getWidth();

                float playerUpperX = this.getX() + this.getWidth();
//                float playerUpperY = this.getY()

                // if player x is > rec.x and < rec.x+width -> x = oldpos.x
                // if player y is > rec.y and < rec.y+height -> y = oldpos.y
                if ((playerUpperX >= lowerX) &&
                        (this.getX() <= upperX) &&
                        (this.getY() >= lowerY) &&
                        (this.getY() <= upperY)) {
                    this.setPosition(this.oldPos.x, this.oldPos.y);
                    System.out.println("collides"+this.oldPos);

                    break;
                }
            }

        }
    }

    public void damage(float damageValue) {
        this.health += damageValue;
        this.health = helpers.capValue(0, 100, this.health);
    }

    public void move() {
        this.oldPos.set(this.getX(), this.getY());
        if (this.isPlayer) {
            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)){
                    this.translateX(-2.0f*this.speed);
                } else {
                    this.translateX(-1f*this.speed);
                }
            }
            if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
                    this.translateX(2.0f*this.speed);
                } else {
                    this.translateX(this.speed);
                }
            }
            if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)){
                    this.translateY(2.0f*this.speed);
                } else {
                    this.translateY(this.speed);
                }
            }
            if (Gdx.input.isKeyPressed(Input.Keys.S)) {
                if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
                    this.translateY(-2.0f*this.speed);
                } else {
                    this.translateY(-1f*this.speed);
                }
            }
        }
        else {
            // npc movement
        }
    }

}
