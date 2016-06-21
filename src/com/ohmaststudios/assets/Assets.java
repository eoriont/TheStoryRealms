package com.ohmaststudios.assets;

import com.ohmaststudios.engine.SpriteSheet;
import com.ohmaststudios.engine.loadImageFrom;

import java.awt.image.BufferedImage;

public class Assets {

    private SpriteSheet blocks = new SpriteSheet();

    public static BufferedImage stone1, wall1;

    public void init() {
        blocks.setSpriteSheet(loadImageFrom.LoadImageFrom(this.getClass(), "spritesheet.png"));

        stone1 = blocks.getTile(0, 0, 16, 16);
        wall1 = blocks.getTile(16, 0, 16, 16);
    }

}
