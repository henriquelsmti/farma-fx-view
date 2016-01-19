package br.com.datarey.fis.ncm;

import br.com.datarey.component.input.LongInput;
import br.com.datarey.databind.DataBind;
import br.com.datarey.frame.crud.BaseFormController;
import br.com.datarey.model.est.Produto;
import br.com.datarey.model.fis.NCM;
import br.com.datarey.service.fis.NCMService;
import br.com.datarey.util.MessageUtil;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javax.inject.Inject;

public class NCMFormController extends BaseFormController<NCM, NCMService> {

    private NCM ncm;

    @FXML
    @DataBind(mappedBy = "ncm.codigo")
    private LongInput codigo;

    @FXML
    @DataBind(mappedBy = "ncm.nome")
    private TextField nome;



    @Override
    public void salvarActionListener() {
        super.salvarActionListener();
    }

    @Override
    public NCM getEntity() {
        return ncm ;
    }

    @Override
    public void setEntity(NCM entity) {
        ncm  = entity;
    }
}
