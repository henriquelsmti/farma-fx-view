package br.com.datarey.sys.usuario;

import br.com.datarey.frame.crud.BaseCRUD;
import br.com.datarey.frame.crud.BaseForm;
import br.com.datarey.model.Usuario;


public class UsuarioForm extends BaseForm<Usuario> {

    public UsuarioForm() {
        super("usuarioForm.fxml");
    }

}
