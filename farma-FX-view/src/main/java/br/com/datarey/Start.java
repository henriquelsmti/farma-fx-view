package br.com.datarey;


import br.com.datarey.sys.util.ExceptionMessageUtil;
import com.sun.javafx.css.StyleManager;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.validation.ConstraintViolationException;
import java.lang.reflect.InvocationTargetException;

public class Start extends Application {

    private Label outLabel = new Label();
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Application.setUserAgentStylesheet(null);
        StyleManager.getInstance().addUserAgentStylesheet("/br/com/datarey/css/global.css");
        Thread.setDefaultUncaughtExceptionHandler(ExceptionMessageUtil::showError);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        Image image = new Image(Start.class.getResourceAsStream("logo-datarey.png"));
        ImageView imageView = new ImageView(image);
        VBox box = new VBox();
        this.outLabel.setPrefWidth(image.getWidth());
        box.getChildren().addAll(imageView, this.outLabel);
        Scene scene = new Scene(box);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        Task task = new Task(primaryStage);
        this.outLabel.textProperty().bindBidirectional(task.getMsg());
        
        new Thread(task).start();
    }




    public static void main(String[] args) {
        
        launch(args);
    }
}