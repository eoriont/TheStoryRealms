package com.ohmaststudios.movableObjects;

import com.ohmaststudios.engine.Vector2F;
import com.ohmaststudios.gameloop.GameLoop;
import com.ohmaststudios.main.Check;
import com.ohmaststudios.main.Game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player implements KeyListener {

    Vector2F pos;
    private int width = 42;
    private int height = 42;
    private static boolean up, down, left, right;
    private float slowdown = 4.093f, maxSpeed = 3*32f;
    private float fixDt = 1f/60f;
    private float speedUp = 0, speedDown = 0, speedRight = 0, speedLeft = 0;
    private boolean mapMove = true;

    //RENDER
    private int renderDistanceW = Game.width;
    private int renderDistanceH = Game.height;
    public static Rectangle render;

    public Player () {
        pos = new Vector2F(Game.width / 2 - width / 2, Game.height / 2 - height / 2);
    }

    public void init () {
        render = new Rectangle(
                (int) (pos.xpos - pos.getWorldLocation().xpos + pos.xpos - renderDistanceW * 32 / 2 + width / 2),
                (int) (pos.ypos - pos.getWorldLocation().ypos + pos.ypos - renderDistanceH * 32 / 2 + height / 2),
                renderDistanceW*32, renderDistanceH*32);
    }

    public void tick (double deltaTime) {
        render = new Rectangle(
                (int) (pos.xpos - pos.getWorldLocation().xpos + pos.xpos - renderDistanceW * 32 / 2 + width / 2),
                (int) (pos.ypos - pos.getWorldLocation().ypos + pos.ypos - renderDistanceH * 32 / 2 + height / 2),
                renderDistanceW*32, renderDistanceH*32);

        float moveAmountU = speedUp * fixDt;
        float moveAmountD = speedDown * fixDt;
        float moveAmountL = speedLeft * fixDt;
        float moveAmountR = speedRight * fixDt;
        if (mapMove) {
            if (up) {
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
                new Point((int) (pos.xpos + GameLoop.map.xpos),
                        (int) (pos.ypos + GameLoop.map.ypos - speed)),
                new Point((int) (pos.xpos + GameLoop.map.xpos + width),
                        (int) (pos.ypos + GameLoop.map.ypos - speed)))) {
            if (speedUp < maxSpeed) {
                speedUp += slowdown;
            } else {
                speedUp = maxSpeed;
            }
            GameLoop.map.ypos -= speed;
        } else {
            speedUp = 0;
        }
    }
    public void moveMapUpGlide(float speed) {
        if (!Check.CollisionPlayerBlock(
                new Point((int) (pos.xpos + GameLoop.map.xpos),
                        (int) (pos.ypos + GameLoop.map.ypos - speed)),
                new Point((int) (pos.xpos + GameLoop.map.xpos + width),
                        (int) (pos.ypos + GameLoop.map.ypos - speed)))) {
            if (speedUp != 0) {
                speedUp -= slowdown;
                if (speedUp < 0) {
                    speedUp = 0;
                }
            }
            GameLoop.map.ypos -= speed;
        } else {
            speedUp = 0;
        }
    }
    public void moveMapDown(float speed) {
        if (!Check.CollisionPlayerBlock(
                new Point((int) (pos.xpos + GameLoop.map.xpos),
                        (int) (pos.ypos + GameLoop.map.ypos + height + speed)),
                new Point((int) (pos.xpos + GameLoop.map.xpos + width),
                        (int) (pos.ypos + GameLoop.map.ypos + height + speed)))) {
            if (speedDown < maxSpeed) {
                speedDown += slowdown;
            } else {
                speedDown = maxSpeed;
            }
            GameLoop.map.ypos += speed;
        } else {
            speedDown = 0;
        }
    }
    public void moveMapDownGlide(float speed) {
        if (!Check.CollisionPlayerBlock(
                new Point((int) (pos.xpos + GameLoop.map.xpos),
                        (int) (pos.ypos + GameLoop.map.ypos + height + speed)),
                new Point((int) (pos.xpos + GameLoop.map.xpos + width),
                        (int) (pos.ypos + GameLoop.map.ypos + height + speed)))) {
            if (speedDown != 0) {
                speedDown -= slowdown;
                if (speedDown < 0) {
                    speedDown = 0;
                }
            }
            GameLoop.map.ypos += speed;
        } else {
            speedDown = 0;
        }
    }
    public void moveMapRight(float speed) {
        if (!Check.CollisionPlayerBlock(
                new Point((int) (pos.xpos + GameLoop.map.xpos + width + speed),
                        (int) (pos.ypos + GameLoop.map.ypos)),
                new Point((int) (pos.xpos + GameLoop.map.xpos + width + speed),
                        (int) (pos.ypos + GameLoop.map.ypos + height)))) {
            if (speedRight < maxSpeed) {
                speedRight += slowdown;
            } else {
                speedRight = maxSpeed;
            }
            GameLoop.map.xpos += speed;
        } else {
            speedRight = 0;
        }
    }
    public void moveMapRightGlide(float speed) {
        if (!Check.CollisionPlayerBlock(
                new Point((int) (pos.xpos + GameLoop.map.xpos + width + speed),
                        (int) (pos.ypos + GameLoop.map.ypos)),
                new Point((int) (pos.xpos + GameLoop.map.xpos + width + speed),
                        (int) (pos.ypos + GameLoop.map.ypos + height)))) {
            if (speedRight != 0) {
                speedRight -= slowdown;
                if (speedRight < 0) {
                    speedRight = 0;
                }
            }
            GameLoop.map.xpos += speed;
        } else {
            speedRight = 0;
        }
    }
    public void moveMapLeft(float speed) {
        if (!Check.CollisionPlayerBlock(
                new Point((int) (pos.xpos + GameLoop.map.xpos - speed),
                        (int) (pos.ypos + GameLoop.map.ypos + height)),
                new Point((int) (pos.xpos + GameLoop.map.xpos - speed),
                        (int) (pos.ypos + GameLoop.map.ypos + height)))) {
            if (speedLeft < maxSpeed) {
                speedLeft += slowdown;
            } else {
                speedLeft = maxSpeed;
            }
            GameLoop.map.xpos -= speed;
        } else {
            speedLeft = 0;
        }
    }
    public void moveMapLeftGlide(float speed) {
        if (!Check.CollisionPlayerBlock(
                new Point((int) (pos.xpos + GameLoop.map.xpos - speed),
                        (int) (pos.ypos + GameLoop.map.ypos + height)),
                new Point((int) (pos.xpos + GameLoop.map.xpos - speed),
                        (int) (pos.ypos + GameLoop.map.ypos + height)))) {
            if (speedLeft != 0) {
                speedLeft -= slowdown;
                if (speedLeft < 0) {
                    speedLeft = 0;
                }
            }
            GameLoop.map.xpos -= speed;
        } else {
            speedLeft = 0;
        }
    }

    public void render(Graphics2D g) {
        g.fillRect((int) pos.xpos, (int) pos.ypos, width, height);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Game.width, Game.height / 7);
        g.fillRect(0, 1000, Game.width, Game.height / 6);
        g.setColor(Color.WHITE);
    }

    //////////////////////////

    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_W) {
            up = true;
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

    }
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_W) {
            up = false;
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
    }
}
