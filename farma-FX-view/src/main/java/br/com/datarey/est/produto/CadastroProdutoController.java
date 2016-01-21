package br.com.datarey.est.produto;

import br.com.datarey.app.BaseReport;
import br.com.datarey.component.input.TextField;
import br.com.datarey.fis.ncm.NCMInput;
import br.com.datarey.fis.ncm.NCMSearchPopUp;
import br.com.datarey.frame.crud.BaseCRUDController;
import br.com.datarey.model.Usuario;
import br.com.datarey.model.est.Produto;
import br.com.datarey.service.UsuarioService;
import br.com.datarey.service.est.ProdutoService;
import br.com.datarey.table.ColumnSearch;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Pos;

import javax.inject.Inject;

public class CadastroProdutoController extends BaseCRUDController<Produto, ProdutoService> {

    @Override
    protected void init() {
        super.init();
        ColumnSearch<Produto> columnSearch = new ColumnSearch<>();
        columnSearch.setTitle("Codigo");
        columnSearch.setField("codigo");
        columnSearch.setVisible(true);
        columnSearch.setGraphic(new TextField());
        columnSearch.setAlignment(Pos.BASELINE_RIGHT);
        columnSearch.setCellData((data) ->{
            return new SimpleStringProperty(data.getValue().getCodigo().toString());});
        addColumnSearch(columnSearch);

        columnSearch = new ColumnSearch<>();
        columnSearch.setTitle("Nome");
        columnSearch.setField("nome");
        columnSearch.setVisible(true);
        columnSearch.setGraphic(new TextField());
        columnSearch.setCellData((data) -> {
           return new SimpleStringProperty(data.getValue().getNome());});
        addColumnSearch(columnSearch);


        columnSearch = new ColumnSearch<>();
        columnSearch.setTitle("NCM");
        columnSearch.setField("ncm");
        columnSearch.setVisible(true);
        columnSearch.setAlignment(Pos.BASELINE_RIGHT);
        columnSearch.setGraphic(new NCMInput());
        columnSearch.setCellData((data) -> {
            return new SimpleLongProperty(data.getValue().getNcm().getCodigo());});
        addColumnSearch(columnSearch);


    }

    @Override
    protected BaseReport getReport() {
        return null;
    }
}
