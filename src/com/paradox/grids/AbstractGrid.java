package com.paradox.grids;

import com.paradox.tiles.*;

public abstract class AbstractGrid implements Grid {
  private Tile[][] arr;

  public AbstractGrid (int w, int h) {
    arr = new Tile[w][h];
  }

  public Tile get(int x, int y) {
    if ((x < 0) || (y < 0) || (x >= arr.length) || (y >= arr[0].length)) {
      return null;
    }
    return arr[x][y];
  }
  public void set(int x, int y, Tile t) {
    if ((x < 0) || (y < 0) || (x >= arr.length) || (y >= arr[0].length)) {
      throw new IllegalArgumentException("Index is Out of Bounds" + arr.length);
    }
    t.setGrid(this);
    arr[x][y] = t;
  }

  public abstract Tile[] getAdjacents(int x, int y);
}
