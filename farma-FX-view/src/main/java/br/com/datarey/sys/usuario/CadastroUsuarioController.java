package br.com.datarey.sys.usuario;

import javax.inject.Inject;

import br.com.datarey.controller.BaseController;
import br.com.datarey.databind.DataBind;
import br.com.datarey.model.Usuario;
import br.com.datarey.service.UsuarioService;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CadastroUsuarioController extends BaseController{

    @FXML
    private TextField pesquisa;
    
    @FXML
    private Button botaoPesquisar;
    
    @FXML
    private Button botaoAdicionar;
    
    
    @FXML
    private TableView<Usuario> listagem;
    
    @FXML
    @DataBind(mappedBy="usuario.nome")
    private TextField nome;
    
    @FXML
    @DataBind(mappedBy="usuario.login")
    private TextField login;
    
    @FXML
    @DataBind(mappedBy="usuario.senha")
    private TextField senha;
    
    @FXML
    private TextField confimacaoSenha;
    
    @FXML
    private Button salvar;
    
    @FXML
    private Button cancelar;
    
    @FXML
    private Button recarregar;
    
    @FXML
    private Button inativar;
    
    @FXML
    private Button ativar;
    
    @Inject
    private UsuarioService usuarioService;
    
    private Usuario usuario = new Usuario();
    
    public void pesquisar(){
        listagem.getItems().clear();
         listagem.getItems().addAll(usuarioService.listarUsuariosPorNome(pesquisa.getText()));
    }
    
    @Override
    protected void init() {
       inicializarNavegação();
       iniciarColunas();
    }
    
    private void inicializarNavegação(){
        addEnterNavigator(pesquisa);
        addEnterNavigator(botaoPesquisar);
        addEnterNavigator(listagem);
        addEnterNavigator(nome);
        addEnterNavigator(login);
        addEnterNavigator(senha);
        addEnterNavigator(confimacaoSenha);
        addEnterNavigator(salvar);
    }
    
    @SuppressWarnings("unchecked")
    private void iniciarColunas(){
        TableColumn<Usuario, String> colunaCodigo = new TableColumn<>("Codigo");
        TableColumn<Usuario, String> colunaNome = new TableColumn<>("Nome");
        TableColumn<Usuario, String> colunaLogin = new TableColumn<>("Login");
        colunaCodigo.setPrefWidth(50);
        colunaNome.setPrefWidth(100);
        colunaLogin.setPrefWidth(100);
        colunaCodigo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigo().toString()));
        colunaNome.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
        colunaLogin.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLogin()));
        listagem.getColumns().addAll(colunaCodigo, colunaNome, colunaLogin);
    }
    
}
