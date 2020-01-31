package kr.or.ddit.basic;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Pagination;

public class PagingController  implements Initializable{
	
	
	@FXML TableView<MemberVO> tableView;
	@FXML TableColumn <MemberVO, String> id;
	@FXML TableColumn <MemberVO, String> name;
	@FXML TableColumn <MemberVO, String> addr;
	@FXML Pagination pagination;

	private int from, to, itemsForPage;
	
	private ObservableList<MemberVO> alltableData, currentPageData;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		id.setCellValueFactory(new PropertyValueFactory<>("id"));
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		addr.setCellValueFactory(new PropertyValueFactory<>("addr"));
		
		//	전체 테이블 데이터 설정
		alltableData = FXCollections.observableArrayList();
		
		alltableData.add(new MemberVO("1","이누리1","대전시 선화동"));
		alltableData.add(new MemberVO("2","이누리2","대전시 선화동"));
		alltableData.add(new MemberVO("3","이누리3","대전시 선화동"));
		alltableData.add(new MemberVO("4","이누리4","대전시 선화동"));
		alltableData.add(new MemberVO("5","이누리5","대전시 선화동"));
		alltableData.add(new MemberVO("6","이누리6","대전시 선화동"));
		alltableData.add(new MemberVO("7","이누리7","대전시 선화동"));
		alltableData.add(new MemberVO("8","이누리8","대전시 선화동"));
		alltableData.add(new MemberVO("9","이누리9","대전시 선화동"));
		alltableData.add(new MemberVO("10","이누리10","대전시 선화동"));
		alltableData.add(new MemberVO("11","이누리11","대전시 선화동"));
		alltableData.add(new MemberVO("12","이누리12","대전시 선화동"));
		alltableData.add(new MemberVO("13","이누리13","대전시 선화동"));
		alltableData.add(new MemberVO("14","이누리14","대전시 선화동"));
		alltableData.add(new MemberVO("15","이누리15","대전시 선화동"));
	
		itemsForPage = 5; // 한페이지에 보여줄 수 있는 항목 설정
		int totPageCount = alltableData.size()%itemsForPage == 0 ? 
				alltableData.size()/itemsForPage : alltableData.size()/itemsForPage + 1;
		pagination.setPageCount(totPageCount); // 전체페이지 수 설정
		
		pagination.setPageFactory(new Callback<Integer, Node>(){

			@Override
			public Node call(Integer pageIndex) {
				from = pageIndex * itemsForPage;
				to = from+ itemsForPage -1;
				tableView.setItems(getTableViewData(from, to));
				return tableView;
			}
			/**
			 * TableView에 채워줄 데이터를 가져오는 메서드 
			 * @param from
			 * @param to
			 * @return
			 */
			private ObservableList<MemberVO> getTableViewData(int from, int to) {
				//현재페이지의 데이터 초기화
				currentPageData = FXCollections.observableArrayList();
				
				int totSize = alltableData.size();
				for(int i = from; i<= to && i < totSize; i++) {
					currentPageData.add(alltableData.get(i));
				}
				
				return currentPageData;
			}
		});
	}
}




	