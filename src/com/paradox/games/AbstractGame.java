package com.paradox.games;

import com.paradox.grids.*;
import javafx.scene.Group;

public abstract class AbstractGame implements Game {
  private boolean won;
  private Group group;
  private double scale;

  public AbstractGame (Group g) {
    group = g;
    scale = 1;
    init();
  }

  public Group getGroup() {
    return group;
  }

  public double getScale() {
    return scale;
  }

  public void resize(double newScale) {
    scale = newScale;
  }

  public abstract void init();
  public abstract boolean rClick(double x, double y);
  public abstract boolean lClick(double x, double y);
}
