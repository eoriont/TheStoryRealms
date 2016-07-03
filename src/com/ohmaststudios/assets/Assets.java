package com.ohmaststudios.assets;

import com.ohmaststudios.engine.SpriteSheet;
import com.ohmaststudios.engine.loadImageFrom;

import java.awt.image.BufferedImage;

public class Assets {

    private SpriteSheet blocks = new SpriteSheet();
    private SpriteSheet widgets = new SpriteSheet();

    public static BufferedImage stone1, wall1;
    public static BufferedImage mouse1, mouse2;
    public static BufferedImage newBlock;

    public void init() {
        blocks.setSpriteSheet(loadImageFrom.LoadImageFrom(this.getClass(), "spritesheet.png"));
        widgets.setSpriteSheet(loadImageFrom.LoadImageFrom(this.getClass(), "GUI/widgets.png"));

        stone1 = blocks.getTile(0, 0, 16, 16);
        wall1 = blocks.getTile(16, 0, 16, 16);

        mouse1 = widgets.getTile(0, 0, 5, 5);
        mouse2 = widgets.getTile(14, 0, 5, 5);

        newBlock = blocks.getTile(0, 32, 16, 16);
    }

}
