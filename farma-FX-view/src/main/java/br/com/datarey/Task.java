package br.com.datarey;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import br.com.datarey.context.Context;


public class Task extends javafx.concurrent.Task<Object> {
    
    private StringProperty msg = new SimpleStringProperty();
    private StringBuilder builder = new StringBuilder();
    private Stage primaryStage;
    
    public Task(Stage primaryStage){
        this.primaryStage = primaryStage;
    }
    @Override
    protected Object call() throws Exception {
        OutputStream out = new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                appendText(String.valueOf((char) b));
            }
        };
        System.setOut(new PrintStream(out, true));
        Context.init();
        return null;
    }

    @Override
    protected void failed() {
        Alert alert = alert = new Alert(Alert.AlertType.ERROR);
        String msg = getException().getMessage();
        if(getException().getCause() != null){
            msg += "\n" + getException().getCause().getMessage();
        }
        alert.setHeaderText(msg);
        alert.showAndWait();
        Context.shutdown();
        System.exit(0);

    }

    @Override
    protected void succeeded() {
        super.succeeded();
        Init init = Context.getBean(Init.class);
        init.start(primaryStage);
        primaryStage.close();
    }
    
    public void appendText(String str) {
        if(str.equals(System.lineSeparator()) || str.equals("\n")){
            Platform.runLater(() -> msg.set(builder.toString()));
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            builder = new StringBuilder();
        }else{
            builder.append(str);
        }
    }

    public StringProperty getMsg() {
        return this.msg;
    }

    

}
