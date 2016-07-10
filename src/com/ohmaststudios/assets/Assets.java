package com.ohmaststudios.assets;

import com.ohmaststudios.engine.SpriteSheet;
import com.ohmaststudios.engine.loadImageFrom;

import java.awt.image.BufferedImage;

public class Assets {

    private SpriteSheet blocks = new SpriteSheet();
    private SpriteSheet widgets = new SpriteSheet();

    public static BufferedImage ohmastLogo1;
    public static BufferedImage stone1, wall1;
    public static BufferedImage mouse1, mouse2, mouse3, mouse4;
    public static BufferedImage newBlock;
    public static BufferedImage button1, button2;

    public void init() {
        blocks.setSpriteSheet(loadImageFrom.LoadImageFrom(this.getClass(), "spritesheet.png"));
        widgets.setSpriteSheet(loadImageFrom.LoadImageFrom(this.getClass(), "GUI/widgets.png"));

        ohmastLogo1 = loadImageFrom.LoadImageFrom(this.getClass(), "Ohmast-Logo.png");

        stone1 = blocks.getTile(0, 0, 16, 16);
        wall1 = blocks.getTile(16, 0, 16, 16);

        mouse1 = widgets.getTile(0, 0, 5, 5);
        mouse2 = widgets.getTile(0, 5, 5, 5);
        mouse3 = widgets.getTile(5, 0, 5, 5);
        mouse4 = widgets.getTile(5, 5, 5, 5);

        newBlock = blocks.getTile(0, 32, 16, 16);

        button1 = widgets.getTile(28, 14, 44, 14);
        button2 = widgets.getTile(28, 28, 44, 14);
    }

}
