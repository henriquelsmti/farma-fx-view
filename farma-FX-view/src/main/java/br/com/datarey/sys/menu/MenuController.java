package br.com.datarey.sys.menu;

import java.util.HashMap;
import java.util.Map;

import br.com.datarey.context.Context;
import br.com.datarey.controller.BaseController;
import br.com.datarey.frame.base.BaseWindow;
import br.com.datarey.sys.usuario.CadastroUsuario;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;

public class MenuController extends BaseController{

    private Map<Class<?>, BaseWindow> janelas = new HashMap<>();
    
    @FXML
    private MenuBar menuBar;
    
    public void abrirCadastroUsuario(){
        BaseWindow cadastroUsuario = janelas.get(CadastroUsuario.class);
        if(cadastroUsuario == null){
            cadastroUsuario = Context.getBean(CadastroUsuario.class);
            cadastroUsuario.setOnCloseRequest(event ->{
                janelas.remove(CadastroUsuario.class);
            });
            janelas.put(CadastroUsuario.class, cadastroUsuario);
        }
        cadastroUsuario.show();
        
    }
}
