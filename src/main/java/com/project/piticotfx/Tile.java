package com.project.piticotfx;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {

    public Tile(int x, int y){
        setWidth(Piticot.tile_size);
        setHeight((Piticot.tile_size));

        setFill(Color.BLUE);
        setStroke(Color.BLACK);
    }
}
