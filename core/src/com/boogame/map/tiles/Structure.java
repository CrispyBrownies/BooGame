package com.boogame.map.tiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;

public class Structure {
    private final Texture structTileSet = new Texture(Gdx.files.internal("Map/TX Struct.png"));

    private ArrayList<TextureRegion> stairs;
    private ArrayList<TextureRegion> arches;

    public final int PADDING_ARCHES = 24;
    public final int PADDING_STAIRS = 8;

    public Structure() {
        splitStairs();
        splitArches();
    }

    private void splitStairs() {
        TextureRegion s1 = new TextureRegion(structTileSet, 32, 32, 64, 64);
        TextureRegion s2 = new TextureRegion(structTileSet, 128, 32, 64, 64);
        TextureRegion s3 = new TextureRegion(structTileSet, 224, 32, 64, 64);
        TextureRegion s4 = new TextureRegion(structTileSet, 32, 160, 64, 64);
        TextureRegion s5 = new TextureRegion(structTileSet, 128, 160, 64, 64);
        TextureRegion s6 = new TextureRegion(structTileSet, 224, 160, 64, 64);

        stairs.add(s1);
        stairs.add(s2);
        stairs.add(s3);
        stairs.add(s4);
        stairs.add(s5);
        stairs.add(s6);
    }

    private void splitArches() {
        TextureRegion a1 = new TextureRegion(structTileSet, 408, 28, 80, 64);
        TextureRegion a2 = new TextureRegion(structTileSet, 408, 128, 80, 64);

        arches.add(a1);
        arches.add(a2);
    }

    public ArrayList<TextureRegion> getStairs() {
        return stairs;
    }

    public ArrayList<TextureRegion> getArches() {
        return arches;
    }
}
