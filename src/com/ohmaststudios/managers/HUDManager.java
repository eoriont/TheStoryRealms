package com.ohmaststudios.managers;

import com.ohmaststudios.assets.Assets;
import com.ohmaststudios.engine.loadImageFrom;
import com.ohmaststudios.gameloop.GameLoop;
import com.ohmaststudios.generator.Block;
import com.ohmaststudios.generator.TileManager;
import com.ohmaststudios.generator.World;
import com.ohmaststudios.movableObjects.Player;

import java.awt.*;
import java.util.ArrayList;

public class HUDManager {

    private Player player;
    private World world;
    //private ArrayList<Block>

    public HUDManager(Player player, World world) {
        this.player = player;
        this.world = world;
    }

    public void render(Graphics2D g) {
        g.drawImage(Assets.ohmastLogo1, 10, 10, 867, 533, null);

        if(player.isDebug()) {
            g.drawString("[DEBUG WINDOW]", 20, 20);
            g.drawString("(Map Xpos) " + world.getWorldXpos(), 20, 40);
            g.drawString("(Map Ypos) " + world.getWorldYpos(), 20, 60);
            g.drawString("(FPS) " + GameLoop.currFPS, 20, 80);
            //g.drawString("(Blocks Loaded)" + );
        }
    }

}
