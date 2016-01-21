package br.com.datarey.fis.ncm;

import br.com.datarey.app.BaseReport;
import br.com.datarey.app.fis.NCMReport;
import br.com.datarey.app.fis.NCMReportImpl;
import br.com.datarey.component.input.TextField;
import br.com.datarey.frame.crud.BaseCRUDController;
import br.com.datarey.model.fis.NCM;
import br.com.datarey.service.fis.NCMService;
import br.com.datarey.table.ColumnSearch;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Pos;

import javax.inject.Inject;

public class CadastroNCMController extends BaseCRUDController<NCM, NCMService> {

    @Inject
    private NCMReport ncmReport;

    @Override
    protected void init() {
        super.init();
        ColumnSearch<NCM> columnSearch = new ColumnSearch<>();
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
    }

    @Override
    protected BaseReport getReport() {
        return ncmReport;
    }
}
