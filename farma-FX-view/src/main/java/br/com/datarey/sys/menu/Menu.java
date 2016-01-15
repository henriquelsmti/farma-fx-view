package br.com.datarey.sys.menu;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;


import br.com.datarey.context.Context;
import br.com.datarey.frame.base.BaseWindow;

@ApplicationScoped
public class Menu extends BaseWindow {

    public Menu() {
        super(Menu.class.getResource("menu.fxml"), 1024, 700, "Farma FX");
    }
    
    @Override
    @PostConstruct
    protected void postConstruct(){
        super.postConstruct();
        super.stage.setOnCloseRequest(event -> {
            Context.shutdown();
        });
    }

}
