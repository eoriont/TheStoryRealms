package com.ohmaststudios.generator;

import com.ohmaststudios.movableObjects.Player;

import java.awt.*;
import java.util.ArrayList;

public class TileManager {

    public static ArrayList<Block> blocks = new ArrayList<Block>();

    public TileManager() {

    }

    public void tick(double deltaTime) {
        for(Block block : blocks) {
            block.tick(deltaTime);
            block.setAlive(Player.render.intersects(block));
        }
    }

    public void render(Graphics2D g) {
        for(Block block : blocks) {
            block.render(g);
        }
    }

}
