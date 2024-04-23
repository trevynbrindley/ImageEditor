package com.mygdx.imageeditor;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Button extends Rec2D implements IClickable, IHoverable {

    
    private static int _buttonCount;
    private int _buttonNumber;
    private Color _startColor;
    protected Color _recColor;
    public enum ButtonState {Clicked, Hovered, None};
    private ButtonState _state;
    public Button(Vector2 scale, Vector2 position, Color recColor) {
        super(scale, position, recColor);
        _startColor = recColor;
        _buttonCount +=1;
        _buttonNumber = _buttonCount;

    }

    public void onHovered() {
        _recColor = new Color(_recColor.r / 2f, _recColor.g / 2f , _recColor.b / 2f, 1);
        generateTexture();
    }

    public void onHoverExit() {
        _recColor = _startColor;
        generateTexture();
    }

    public void add(){

    }
}
