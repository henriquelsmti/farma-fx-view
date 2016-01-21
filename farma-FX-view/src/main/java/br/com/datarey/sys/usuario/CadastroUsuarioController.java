package br.com.datarey.sys.usuario;

import br.com.datarey.app.BaseReport;
import br.com.datarey.component.input.TextField;
import br.com.datarey.frame.crud.BaseCRUDController;
import br.com.datarey.model.Usuario;
import br.com.datarey.service.UsuarioService;
import br.com.datarey.table.ColumnSearch;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Pos;

public class CadastroUsuarioController extends BaseCRUDController<Usuario, UsuarioService> {


    @Override
    protected void init() {
        super.init();
        ColumnSearch<Usuario> columnSearch = new ColumnSearch<>();
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
        columnSearch.setTitle("Login");
        columnSearch.setField("login");
        columnSearch.setVisible(true);
        columnSearch.setGraphic(new TextField());
        columnSearch.setCellData((data) -> {
            return new SimpleStringProperty(data.getValue().getNome());});
        addColumnSearch(columnSearch);
    }

    @Override
    protected BaseReport getReport() {
        return null;
    }
}
