package com.ohmaststudios.generator;

import com.ohmaststudios.assets.Assets;
import com.ohmaststudios.engine.loadImageFrom;
import com.ohmaststudios.movableObjects.Player;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Map {

    TileManager tiles = new TileManager();
    Player player = new Player();
    public static BufferedImage map = null;

    public World world1;

    public Map() {

    }

    public void init() {
        try {
            map = loadImageFrom.LoadImageFrom(Assets.class, "map.png");
        } catch (Exception e) {

        }

        world1 = new World("World1", map, 100, 100);
        world1.generateWorld();

    }

    public void tick(double deltaTime) {
        world1.tick(deltaTime);
    }

    public void render(Graphics2D g) {
        world1.render(g);
    }
}
