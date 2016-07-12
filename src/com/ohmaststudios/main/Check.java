package com.ohmaststudios.main;

import com.ohmaststudios.generator.Block;
import com.ohmaststudios.generator.TileManager;
import com.ohmaststudios.generator.World;

import java.awt.*;

public class Check {
    public static boolean CollisionPlayerBlock(Point p1, Point p2, World world) {
        for(Block block : world.tiles.blocks.values()) {
            if(block.isSolid()) {
                if(block.contains(p1) || block.contains(p2)) {
                    return true;
                }
            }
        }
        return false;
    }

}
