package com.paradox.tiles;

import javafx.scene.image.ImageView;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.geometry.Rectangle2D;

public class Mine extends AbstractTile {

  public Mine (int newX, int newY) {
    super(newX, newY);
  }

  public boolean rClick() {
    setMarked(!getMarked());
    if (getMarked()) {
      setViewport(new Rectangle2D(0,16,16,16));
    } else {
      setViewport(new Rectangle2D(0,0,16,16));
    }
    return(getMarked());
  }
  public boolean lClick() {
    for (int i = 0; i < getGrid().getWidth(); i++) {
      for (int j = 0; j < getGrid().getHeight(); j++) {
        if (getGrid().get(i,j) instanceof Mine) {
          getGrid().get(i,j).setViewport(new Rectangle2D(0,48,16,16));
        }
      }
    }
    return true;
  }
}
