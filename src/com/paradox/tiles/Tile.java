package com.paradox.tiles;

import com.paradox.grids.*;
import javafx.scene.Node;
import javafx.geometry.Rectangle2D;

public interface Tile {
  public void setGrid(Grid g);
  public int getX();
  public int getY();
  public Grid getGrid();
  public boolean getRevealed();
  public boolean getMarked();
  public void setRevealed(boolean b);
  public void setMarked(boolean b);
  public void setViewport(Rectangle2D r);
  public Node show();
  public void resize(double scale);
  public int rClick();
  public boolean lClick();
}
