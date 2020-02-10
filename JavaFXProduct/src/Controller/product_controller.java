package Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import Service.productService;
import Service.productServiceImpl;
import Vo.productVo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import javafx.scene.control.TableColumn;
import javafx.event.ActionEvent;

public class product_controller implements Initializable{

	@FXML ComboBox<productVo> COMBO1;
	@FXML ComboBox<productVo> COMBO2;
	@FXML TableView<productVo> tableView;
	@FXML TableColumn <productVo, String>prod_id;
	@FXML TableColumn <productVo, String>prod_name;
	@FXML TableColumn <productVo, String>prod_lgu;
	@FXML TableColumn <productVo, String>prod_buyer;
	@FXML TableColumn <productVo, String>prod_cost;
	@FXML TableColumn <productVo, String>prod_price;
	@FXML TableColumn <productVo, String>prod_sale;
	@FXML TableColumn <productVo, String>prod_outline;
	@FXML TableColumn <productVo, String>prod_detail;

	
    ObservableList<productVo> COMBO1Data;
    ObservableList<productVo> COMBO2Data;
    ObservableList<productVo> view;

    productService  service = productServiceImpl.getInstance();
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {		
		prod_id.setCellValueFactory(new PropertyValueFactory<>("prod_id"));
		prod_name.setCellValueFactory(new PropertyValueFactory<>("prod_name"));
		prod_lgu.setCellValueFactory(new PropertyValueFactory<>("prod_lgu"));
		prod_buyer.setCellValueFactory(new PropertyValueFactory<>("prod_buyer"));
		prod_cost.setCellValueFactory(new PropertyValueFactory<>("prod_cost"));
		prod_price.setCellValueFactory(new PropertyValueFactory<>("prod_price"));
		prod_sale.setCellValueFactory(new PropertyValueFactory<>("prod_sale"));
		prod_outline.setCellValueFactory(new PropertyValueFactory<>("prod_outline"));
		prod_detail.setCellValueFactory(new PropertyValueFactory<>("prod_detail"));
				
//		ListView<productVo> list = new ListView<productVo>();
//		List<productVo> compd1 = productservice.COMBO1();

		COMBO1Data = FXCollections.observableArrayList(service.COMBO1());
		COMBO1.setItems(COMBO1Data);
		
		COMBO1.setCellFactory(new Callback<ListView<productVo>, ListCell<productVo>>() {
			
			@Override
			public ListCell<productVo> call(ListView<productVo> param) {
				return new ListCell<productVo>() {
					@Override
					protected void updateItem(productVo item, boolean empty) {
						super.updateItem(item, empty);
						if(!empty) {
							setText(item.getLprod_nm());
						}
					}
				};
			}
		});
		//바깥에 보이는 combo1의 내용
		COMBO1.setButtonCell(new ListCell<productVo>() {
			@Override
			protected void updateItem(productVo item, boolean empty) {
				super.updateItem(item, empty);
				if(!empty) {
					setText(item.getLprod_nm());
				}
			}
		});
	
	}

	@FXML public void COMBO1Sel(ActionEvent event) {
		//lprod에서 데이터 받기
		productVo pv = COMBO1.getValue();
		
		//combo2에 prod_lgu = #lg#에 들어갈 lprod 데이터를 보내서 같은 값의 데이터를 받음
		COMBO2Data = FXCollections.observableArrayList(service.COMBO2(pv.getLprod_gu()));
		COMBO2.setItems(COMBO2Data);
		
		//combo2에 데이터 정렬
		COMBO2.setCellFactory(new Callback<ListView<productVo>, ListCell<productVo>>() {

			@Override
			public ListCell<productVo> call(ListView<productVo> param) {
				return new ListCell<productVo>(){
					@Override
					protected void updateItem(productVo item, boolean empty) {
						super.updateItem(item, empty);
						if(!empty) {
							setText(item.getProd_name());
						}
					}
				};
			}
		});
		
		//바깥에 보이는 com2의 내용
		COMBO2.setButtonCell(new ListCell<productVo>() {
					@Override
					protected void updateItem(productVo item, boolean empty) {
						super.updateItem(item, empty);
						if(!empty) {
							setText(item.getProd_name());
						}
					}
				});
			}
	

	@FXML public void COMBO2Sel(ActionEvent event) {
		//테이블에 리스트 출력하기
		productVo pv2 = COMBO2.getValue();
		view = FXCollections.observableArrayList(pv2);
		tableView.setItems(view);
		
	}


	


}
