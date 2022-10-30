package com.boogame.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.boogame.characters.Character;

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

}
