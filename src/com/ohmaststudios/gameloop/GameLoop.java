package com.ohmaststudios.gameloop;

import com.ohmaststudios.engine.OGameLoop;
import com.ohmaststudios.gamestate.GameStateManager;
import com.ohmaststudios.assets.Assets;
import com.ohmaststudios.managers.MouseManager;

import java.awt.event.*;

public class GameLoop extends OGameLoop implements KeyListener {
    public GameStateManager gsm;
    public Assets assets = new Assets();

    public GameLoop(int fwidth, int fheight) {
        super(fwidth, fheight);
    }

    @Override
    public void init() {
        assets.init();
        gsm = new GameStateManager();
        gsm.init();
        super.init();
    }

    @Override
    public void tick(double deltaTime) {
        gsm.states.peek().mm.tick();
        gsm.tick(deltaTime);
    }

    public void render() {
        super.render();
        gsm.render(graphics2D);
        gsm.states.peek().mm.render(graphics2D);
        clear();
    }

    @Override
    public void clear() {
        super.clear();
    }

    ////////////////////////////////////////////////

    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {
        gsm.states.peek().keyPressed(e);
    }
    @Override
    public void keyReleased(KeyEvent e) {
        gsm.states.peek().keyReleased(e);
    }

}
