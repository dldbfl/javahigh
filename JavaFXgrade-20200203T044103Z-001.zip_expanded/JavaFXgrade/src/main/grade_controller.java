package main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.TableView;



public class grade_controller  {

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnadd;

    @FXML
    private TableColumn<?, ?> tlang;

    @FXML
    private TableColumn<?, ?> tname;

    @FXML
    private TableColumn<?, ?> tmath;

    @FXML
    private Button stick;

    @FXML
    private TableColumn<?, ?> teng;

	@FXML TableView<Member> tv;
    
	ObservableList<Member> data = FXCollections.observableArrayList();
	
    @FXML
	public void initialize() { 	
    	    	
    	tv.setItems(data);
	}
	
	@FXML
	void btnaddClicked(ActionEvent event) {
		
			// 1. Stage객체 생성
			Stage dialog = new Stage(StageStyle.UTILITY);
			
			// 2. 모달창 여부 설정
			// 모달창은 자식창이 나타나면 부모창을 사용할 수 없다.
			dialog.initModality(Modality.APPLICATION_MODAL);
			
			// 3. 부모창 지정
//			dialog.initOwner(primaryStage);

			dialog.setTitle("사용자 정의 창");
			
			// 4. 자식창이 나타날 컨테이너 객체 생성
			Parent parent = null;
			try {
				parent = FXMLLoader.load(getClass().getResource("gradeadd.fxml"));
			}catch(IOException ex) {
				ex.printStackTrace();
			}
			
			// 부모창에서 FXML로 만든 자식창의 컨트롤 객체 얻기
			TextField txtName = (TextField) parent.lookup("#txtName");
			TextField txtKor = (TextField) parent.lookup("#txtKor");
			TextField txtMath = (TextField) parent.lookup("#txtMath");
			TextField txtEng = (TextField) parent.lookup("#txtEng");
//					PasswordField pass = (PasswordField) parent.lookup("#pass");
			
			
			
			Button btnOk = (Button) parent.lookup("#btnOk");
			btnOk.setOnAction(e2->{
				
				
				
				tname.setCellValueFactory(new PropertyValueFactory<>("tname"));
				tlang.setCellValueFactory(new PropertyValueFactory<>("tlang"));
				tmath.setCellValueFactory(new PropertyValueFactory<>("tmath"));
				teng.setCellValueFactory(new PropertyValueFactory<>("teng"));
				
				
				System.out.println("이름 : "+ txtName.getText());
				System.out.println("국어 : "+ txtKor.getText());
				System.out.println("수학 : "+ txtMath.getText());
				System.out.println("영어 : "+ txtEng.getText());
//						System.out.println("비밀번호 : "+ pass.getText());
				
				
				data.add(new Member(txtName.getText(), 
						 txtKor.getText(), 
						 txtMath.getText(), 
						 txtEng.getText()));
				
				
				dialog.close();
			});
			
			Button btnCancel = (Button) parent.lookup("#btnCancel");
			btnCancel.setOnAction(e3->{
				dialog.close();
			});
			
			// 5. Scene 객체 생성해서 컨테이너 객체 추가
			Scene scene = new Scene(parent);
			
			//6. Stage 객체에 Scene객체 추가
			dialog.setScene(scene);
			dialog.setResizable(false); //크기 고정
			dialog.show();
		}
	
	public class Member {
		private String tname;
		private String tlang;
		private String tmath;
		private String teng;
		
		
		public Member(String tname, String tlang, String tmath, String teng) {
			super();
			this.tname = tname;
			this.tlang = tlang;
			this.tmath = tmath;
			this.teng = teng;
			
		}


		public String getTname() {
			return tname;
		}


		public void setTname(String tname) {
			this.tname = tname;
		}


		public String getTlang() {
			return tlang;
		}


		public void setTlang(String tlang) {
			this.tlang = tlang;
		}


		public String getTmath() {
			return tmath;
		}


		public void setTmath(String tmath) {
			this.tmath = tmath;
		}


		public String getTeng() {
			return teng;
		}


		public void setTeng(String teng) {
			this.teng = teng;
		}
		
		
		
		
		
		
	}
		

		
			
	
}
