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
	private Vector2 _screenSize;
	public Vector2 ScreenSize;
	public static CollisionManager Instance;
	private EditWindow _editWindow;

	@Override
	public void create() {
		batch = new SpriteBatch();
		_screenSize = new Vector2(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		InputManager inputManager = new InputManager();
		Gdx.input.setInputProcessor(inputManager);
		Vector2 editWindowSize = new Vector2(500, ScreenSize.y - 50);
		_editWindow = new EditWindow(
				editWindowSize, new Vector2(ScreenSize.x - editWindowSize.x, 0), Color.GRAY);
		CollisionManager collisionManager = new CollisionManager();
	}

	@Override
	public void render() {
		ScreenUtils.clear(0f, 0f, 0f, 1);
		Rec2D rec;
		for (int i = 0; i < Rectangles.size; i++) {
			rec = Rectangles.get(i);
			batch.draw(rec.RecTexture, rec.Position.x, rec.Position.y, rec.Scale.x, rec.Scale.y);
		}
		batch.draw(_editWindow.DoodleTexture, _editWindow.Position.x,
			_editWindow.Position.y, _editWindow.Scale.x, _editWindow.Scale.y);
	}

	@Override
	public void dispose() {
		batch.dispose();
	}
}
