package com.boogame.map.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;

public class Plant {

    private final Texture plantSprite = new Texture(Gdx.files.internal("Map/TX Plant.png"));

    private ArrayList<TextureRegion> trees;
    private ArrayList<TextureRegion> bushes;
    private ArrayList<TextureRegion> weeds;

    public Plant() {
        splitTrees();
        splitBushes();
        splitWeeds();
    }

    private void splitTrees() {
        TextureRegion treeRegion = new TextureRegion(plantSprite, 0, 0, 384, 160);
        TextureRegion[][] tmp = TextureRegion.split(treeRegion.getTexture(),
                treeRegion.getRegionWidth() / 3,
                treeRegion.getRegionHeight());

        for (int i=0; i<1; i++) {
            for (int j=0; j<3; j++) {
                trees.add(tmp[i][j]);
            }
        }
    }

    private void splitBushes() {
        TextureRegion bushRegion = new TextureRegion(plantSprite, 0, 172, 416, 48);
        TextureRegion[][] tmp = TextureRegion.split(bushRegion.getTexture(),
                bushRegion.getRegionWidth() / 6,
                bushRegion.getRegionHeight());

        for (int i=0; i<1; i++) {
            for (int j=0; j<6; j++) {
                bushes.add(tmp[i][j]);
            }
        }
    }

    private void splitWeeds() {
        TextureRegion weedRegion = new TextureRegion(plantSprite,0, 384, 128, 128);
        TextureRegion[][] tmp = TextureRegion.split(weedRegion.getTexture(),
                weedRegion.getRegionWidth() / 4,
                weedRegion.getRegionHeight() / 4);

        for (int i=0; i<4; i++) {
            for (int j=0; j<4; j++) {
                weeds.add(tmp[i][j]);
            }
        }
    }

    public ArrayList<TextureRegion> getTrees() {
        return trees;
    }

    public ArrayList<TextureRegion> getBushes() {
        return bushes;
    }

    public ArrayList<TextureRegion> getWeeds() {
        return weeds;
    }
}
