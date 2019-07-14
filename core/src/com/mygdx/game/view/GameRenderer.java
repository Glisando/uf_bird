package com.mygdx.game.view;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.helpers.GameInfo;
import com.mygdx.game.model.GameModel;
import com.mygdx.game.model.Bird;
import com.mygdx.game.model.Background;
import com.mygdx.game.controller.GameMain;
import com.mygdx.game.model.Tubes;

public class GameRenderer {
    public void render(GameModel GameData, SpriteBatch batch) {
        GameData.render(batch);
    }
}
