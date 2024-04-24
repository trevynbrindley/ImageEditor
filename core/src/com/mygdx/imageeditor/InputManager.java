package com.mygdx.imageeditor;

import java.io.IOException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.graphics.Color;

public class InputManager implements InputProcessor {
    public CollisionManager Instance;
    public Array<Button> Buttons = new Array<Button>();
    private boolean _controlPressed;

    public boolean keyDown(int keycode) {
        if (_controlPressed && keycode == Keys.S) {
            try {
                ImageInputOutput.Instance.saveImage("PATHTOYOURDESKTOP!!!!!\\test.bmp");
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("YOU PRESSED CONTROL + S!");
        }
        if (keycode == Keys.CONTROL_LEFT) {
            _controlPressed = true;
            return false;
        }
    }

    public boolean keyUp(int keycode) {
        if (keycode == Keys.CONTROL_LEFT)
            _controlPressed = false;
        return false;
    }

    public boolean keyTyped(char character) {
        return false;
    }

    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        CollisionManager.Instance.getCollision(new Vector2(screenX, screenY));
        Vector2 _screenSize = new Vector2(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Vector2 rectangleScale = new Vector2(100, 50);
        Rec2D rectangle = new Rec2D(
                rectangleScale,
                new Vector2(_screenSize.x / 2f - rectangleScale.x * 2, _screenSize.y / 2f - rectangleScale.y / 2f),
                Color.ORANGE);
        Rec2D rectangleTwo = new Rec2D(
                rectangleScale,
                new Vector2(_screenSize.x / 2f - rectangleScale.x, _screenSize.y / 2f - rectangleScale.y / 2f),
                Color.GREEN);
        Rec2D collision = CollisionManager.Instance
                .getCollision(new Vector2(screenX, ImageEditor.ScreenSize.y - screenY));
        if (collision == ImageEditor.Instance.button1)
            System.out.println("Pressed button 1");
        else if (collision == ImageEditor.Instance.button2)
            System.out.println("Pressed button 2");
        return true;
    }

    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    public boolean mouseMoved(int screenX, int screenY) {
        return true;
    }

    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
