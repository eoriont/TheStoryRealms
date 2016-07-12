package com.ohmaststudios.generator;

import com.ohmaststudios.movableObjects.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class TileManager {

    public HashMap<Integer, Block> blocks = new HashMap<Integer, Block>();
    public HashMap<Integer, Block> blocksLoaded = new HashMap<Integer, Block>();
    public int blocksAreAlive;

    private World world;
    private Player player;

    public TileManager(World world) {
        this.world = world;
        player = world.getPlayer();
    }

    public void tick(double deltaTime) {
        if(!player.isDebug()) if(!blocksLoaded.isEmpty()) blocksLoaded.clear();
        for(Block block : blocks.values()) {
            block.tick(deltaTime);
            if (Player.render.intersects(block)) {
                block.setAlive(true);
                if(player.isDebug()) if(!blocksLoaded.containsKey(block.id)) blocksLoaded.put(block.id, block);
            } else {
                block.setAlive(false);
                if(player.isDebug()) if(blocksLoaded.containsKey(block.id)) blocksLoaded.remove(block.id);
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
