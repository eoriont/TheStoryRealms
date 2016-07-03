package com.ohmaststudios.generator;

import com.ohmaststudios.assets.Assets;
import com.ohmaststudios.engine.Vector2F;
import com.ohmaststudios.engine.loadImageFrom;
import com.ohmaststudios.movableObjects.Player;

import java.awt.*;
import java.awt.image.BufferedImage;

public class World {

    private String worldName;
    private BufferedImage map;
    private int worldWidth, worldHeight;
    private Player player;

    private TileManager tiles;

    private boolean hasSize = false;

    public World(String worldName) {
        this.worldName = worldName;
    }

    public void init() {
        tiles = new TileManager();
        if(player != null) player.init(this);
    }

    public void tick(double deltaTime) {
        tiles.tick(deltaTime);
        if(player != null) player.tick(deltaTime);
    }

    public void render(Graphics2D g) {
        tiles.render(g);
        if(player != null) player.render(g);
    }

    public void generate(String worldImageName) {
        map = null;
        if(hasSize) {
            try {
                map = loadImageFrom.LoadImageFrom(Assets.class, worldImageName + ".png");
            } catch (Exception e) {
            }

            for(int x = 0; x < worldWidth; x++) {
                for(int y = 0; y < worldHeight; y++) {
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
    }

    public void setSize(int worldWidth, int worldHeight) {
        this.worldWidth = worldWidth;
        this.worldHeight = worldHeight;
        hasSize = true;
    }

    public void addPlayer(Player player) {
        this.player = player;
    }
}
