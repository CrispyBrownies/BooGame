package com.boogame.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.boogame.characters.Character;

public class PlayerController {

    private final float sensitivity = 10;
    private final double diag = Math.sqrt(2)/2;

    public void processUserInput(Character player) {
        if (Gdx.input.isKeyPressed(Input.Keys.W) && Gdx.input.isKeyPressed(Input.Keys.D)) {
            player.setVelocity(new Vector2((float)(sensitivity * diag * player.getSpeed()),(float)(sensitivity * diag * player.getSpeed())));
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.W) && Gdx.input.isKeyPressed(Input.Keys.A)) {
            player.setVelocity(new Vector2((float)(sensitivity * diag * -1 * player.getSpeed()),(float)(sensitivity * diag * player.getSpeed())));
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.S) && Gdx.input.isKeyPressed(Input.Keys.D)) {
            player.setVelocity(new Vector2((float)(sensitivity * diag * player.getSpeed()),(float)(sensitivity * -1 * diag * player.getSpeed())));
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.S) && Gdx.input.isKeyPressed(Input.Keys.A)) {
            player.setVelocity(new Vector2((float)(sensitivity * diag * -1 * player.getSpeed()),(float)(sensitivity * -1 * diag * player.getSpeed())));
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            player.setVelocity(new Vector2(0, (float)(sensitivity * player.getSpeed())));
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            player.setVelocity(new Vector2((float)(sensitivity * -1 * player.getSpeed()), 0));
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            player.setVelocity(new Vector2(0, (float)(sensitivity * -1 * player.getSpeed())));
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            player.setVelocity(new Vector2((float)(sensitivity * player.getSpeed()),0));
        }
        else {
            player.setVelocity(new Vector2(0, 0));
        }

    }

}
