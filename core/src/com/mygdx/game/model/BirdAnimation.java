package com.mygdx.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BirdAnimation {
    Texture             atlas;
    TextureRegion[][]   animation;
    int                 i;
    float               timer;

    public BirdAnimation() {
        atlas = new Texture("birdanimation.png");
        animation = TextureRegion.split(atlas, atlas.getWidth() / 3, atlas.getHeight());

        timer = 0;
        i = 0;
    }

    public void update() {
        if (timer >  0.1f) {
            timer = 0;
            i = (i + 1) % 3;
        }
        timer += Gdx.graphics.getDeltaTime();
    }

    public TextureRegion getCurrentTexture() {
        return animation[0][i];
    }
}
