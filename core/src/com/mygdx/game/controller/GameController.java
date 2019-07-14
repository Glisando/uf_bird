package com.mygdx.game.controller;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.helpers.GameInfo;
import com.mygdx.game.model.Bird;
import com.mygdx.game.model.Tubes;
import com.mygdx.game.model.GameModel;
import com.mygdx.game.view.GameRenderer;

import java.util.ArrayList;

public class GameController {

    GameModel GameData;
    GameRenderer gameRenderer;

    float timer;
    float incr_speed;

    public GameController() {
        timer = 0;
        incr_speed = 2;
        GameData = new GameModel();
        gameRenderer = new GameRenderer();
    }

    public void update(){
        GameData.update();
        timer += Gdx.graphics.getDeltaTime();
        if (timer > incr_speed) {
            timer = 0;
            GameInfo.SPEED -= 0.5f;
        }
        if (collision(GameData.getBird().getBird(), GameData.getTubes().getBottom(), GameData.getTubes().getTop())) {
            GameMain.stop = true;
        }
    }

    public boolean collision(Sprite bird, ArrayList<Sprite> bottom, ArrayList<Sprite> top) {

        for (Sprite tube : top) {
            if (bird.getX() + GameInfo.BIRD_WIDTH > tube.getX() && bird.getX() < tube.getX() + GameInfo.TUBE_WIDTH &&
                    bird.getY() < tube.getY() + GameInfo.TUBE_HEIGHT &&
                    bird.getY() + GameInfo.BIRD_HEIGHT > tube.getY())
                return true;
        }

        for (Sprite tube : bottom) {
            if (bird.getX() + GameInfo.BIRD_WIDTH > tube.getX() && bird.getX() < tube.getX() + GameInfo.TUBE_WIDTH &&
                    bird.getY() < tube.getY() + GameInfo.TUBE_HEIGHT &&
                    bird.getY() + GameInfo.BIRD_HEIGHT > tube.getY())
                return true;
        }

        return false;
    }

    public void render(SpriteBatch batch){

        gameRenderer.render(GameData, batch);
    }
}
