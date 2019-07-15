package com.mygdx.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.helpers.GameInfo;

public class GameOverController {

    int score;
    Texture GameOver;
    float timer;

    public GameOverController(int sc) {
        timer = 0;
        GameOver = new Texture("gameover.png");
        score = sc;
    }

    public void update() {
        if (timer > 1f)
            if (Gdx.input.isTouched()) {
                GameMain.state = "start";
                timer = 0;
            }
        timer += Gdx.graphics.getDeltaTime();
    }

    public void render(SpriteBatch batch) {
        int score_width = 50;

        if (score > 99)
            score_width = 150;
        else if(score > 9)
            score_width = 100;

        GameInfo.font.draw(batch,  Integer.toString(score), (GameInfo.WIDTH / 2) - score_width, GameInfo.HEIGHT / 2f);
        batch.draw(GameOver, (GameInfo.WIDTH / 2) - 400, GameInfo.HEIGHT / 1.7f, 800, 400);
    }
}
