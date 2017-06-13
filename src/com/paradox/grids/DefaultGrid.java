package com.paradox.grids;

import com.paradox.tiles.*;

public class DefaultGrid extends AbstractGrid {
  public DefaultGrid (int w, int h) {
    super(w,h);
  }

  public Tile[] getAdjacents(int x, int y) {
    Tile[] tileArr = new Tile[8];
    tileArr[0] = get((x - 1), (y - 1));
    tileArr[1] = get(x, (y - 1));
    tileArr[2] = get((x + 1), (y - 1));
    tileArr[3] = get((x + 1), y);
    tileArr[4] = get((x + 1), (y + 1));
    tileArr[5] = get(x, (y + 1));
    tileArr[6] = get((x - 1), (y + 1));
    tileArr[7] = get((x - 1), y);
    return tileArr;
  }
}
