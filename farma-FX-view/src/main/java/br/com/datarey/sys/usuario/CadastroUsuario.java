package br.com.datarey.sys.usuario;

import br.com.datarey.frame.crud.BaseCRUD;


public class CadastroUsuario extends BaseCRUD<CadastroUsuarioController> {

    public CadastroUsuario() {
        super(UsuarioForm.class);
    }

}
