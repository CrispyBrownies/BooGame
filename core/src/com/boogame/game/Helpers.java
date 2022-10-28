package com.boogame.game;

public class Helpers {

    public float capValue(int maxValue, int minValue, float num) {
        if (num > maxValue) return maxValue;
        if (num < maxValue) return minValue;
        else return num;
    }

    public long capValue(int maxValue, int minValue, long num) {
        if (num > maxValue) return maxValue;
        if (num < maxValue) return minValue;
        else return num;
    }

    public int capValue(int maxValue, int minValue, int num) {
        if (num > maxValue) return maxValue;
        if (num < maxValue) return minValue;
        else return num;
    }

}
