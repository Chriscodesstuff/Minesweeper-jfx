package com.paradox.games;

import com.paradox.grids.*;
import javafx.scene.Group;

public interface Game {
  public void init();
  public Group getGroup();
  public double getScale();
  public void resize(double newScale);
  public boolean rClick(double x, double y);
  public boolean lClick(double x, double y);
}
