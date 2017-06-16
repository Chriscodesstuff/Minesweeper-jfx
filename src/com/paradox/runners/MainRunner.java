package com.paradox.runners;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseButton;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import com.paradox.games.*;

public class MainRunner extends Application
{
  @Override
  public void start(Stage stage){
    final Group root = new Group();
    final Game game = new Minesweeper(root);
    final Button reset = new Button("Reset");
    reset.setLayoutX(6);
    reset.setLayoutY(200);
    reset.setOnAction(new EventHandler<ActionEvent>(){
      public void handle (ActionEvent event) {
        root.getChildren().clear();
        game.init();
        root.getChildren().add(reset);
      }
    });
    root.getChildren().add(reset);
    root.setOnMouseClicked(new EventHandler<MouseEvent>(){
      public void handle (MouseEvent event){
        int x = (int)(event.getSceneX()/16);
        int y = (int)(event.getSceneY()/16)-2;
        if (event.getButton().equals(MouseButton.PRIMARY)) {
          game.lClick(x,y);
        } else {
          game.rClick(x,y);
        }

      }
    });
    final Scene scene = new Scene(root,240,300);
    stage.setTitle("Minesweeper");
    stage.setResizable(false);
    stage.setScene(scene);
    stage.show();
  }

  public static void main (String[] args)
  {
    Application.launch(args);
  }
}
