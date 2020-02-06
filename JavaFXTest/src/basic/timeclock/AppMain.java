package basic.timeclock;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {
/**
 	이 자료는 자바 FX의 꽃 자바FX 어플리케이션 쓰레드에 관한 내용입니다.
 	Platform.runLater메소드를 사용하는 예제입니다.
 */
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("Root.fxml"));
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		
		primaryStage.setTitle("Platform.runLater() 예제");
		
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);;
	}

}
