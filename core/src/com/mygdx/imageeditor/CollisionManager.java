package com.mygdx.imageeditor;

import com.badlogic.gdx.math.Vector2;

public class CollisionManager {
    private Rec2D _recOne, _recTwo;
    public static CollisionManager Instance;
    

    public CollisionManager(Rec2D recOne, Rec2D recTwo) {
        _recOne = recOne;
        _recTwo = recTwo;
        Instance = this;
    }

    public Rec2D getCollision(Vector2 coordinates) {
        Button iteratingButton;
        for(int i = 0; i < InputManager.Instance.Buttons.size; i++) {
            iteratingButton = InputManager.Instance.Buttons.get(i);
        }
        // Check to see if we collided with _recOne
        if (coordinates.x > _recOne.Position.x) {
            return _recOne;
        }
        // Check to see if we collided with _recTwo
        if (coordinates.x > _recTwo.Position.x) {
            return _recTwo;
        }

        return null;
    }
}
