package com.boogame.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;

public class Camera {

    private final float viewPercent = 0.1f; //How big you want the player ot show up
    private final float defaultCharSize = 100;
    private final Helpers helpers = new Helpers();

    private OrthographicCamera camera = new OrthographicCamera();

    public Camera() {}

    public Camera(Vector2 windowSize, Vector2 playerSize) {
        if (playerSize == null) {playerSize = new Vector2(0, 100f);}

        Vector2 cameraSize = helpers.getCameraSize(windowSize, playerSize, viewPercent);
        camera.setToOrtho(false, cameraSize.x, cameraSize.y);
    }

    public void follow(Vector2 playerPosition, Vector2 playerSize) {
        Vector2 newCameraPos = new Vector2(playerPosition);
        newCameraPos.mulAdd(playerSize, 0.5f);
        this.camera.position.set(newCameraPos, 0);
    }

    public void update() {
        this.camera.update();
//        System.out.println(new Vector2(camera.viewportHeight, camera.viewportWidth));
    }

    public Matrix4 getCombined() {
        return this.camera.combined;
    }
}
