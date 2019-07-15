package com.mygdx.game.helpers;

import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class GameInfo {
    public static final float WIDTH = Gdx.graphics.getWidth();
    public static final float HEIGHT = Gdx.graphics.getHeight();
    public static final float TUBE_HEIGHT = HEIGHT * 0.7f;
    public static final float TUBE_WIDTH = WIDTH * 0.15f;
    public static final float BIRD_HEIGHT = HEIGHT * 0.05f;
    public static final float BIRD_WIDTH = WIDTH * 0.11f;
    public static float SPEED = -3f;
    public static final Music music = Gdx.audio.newMusic(Gdx.files.internal("marios_way.mp3"));
    public static final Sound jump = Gdx.audio.newSound(Gdx.files.internal("jump.wav"));
    public static final Sound score = Gdx.audio.newSound(Gdx.files.internal("score.wav"));
    public static final Sound explosion = Gdx.audio.newSound(Gdx.files.internal("explosion.wav"));
    public static final BitmapFont font = new BitmapFont(Gdx.files.internal("scoreFont.fnt"), false);
}
