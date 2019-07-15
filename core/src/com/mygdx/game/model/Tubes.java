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
    float rand_h;
    float dist;

    public Tubes() {

        x = GameInfo.SPEED;
        rand = new Random();

        top = new ArrayList<Sprite>();
        bottom = new ArrayList<Sprite>();

        gap = GameInfo.HEIGHT / 5;

        rand_h = (rand.nextFloat() * (GameInfo.HEIGHT / 2 - GameInfo.HEIGHT / 8)) + GameInfo.HEIGHT / 8;
        rand_h = rand.nextInt() == 0 ? -rand_h : rand_h;

        top.add(new Sprite(new Texture("toptube.png")));
        bottom.add(new Sprite(new Texture("bottomtube.png")));
        top.get(0).setPosition(GameInfo.WIDTH , GameInfo.HEIGHT + rand_h - GameInfo.TUBE_HEIGHT + gap / 2);
        bottom.get(0).setPosition(GameInfo.WIDTH ,  -GameInfo.TUBE_HEIGHT + rand_h + gap);

        dist = 0;
    }

    public void update(){

        x = GameInfo.SPEED;

        for (Sprite tube : top) {
            tube.setPosition(tube.getX() + x, tube.getY());
        }

        for (Sprite tube : bottom) {
            tube.setPosition(tube.getX() + x, tube.getY());
        }

        dist = top.get(top.size() - 1).getX() + GameInfo.TUBE_WIDTH + ((rand.nextFloat() * (600 - 200)) + 200);
        if (dist < GameInfo.WIDTH) {

            rand_h = (rand.nextFloat() * (GameInfo.HEIGHT / 3 - GameInfo.HEIGHT / 5)) + GameInfo.HEIGHT / 5;
            rand_h = rand.nextInt() == 0 ? -rand_h : rand_h;

            top.add(new Sprite(new Texture("toptube.png")));
            bottom.add(new Sprite(new Texture("bottomtube.png")));
            top.get(top.size() - 1).setPosition(GameInfo.WIDTH , GameInfo.HEIGHT + rand_h - GameInfo.TUBE_HEIGHT + gap / 2);
            bottom.get(top.size() - 1).setPosition(GameInfo.WIDTH ,  -GameInfo.TUBE_HEIGHT + rand_h + gap);
        }

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
