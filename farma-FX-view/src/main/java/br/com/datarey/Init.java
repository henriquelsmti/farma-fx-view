package br.com.datarey;

import javax.inject.Inject;

import br.com.datarey.sys.menu.Menu;
import javafx.stage.Stage;

public class Init {

    @Inject
    private Menu menu;

    public void start(Stage primaryStage) {
        menu.show();
    }
}
