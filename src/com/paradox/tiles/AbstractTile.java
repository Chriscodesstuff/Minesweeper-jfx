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
    img.setY(y*16);
    img.setViewport(viewport);
    /*img.setOnMouseClicked(new EventHandler<MouseEvent>(){
      public void handle (MouseEvent event){
        this.lClick();
      }
    });*/
  }

  public void setGrid(Grid g) {
    grid = g;
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

  public void setViewport (Rectangle2D r) {
    viewport = r;
    img.setViewport(viewport);
  }

  public void setRevealed (boolean b) {
    revealed = b;
  }

  public Node show () {
    return img;
  }

  public abstract void rClick();
  public abstract void lClick();
}
