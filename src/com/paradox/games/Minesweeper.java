package com.paradox.games;

import com.paradox.grids.*;
import com.paradox.tiles.*;
import javafx.scene.Group;

public class Minesweeper extends AbstractGame {
  private Grid grid;
  private boolean won;
  private int width;
  private int height;

  public Minesweeper (Group g) {
    super(g);
  }

  public void init() {
    int x;
    int y;
    width = 15;
    height = 10;
    grid = new DefaultGrid(width,height);
    for (int i = 0; i < 30; i++) {
       while (true) {
         x = (int)(Math.random()*width);
         y = (int)(Math.random()*height);
         if (grid.get(x,y)==null) {
           grid.set(x,y,new Mine(x,y));
           break;
         }
       }
    }
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        if (grid.get(i,j)!=null) {
          getGroup().getChildren().add(grid.get(i,j).show());
        }
        if (grid.get(i,j) instanceof DefaultTile) {
          grid.get(i,j).lClick();
        }
      }
    }
  }

  public boolean rClick(int x, int y) {
    return false;
  }

  public boolean lClick(int x, int y) {
    return false;
  }
}
