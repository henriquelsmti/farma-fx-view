package br.com.datarey.fis.ncm;

import br.com.datarey.frame.crud.BaseForm;
import br.com.datarey.model.est.Produto;
import br.com.datarey.model.fis.NCM;


public class NCMForm extends BaseForm<NCM> {

    public NCMForm() {
        super(NCMForm.class.getResource("ncmForm.fxml"));
        setWidth(500);
        setHeight(300);
    }
}
