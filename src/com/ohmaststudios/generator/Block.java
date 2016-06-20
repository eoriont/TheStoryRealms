package com.ohmaststudios.generator;

import com.ohmaststudios.engine.Vector2F;
import com.ohmaststudios.main.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Block extends Rectangle {

    Vector2F pos = new Vector2F();
    public static int BlockSize = 48;
    private BlockType blockType;
    private BufferedImage block;
    private boolean isSolid;

    public Block(Vector2F pos, BlockType blockType) {
        setBounds((int) pos.xpos, (int) pos.ypos, BlockSize, BlockSize);
        this.pos = pos;
        this.blockType = blockType;
        init();
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
                block = Assets.wall_1;
                break;
        }
    }

    public void tick(double deltaTime) {

    }

    public void render(Graphics2D g) {
        g.drawImage(block, (int) pos.getWorldLocation().xpos, (int) pos.getWorldLocation().ypos, BlockSize, BlockSize, null);
        if(isSolid) {
            g.drawRect((int) pos.getWorldLocation().xpos, (int) pos.getWorldLocation().ypos, BlockSize, BlockSize);
        }
    }

    public boolean isSolid() {
        return isSolid;
    }

    public enum BlockType {
        STONE_1, WALL_1
    }

}
