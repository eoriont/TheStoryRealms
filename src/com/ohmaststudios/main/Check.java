package com.ohmaststudios.main;

import com.ohmaststudios.generator.Block;
import com.ohmaststudios.generator.TileManager;

import java.awt.*;

public class Check {

    public static boolean CollisionPlayerBlock(Point p1, Point p2) {
        for(Block block : TileManager.blocks) {
            if(block.isSolid()) {
                if(block.contains(p1) || block.contains(p2)) {
                    return true;
                }
            }
        }
        return false;
    }

}
