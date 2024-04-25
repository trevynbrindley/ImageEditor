package com.mygdx.imageeditor;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Rec2D {

    public Vector2 Scale;
    public Vector2 Position;
    public Texture RecTexture;
    private Pixmap _pixelMap;
    private Color _recColor;
    public int Width;
    public int Height;
    public int XPositon;
    public int YPosition;

    Texture img;
	Texture imageTwo;
	Pixmap rectangleMap;
	Pixmap otherRectangleMap;

    public Rec2D(Vector2 scale, Vector2 position, Color recColor) {
        Scale = scale;
        Position = position;
        _recColor = recColor;
        generateTexture();
    }

    public void generateTexture() {
        rectangleMap = new Pixmap(50, 500, Format.RGBA8888);
		otherRectangleMap = new Pixmap(300, 50, Format.RGBA8888);
		rectangleMap.setColor(Color.GREEN);
		otherRectangleMap.setColor(Color.BLUE);
		for(int x = 0; x < rectangleMap.getWidth(); x++) {
			for(int y = 0; y < rectangleMap.getHeight(); y++) {
				rectangleMap.drawPixel(x, y);
			}
		}
		for(int x = 0; x < otherRectangleMap.getWidth(); x++) {
			for(int y = 0; y < otherRectangleMap.getHeight(); y++) {
				otherRectangleMap.drawPixel(x, y);
			}
		}
		img = new Texture("Rectangle.png");
		imageTwo = new Texture(otherRectangleMap);
    }

    public void changeColor(Color newColor) {
        _recColor = newColor;
        //Regernate our texture using our new color
        generateTexture();
    }
}