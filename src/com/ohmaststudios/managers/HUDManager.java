package com.ohmaststudios.managers;

import com.ohmaststudios.assets.Assets;
import com.ohmaststudios.engine.loadImageFrom;
import com.ohmaststudios.main.Game;
import com.ohmaststudios.movableObjects.Player;

import java.awt.*;

public class HUDManager {

    private Player player;

    public HUDManager(Player player) {
        this.player = player;
    }

    public void render(Graphics2D g) {
        g.setColor(Color.BLACK);
       // g.fillRect(0, 0, Game.width, Game.height / 7);
       // g.fillRect(0, (Game.height / 7) * 6, Game.width, Game.height / 7);
        g.setColor(Color.WHITE);
        g.drawString("PLAYER POS: x:" + (int) (player.getPos().getWorldLocation().xpos + player.getPos().xpos) + " y:" + (int) (player.getPos().getWorldLocation().ypos + player.getPos().ypos), 1000, 100);
        g.drawImage(loadImageFrom.LoadImageFrom(Assets.class, "Ohmast-Logo.png"), 10, 10, 867, 533, null);
    }

}
