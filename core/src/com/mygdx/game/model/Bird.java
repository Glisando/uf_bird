package com.mygdx.game.model;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.controller.GameMain;
import com.mygdx.game.helpers.GameInfo;

import java.util.ArrayDeque;
import java.util.Timer;

public class Bird {

    Sprite bird;
    int i;
    float timer;
    Texture atlas;
    TextureRegion [][] animation;

    public Bird() {
        atlas = new Texture("birdanimation.png");
        animation = TextureRegion.split(atlas, atlas.getWidth() / 3, atlas.getHeight());
        timer = 0;
        bird = new Sprite(animation[0][0]);
        bird.setPosition((GameInfo.WIDTH / 4) - bird.getWidth() / 4,
                (GameInfo.HEIGHT / 2) - bird.getHeight() / 2);
        i = 0;
    }

    public void update() {

        if (Gdx.input.isTouched() && timer > 0.3f) {
            timer = 0;
            i = 20;
        }else
            i--;
        if (bird.getY() > GameInfo.HEIGHT )
            i = -3;
       else if (bird.getY() + i < GameInfo.HEIGHT *  0.15f)
            GameMain.stop = true;

        bird.setPosition(bird.getX(), bird.getY() + i);
        timer += Gdx.graphics.getDeltaTime();
    }

    public Sprite getBird() {
        return bird;
    }

    public void render(SpriteBatch batch) {
        batch.draw(bird, bird.getX(), bird.getY(), GameInfo.BIRD_WIDTH, GameInfo.BIRD_HEIGHT);

    }
}