package br.com.datarey.sys.menu;

import java.util.HashMap;
import java.util.Map;

import br.com.datarey.context.Context;
import br.com.datarey.controller.BaseController;
import br.com.datarey.est.produto.CadastroProduto;
import br.com.datarey.fis.ncm.CadastroNCM;
import br.com.datarey.frame.base.BaseWindow;
import br.com.datarey.sys.usuario.CadastroUsuario;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;

public class MenuController extends BaseController{

    private Map<Class<?>, BaseWindow> janelas = new HashMap<>();
    
    @FXML
    private MenuBar menuBar;

    @FXML
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

    @FXML
    public void abrirCadastroNCM(){
        BaseWindow cadastroNCM = janelas.get(CadastroNCM.class);
        if(cadastroNCM == null){
            cadastroNCM = Context.getBean(CadastroNCM.class);
            cadastroNCM.setOnCloseRequest(event ->{
                janelas.remove(CadastroNCM.class);
            });
            janelas.put(CadastroNCM.class, cadastroNCM);
        }
        cadastroNCM.show();

    }

    @FXML
    public void abrirCadastroProduto(){
        BaseWindow cadastroProduto = janelas.get(CadastroProduto.class);
        if(cadastroProduto == null){
            cadastroProduto = Context.getBean(CadastroProduto.class);
            cadastroProduto.setOnCloseRequest(event ->{
                janelas.remove(CadastroProduto.class);
            });
            janelas.put(CadastroProduto.class, cadastroProduto);
        }
        cadastroProduto.show();

    }
}
