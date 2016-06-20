package com.ohmaststudios.main;

import com.ohmaststudios.engine.SpriteSheet;
import com.ohmaststudios.engine.loadImageFrom;

import java.awt.image.BufferedImage;

public class Assets {

    SpriteSheet blocks = new SpriteSheet();

    public static BufferedImage stone1, wall_1;

    public void init() {
        blocks.setSpriteSheet(loadImageFrom.LoadImageFrom(this.getClass(), "spritesheet.png"));

        stone1 = blocks.getTile(0, 0, 16, 16);
        wall_1 = blocks.getTile(16, 0, 16, 16);
    }

}
