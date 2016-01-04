package br.com.datarey;


import br.com.datarey.context.Context;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Start extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.initStyle(StageStyle.UNDECORATED);
        Image image = new Image(Start.class.getResourceAsStream("logo-datarey.png"));
        ImageView imageView = new ImageView(image);
        HBox box = new HBox();
        box.getChildren().add(imageView);
        Scene scene = new Scene(box);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        Runnable runnable = ()-> {
            Init init = Context.getBean(Init.class);
            init.start(primaryStage);
            primaryStage.close();
        };
        Platform.runLater(runnable);
        
    }

    public static void main(String[] args) {
        
        launch(args);
    }
}