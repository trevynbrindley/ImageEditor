package com.mygdx.imageeditor;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import java.util.Random;

public class ImageEditor extends ApplicationAdapter {
	SpriteBatch batch;
	Button button1;
	Button button2;
	private Vector2 _screenSize;
	public Vector2 ScreenSize;
	public static CollisionManager Instance;

	@Override
	public void create () {
		batch = new SpriteBatch();
		_screenSize = new Vector2(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		InputManager inputManager = new InputManager();
		Gdx.input.setInputProcessor(inputManager);
		Vector2 rectangleScale = new Vector2(100, 50);
		button1 = new Button(rectangleScale, new Vector2(ScreenSize.x / 2f - rectangleScale.x * 2, ScreenSize.y / 2f - rectangleScale.y / 2f), Color.ORANGE);
		button2 = new Button(rectangleScale, new Vector2(ScreenSize.x / 2f + rectangleScale.x, ScreenSize.y / 2f - rectangleScale.y / 2f), Color.GREEN);
		CollisionManager collisionManager = new CollisionManager(button1, button2);
	}

	@Override
	public void render() {
		ScreenUtils.clear(0f, 0f, 0f, 1);
		batch.begin();
		batch.draw(button1.RecTexture, button1.Position.x, button1.Position.y);
		batch.draw(button2.RecTexture, button2.Position.x, button2.Position.y);
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
	}
}
