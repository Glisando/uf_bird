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
    public static String state = "start";
    Ground ground;
    GameController gameController;
    GameOverController gameOverController;
    StartController startController;

    @Override
    public void create() {
        startController = new StartController();
        batch = new SpriteBatch();
        bg1 = new Background(0);
        bg2 = new Background((int) GameInfo.WIDTH);
        ground = new Ground(0);
        gameController = new GameController();
        GameInfo.music.setLooping(true);
        GameInfo.music.play();
    }

    public void update() {
        bg1.update();
        bg2.update();
        ground.update();

        if (state == "new_game")
            newGame();

        if (state == "game")
            gameController.update();
        else if (state == "game_over") {
            gameOverController.update();
        } else if (state == "start") {
            startController.update();
        }
    }
    @Override
    public void render() {

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (state == "stop") {
            gameOverController = new GameOverController(gameController.getScore());
            GameInfo.explosion.play();
            state = "game_over";
        }

        update();

        batch.begin();

        bg1.render(batch);
        bg2.render(batch);
        if (state == "game")
            gameController.render(batch);
        else if (state == "start")
            startController.render(batch);
        else if (state == "game_over")
            gameOverController.render(batch);

        ground.render(batch);

        batch.end();
    }

    public void newGame()
    {
        GameInfo.SPEED = -3;
        state = "game";
        gameController = new GameController();
    }
    @Override
    public void dispose() {
        ground.disp();
        bg1.disp();
        bg2.disp();
    }
}
