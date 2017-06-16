package com.paradox.games;

import com.paradox.grids.*;
import javafx.scene.Group;

public interface Game {
  public void init();
  public Group getGroup();
  public boolean rClick(int x, int y);
  public boolean lClick(int x, int y);
}
