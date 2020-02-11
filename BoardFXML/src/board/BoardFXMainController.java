package board;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import vo.BoardVO;

public class BoardFXMainController implements Initializable {

	
    @FXML ResourceBundle resources;
    @FXML TableView<String> tv;
    @FXML TableColumn<BoardVO, String> board_no;
    @FXML TableColumn<BoardVO, String> board_title;
    @FXML TableColumn<BoardVO, String> board_writer;
    @FXML TableColumn<BoardVO, String> board_date;
    @FXML TableColumn<BoardVO, String> board_content;
    @FXML Button add;
    @FXML Button edit;
    @FXML Button display;
    @FXML Button search;
    @FXML Button delete;
    @FXML Button exit;
    @FXML ComboBox<String> combo;
    @FXML TextField searchfield;
    @FXML Pagination page;
    @FXML URL location;

    List<BoardVO>boardList;
    private ObservableList<BoardVO> tableData, currentPageData;
    private ObservableList<String> comboData;
    
    List<BoardVO>bv = new ArrayList<BoardVO>();
    Parent parent
    		
    
    
    @FXML void initialize() {
        

    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		display();
		
	}
	
	private void display() {
		// TODO Auto-generated method stub
		
	}
}