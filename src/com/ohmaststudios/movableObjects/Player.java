package com.ohmaststudios.movableObjects;

import com.ohmaststudios.engine.Vector2F;
import com.ohmaststudios.gameloop.GameLoop;
import com.ohmaststudios.gamestate.GameState;
import com.ohmaststudios.gamestate.GameStateButton;
import com.ohmaststudios.gamestate.GameStateManager;
import com.ohmaststudios.gamestates.QuitState;
import com.ohmaststudios.generator.World;
import com.ohmaststudios.main.Check;
import com.ohmaststudios.main.Game;
import com.ohmaststudios.managers.GUIManager;
import com.ohmaststudios.managers.HUDManager;
import com.ohmaststudios.managers.MouseManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player {

    Vector2F pos;
    private int width = 42;
    private int height = 42;
    private boolean up, down, left, right;
    private float slowdown = 4.093f, maxSpeed = 3*32f;
    private float fixDt = 1f/60f;
    private float speedUp = 0, speedDown = 0, speedRight = 0, speedLeft = 0;
    private boolean mapMove = true;
    private boolean debug = false;
    private World world;
    private GameStateManager gsm;

    //RENDER
    private int renderDistanceW = 60;
    private int renderDistanceH = 34;
    public static Rectangle render;

    private HUDManager hudm;
    private GUIManager guim;
    private MouseManager playermMM = new MouseManager();

    public Player () {
        pos = new Vector2F(Game.width / 2 - width / 2, Game.height / 2 - height / 2);
    }

    public void init (World world) {
        hudm = new HUDManager(this, world);
        guim = new GUIManager();
        this.world = world;
        render = new Rectangle(
                (int) (pos.xpos - pos.getWorldLocation().xpos + pos.xpos - renderDistanceW * 32 / 2 + width / 2),
                (int) (pos.ypos - pos.getWorldLocation().ypos + pos.ypos - renderDistanceH * 32 / 2 + height / 2),
                renderDistanceW*32, renderDistanceH*32);
    }

    public void tick (double deltaTime) {
        playermMM.tick();

        render = new Rectangle(
                (int) (pos.xpos - pos.getWorldLocation().xpos + pos.xpos - renderDistanceW * 32 / 2 + width / 2),
                (int) (pos.ypos - pos.getWorldLocation().ypos + pos.ypos - renderDistanceH * 32 / 2 + height / 2),
                renderDistanceW*32, renderDistanceH*32);

        float moveAmountU = speedUp * fixDt;
        float moveAmountD = speedDown * fixDt;
        float moveAmountL = speedLeft * fixDt;
        float moveAmountR = speedRight * fixDt;
        if (mapMove) {
            if (this.up) {
                moveMapUp(moveAmountU);
            } else {
                moveMapUpGlide(moveAmountU);
            }
            if (down) {
                moveMapDown(moveAmountD);
            } else {
                moveMapDownGlide(moveAmountD);
            }
            if (right) {
                moveMapRight(moveAmountR);
            } else {
                moveMapRightGlide(moveAmountR);
            }
            if (left) {
                moveMapLeft(moveAmountL);
            } else {
                moveMapLeftGlide(moveAmountL);
            }
        }
    }

    public void moveMapUp(float speed) {
        if (!Check.CollisionPlayerBlock(
                new Point((int) (pos.xpos + world.mapPos.xpos),
                        (int) (pos.ypos + world.mapPos.ypos - speed)),
                new Point((int) (pos.xpos + world.mapPos.xpos + width),
                        (int) (pos.ypos + world.mapPos.ypos - speed)), world)) {
            if (speedUp < maxSpeed) {
                speedUp += slowdown;
            } else {
                speedUp = maxSpeed;
            }
            world.mapPos.ypos -= speed;
        } else {
            speedUp = 0;
        }
    }
    public void moveMapUpGlide(float speed) {
        if (!Check.CollisionPlayerBlock(
                new Point((int) (pos.xpos + world.mapPos.xpos),
                        (int) (pos.ypos + world.mapPos.ypos - speed)),
                new Point((int) (pos.xpos + world.mapPos.xpos + width),
                        (int) (pos.ypos + world.mapPos.ypos - speed)), world)) {
            if (speedUp != 0) {
                speedUp -= slowdown;
                if (speedUp < 0) {
                    speedUp = 0;
                }
            }
            world.mapPos.ypos -= speed;
        } else {
            speedUp = 0;
        }
    }
    public void moveMapDown(float speed) {
        if (!Check.CollisionPlayerBlock(
                new Point((int) (pos.xpos + world.mapPos.xpos),
                        (int) (pos.ypos + world.mapPos.ypos + height + speed)),
                new Point((int) (pos.xpos + world.mapPos.xpos + width),
                        (int) (pos.ypos + world.mapPos.ypos + height + speed)), world)) {
            if (speedDown < maxSpeed) {
                speedDown += slowdown;
            } else {
                speedDown = maxSpeed;
            }
            world.mapPos.ypos += speed;
        } else {
            speedDown = 0;
        }
    }
    public void moveMapDownGlide(float speed) {
        if (!Check.CollisionPlayerBlock(
                new Point((int) (pos.xpos + world.mapPos.xpos),
                        (int) (pos.ypos + world.mapPos.ypos + height + speed)),
                new Point((int) (pos.xpos + world.mapPos.xpos + width),
                        (int) (pos.ypos + world.mapPos.ypos + height + speed)), world)) {
            if (speedDown != 0) {
                speedDown -= slowdown;
                if (speedDown < 0) {
                    speedDown = 0;
                }
            }
            world.mapPos.ypos += speed;
        } else {
            speedDown = 0;
        }
    }
    public void moveMapRight(float speed) {
        if (!Check.CollisionPlayerBlock(
                new Point((int) (pos.xpos + world.mapPos.xpos + width + speed),
                        (int) (pos.ypos + world.mapPos.ypos)),
                new Point((int) (pos.xpos + world.mapPos.xpos + width + speed),
                        (int) (pos.ypos + world.mapPos.ypos + height)), world)) {
            if (speedRight < maxSpeed) {
                speedRight += slowdown;
            } else {
                speedRight = maxSpeed;
            }
            world.mapPos.xpos += speed;
        } else {
            speedRight = 0;
        }
    }
    public void moveMapRightGlide(float speed) {
        if (!Check.CollisionPlayerBlock(
                new Point((int) (pos.xpos + world.mapPos.xpos + width + speed),
                        (int) (pos.ypos + world.mapPos.ypos)),
                new Point((int) (pos.xpos + world.mapPos.xpos + width + speed),
                        (int) (pos.ypos + world.mapPos.ypos + height)), world)) {
            if (speedRight != 0) {
                speedRight -= slowdown;
                if (speedRight < 0) {
                    speedRight = 0;
                }
            }
            world.mapPos.xpos += speed;
        } else {
            speedRight = 0;
        }
    }
    public void moveMapLeft(float speed) {
        if (!Check.CollisionPlayerBlock(
                new Point((int) (pos.xpos + world.mapPos.xpos - speed),
                        (int) (pos.ypos + world.mapPos.ypos + height)),
                new Point((int) (pos.xpos + world.mapPos.xpos - speed),
                        (int) (pos.ypos + world.mapPos.ypos)), world)) {
            if (speedLeft < maxSpeed) {
                speedLeft += slowdown;
            } else {
                speedLeft = maxSpeed;
            }
            world.mapPos.xpos -= speed;
        } else {
            speedLeft = 0;
        }
    }
    public void moveMapLeftGlide(float speed) {
        if (!Check.CollisionPlayerBlock(
                new Point((int) (pos.xpos + world.mapPos.xpos - speed),
                        (int) (pos.ypos + world.mapPos.ypos + height)),
                new Point((int) (pos.xpos + world.mapPos.xpos - speed),
                        (int) (pos.ypos + world.mapPos.ypos)), world)) {
            if (speedLeft != 0) {
                speedLeft -= slowdown;
                if (speedLeft < 0) {
                    speedLeft = 0;
                }
            }
            world.mapPos.xpos -= speed;
        } else {
            speedLeft = 0;
        }
    }

    public void render(Graphics2D g) {
        g.fillRect((int) pos.xpos, (int) pos.ypos, width, height);
        guim.render(g);
        hudm.render(g);
        playermMM.render(g);
    }

    //////////////////////////

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_W) {
            this.up = true;
        }
        if(key == KeyEvent.VK_S) {
            down = true;
        }
        if(key == KeyEvent.VK_A) {
            left = true;
        }
        if(key == KeyEvent.VK_D) {
            right = true;
        }
        if(key == KeyEvent.VK_ESCAPE) {
            System.exit(1);
        }
        if(key == KeyEvent.VK_F3) {
            debug = !debug;
        }
        if(key == KeyEvent.VK_SHIFT) {
            fixDt = 1f/60f * 2;
        }

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_W) {
            this.up = false;
        }
        if(key == KeyEvent.VK_S) {
            down = false;
        }
        if(key == KeyEvent.VK_A) {
            left = false;
        }
        if(key == KeyEvent.VK_D) {
            right = false;
        }
        if(key == KeyEvent.VK_SHIFT) {
            fixDt = 1f/60f;
        }
    }

    //////////////////////////


    public Vector2F getPos() {
        return pos;
    }
    public float getMaxSpeed() {
        return maxSpeed;
    }
    public float getSlowdown() {
        return slowdown;
    }
    public boolean isDebug() {
        return debug;
    }
    public World getWorld() {
        return world;
    }
}
