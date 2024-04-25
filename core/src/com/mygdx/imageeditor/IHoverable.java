package com.mygdx.imageeditor;

public interface IHoverable {
    public void onHovered();
    public void onHoverExit();

    public default IHoverable getHovered(Vector2 coordinates) {
        Rec2D hovered;
        /* 
        for(int i = 0; i < InputManager.Instance.Hoverables.size; i++) {
        hovered = (Rec2D) InputManager.Instance.Hoverables.get(i);
        if(coordinates.x > hovered.Position.x && coordinates.x < hovered.Position.x + hovered.Scale.x) {
        if(coordinates.y > hovered.Position.y && coordinates.y < hovered.Position.y + hovered.Scale.y)
        return (IHoverable) hovered;
        */
        
        
        return null;
    }
}
