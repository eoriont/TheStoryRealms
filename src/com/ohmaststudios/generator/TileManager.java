package com.ohmaststudios.generator;

import com.ohmaststudios.movableObjects.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class TileManager {

    public static HashMap<Integer, Block> blocks = new HashMap<Integer, Block>();
    public static HashMap<Integer, Block> blocksLoaded = new HashMap<Integer, Block>();
    public static int blocksAreAlive;

    private World world;

    public TileManager(World world) {
        this.world = world;
    }

    public void tick(double deltaTime) {
        if(!world.getPlayer().isDebug()) if(!blocksLoaded.isEmpty()) blocksLoaded.clear();
        for(Block block : blocks.values()) {
            block.tick(deltaTime);
            if (Player.render.intersects(block)) {
                block.setAlive(true);
                if(Player.isDebug()) if(!blocksLoaded.containsKey(block.id)) blocksLoaded.put(block.id, block);
            } else {
                block.setAlive(false);
                if(Player.isDebug()) if(blocksLoaded.containsKey(block.id)) blocksLoaded.remove(block.id);
            }
        }
    }

    public void render(Graphics2D g) {
        blocksAreAlive = 0;
        for(Block block : blocks.values()) {
            if(block.isAlive) {
                blocksAreAlive++;
                block.render(g);
            }
        }
    }
}
