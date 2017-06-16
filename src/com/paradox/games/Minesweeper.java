package com.paradox.games;

import com.paradox.grids.*;
import com.paradox.tiles.*;
import javafx.scene.Group;
import javafx.scene.text.Text;

public class Minesweeper extends AbstractGame {
  private Grid grid;
  private Text message;
  private boolean gameOver;
  private int width;
  private int height;
  private int mines;
  private int flags;
  private int correctFlags;


  public Minesweeper (Group g) {
    super(g);
  }

  public void init() {
    int x;
    int y;
    width = 15;
    height = 10;
    mines = 30;
    flags = 0;
    gameOver = false;
    grid = new DefaultGrid(width,height);
    message = new Text(6,16,"Mines: " + mines);
    for (int i = 0; i < mines; i++) {
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
        if (grid.get(i,j)==null) {
          grid.set(i,j,new DefaultTile(i,j));
        }
        getGroup().getChildren().add(grid.get(i,j).show());
      }
    }
    getGroup().getChildren().add(message);
  }

  public boolean rClick(int x, int y) {
    if (!gameOver && (x >= 0) && (y >= 0) && (x <= width) && (y <= height)) {
      flags += grid.get(x,y).rClick();
      message.setText("Mines: " + (mines-flags));
      if (flags == mines) {
        for (int i = 0; i < width; i++) {
          for (int j = 0; j < height; j++) {
            if ((grid.get(i,j) instanceof Mine)&&(!grid.get(i,j).getMarked())) {
              return false;
            }
          }
        }
        gameOver = true;
        message.setText("You won!");
      }
    }
    return false;
  }

  public boolean lClick(int x, int y) {
    if (!gameOver && (x >= 0) && (y >= 0) && (x <= width) && (y <= height)) {
      if (grid.get(x,y).lClick()) {
        gameOver = true;
        message.setText("You Lost!");
      }
    }
    return false;
  }
}
