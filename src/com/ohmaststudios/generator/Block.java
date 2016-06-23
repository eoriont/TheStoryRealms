package com.ohmaststudios.generator;

import com.ohmaststudios.engine.Vector2F;
import com.ohmaststudios.assets.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Block extends Rectangle {

    Vector2F pos = new Vector2F();
    public static int BlockSize = 48;
    private BlockType blockType;
    private BufferedImage block;
    private boolean isSolid;
    public boolean isAlive;

    public Block(Vector2F pos, BlockType blockType) {
        setBounds((int) pos.xpos, (int) pos.ypos, BlockSize, BlockSize);
        this.pos = pos;
        isAlive = true;
        this.blockType = blockType;
        init();
    }

    public Block(Vector2F pos) {
        setBounds((int) pos.xpos, (int) pos.ypos, BlockSize, BlockSize);
        this.pos = pos;
        isAlive = true;
    }

    public Block isSolid(boolean isSolid) {
        setBounds((int) pos.xpos, (int) pos.ypos, BlockSize, BlockSize);
        this.isSolid = isSolid;
        return this;
    }

    public void init() {
        switch (blockType) {
            case STONE_1:
                block = Assets.stone1;
                break;
            case WALL_1:
                block = Assets.wall1;
                break;
        }
    }

    public void tick(double deltaTime) {
        if (isAlive) {
            setBounds((int) pos.xpos, (int) pos.ypos, BlockSize, BlockSize);
        }
    }

    public void render(Graphics2D g) {
        if (isAlive) {
            g.drawImage(block, (int) pos.getWorldLocation().xpos, (int) pos.getWorldLocation().ypos, BlockSize, BlockSize, null);
            if (isSolid) {
                g.drawRect((int) pos.getWorldLocation().xpos, (int) pos.getWorldLocation().ypos, BlockSize, BlockSize);
            }
        }
    }

    public enum BlockType {
        STONE_1, WALL_1
    }

    public boolean isSolid() {
        return isSolid;
    }
    public boolean isAlive() {
        return isAlive;
    }
    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
