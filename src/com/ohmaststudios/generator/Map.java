package com.ohmaststudios.generator;

import com.ohmaststudios.assets.Assets;
import com.ohmaststudios.engine.Vector2F;
import com.ohmaststudios.engine.loadImageFrom;
import com.ohmaststudios.movableObjects.Player;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Map {

    TileManager tiles = new TileManager();
    Player player = new Player();

    public Map() {

    }

    public void init() {
        player.init();

        BufferedImage map = null;
        try {
            map = loadImageFrom.LoadImageFrom(Assets.class, "map.png");
        } catch (Exception e) {

        }

        for(int x = 0; x < 100; x++) {
            for(int y = 0; y < 100; y++) {
                int col = map.getRGB(x, y);
                switch (col & 0xFFFFFF) {
                    case 0x808080:
                        tiles.blocks.add(new Block(new Vector2F(x*Block.BlockSize, y*Block.BlockSize), Block.BlockType.STONE_1).isSolid(false));
                        break;
                    case 0x404040:
                        tiles.blocks.add(new Block(new Vector2F(x*Block.BlockSize, y*Block.BlockSize), Block.BlockType.WALL_1).isSolid(true));
                        break;
                }
            }
        }
    }

    public void tick(double deltaTime) {
        tiles.tick(deltaTime);
        player.tick(deltaTime);
    }

    public void render(Graphics2D g) {
        tiles.render(g);
        player.render(g);
    }
}
