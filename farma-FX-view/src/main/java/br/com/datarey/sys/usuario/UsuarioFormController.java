package br.com.datarey.sys.usuario;

import br.com.datarey.databind.DataBind;
import br.com.datarey.frame.crud.BaseFormController;
import br.com.datarey.model.Usuario;
import br.com.datarey.service.UsuarioService;
import br.com.datarey.util.MessageType;
import br.com.datarey.util.MessageUtil;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.inject.Inject;

public class UsuarioFormController extends BaseFormController<Usuario, UsuarioService> {

    private Usuario usuario;

    @FXML
    @DataBind(mappedBy = "usuario.nome")
    private TextField nome;

    @FXML
    @DataBind(mappedBy = "usuario.login")
    private TextField login;

    @FXML
    @DataBind(mappedBy = "usuario.senha")
    private PasswordField senha;

    @FXML
    private PasswordField confimacaoSenha;

    @Override
    public void salvarActionListener() {
        if(senha.getText() != null){
            if(!senha.getText().equals(confimacaoSenha.getText())){
               getMessageUtil().showMessage("As senhas não conferem", MessageType.ALERT);
                return;
            }
        }
        super.salvarActionListener();
    }

    @Override
    public Usuario getEntity() {
        return usuario;
    }

    @Override
    public void setEntity(Usuario entity) {
        usuario = entity;
    }
}
