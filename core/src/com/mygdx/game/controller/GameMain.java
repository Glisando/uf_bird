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
import com.mygdx.game.model.ButtonTubes;
import com.mygdx.game.model.Model;
import com.mygdx.game.model.TopTubes;
import com.mygdx.game.view.Renderer;

public class GameMain extends Game {
    Model Data;
    Renderer renderer;

    @Override
    public void create() {
        renderer = new Renderer();
        Data = new Model();
        Data.create();
    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        Data.update();
        renderer.render(Data);
    }

    @Override
    public void dispose() {
        Data.dispose();
    }
}
