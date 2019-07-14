package com.mygdx.game.controller;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Game;
import com.mygdx.game.helpers.GameInfo;
import com.mygdx.game.model.Bird;
import com.mygdx.game.model.Background;
import com.mygdx.game.model.Ground;
import com.mygdx.game.model.Tubes;
import com.mygdx.game.model.GameModel;
import com.mygdx.game.view.GameRenderer;

public class GameMain extends Game {
    SpriteBatch batch;

    Background bg1;
    Background bg2;
    Texture     GameOver;
    public static boolean stop = false;
    Ground ground;
    GameController gameController;


    @Override
    public void create() {
        GameOver = new Texture("gameover.png");
        batch = new SpriteBatch();
        bg1 = new Background(0);
        bg2 = new Background((int) GameInfo.WIDTH);
        ground = new Ground(0);
        gameController = new GameController();
    }

    public void update() {
        bg1.update();
        bg2.update();
        ground.update();
        gameController.update();
    }
    @Override
    public void render() {

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (stop)
            newGame();
        update();

        batch.begin();

        bg1.render(batch);
        bg2.render(batch);
        gameController.render(batch);
        ground.render(batch);
//        batch.draw(GameOver, 400, 800, 400, 400;

        batch.end();
    }

    public void newGame()
    {
        GameInfo.SPEED = -3;
        stop = !stop;
        gameController = new GameController();
    }
    @Override
    public void dispose() {
        ground.disp();
        bg1.disp();
        bg2.disp();
    }
}
