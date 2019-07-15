package com.mygdx.game.model;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.controller.GameMain;
import com.mygdx.game.helpers.GameInfo;

import java.util.ArrayDeque;
import java.util.Timer;

public class Bird {

    float x;
    float y;
    float i;
    float timer;
    BirdAnimation animation;
    TextureRegion currentTexture;

    public Bird() {
        animation = new BirdAnimation();
        currentTexture = animation.getCurrentTexture();
        x = (GameInfo.WIDTH / 4) - currentTexture.getRegionWidth() / 4;
        y = (GameInfo.HEIGHT / 2) - currentTexture.getRegionHeight() / 2;

        i = 0;
        timer = 0;
    }

    public void update() {

        animation.update();
        currentTexture = animation.getCurrentTexture();

        if (Gdx.input.isTouched() && timer > 0.2f) {
            timer = 0;
            i = 20;
            GameInfo.jump.stop();
            GameInfo.jump.play();
        } else
            i -= 1.5f;
        if (y > GameInfo.HEIGHT )
            GameMain.state = "stop";
       else if (y + i < GameInfo.HEIGHT *  0.15f)
            GameMain.state = "stop";

        y += i;
        timer += Gdx.graphics.getDeltaTime();
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void render(SpriteBatch batch) {
        batch.draw(currentTexture, x, y, GameInfo.BIRD_WIDTH, GameInfo.BIRD_HEIGHT);

    }
}