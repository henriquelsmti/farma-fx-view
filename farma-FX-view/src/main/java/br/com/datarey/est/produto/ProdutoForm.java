package br.com.datarey.est.produto;

import br.com.datarey.frame.crud.BaseForm;
import br.com.datarey.model.est.Produto;


public class ProdutoForm extends BaseForm<Produto> {

    public ProdutoForm() {
        super(ProdutoForm.class.getResource("produtoForm.fxml"));
        setWidth(500);
        setHeight(300);
    }
}
