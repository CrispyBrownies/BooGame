package com.boogame.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player extends Character {
    public Player(Texture playerTexture) {
        super(playerTexture);
    }

    public void checkCollision(Vector2 oldPosition, MapObjects collisions) {

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
                    this.setPosition(oldPosition.x, oldPosition.y);

                    break;
                }
            }

        }
    }

    public void inputMovement() {
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)){
                this.translateX(-2.0f);
            } else {
                this.translateX(-1f);
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
                this.translateX(2.0f);
            } else {
                this.translateX(1f);
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)){
                this.translateY(2.0f);
            } else {
                this.translateY(1f);
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
                this.translateY(-2.0f);
            } else {
                this.translateY(-1f);
            }
        }
    }
}
