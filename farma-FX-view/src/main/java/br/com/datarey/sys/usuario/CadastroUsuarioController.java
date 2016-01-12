package br.com.datarey.sys.usuario;

import br.com.datarey.component.input.TextField;
import br.com.datarey.frame.crud.BaseCRUDController;
import br.com.datarey.model.Usuario;
import br.com.datarey.service.UsuarioService;
import br.com.datarey.table.ColumnSearch;

public class CadastroUsuarioController extends BaseCRUDController<Usuario, UsuarioService> {


    @Override
    protected void init() {
        super.init();
        ColumnSearch<Usuario> columnSearch = new ColumnSearch<>();
        columnSearch.setTitle("Codigo");
        columnSearch.setField("codigo");
        columnSearch.setVisible(true);
        columnSearch.setGraphic(new TextField());
        columnSearch.setCellData((data) ->{
            return data.getValue().getCodigo().toString();});
        addColumnSearch(columnSearch);

        columnSearch = new ColumnSearch<>();
        columnSearch.setTitle("Nome");
        columnSearch.setField("nome");
        columnSearch.setVisible(true);
        columnSearch.setGraphic(new TextField());
        columnSearch.setCellData((data) -> {
           return data.getValue().getNome();});
        addColumnSearch(columnSearch);
    }
}
