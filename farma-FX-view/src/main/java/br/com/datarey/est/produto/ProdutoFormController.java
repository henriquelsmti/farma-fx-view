package br.com.datarey.est.produto;

import br.com.datarey.component.input.LongInput;
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

public class ProdutoFormController extends BaseFormController<Usuario, UsuarioService> {

    private Usuario usuario;

    @FXML
    @DataBind(mappedBy = "produto.codigo")
    private LongInput codigo;

    @FXML
    @DataBind(mappedBy = "produto.nome")
    private TextField nome;



    @Inject
    private MessageUtil messageUtil;

    @Override
    public void salvarActionListener() {

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
