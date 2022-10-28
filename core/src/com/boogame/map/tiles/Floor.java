package com.boogame.map.tiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;

public class Floor {

    private final Texture grassTileSetSheet = new Texture(Gdx.files.internal("Map/TX Tileset Grass.png"));
    private ArrayList<TextureRegion> grass;
    private ArrayList<TextureRegion> flowers;

    private ArrayList<TextureRegion> stones;
    private ArrayList<TextureRegion> stonesPath;
    private ArrayList<TextureRegion> stonesBroken;
    public Floor() {
        splitTexture();
    }

    private void splitTexture() {
        splitGrass();
        splitFlowers();
        splitStones();
        splitStonesPath();
    }

    private void splitGrass() {
        TextureRegion grassRegion = new TextureRegion(grassTileSetSheet,0, 0, 128,128);
        TextureRegion[][] tmp = TextureRegion.split(grassRegion.getTexture(),
                grassRegion.getRegionWidth() / 2,
                grassRegion.getRegionHeight() / 2);

        for (int i=0; i<2; i++) {
            for (int j=0; j<2; j++) {
                grass.add(tmp[i][j]);
            }
        }
    }

    private void splitFlowers() {
        TextureRegion flowerRegion = new TextureRegion(grassTileSetSheet, 128, 0, 128, 128);
        TextureRegion[][] tmp = TextureRegion.split(flowerRegion.getTexture(),
                flowerRegion.getRegionWidth() / 2,
                flowerRegion.getRegionHeight() / 2);

        for (int i=0; i<2; i++) {
            for (int j=0; j<2; j++) {
                flowers.add(tmp[i][j]);
            }
        }
    }

    private void splitStones() {
        TextureRegion stonesRegion = new TextureRegion(grassTileSetSheet, 0, 128, 64, 128);

        TextureRegion[][] tmp = TextureRegion.split(stonesRegion.getTexture(),
                stonesRegion.getRegionWidth() / 2,
                stonesRegion.getRegionHeight() / 4);

        for (int i=0; i<4; i++) {
            for (int j=0; j<2; j++) {
                stones.add(tmp[i][j]);
            }
        }
    }

    private void splitStonesPath() {
        TextureRegion stonesPathRegion = new TextureRegion(grassTileSetSheet, 64, 128, 64, 128);
        TextureRegion[][] tmp = TextureRegion.split(stonesPathRegion.getTexture(),
                stonesPathRegion.getRegionWidth(),
                stonesPathRegion.getRegionHeight() / 4);

        for (int i=0; i<4; i++) {
            for (int j=0; j<1; j++) {
                stonesPath.add(tmp[i][j]);
            }
        }
    }

    private void splitStonesBroken() {
        TextureRegion stonesPathRegion = new TextureRegion(grassTileSetSheet, 128, 192, 128, 64);
        TextureRegion[][] tmp = TextureRegion.split(stonesPathRegion.getTexture(),
                stonesPathRegion.getRegionWidth() / 4,
                stonesPathRegion.getRegionHeight() / 2);

        for (int i=0; i<2; i++) {
            for (int j=0; j<4; j++) {
                stonesBroken.add(tmp[i][j]);
            }
        }
    }

    public ArrayList<TextureRegion> getGrass() {
        return grass;
    }

    public ArrayList<TextureRegion> getFlowers() {
        return flowers;
    }

    public ArrayList<TextureRegion> getStones() {
        return stones;
    }

    public ArrayList<TextureRegion> getStonesPath() {
        return stonesPath;
    }

    public ArrayList<TextureRegion> getStonesBroken() {
        return stonesBroken;
    }
}