package exam;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class 상품관리_Controller implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<?> list1;

    @FXML
    private TableColumn<?, ?> t4;

    @FXML
    private TableColumn<?, ?> t5;

    @FXML
    private TableColumn<?, ?> t6;

    @FXML
    private TableColumn<?, ?> t7;

    @FXML
    private TableColumn<?, ?> t8;

    @FXML
    private TableColumn<?, ?> t9;

    @FXML
    private ComboBox<?> list2;

    @FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> t1;

    @FXML
    private TableColumn<?, ?> t2;

    @FXML
    private TableColumn<?, ?> t3;

    @FXML
    void initialize() {
        assert list1 != null : "fx:id=\"list1\" was not injected: check your FXML file '상품관리.fxml'.";
        assert t4 != null : "fx:id=\"t4\" was not injected: check your FXML file '상품관리.fxml'.";
        assert t5 != null : "fx:id=\"t5\" was not injected: check your FXML file '상품관리.fxml'.";
        assert t6 != null : "fx:id=\"t6\" was not injected: check your FXML file '상품관리.fxml'.";
        assert t7 != null : "fx:id=\"t7\" was not injected: check your FXML file '상품관리.fxml'.";
        assert t8 != null : "fx:id=\"t8\" was not injected: check your FXML file '상품관리.fxml'.";
        assert t9 != null : "fx:id=\"t9\" was not injected: check your FXML file '상품관리.fxml'.";
        assert list2 != null : "fx:id=\"list2\" was not injected: check your FXML file '상품관리.fxml'.";
        assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file '상품관리.fxml'.";
        assert t1 != null : "fx:id=\"t1\" was not injected: check your FXML file '상품관리.fxml'.";
        assert t2 != null : "fx:id=\"t2\" was not injected: check your FXML file '상품관리.fxml'.";
        assert t3 != null : "fx:id=\"t3\" was not injected: check your FXML file '상품관리.fxml'.";

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
