package com.mygdx.game.model;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.helpers.GameInfo;

public class Bird {

    Sprite bird;
    int i;

    public Bird() {
        bird = new Sprite(new Texture("bird.png"));
        bird.setPosition((GameInfo.WIDTH / 4) - bird.getWidth() / 4,
                (GameInfo.HEIGHT / 2) - bird.getHeight() / 2);
        i = 0;
    }

    public void update() {

        if (Gdx.input.isTouched())
            i++;
        else
            i--;
        if ((bird.getY() + i + bird.getWidth() > GameInfo.HEIGHT) || (bird.getY() + i < 0))
            i = 0;
        bird.setPosition(bird.getX(), bird.getY() + i);
    }

    public Sprite getBird() {
        return bird;
    }
    public float getX() { return bird.getX(); }
    public float getY() { return bird.getY(); }

}