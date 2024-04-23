package com.mygdx.imageeditor;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class EditWindow extends Button {
    public Texture DoodleTexture;
    private Pixmap _doodleMap;

    public EditWindow(Vector2 scale, Vector2 position, Color backgroundColor) {
        super(scale, position, backgroundColor);
        _doodleMap = new Pixmap((int) scale.x, (int) scale.y, Format.RGBA8888);
        _doodleMap.setColor(Color.ORANGE);
        DoodleTexture = new Texture(_doodleMap);
    }

    @Override
    public void onClickDragged(Vector2 clickPosition) {
        mouseMoved(screenX, screenY);
        if (_currentlyClicked != null)
            _currentlyClicked.onClickDragged(new Vector2(screenX, ImageEditor.Instance.ScreenSize.y - screenY));
    }

    private void paintAtPosition(Vector2 worldPosition) {
        _doodleMap.drawPixel((int) (worldPosition.x - Position.x), (int) (Scale.y - worldPosition.y));
        DoodleTexture = new Texture(_doodleMap);
    }

    public void onClickDragged(Vector2 clickPosition) {
        paintAtPosition(mousePosition);
    }

    public void onClickDown(Vector2 clickPosition) {
        paintAtPosition(position);
    }

    public void onClickDown(Vector2 clickPosition) {
        System.out.println("Clicked on the Edit Window");
        _doodleMap.drawPixel((int) (Position.x - Position.x), (int) (Scale.y - position.y));
        DoodleTexture = new Texture(_doodleMap);
    }

    @Override
    public void onClickUp(Vector2 mousePosition) {
        // TODO Auto-generated method stub
    }
}
