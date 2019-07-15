package com.mygdx.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.helpers.GameInfo;

public class StartController {

    float timer;

    public StartController() {
        timer = 0;
    }
    public void update () {
        if (timer > 1f)
            if (Gdx.input.isTouched()) {
                GameMain.state = "new_game";
                timer = 0;
            }
        timer += Gdx.graphics.getDeltaTime();
    }

    public void render(SpriteBatch batch) {
        GameInfo.font.draw(batch,  "TAP TO PLAY", (GameInfo.WIDTH / 2) - 500, GameInfo.HEIGHT / 2f);
    }
}
