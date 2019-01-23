package com.mygdx.game.model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.helpers.GameInfo;

public class Model {
    SpriteBatch batch;
    Bird bird;
    Background bg1;
    Background bg2;
//    ButtonTubes b_tubes;
//    TopTubes t_tubes;

    public void create() {
        batch = new SpriteBatch();
        bg1 = new Background(0);
        bg2 = new Background((int) GameInfo.WIDTH);
        bird = new Bird();
//        t_tubes = new TopTubes();
//        b_tubes = new ButtonTubes();
    }

    public void update() {
        bird.update();
        bg1.update();
        bg2.update();
    }

    public void dispose() {
        batch.dispose();
        bg1.disp();
        bg2.disp();
    }

    public SpriteBatch getBatch() { return batch; }
    public Bird getBird() { return bird; }
    public Background getBg1() { return bg1; }
    public Background getBg2() { return bg2; }
}
