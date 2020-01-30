package exam;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class practiceMain extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
	
	Parent root = FXMLLoader.load(getClass().getResource("Practice.fxml"));
	Scene scene = new Scene(root);
	
	primaryStage.setTitle("1번째 꺼");
	primaryStage.setScene(scene);
	primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
	
}
