package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import service.BoardService;
import service.BoardServiceImpl;

public class BoardMain extends Application{
	private BoardService boardService;
	
	public BoardMain() {
		boardService = new BoardServiceImpl();
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("boardMain.fxml"));
		
		Scene scene =new Scene(root);
		
		primaryStage.setTitle("게시판관리");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
