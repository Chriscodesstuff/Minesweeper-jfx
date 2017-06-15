package com.paradox.games;

import com.paradox.grids.*;
import javafx.scene.Group;

public abstract class AbstractGame implements Game {
  private boolean won;
  private Group group;

  public AbstractGame (Group g) {
    won = false;
    group = g;
    init(15,10,30);
  }

  public Group getGroup() {
    return group;
  }

  public abstract void init(int x, int y, int m);
  public abstract boolean rClick(int x, int y);
  public abstract boolean lClick(int x, int y);
}
