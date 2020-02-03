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
import javafx.util.Callback;

import javafx.scene.control.TableColumn;

public class product_controller implements Initializable{

	@FXML ComboBox<productVo> COMBO1;
	@FXML ComboBox<productVo> COMBO2;
	@FXML TableView<productVo> tableView;
	@FXML TableColumn<productVo, String> PROD_ID;
	@FXML TableColumn<productVo, String> PROD_NAME;
	@FXML TableColumn<productVo, String> PROD_LGU;
	@FXML TableColumn<productVo, String> PROD_BUYER;
	@FXML TableColumn<productVo, String> PROD_COST;
	@FXML TableColumn<productVo, String> PROD_PRICE;
	@FXML TableColumn<productVo, String> PROD_SALE;
	@FXML TableColumn<productVo, String> PROD_OUTLINE;
	@FXML TableColumn<productVo, String> PROD_DETAIL;
	
    productService  productservice = productServiceImpl.getInstance();
    ObservableList<productVo> obList;
    ObservableList<productVo> obifList;
    ObservableList<productVo> view;

	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		System.out.println("메롱");
//		List<productVo> compd1 = productservice.COMBO1();
		obList = FXCollections.observableArrayList(productservice.COMBO1());
		System.out.println("메롱");
		
		COMBO1.setItems(obList);
		
		ListView<productVo> list = new ListView<productVo>();
		
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
					};
				};
			}
		});
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
	
	


}
