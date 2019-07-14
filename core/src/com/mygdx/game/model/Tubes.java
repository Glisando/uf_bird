package com.mygdx.game.model;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.helpers.GameInfo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;

import jdk.nashorn.internal.runtime.arrays.ArrayIndex;

public class Tubes {

    ArrayList<Sprite>  top;
    ArrayList<Sprite> bottom;
    float  gap;
    float     x;
    Random rand;
    float timer;
    float delta_timer;
    float spawn;
    float max_spawn;
    float min_spawn;
    float min_gap;

    public Tubes() {
        timer = 0;
        delta_timer = 0;
        min_spawn = 1f;
        max_spawn = 2f;
        min_gap = 3;
        x = GameInfo.SPEED;
        rand = new Random();
        top = new ArrayList<Sprite>();
        bottom = new ArrayList<Sprite>();
        gap = (rand.nextFloat() * (GameInfo.HEIGHT / 3 - GameInfo.HEIGHT / min_gap)) + GameInfo.HEIGHT / min_gap;
        spawn = (rand.nextFloat() * (max_spawn - min_spawn)) + min_spawn;
        top.add(new Sprite(new Texture("toptube.png")));
        bottom.add(new Sprite(new Texture("bottomtube.png")));

        top.get(0).setPosition(GameInfo.WIDTH , GameInfo.HEIGHT - GameInfo.TUBE_HEIGHT + gap / 2);
        bottom.get(0).setPosition(GameInfo.WIDTH ,  -gap / 2);
    }

    public void update(){

        x = GameInfo.SPEED;
        for (Sprite tube : top) {
            tube.setPosition(tube.getX() + x, tube.getY());
        }

        for (Sprite tube : bottom) {
            tube.setPosition(tube.getX() + x, tube.getY());
        }

        if (delta_timer > 2) {
            max_spawn -= max_spawn < 0.1f ? 0 : 0.05f;
            min_spawn -= min_spawn < 0.1f ? 0 : 0.05f;
            delta_timer = 0;
        }

        if (timer > spawn) {
            gap = (rand.nextFloat() * (GameInfo.HEIGHT / 3 - GameInfo.HEIGHT / min_gap)) + GameInfo.HEIGHT / min_gap;

            top.add(new Sprite(new Texture("toptube.png")));
            bottom.add(new Sprite(new Texture("bottomtube.png")));
            top.get(top.size() - 1).setPosition(GameInfo.WIDTH , GameInfo.HEIGHT - GameInfo.TUBE_HEIGHT + gap / 2);
            bottom.get(top.size() - 1).setPosition(GameInfo.WIDTH ,  -gap / 2);

            spawn = (rand.nextFloat() * (max_spawn - min_spawn)) + min_spawn;;
            timer = 0;
            min_gap += min_gap > 6 ? 0 : 0.4f;
        }

        timer += Gdx.graphics.getDeltaTime();
        delta_timer += Gdx.graphics.getDeltaTime();

        if (top.get(0).getX() + GameInfo.TUBE_WIDTH < 0) {
            top.remove(0);
            bottom.remove(0);
        }
    }

    public ArrayList<Sprite> getTop() {
        return top;
    }

    public ArrayList<Sprite> getBottom() {
        return bottom;
    }

    public void render(SpriteBatch batch){
        for (Sprite tube : top) {
            batch.draw(tube, tube.getX(), tube.getY(), GameInfo.TUBE_WIDTH, GameInfo.TUBE_HEIGHT);
        }
        for (Sprite tube : bottom) {
            batch.draw(tube, tube.getX(), tube.getY(), GameInfo.TUBE_WIDTH, GameInfo.TUBE_HEIGHT);
        }
    }
}
