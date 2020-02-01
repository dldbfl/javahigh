package controller;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import service.PostnumService;
import service.PostnumServiceImpl;
import vo.PostnumVO;


public class Postnum_Controller implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<PostnumVO> tableView;
    @FXML
    private TableColumn<PostnumVO, String> zipcode;
    @FXML
    private TableColumn<PostnumVO, String> sido;
    @FXML
    private TableColumn<PostnumVO, String> gugun;
    @FXML
    private TableColumn<PostnumVO, String> dong;
    @FXML
    private TableColumn<PostnumVO, String> bunji;
    @FXML
    private ComboBox<String> combobox;
    @FXML
    private TextField tfid;
    @FXML
    private Button btn;

    PostnumService  Postnumservice = PostnumServiceImpl.getInstance();
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	//컬럼 연결하기
	zipcode.setCellValueFactory(new PropertyValueFactory<>("zipcode"));
	sido.setCellValueFactory(new PropertyValueFactory<>("sido"));
	gugun.setCellValueFactory(new PropertyValueFactory<>("gugun"));
	dong.setCellValueFactory(new PropertyValueFactory<>("dong"));
	bunji.setCellValueFactory(new PropertyValueFactory<>("bunji"));
		
	combobox.getItems().addAll("동이름", "우편번호");
	
	btn.setOnAction(e ->{
		String search = null;
		Map<String, String> map = new HashMap<>();
		if (combobox.getValue() == null || combobox.getValue().equals("")) {
		} else if (combobox.getValue().equals("동이름")) {
			map.put("dongSearch", tfid.getText());
		} else if (combobox.getValue().equals("우편번호")) {
			map.put("zipSearch", tfid.getText());
		} else {
			System.out.println("오류발생");
			return;
		}
		
		System.out.println(map);
		List<PostnumVO> list = Postnumservice.getSearch(map);
		ObservableList<PostnumVO> result = FXCollections.observableArrayList(list);
		tableView.setItems(result);
	
	
		});
	}
	
	
	
}
