package com.ohmaststudios.generator;

import com.ohmaststudios.movableObjects.Player;

import java.awt.*;
import java.util.ArrayList;

public class TileManager {

    public static ArrayList<Block> blocks = new ArrayList<Block>();
    public static int blocksAreAlive;

    public TileManager() {

    }

    public void tick(double deltaTime) {

        for(Block block : blocks) {
            block.tick(deltaTime);
            block.setAlive(Player.render.intersects(block));
        }
    }

    public void render(Graphics2D g) {

        blocksAreAlive = 0;

        for(Block block : blocks) {
            if(block.isAlive) {
                blocksAreAlive++;
                block.render(g);
            }
        }
    }

}
