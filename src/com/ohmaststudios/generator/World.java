package com.ohmaststudios.generator;

import com.ohmaststudios.assets.Assets;
import com.ohmaststudios.engine.Vector2F;
import com.ohmaststudios.engine.loadImageFrom;
import com.ohmaststudios.movableObjects.Player;

import java.awt.*;
import java.awt.image.BufferedImage;

public class World {

    public static Vector2F mapPos = new Vector2F();
    private String worldName;
    private BufferedImage map;
    private int worldWidth, worldHeight;
    private Player player;
    private int idCounter;

    public TileManager tiles;

    private boolean hasSize = false;

    private Block spawn;

    public World(String worldName) {
        this.worldName = worldName;
        Vector2F.setWorldVariables(mapPos.xpos, mapPos.ypos);
    }

    public void init() {
        tiles = new TileManager(this);
        if(player != null) player.init(this);

        mapPos.xpos = spawn.pos.xpos - player.getPos().xpos;
        mapPos.ypos = spawn.pos.ypos - player.getPos().ypos;
    }

    public void tick(double deltaTime) {
        spawn.tick(deltaTime);
        tiles.tick(deltaTime);
        if(player != null) player.tick(deltaTime);
        Vector2F.setWorldVariables(mapPos.xpos, mapPos.ypos);
    }

    public void render(Graphics2D g) {
        tiles.render(g);
        spawn.render(g);
        if(player != null) player.render(g);
    }

    public void generate(String worldImageName) {
        map = null;
        if(hasSize) {
            try{map = loadImageFrom.LoadImageFrom(Assets.class, worldImageName + ".png");}catch(Exception e){}

            for(int x = 0; x < worldWidth; x++) {
                for(int y = 0; y < worldHeight; y++) {
                    int col = map.getRGB(x, y);
                    switch (col & 0xFFFFFF) {
                        case 0x808080:
                            Block thing = new Block(new Vector2F(x*Block.BlockSize, y*Block.BlockSize), Block.BlockType.STONE_1, idCounter++).isSolid(false);
                            tiles.blocks.put(thing.id, thing);
                            break;
                        case 0x404040:
                            Block thing2 = new Block(new Vector2F(x*Block.BlockSize, y*Block.BlockSize), Block.BlockType.WALL_1, idCounter++).isSolid(true);
                            tiles.blocks.put(thing2.id, thing2);
                            break;

                    }
                }
            }
        }
    }

    public void setWorldSpawn(float xpos, float ypos) {
        if(xpos < worldWidth) {
            if(ypos < worldHeight) {
                Block spawn = new Block(new Vector2F(xpos*Block.BlockSize, ypos*Block.BlockSize), idCounter++);
                this.spawn = spawn;
            }
        }
    }

    public void setSize(int worldWidth, int worldHeight) {
        this.worldWidth = worldWidth;
        this.worldHeight = worldHeight;
        hasSize = true;
    }

    public Vector2F getWorldSpawn() {
        return spawn.pos;
    }
    public void addPlayer(Player player) {
        this.player = player;
    }
    public Vector2F getWorldLocation() {
        return mapPos;
    }
    public float getWorldXpos() {
        return mapPos.xpos;
    }
    public float getWorldYpos() {
        return mapPos.ypos;
    }
    public TileManager getTiles() {
        return tiles;
    }
    public Player getPlayer() {
        return player;
    }
}
