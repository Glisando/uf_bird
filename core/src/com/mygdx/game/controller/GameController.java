package com.mygdx.game.controller;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.helpers.GameInfo;
import com.mygdx.game.model.Bird;
import com.mygdx.game.model.Tubes;
import com.mygdx.game.model.GameModel;
import com.mygdx.game.view.GameRenderer;

import java.util.ArrayList;

//import sun.util.locale.provider.SPILocaleProviderAdapter;

public class GameController {

    ArrayList<Sprite>   checked_tubes;
    GameModel       GameData;
    GameRenderer    gameRenderer;
    BitmapFont      font;
    float           timer;
    float           incr_speed;
    int             score;

    public GameController() {
        timer = 0;
        score = 0;
        font = new BitmapFont(Gdx.files.internal("scoreFont.fnt"), false);

        incr_speed = 2;
        GameData = new GameModel();
        gameRenderer = new GameRenderer();
        checked_tubes = new ArrayList<Sprite>();
    }

    public void update(){
        GameData.update();
        timer += Gdx.graphics.getDeltaTime();
        if (timer > incr_speed) {
            timer = 0;
            GameInfo.SPEED -= 0.5f;
            checked_tubes.clear();
        }
        if (collision(GameData.getBird().getBird(), GameData.getTubes().getBottom(), GameData.getTubes().getTop())) {
                GameMain.stop = true;
        }
        else
            check_score(GameData.getBird().getBird(), GameData.getTubes().getTop());
    }

    public void check_score(Sprite bird, ArrayList<Sprite> tubes) {
        for (Sprite tube : tubes) {
            if (bird.getX() < tube.getX() + GameInfo.TUBE_WIDTH && bird.getX() > tube.getX() &&
                    !checked_tubes.contains(tube)) {
                checked_tubes.add(tube);
                score++;
            }
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

        int score_width = 50;

        if (score > 99)
            score_width = 150;
        else if(score > 9)
            score_width = 100;
        font.draw(batch,  Integer.toString(score), (GameInfo.WIDTH / 2) - score_width, GameInfo.HEIGHT / 1.2f);
    }
}
