package com.paradox.grids;

import com.paradox.tiles.*;

public abstract class AbstractGrid implements Grid {
  private Tile[][] arr;
  private int width;
  private int height;

  public AbstractGrid (int w, int h) {
    arr = new Tile[w][h];
    width = w;
    height = h;
  }

  public Tile get(int x, int y) {
    if ((x < 0) || (y < 0) || (x >= width) || (y >= height)) {
      return null;
    }
    return arr[x][y];
  }
  public Tile[] getAll() {
    Tile[] all = new Tile[width*height];
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        all[i*j] = arr[i][j];
      }
    }
    return all;
  }
  public void set(int x, int y, Tile t) {
    if ((x < 0) || (y < 0) || (x >= width) || (y >= height)) {
      throw new IllegalArgumentException("Index is Out of Bounds");
    }
    t.setGrid(this);
    arr[x][y] = t;
  }
  public int getWidth() {
    return width;
  }
  public int getHeight() {
    return height;
  }

  public abstract Tile[] getAdjacents(int x, int y);
}
