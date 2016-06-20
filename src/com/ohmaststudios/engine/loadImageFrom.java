package com.ohmaststudios.engine;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class loadImageFrom {

    public static BufferedImage LoadImageFrom(Class<?> classfile, String path) {
        URL url  = classfile.getResource(path);
        BufferedImage img = null;

        try {
            img = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return img;
    }

}
