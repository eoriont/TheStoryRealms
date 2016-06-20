package com.ohmaststudios.engine;

import java.awt.image.BufferedImage;

public class SpriteSheet {
    public BufferedImage spriteSheet;

    public SpriteSheet() {

    }

    public void setSpriteSheet(BufferedImage spriteSheet) {
        this.spriteSheet = spriteSheet;
    }
    public BufferedImage getTile(int xTile, int yTile, int width, int height) {
        BufferedImage sprite = spriteSheet.getSubimage(xTile, yTile, width, height);
        return sprite;
    }
}
