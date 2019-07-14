package com.mygdx.game.model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.helpers.GameInfo;

public class GameModel {
    Bird bird;

    Tubes tubes;

    public GameModel() {
        bird = new Bird();
        tubes = new Tubes();
    }

    public void update() {
        bird.update();
        tubes.update();
    }

    public Bird getBird() { return bird; }

    public Tubes getTubes() {
        return tubes;
    }

    public void render(SpriteBatch batch) {
        tubes.render(batch);
        bird.render(batch);
    }
}
