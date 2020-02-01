package exam;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.RadioButton;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

public class 회원관리_controller implements Initializable{
	
			
	@FXML TextField tfid;	
	@FXML TextField tfname;	
	@FXML TextField tftel;	
	@FXML TextField tfaddr;

	@FXML Button btnadd;
	@FXML Button btnedit;
	@FXML Button btndel;
	@FXML Button btncon;
	@FXML Button btncan;

	@FXML TableView<Member> tableView;
	@FXML TableColumn idCol;
	@FXML TableColumn nameCol;
	@FXML TableColumn telCol;
	@FXML TableColumn addrCol;

		
	static int flag = 0;
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			
			ObservableList<Member> data = FXCollections.observableArrayList(
					new Member("처음","값","넣어","주기"));
			
			tableView.setItems(data);
			
			//컬럼 연결하기
			idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
			nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
			telCol.setCellValueFactory(new PropertyValueFactory<>("tel"));
			addrCol.setCellValueFactory(new PropertyValueFactory<>("addr"));
			
			
			btncon.setDisable(true);
			btncan.setDisable(true);
			
			
			
			
			//추가 버튼 작업시
			btnadd.setOnAction(e->{ //수정과 삭제 비활성화 및 확인과 취소버튼 활성화
				btnadd.setDisable(true);
				btnedit.setDisable(true);
				btndel.setDisable(true);
				btncon.setDisable(false);
				btncan.setDisable(false);
				
				flag = 1;
			});
			
			//수정 버튼 작업시
			btnedit.setOnAction(e->{//추가와 삭제 비활성및 확인과 취소버튼 활성화
				btnadd.setDisable(true);
				btnedit.setDisable(true);
				btndel.setDisable(true);
				btncon.setDisable(false);
				btncan.setDisable(false);
				
				flag = 2;
			
			});
			
			//삭제 버튼 작업시
			btndel.setOnAction(e->{//추가와 수정버튼 비활성화 및 확인과 취소버튼 활성화
				btnadd.setDisable(false);
				btnedit.setDisable(false);
				btndel.setDisable(false);
				btncon.setDisable(true);
				btncan.setDisable(true);
				
				
				//삭제
				data.remove(tableView.getSelectionModel().getSelectedIndex());
				
				info("작업결과", nameCol.getText() + "님 정보를 삭제했습니다.");
				
				tfid.clear();
				tfname.clear();
				tftel.clear();
				tfaddr.clear();	
			
			});
			
			//취소 버튼 작업시
			btncan.setOnAction(e->{ //초기상태로 돌아감
				btnadd.setDisable(false);
				btnedit.setDisable(false);
				btndel.setDisable(false);
				btncon.setDisable(true);
				btncan.setDisable(true);
				
				tfid.clear();
				tfname.clear();
				tftel.clear();
				tfaddr.clear();
			});
			
			//확인 버튼 작업시 	
			
			
			btncon.setOnAction(e->{ //작업을 진행한다.
				btnadd.setDisable(false);
				btnedit.setDisable(false);
				btndel.setDisable(false);
				btncon.setDisable(true);
				btncan.setDisable(true);
				
			if(flag == 1) {if(tfid.getText().isEmpty() 
					|| tfname.getText().isEmpty()	
					|| tftel.getText().isEmpty()	
					|| tfaddr.getText().isEmpty()) {

					errmsg("작업오류", "빈 항목이 있습니다.");
					
					return;
				}
				//추가
				data.add(new Member(tfid.getText(), 
						tfname.getText(), 
						tftel.getText(), 
						tfaddr.getText()));
				info("작업 결과", tfname.getText() + " 님 정보를 추가했습니다.");
				
			}
				
			else if(flag == 2) {if(tfid.getText().isEmpty() 
					|| tfname.getText().isEmpty()	
					|| tftel.getText().isEmpty()	
					|| tfaddr.getText().isEmpty()) {

					errmsg("작업오류", "빈 항목이 있습니다.");
					
					return;
				}
				//수정
			data.set(tableView.getSelectionModel().getSelectedIndex(),new Member(tfid.getText(), 
					tfname.getText(), 
					tftel.getText(), 
					tfaddr.getText()));
				info("작업 결과", tfname.getText() + " 님 정보를 수정했습니다.");
			
			}
			
				tfid.clear();
				tfname.clear();
				tftel.clear();
				tfaddr.clear();	
		});
			
			// TableView를 클릭했을때의 처리
						tableView.setOnMouseClicked(e -> {
							//TableView에서 선택한 줄의 데이터를 가져온다.
							Member mem = tableView.getSelectionModel().getSelectedItem();
							
//							if(mem == null)
//								return;
							
							tfid.setText(mem.getId());
							tfname.setText(mem.getName());
							tftel.setText(mem.getTel());
							tfaddr.setText(mem.getAddr());
							
						});	
					
				}
				
				public void errmsg(String headerText, String msg) {
					
					Alert errAlert = new Alert(AlertType.ERROR);
					errAlert.setTitle("오류");
					errAlert.setHeaderText(headerText);
					errAlert.setContentText(msg);
					errAlert.showAndWait();
				}
				public void info(String headerText, String msg) {
					
					Alert infoAlert = new Alert(AlertType.ERROR);
					infoAlert.setTitle("정보 확인");
					infoAlert.setHeaderText(headerText);
					infoAlert.setContentText(msg);
					infoAlert.showAndWait();
				}
		


		public class Member{
			
			private String id;
			private String name;
			private String tel;
			private String addr;

			public Member(String id, String name, String tel, String addr) {
				super();
				this.id = id;
				this.name = name;
				this.tel = tel;
				this.addr = addr;
			}

			public String getId() {
				return id;
			}

			public void setId(String id) {
				this.id = id;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public String getTel() {
				return tel;
			}

			public void setTel(String tel) {
				this.tel = tel;
			}

			public String getAddr() {
				return addr;
			}

			public void setAddr(String addr) {
				this.addr = addr;
			}
			
		}	
		}



	



