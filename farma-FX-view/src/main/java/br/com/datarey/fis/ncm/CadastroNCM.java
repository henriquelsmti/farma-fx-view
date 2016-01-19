package br.com.datarey.fis.ncm;

import br.com.datarey.frame.crud.BaseCRUD;


public class CadastroNCM extends BaseCRUD<CadastroNCMController> {

    public CadastroNCM() {
        super(NCMForm.class);
    }

}
