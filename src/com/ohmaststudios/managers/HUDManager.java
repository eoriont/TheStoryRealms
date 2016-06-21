package com.ohmaststudios.managers;

import com.ohmaststudios.assets.Assets;
import com.ohmaststudios.engine.loadImageFrom;
import com.ohmaststudios.movableObjects.Player;

import java.awt.*;

public class HUDManager {

    private Player player;

    public HUDManager(Player player) {
        this.player = player;
    }

    public void render(Graphics2D g) {
        try {g.drawImage(loadImageFrom.LoadImageFrom(Assets.class, "Ohmast-Logo.png"), 10, 10, 867, 533, null);} catch (Exception e) {}
    }

}
