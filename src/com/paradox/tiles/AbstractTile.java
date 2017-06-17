package com.paradox.tiles;

import com.paradox.grids.*;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.geometry.Rectangle2D;

public abstract class AbstractTile implements Tile {
  private int x;
  private int y;
  private ImageView img;
  private Rectangle2D viewport;
  private boolean revealed;
  private boolean marked;
  private Grid grid;

  public AbstractTile (int newX, int newY) {
    x = newX;
    y = newY;
    revealed = false;
    marked = false;
    img = new ImageView(new Image("Tiles.png"));
    viewport = new Rectangle2D(0,0,16,16);
    img.setX(x*16);
    img.setY((y*16)+32);
    img.setViewport(viewport);
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public Grid getGrid() {
    return grid;
  }

  public Rectangle2D getViewport () {
    return viewport;
  }

  public boolean getRevealed () {
    return revealed;
  }

  public boolean getMarked () {
    return marked;
  }

  public void setGrid(Grid g) {
    grid = g;
  }

  public void setViewport (Rectangle2D r) {
    viewport = r;
    img.setViewport(viewport);
  }

  public void setRevealed (boolean b) {
    revealed = b;
  }

  public void setMarked (boolean b) {
    marked = b;
  }

  public Node show () {
    return img;
  }

  public void resize (double scale){
    img.setX(x*(16*scale));
    img.setY((y+2)*(16*scale));
    img.setFitWidth(16*scale);
    img.setFitHeight(16*scale);
    img.setPreserveRatio(true);
    img.setSmooth(true);
    img.setCache(true);
  }

  public int rClick() {
    if (!getRevealed()) {
      setMarked(!getMarked());
      if (getMarked()) {
        setViewport(new Rectangle2D(0,16,16,16));
        return 1;
      } else {
        setViewport(new Rectangle2D(0,0,16,16));
        return -1;
      }
    }
    return 0;
  }

  public abstract boolean lClick();
}
