package com.paradox.tiles;

import javafx.scene.image.ImageView;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.paint.Color;

public class DefaultTile extends AbstractTile {

  public DefaultTile (int newX, int newY) {
    super(newX, newY);
  }

  public boolean lClick() {
    if (!getRevealed() && !getMarked()) {
      setRevealed(true);
      Tile[] adjacents = getGrid().getAdjacents(getX(),getY());
      int num = 0;
      for (Tile t : adjacents) {
        if (t instanceof Mine) {
          num++;
        }
      }
      switch (num) {
        case 1:
          setViewport(new Rectangle2D(16,0,16,16));
          break;
        case 2:
          setViewport(new Rectangle2D(16,16,16,16));
          break;
        case 3:
          setViewport(new Rectangle2D(16,32,16,16));
          break;
        case 4:
          setViewport(new Rectangle2D(16,48,16,16));
          break;
        case 5:
          setViewport(new Rectangle2D(32,0,16,16));
          break;
        case 6:
          setViewport(new Rectangle2D(32,16,16,16));
          break;
        case 7:
          setViewport(new Rectangle2D(32,32,16,16));
          break;
        case 8:
          setViewport(new Rectangle2D(32,48,16,16));
          break;
        case 0:
          setViewport(new Rectangle2D(0,32,16,16));
          for (Tile t : adjacents) {
            if (t instanceof DefaultTile && !t.getRevealed()) {
              t.lClick();
            }
          }
          break;
        default:
          setViewport(new Rectangle2D(0,32,16,16));
          break;
      }
    }
    return false;
  }
}
