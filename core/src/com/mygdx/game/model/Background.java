package com.mygdx.game.model;
import com.mygdx.game.helpers.GameInfo;
import com.badlogic.gdx.graphics.Texture;

public class Background {

    Texture bg;
    int i;

    public Background(int i) {
        bg = new Texture("bg.png");
        bg.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        this.i = i;
    }

    public void update() {

        if (GameInfo.WIDTH + i < 1)
            i = (int) GameInfo.WIDTH;
        i--;
    }

    public Texture getBG() {
        return bg;
    }

    public int getI() {
        return  i;
    }

    public void disp() {
        bg.dispose();
    }
}
