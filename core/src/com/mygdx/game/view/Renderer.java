package com.mygdx.game.view;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.helpers.GameInfo;
import com.mygdx.game.model.Model;
import com.mygdx.game.model.Bird;
import com.mygdx.game.model.Background;
import com.mygdx.game.controller.GameMain;
import com.mygdx.game.model.ButtonTubes;
import com.mygdx.game.model.TopTubes;

public class Renderer {
    SpriteBatch batch;
    Bird bird;
    Background bg1;
    Background bg2;
//    ButtonTubes b_tubes;
//    TopTubes t_tubes;

    public void load(Model Data) {
        batch = Data.getBatch();
        bird = Data.getBird();
        bg1 = Data.getBg1();
        bg2 = Data.getBg2();
    }

    public void render(Model Data) {
        load(Data);

        batch.begin();
        batch.draw(bg1.getBG(), bg1.getI(), 0, GameInfo.WIDTH, GameInfo.HEIGHT);
        batch.draw(bg2.getBG(), bg2.getI(), 0, GameInfo.WIDTH, GameInfo.HEIGHT);
        batch.draw(bird.getBird(), bird.getX(), bird.getY(),
                GameInfo.WIDTH * 0.11f, GameInfo.HEIGHT * 0.05f);
        batch.end();
    }
}
