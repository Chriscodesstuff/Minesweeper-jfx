package com.paradox.games;

import com.paradox.grids.*;
import javafx.scene.Group;

public abstract class AbstractGame implements Game {
  private boolean won;
  private Group group;

  public AbstractGame (Group g) {
    won = false;
    group = g;
    init();
  }

  public Group getGroup() {
    return group;
  }

  public abstract void init();
  public abstract boolean rClick(int x, int y);
  public abstract boolean lClick(int x, int y);
}
