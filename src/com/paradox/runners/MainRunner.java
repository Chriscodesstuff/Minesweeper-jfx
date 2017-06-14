package com.paradox.runners;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import com.paradox.games.*;

public class MainRunner extends Application
{
  @Override
  public void start(Stage stage){
    final Group root = new Group();
    final Game game = new Minesweeper(root);
    final Scene scene = new Scene(root,400,300);
    scene.setOnMouseClicked(new EventHandler<MouseEvent>(){
      public void handle (MouseEvent event){
        int x = (int)(event.getSceneX()/16);
        int y = (int)(event.getSceneY()/16);
        game.lClick(x,y);
      }
    });
    stage.setScene(scene);
    stage.show();
  }

  public static void main (String[] args)
  {
    Application.launch(args);
  }
}
