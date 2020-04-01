package board;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import service.BoardService;
import service.BoardServiceImpl;
import vo.BoardVO;


public class BoardFXMainController implements Initializable {

	
    @FXML ResourceBundle resources;
    @FXML TableView<BoardVO> tv;
    @FXML TableColumn<BoardVO, Integer> bno;
    @FXML TableColumn<BoardVO, String> btitle;
    @FXML TableColumn<BoardVO, String> bwriter;
    @FXML TableColumn<BoardVO, String> bdate;
    @FXML TableColumn<BoardVO, String> bcontent;
    @FXML Button add;
    @FXML Button edit;
    @FXML Button display;
    @FXML Button search;
    @FXML Button delete;
    @FXML Button exit;
    @FXML ComboBox<String> combo;
    @FXML TextField searchfield;
    @FXML Pagination page;
    
    
    @FXML TextField writer;
    @FXML TextArea writeContents;
    @FXML TextField writeTitle;
    @FXML Button writeAdd;
    @FXML Button writeCancel;
    
	private BoardService boardService;
	private BoardServiceImpl bsi = BoardServiceImpl.getInstance();
    
    @FXML URL location;
    
	private BoardVO bv;
	
    List<BoardVO>boardList;
    private int from, to, itemsForPage;
    private ObservableList<BoardVO> tableData, currentPageData;
    
    
    Parent parent = null;
    Stage dialog = new Stage(StageStyle.UTILITY);
    
	@FXML TextField editwriter;
	@FXML TextArea editContents;
	@FXML TextField editTitle;
	@FXML Button Edit;
	@FXML Button Del;
    
	private int board_no;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tableLocation(); // 테이블세팅
		
		search.setOnAction(e -> {

			if (search.getText().isEmpty()) {
				tableLocation();
				search.requestFocus(); // 해당 객체에 포커스 주기
				return;
			}
			
			bv = new BoardVO();
			bv.setBoard_title(search.getText());

			List<BoardVO> boardList = boardService.searchBoard(bv);

			if (boardList.size() == 0) {
				info("", "검색하신 게시글이 없습니다.");
				return;
			} else {

				tableData = FXCollections.observableArrayList(boardList); // 어레이리스트에 담은 데이터를 observableArrayList에 담음

				tv.setItems(tableData);
			}
		});
		
	}
	

	
	public void info(String headerText, String msg) {
		
		Alert infoAlert = new Alert(AlertType.ERROR);
		infoAlert.setTitle("알림");
		infoAlert.setHeaderText(headerText);
		infoAlert.setContentText(msg);
		infoAlert.showAndWait();
	}
	
	
	private void tableLocation() {
		bno.setCellValueFactory(new PropertyValueFactory<>("board_no")); // 컬럼 참조.
		btitle.setCellValueFactory(new PropertyValueFactory<>("board_title"));
		bwriter.setCellValueFactory(new PropertyValueFactory<>("board_writer"));
		bdate.setCellValueFactory(new PropertyValueFactory<>("board_date"));
		bcontent.setCellValueFactory(new PropertyValueFactory<>("board_content"));

		tableData = FXCollections.observableArrayList(boardService.displayBoardAll()); // 어레이리스트에 담은 데이터를
																							// observableArrayList에 담음

		tv.setItems(tableData); // observableArrayList에 담은 데이터를 테이블뷰에 세팅.

		itemsForPage = 10; // 한페이지에 보여줄 항목 수 설정
		int totPageCount = tableData.size() % itemsForPage == 0 ? tableData.size() / itemsForPage
				: tableData.size() / itemsForPage + 1;
		page.setPageCount(totPageCount); // 전체 페이지 수 설정

		page.setPageFactory(new Callback<Integer, Node>() {

			@Override
			public Node call(Integer param) {
				from = param * itemsForPage;
				to = from + itemsForPage - 1;
				tv.setItems(getTableViewData(from, to));
				return tv;
			}

			private ObservableList<BoardVO> getTableViewData(int from, int to) {

				// 현재 페이지의 데이터 초기화
				currentPageData = FXCollections.observableArrayList();

				int totSize = tableData.size();
				for (int i = from; i <= to && i < totSize; i++) {
					currentPageData.add(tableData.get(i));
				}
				return currentPageData;
			}

		});
	}
	
	@FXML public void writer(ActionEvent event) {
		
		// 1. Stage객체 생성
		Stage dialog = new Stage(StageStyle.UTILITY);
		
		
		dialog.setTitle("새 게시글 작성");
		
		// 4. 자식창이 나타날 컨테이너 객체 생성
		
		try {
			parent = FXMLLoader.load(getClass().getResource("writer.fxml"));
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		// 5. Scene객체 생성해서 컨테이너 객체 추가
		Scene scene = new Scene(parent);
		
		// 6. Stage객체에 Scene객체 추가
		dialog.setScene(scene);
		dialog.setResizable(false);//크기고정
		dialog.show();
		
		
		// 부모창에서 FXML로 만든 자식창의 컨트롤 객체 얻기
		TextField title = (TextField) parent.lookup("#board_title");
		TextField writer = (TextField) parent.lookup("#board_writer");
		TextArea content = (TextArea) parent.lookup("#board_content");
		
		Button btnOk = (Button) parent.lookup("#writeAdd");
		btnOk.setOnAction(e2->{
			
			if(writer.getText().isEmpty()) {
				info("", "작성자를 입력해주세요.");
				writer.requestFocus(); //해당 객체에 포커스 주기
				return;
			}else if(title.getText().isEmpty()){
				info("", "제목을 입력해주세요.");
				title.requestFocus(); //해당 객체에 포커스 주기
				return;
			}else if(content.getText().isEmpty()){
				info("", "내용을 입력해주세요.");
				content.requestFocus(); //해당 객체에 포커스 주기
				return;
			}
			
			BoardVO bv = new BoardVO();
			bv.setBoard_title(title.getText());
			bv.setBoard_writer(writer.getText());
			bv.setBoard_content(content.getText());
			
			int cnt = boardService.insertBoard(bv);
			
			if(cnt==1) {
				info("", "글이 작성되었습니다.");
				tableLocation();
				dialog.close();
			}else {
				info("", "글 작성 실패");
				return;
			}
		});
		
		Button btnCancel = (Button) parent.lookup("#writeCancel");
		btnCancel.setOnAction(e3->{
			dialog.close();
		});
	}
	
	@FXML
	public void exit(ActionEvent event) {
		Platform.exit();
	}


	
}