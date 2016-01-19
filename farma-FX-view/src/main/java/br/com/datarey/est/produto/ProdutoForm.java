package br.com.datarey.est.produto;

import br.com.datarey.frame.crud.BaseForm;
import br.com.datarey.model.Usuario;


public class ProdutoForm extends BaseForm<Usuario> {

    public ProdutoForm() {
        super(ProdutoForm.class.getResource("usuarioForm.fxml"));
        setWidth(500);
        setHeight(300);
    }
}
