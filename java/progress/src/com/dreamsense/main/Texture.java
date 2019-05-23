package com.dreamsense.main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kegg on 2019-05-21 at 17:41.
 * Project: upgraded-fiesta
 */
public class Texture {

  private final static Map<String, BufferedImage> texMap = new HashMap<>();
  
  private BufferedImage image;
  private String fileName;
  private int width, height;
  
  public Texture(String fileName) {
    this.fileName = fileName;
    BufferedImage oldTexture = texMap.get(fileName);
    if (oldTexture != null) {
      this.image = oldTexture;
    } else {
      try {
        this.image = ImageIO.read(getClass().getResourceAsStream("/textures/" + fileName + ".png"));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    
    this.width = image.getWidth();
    this.height = image.getHeight();
  }
  
  public Texture(Texture spriteSheet, int x, int y, int width, int height) {
    this.width = width;
    this.height = height;
    String key = spriteSheet.fileName + "_" + x +"_" + y;
    BufferedImage old = texMap.get(key);
    if (old != null) {
      this.image = old;
    } else {
      this.image = spriteSheet.image.getSubimage(
          x * width - width,
          y * height - height,
          width, height);
    }
  }
  
  public Texture(Texture spriteSheet, int x, int y, int size) {
    this(spriteSheet, x, y, size, size);
  }
  
  public void render(Graphics g, double x, double y) {
    g.drawImage(image, (int)x, (int)y, null);
  }
  
  public int getWidth() {
    return width;
  }
  
  public int getHeight() {
    return height;
  }
  
  public BufferedImage getImage() {
    return image;
  }
}
