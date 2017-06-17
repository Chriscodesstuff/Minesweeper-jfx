package com.paradox.grids;

import com.paradox.tiles.*;

public interface Grid {
  public Tile get(int x, int y);
  public void set(int x, int y, Tile t);
  public int getWidth();
  public int getHeight();
  public Tile[] getAdjacents(int x, int y);
  public Tile[] getAll();
}
