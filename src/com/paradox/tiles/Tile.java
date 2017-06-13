package com.paradox.tiles;

import com.paradox.grids.*;
import javafx.scene.Node;

public interface Tile {
  public void setGrid(Grid g);
  public int getX();
  public int getY();
  public Grid getGrid();
  public Node show();
  public void rClick();
  public void lClick();
}
