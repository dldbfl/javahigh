package exam;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.scene.control.CheckBox;

public class practice_controller implements Initializable{

	@FXML private TextField name;

	@FXML private RadioButton male;

	@FXML private RadioButton female;

	@FXML private CheckBox travel;

	@FXML private CheckBox rdbook;

	@FXML private CheckBox hiking;

	@FXML private CheckBox baduk;

	@FXML private CheckBox changgi;

	@FXML private CheckBox game;

	@FXML private CheckBox tennis;

	@FXML private CheckBox bdmin;

	@FXML private Button select;

	@FXML private TextArea text;


	//토글그룹 객체생성(성별)
		private ToggleGroup togGroup = new ToggleGroup();
		
		// 체크박스배열선언(취미)
		private CheckBox[] chkbox;
		
		
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			
			male.setToggleGroup(togGroup);
			male.setUserData("남자");
			male.setSelected(true);
			
			female.setToggleGroup(togGroup);
			female.setUserData("여자");
			
			// 체크박스배열에 체크박스들 넣기.
			chkbox = new CheckBox[]{travel, rdbook, hiking, baduk, 
					changgi, game, tennis, bdmin};
		}

		@FXML 
		public void selectClicked(ActionEvent event) {
			
			// 유저데이터 취미
			String hobby = "";
			for(int i = 0; i < chkbox.length; i++) {
				if(chkbox[i].isSelected()) { 
					hobby += chkbox[i].getText() + " ";
				}
			}
			
			// 유저데이터 이름
			String nameoutput = name.getText();
			
			// 유저데이터 성별
			if(togGroup.getSelectedToggle().getUserData() != null) {
				String gender = togGroup.getSelectedToggle().getUserData().toString();
				
				text.setText("이름 : " + nameoutput + "\n");
				text.appendText("성별 : " + gender + "\n");
				text.appendText("취미 : " + hobby + "\n");
			
			}
		}
	}



