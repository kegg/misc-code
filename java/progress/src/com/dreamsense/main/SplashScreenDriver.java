package com.dreamsense.main;

import java.awt.event.*;

/**
 * Created by kegg on 2019-05-21 at 18:03.
 * Project: upgraded-fiesta
 */
public class SplashScreenDriver {
  
  public SplashScreenDriver() {
    SplashScreen screen = new SplashScreen(new Texture("splash"));
    screen.setLocationRelativeTo(null);
    screen.setMaxProgress(100);
    screen.setVisible(true);
  
    for (int i = 0; i < 100; i++) {
      screen.setProgress(i);

      if (i == 99) i = 0;
      try {
        Thread.sleep(50);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  
    screen.setVisible(false);
    System.exit(0);
  }

  public static void main(String[] args) {
    new SplashScreenDriver();
  }

}
