package com.paradox.runners;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.Scene;
import com.paradox.games.*;

public class MainRunner extends Application
{
  @Override
  public void start(Stage stage){
    Group root = new Group();
    Game game = new Minesweeper(root);
    Scene scene = new Scene(root,400,300);
    stage.setScene(scene);
    stage.show();
  }

  public static void main (String[] args)
  {
    Application.launch(args);
  }
}
