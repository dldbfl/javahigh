package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import vo.BoardVO;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import service.BoardService;
import service.BoardServiceImpl;

public class BoardController implements Initializable {

	@FXML
	TableView<BoardVO> tableview;
	@FXML
	TableColumn<BoardVO, Integer> no;
	@FXML
	TableColumn<BoardVO, String> name;
	@FXML
	TableColumn<BoardVO, String> writer;
	@FXML
	TableColumn<BoardVO, String> date;
	
	@FXML 
	TableColumn<BoardVO, String> content;
	
	@FXML
	Button addBtn;
	@FXML
	Pagination pagination;
	@FXML
	TextField search;
	@FXML
	Button searchBtn;
	@FXML
	Button exit;
	
	private int board_no;

	private BoardVO bv;
	
	private int from, to, itemsForPage;
	private ObservableList<BoardVO> allTableData, currentPageData;

	Stage dialog = new Stage(StageStyle.UTILITY);
	Parent parent = null;

	private BoardService boardService;
	
	

	public BoardController() {
		boardService = new BoardServiceImpl();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		tableLocation(); // 테이블세팅
		tableRead(); // 게시글 읽기 삭제

		searchBtn.setOnAction(e -> {

			if (search.getText().isEmpty()) {
				tableLocation();
				search.requestFocus(); // 해당 객체에 포커스 주기
				return;
			}
			
			bv = new BoardVO();
			bv.setBoard_title(search.getText());

			List<BoardVO> boardList = boardService.getSearchBoard(bv);

			if (boardList.size() == 0) {
				errMsg("", "검색하신 게시글이 없습니다.");
				return;
			} else {

				allTableData = FXCollections.observableArrayList(boardList); // 어레이리스트에 담은 데이터를 observableArrayList에 담음

				tableview.setItems(allTableData);
			}
		});
	}


	public void tableRead() {
		//게시글 읽기
		tableview.setOnMouseClicked(e->{
			if(e.getClickCount() > 1) {
			
			board_no = tableview.getSelectionModel().getSelectedItem().getBoard_no();
				
			dialog.setTitle("게시글확인/수정/삭제");
			
			try {
				parent = FXMLLoader.load(getClass().getResource("UpdateDelete.fxml"));
			}catch (IOException ex) {
				ex.printStackTrace();
			}
			// 5. Scene객체 생성해서 컨테이너 객체 추가
			Scene scene = new Scene(parent);
			
			// 6. Stage객체에 Scene객체 추가
			dialog.setScene(scene);
			dialog.setResizable(false);
			dialog.show();
			//TableView에서 선택한 줄의 데이터를 가져온다.
			BoardVO bv = tableview.getSelectionModel().getSelectedItem();
			
			TextField r_writer = (TextField) parent.lookup("#r_writer"); 
			TextField r_title =  (TextField) parent.lookup("#r_title"); 
			TextArea r_content = (TextArea) parent.lookup("#r_content");
			
			r_writer.setText(bv.getBoard_writer());
			r_title.setText(bv.getBoard_title());
			r_content.setText(bv.getBoard_content());
			
			Button updateBtn = (Button) parent.lookup("#updateBtn");
			Button deleteBtn = (Button) parent.lookup("#deleteBtn"); 
			
			updateBtn.setOnAction(e1->{
				
				r_title.setEditable(true);
				r_content.setEditable(true);
				
				deleteBtn.setDisable(true);
				
				r_title.requestFocus();
				
				updateBtn.setOnAction(e2->{ //수정모드에서 다시 수정버튼을 누를때
					
					if(r_title.getText().isEmpty()) {
						errMsg("", "제목을 입력해주세요.");
						r_title.requestFocus(); //해당 객체에 포커스 주기
						return;
					}else if(r_content.getText().isEmpty()){
						errMsg("", "내용을 입력해주세요.");
						r_content.requestFocus(); //해당 객체에 포커스 주기
						return;
					}
					
					bv.setBoard_title(r_title.getText());
					bv.setBoard_writer(r_writer.getText());
					bv.setBoard_content(r_content.getText());
					
					int cnt = boardService.updateBoard(bv);
					
					if(cnt==1) {
					infoMsg("","수정되었습니다.");
					
					tableLocation();
					
					dialog.close();}
					else {
						errMsg("", "수정 실패");
					}
				});
				
		  });
			
			
				deleteBtn.setOnAction(e2->{
				
				Alert alertConfirm = new Alert(AlertType.CONFIRMATION);
				alertConfirm.setTitle("삭제");
				alertConfirm.setContentText("삭제하시겠습니까?");
				
				// Alert창을 보여주고 사용자가 누른 버튼 값 읽어오기
				ButtonType confirmResult = alertConfirm.showAndWait().get();
				
				if(confirmResult == ButtonType.OK) {				
					int board_no = tableview.getSelectionModel().getSelectedItem().getBoard_no();
					
					boardService.deleteBoard(board_no);
					
					infoMsg("", "삭제되었습니다.");

					dialog.close();
					
					tableLocation();
					
				}else if(confirmResult == ButtonType.CANCEL) {

				}
				
		  });
			}
		});
		
	}
		
	
	private void tableLocation() {
		no.setCellValueFactory(new PropertyValueFactory<>("board_no")); // 컬럼 참조.
		name.setCellValueFactory(new PropertyValueFactory<>("board_title"));
		writer.setCellValueFactory(new PropertyValueFactory<>("board_writer"));
		date.setCellValueFactory(new PropertyValueFactory<>("board_date"));
		content.setCellValueFactory(new PropertyValueFactory<>("board_content"));

		allTableData = FXCollections.observableArrayList(boardService.getAllBoardList()); // 어레이리스트에 담은 데이터를
																							// observableArrayList에 담음

		tableview.setItems(allTableData); // observableArrayList에 담은 데이터를 테이블뷰에 세팅.

		itemsForPage = 10; // 한페이지에 보여줄 항목 수 설정
		int totPageCount = allTableData.size() % itemsForPage == 0 ? allTableData.size() / itemsForPage
				: allTableData.size() / itemsForPage + 1;
		pagination.setPageCount(totPageCount); // 전체 페이지 수 설정

		pagination.setPageFactory(new Callback<Integer, Node>() {

			@Override
			public Node call(Integer param) {
				from = param * itemsForPage;
				to = from + itemsForPage - 1;
				tableview.setItems(getTableViewData(from, to));
				return tableview;
			}

			private ObservableList<BoardVO> getTableViewData(int from, int to) {

				// 현재 페이지의 데이터 초기화
				currentPageData = FXCollections.observableArrayList();

				int totSize = allTableData.size();
				for (int i = from; i <= to && i < totSize; i++) {
					currentPageData.add(allTableData.get(i));
				}
				return currentPageData;
			}

		});
	}

	@FXML
	public void addBoard(ActionEvent event) {
		dialog.setTitle("새글작성");
		
		// 4. 자식창이 나타날 컨테이너 객체 생성

		try {
			parent = FXMLLoader.load(getClass().getResource("insertBoard.fxml"));
		}catch (IOException ex) {
			ex.printStackTrace();
		}
		// 5. Scene객체 생성해서 컨테이너 객체 추가
		Scene scene = new Scene(parent);
		
		// 6. Stage객체에 Scene객체 추가
		dialog.setScene(scene);
		dialog.setResizable(false);//크기고정
		dialog.show();
		
		TextField title = (TextField) parent.lookup("#title");
		TextField writer = (TextField) parent.lookup("#writer");
		TextArea content = (TextArea) parent.lookup("#content");

		
		Button sbtn = (Button) parent.lookup("#apply");  //새글 저장 클릭
		sbtn.setOnAction(e->{
			
			if(writer.getText().isEmpty()) {
				errMsg("", "작성자를 입력해주세요.");
				writer.requestFocus(); //해당 객체에 포커스 주기
				return;
			}else if(title.getText().isEmpty()){
				errMsg("", "제목을 입력해주세요.");
				title.requestFocus(); //해당 객체에 포커스 주기
				return;
			}else if(content.getText().isEmpty()){
				errMsg("", "내용을 입력해주세요.");
				content.requestFocus(); //해당 객체에 포커스 주기
				return;
			}
			
			BoardVO bv = new BoardVO();
			bv.setBoard_title(title.getText());
			bv.setBoard_writer(writer.getText());
			bv.setBoard_content(content.getText());
			
			int cnt = boardService.insertBoard(bv);
			
			if(cnt==1) {
				infoMsg("", "글이 작성되었습니다.");
				tableLocation();
				dialog.close();
			}else {
				errMsg("", "글 작성 실패");
				return;
			}
		});
		
		Button canbtn = (Button) parent.lookup("#exit");  //취소버튼
		canbtn.setOnAction(e->{
			dialog.close();
		});
		
		Button resetBtn = (Button) parent.lookup("#reset");  //초기화버튼
		resetBtn.setOnAction(e->{
			title.clear();
			writer.clear();
			content.clear();
		});
	}

	@FXML
	public void exit(ActionEvent event) {
		Platform.exit();
	}

	public void errMsg(String headerText, String msg) {
		Alert errAlert = new Alert(AlertType.ERROR);
		errAlert.setTitle("오류");
		errAlert.setHeaderText(headerText);
		errAlert.setContentText(msg);
		errAlert.showAndWait();
	}
	
	public void infoMsg(String headerText, String msg) {
		Alert infoAlert = new Alert(AlertType.INFORMATION);
		infoAlert.setTitle("확인");
		infoAlert.setHeaderText(headerText);
		infoAlert.setContentText(msg);
		infoAlert.showAndWait();
	}
}