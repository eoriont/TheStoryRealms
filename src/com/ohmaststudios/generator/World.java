package com.ohmaststudios.generator;

import com.ohmaststudios.engine.Vector2F;
import com.ohmaststudios.movableObjects.Player;

import java.awt.*;
import java.awt.image.BufferedImage;

public class World {

    private String worldName;
    private BufferedImage worldImage;
    private int worldWidth, worldHeight;

    private TileManager tiles = new TileManager();
    private Player player = new Player();

    public World(String worldName, BufferedImage worldImage, int worldWidth, int worldHeight) {
        this.worldName = worldName;
        this.worldImage = worldImage;
        this.worldHeight = worldHeight;
        this.worldWidth = worldWidth;
    }

    public void generateWorld() {
        for(int x = 0; x < worldWidth; x++) {
            for(int y = 0; y < worldHeight; y++) {
                int col = worldImage.getRGB(x, y);
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
        player.init(this);
    }

    public void tick(double deltaTime) {
        tiles.tick(deltaTime);
        player.tick(deltaTime);
    }

    public void render(Graphics2D g) {
        tiles.render(g);
        player.render(g);
    }

    public String getWorldName() {
        return worldName;
    }
    public BufferedImage getWorldImage() {
        return worldImage;
    }
}
