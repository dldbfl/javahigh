package exam;

import java.net.URL;
import java.util.ResourceBundle;

import exam.회원관리_controller.Member;
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

public class 우편번호_Controller implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Member> tableView;
    private TableColumn<?, ?> t1;
    private TableColumn<?, ?> t2;
    private TableColumn<?, ?> t3;
    private TableColumn<?, ?> t4;
    private TableColumn<?, ?> t5;

    @FXML
    private TextField txtarea;

    @FXML
    private ComboBox<?> list;

    @FXML
    private Button btn;


    @FXML
    void initialize() {
        assert t4 != null : "fx:id=\"t4\" was not injected: check your FXML file '우편번호.fxml'.";
        assert t5 != null : "fx:id=\"t5\" was not injected: check your FXML file '우편번호.fxml'.";
        assert txtarea != null : "fx:id=\"txtarea\" was not injected: check your FXML file '우편번호.fxml'.";
        assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file '우편번호.fxml'.";
        assert list != null : "fx:id=\"list\" was not injected: check your FXML file '우편번호.fxml'.";
        assert btn != null : "fx:id=\"btn\" was not injected: check your FXML file '우편번호.fxml'.";
        assert t1 != null : "fx:id=\"t1\" was not injected: check your FXML file '우편번호.fxml'.";
        assert t2 != null : "fx:id=\"t2\" was not injected: check your FXML file '우편번호.fxml'.";
        assert t3 != null : "fx:id=\"t3\" was not injected: check your FXML file '우편번호.fxml'.";

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		ObservableList<Member> data = FXCollections.observableArrayList();
		
		tableView.setItems(data);
		
	
	//컬럼 연결하기
	t1.setCellValueFactory(new PropertyValueFactory<>("t1"));
	t2.setCellValueFactory(new PropertyValueFactory<>("t2"));
	t3.setCellValueFactory(new PropertyValueFactory<>("t3"));
	t4.setCellValueFactory(new PropertyValueFactory<>("t4"));
	t5.setCellValueFactory(new PropertyValueFactory<>("t5"));
	
	
	btn.setOnAction(e->{ //작업을 진행한다.
		
			//추가
			data.add(new Member(t1.getText(), t2.getText(), 
												t3.getText(), 
												t4.getText(),
												t5.getText()));
					
		
			
					
			t1.clear();
			t2.clear();
			t3.clear();
			t4.clear();	
			t5.clear();
	
	
	
	
	}
	}
	
	
	
	
	
	
	
	
	
	
	
	public class Member{
		
		private String t1;
		private String t2;
		private String t3;
		private String t4;
		private String t5;
		
		public Member(String t1, String t2, String t3, String t4, String t5) {
			super();
			this.t1 = t1;
			this.t2 = t2;
			this.t3 = t3;
			this.t4 = t4;
			this.t5 = t5;
		}

		public String getT1() {
			return t1;
		}

		public void setT1(String t1) {
			this.t1 = t1;
		}

		public String getT2() {
			return t2;
		}

		public void setT2(String t2) {
			this.t2 = t2;
		}

		public String getT3() {
			return t3;
		}

		public void setT3(String t3) {
			this.t3 = t3;
		}

		public String getT4() {
			return t4;
		}

		public void setT4(String t4) {
			this.t4 = t4;
		}

		public String getT5() {
			return t5;
		}

		public void setT5(String t5) {
			this.t5 = t5;
		}
		
		
		
		
	}
}
