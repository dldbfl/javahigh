package main;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class T16_DialogTest extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox root = new HBox(10);
		root.setPadding(new Insets(10));
		root.setAlignment(Pos.CENTER);
		
		// 파일 열기 창
		Button btnFileOpen = new Button("Open FileChooser 실행");
		btnFileOpen.setOnAction(e->{
			
	
			
	
			
		});
			
		Button btnFileSave = 
				new Button("SAVE FileChooser 실행");
		btnFileSave.setOnAction(e2->{
			FileChooser fileChooser2 = new FileChooser();
			fileChooser2.getExtensionFilters().addAll(
			  new ExtensionFilter("All Files", "*.*")		
			);
			
			File selFile = fileChooser2
					.showSaveDialog(primaryStage);
			if(selFile != null) {
				// 이 곳에서 선택한 파일을 이용한 저장 작업을 수행한다.
				System.out.println("SAVE: " 
								+ selFile.getPath());
			}
		});
		
		// 폴더(디렉토리)만 선택하는 Dialog창
		Button btnDirectory = 
				new Button("Directory Chooser 실행");
		btnDirectory.setOnAction(e3->{
			DirectoryChooser dirChooser = 
					new DirectoryChooser();
			File selDir = dirChooser.showDialog(primaryStage);
			if(selDir != null) {
				System.out.println("Directory : " + selDir);
			}
		});
		//---------------------------------------------------
		Button btnPopup = new Button("Popup 실행");
		btnPopup.setOnAction(e4->{
			// Popup창에 나타낼 컨트롤들 구성 시작...
			HBox popRoot = new HBox();
			
			ImageView imgView = new ImageView();
			imgView.setImage(
				new Image(getClass()
						.getResource("./images/ok.png")
						.toString()));
			imgView.setFitWidth(30);
			imgView.setFitHeight(30);
			
			Label lbMsg = new Label("메시지가 왔습니다.");
			HBox.setMargin(lbMsg, new Insets(0, 5, 0, 5));
			
			popRoot.getChildren().addAll(imgView, lbMsg);
			// 구성 끝...
			
			// Popup객체 생성 후 위에서 구성한 컨트롤들 추가 후 보이기
			Popup popup = new Popup();
			popup.setX(1000);
			popup.setY(400);
			popup.getContent().add(popRoot);
			popup.setAutoHide(true);
			popup.show(primaryStage);
		});
		
		// 사용자가 만든 임의의 창 나타내기
		Button btnCustom = new Button("사용자 정의 창 실행");
		btnCustom.setOnAction(e->{
			// 새창 띄우기
			
			// 1. Stage객체 생성
			Stage dialog = new Stage(StageStyle.UTILITY);
			
			// 2. 모달창 여부 설정
			// 모달창은 자식창이 나타나면 부모창을 사용할 수 없다.
			dialog.initModality(Modality.APPLICATION_MODAL);
			
			// 3. 부모창 지정
			dialog.initOwner(primaryStage);

			dialog.setTitle("사용자 정의 창");
			
			// 4. 자식창이 나타날 컨테이너 객체 생성
			HBox parent2 = new HBox(100);
			parent2.setPadding(new Insets(10));
			parent2.setAlignment(Pos.CENTER);
			FileChooser fileChooser = new FileChooser();
			
			// 축의 값이 주로 문자열일 때 사용하는 객체
			CategoryAxis xAxis = new CategoryAxis();
			
			// 축의 값이 숫자일 때 사용하는 객체
			NumberAxis yAxis = new NumberAxis();
			
			//	위에서 만든 축 정보를 이용한 BarChart객체 생성
			BarChart<String, Number> parent = new BarChart<>(xAxis, yAxis);
			
			parent.setTitle("차트 Title");
			xAxis.setLabel("///이름들어가야하는부분");
			yAxis.setLabel("가격");
			
			//BarChart에 나타날 데이터 구성하기
			XYChart.Series<String , Number> ser1 = new XYChart.Series<>();
			ser1.setName("2015년");
			ser1.getData().add(new XYChart.Data<String, Number>("국어",26000));
			ser1.getData().add(new XYChart.Data<String, Number>("영어",20000));
			ser1.getData().add(new XYChart.Data<String, Number>("수학",10000));
			
			parent.getData().addAll(ser1);
			// 5. Scene 객체 생성해서 컨테이너 객체 추가
			Scene scene = new Scene(parent,800,800);
			
			//6. Stage 객체에 Scene객체 추가
			dialog.setScene(scene);
			dialog.setResizable(false); //크기 고정
			dialog.show();
		});
				
		root.getChildren().addAll(btnFileOpen, btnFileSave, 
				btnDirectory, btnPopup, btnCustom);
		
		Scene scene = new Scene(root, 800, 100);
		primaryStage.setTitle("Dialog창 연습");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
