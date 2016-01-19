package br.com.datarey.est.produto;

import br.com.datarey.frame.crud.BaseCRUD;


public class CadastroProduto extends BaseCRUD<CadastroProdutoController> {

    public CadastroProduto() {
        super(ProdutoForm.class);
    }

}
