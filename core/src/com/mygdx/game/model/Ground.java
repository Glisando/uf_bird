package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.helpers.GameInfo;

public class Ground {
    Texture ground;
    float i;

    public Ground(float i) {
        ground = new Texture("ground.png");
        ground.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        this.i = i;
    }

    public void update() {

        if (GameInfo.WIDTH + i < 1)
            i = 0;
        i += GameInfo.SPEED;
    }

    public void render(SpriteBatch batch) {
        batch.draw(ground, i, 0, GameInfo.WIDTH * 2, GameInfo.HEIGHT * 0.15f);
    }

    public Texture getGround() {
        return ground;
    }

    public void disp() {
        ground.dispose();
    }
}


