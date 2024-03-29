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
	Rec2D rectangle;
	private Vector2 _screenSize;

	@Override
	public void create () {
		batch = new SpriteBatch();
		_screenSize = new Vector2(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		rectangle = new Rec2D(new Vector2(200, 100), new Vector2(200,200), new Vector2(5, 0), Color.RED);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0f, 0f, 0f, 1);
		batch.begin();
		batch.draw(rectangle.RecTexture, rectangle.Position.x, rectangle.Position.y);
		if(rectangle.Position.x < _screenSize.x){
			rectangle.Velocity.x *= -1;
		}
		Random random = new Random();
		rectangle.changeColor(new Color(random.nextFloat(), random.nextFloat(), random.nextFloat(), 1));
		rectangle.Position.add(rectangle.Velocity);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
