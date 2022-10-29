package com.boogame.game;

import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;

public class Helpers {

    public float capValue(int maxValue, int minValue, float num) {
        if (num > maxValue) return maxValue;
        if (num < minValue) return minValue;
        else return num;
    }

    public long capValue(int maxValue, int minValue, long num) {
        if (num > maxValue) return maxValue;
        if (num < minValue) return minValue;
        else return num;
    }

    public int capValue(int maxValue, int minValue, int num) {
        if (num > maxValue) return maxValue;
        if (num < minValue) return minValue;
        else return num;
    }

    public Vector2 getCameraSize(Vector2 windowSize, Vector2 playerSize, float viewPercent) {
        // Based off a 16x9 view ratio
        float playerHeight = playerSize.y;
        float viewScale = 1/viewPercent;
        float cameraHeight = playerHeight * viewScale;

        cameraHeight = capValue(Math.round(windowSize.y), 0, cameraHeight);

        float cameraWidth = (float) ((16.0/9.0)*cameraHeight);

        return new Vector2(Math.round(cameraWidth),Math.round(cameraHeight));
    }
}
