package br.com.datarey.fis.ncm;

import br.com.datarey.frame.BaseIdentificadorSearchController;
import br.com.datarey.frame.Predicate;
import br.com.datarey.frame.dialog.ItemTipoPesquisa;
import br.com.datarey.model.Usuario;
import br.com.datarey.model.fis.NCM;
import br.com.datarey.service.UsuarioService;
import br.com.datarey.service.fis.NCMService;
import br.com.serviceinfra.model.Cliente;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableColumn;

public class NCMSearchController extends BaseIdentificadorSearchController<NCM, NCMService> {

    @Override
    protected void init() {
        super.init();

        getChoiceBox().getItems().add(new ItemTipoPesquisa("Codigo", "codigo", Predicate.EQUAL));
        getChoiceBox().getItems().add(new ItemTipoPesquisa("Nome", "nome", Predicate.LIKE));
    }

}
