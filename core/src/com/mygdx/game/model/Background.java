package com.mygdx.game.model;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.helpers.GameInfo;
import com.badlogic.gdx.graphics.Texture;

public class Background {

    Texture bg;
    float i;

    public Background(float i) {
        bg = new Texture("bg.png");
        bg.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        this.i = i;
    }

    public void update() {

        if (GameInfo.WIDTH + i < 1)
            i = GameInfo.WIDTH;
        i -= 1.5;
    }

    public void render(SpriteBatch batch) {
        batch.draw(bg, i, 0, GameInfo.WIDTH, GameInfo.HEIGHT);
    }

    public Texture getBG() {
        return bg;
    }

    public void disp() {
        bg.dispose();
    }
}
