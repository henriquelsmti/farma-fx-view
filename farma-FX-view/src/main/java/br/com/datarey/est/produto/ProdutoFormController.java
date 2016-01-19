package br.com.datarey.est.produto;

import br.com.datarey.component.input.LongInput;
import br.com.datarey.databind.DataBind;
import br.com.datarey.fis.ncm.NCMInput;
import br.com.datarey.frame.crud.BaseFormController;
import br.com.datarey.model.Usuario;
import br.com.datarey.model.est.Produto;
import br.com.datarey.service.est.ProdutoService;
import br.com.datarey.util.MessageUtil;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javax.inject.Inject;

public class ProdutoFormController extends BaseFormController<Produto, ProdutoService> {

    private Produto produto;

    @FXML
    @DataBind(mappedBy = "produto.codigo")
    private LongInput codigo;

    @FXML
    @DataBind(mappedBy = "produto.nome")
    private TextField nome;

    @FXML
    @DataBind(mappedBy = "produto.ncm")
    private NCMInput ncm;



    @Override
    public void salvarActionListener() {

        super.salvarActionListener();
    }

    @Override
    public Produto getEntity() {
        return produto ;
    }

    @Override
    public void setEntity(Produto entity) {
        produto  = entity;
    }
}
