package main;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.TableView;



public class grade_controller  {

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnadd;

    @FXML
    private TableColumn<?, ?> tlang;

    @FXML
    private TableColumn<?, ?> tname;

    @FXML
    private TableColumn<?, ?> tmath;

    @FXML
    private Button stick;

    @FXML
    private TableColumn<?, ?> teng;

	ObservableList<Member> data =	FXCollections.observableArrayList();
	
	private ObservableList<Member> tableData;
    
	@FXML TableView<Member> tv = new TableView<>(data);
	
	List<Member> tableList = new ArrayList<Member>();
	
    @FXML
	public void initialize() { 	
    	    	
    	tv.setItems(data);
    	
    	
    			
    	tv.setOnMouseClicked(e ->{
    		
    		// 1. Stage객체 생성
			Stage dialog = new Stage(StageStyle.UTILITY);
					
			// 5. Scene 객체 생성해서 컨테이너 객체 추가
			PieChart pieChart = new PieChart();					
			Scene scene = new Scene(pieChart, 500, 500);
			
			// 차트에 들어갈 데이터 형식 만들기
			Member mv = tv.getSelectionModel().getSelectedItem();
	    	
	    	//	차트에 나타날 데이터 구성하기	    	
	    	ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
	    			new PieChart.Data("국어", mv.getTlang()),
					new PieChart.Data("수학", mv.getTmath()),
					new PieChart.Data("영어", mv.getTeng())
	    			
	    	);
			
	    	pieChart.setTitle(mv.getTname());
			pieChart.setLabelLineLength(20);
			pieChart.setLegendSide(Side.RIGHT); // 범례가 나타날 위치
			pieChart.setData(pieChartData); // 데이터 설정			

			//6. Stage 객체에 Scene객체 추가
			
			dialog.setTitle("파이 차트");			
			dialog.setScene(scene);
			dialog.setResizable(false); //크기 고정
			dialog.show();
    	
    		});
    	
	}
	
	@FXML
	void btnaddClicked(ActionEvent event) {
		
			// 1. Stage객체 생성
			Stage dialog = new Stage(StageStyle.UTILITY);
			
			// 2. 모달창 여부 설정
			// 모달창은 자식창이 나타나면 부모창을 사용할 수 없다.
			dialog.initModality(Modality.APPLICATION_MODAL);
			
			// 3. 부모창 지정
//			dialog.initOwner(primaryStage);

			dialog.setTitle("사용자 정의 창");
			
			// 4. 자식창이 나타날 컨테이너 객체 생성
			Parent parent = null;
			try {
				parent = FXMLLoader.load(getClass().getResource("gradeadd.fxml"));
			}catch(IOException ex) {
				ex.printStackTrace();
			}
			
			// 부모창에서 FXML로 만든 자식창의 컨트롤 객체 얻기
			TextField txtName = (TextField) parent.lookup("#txtName");
			TextField txtKor = (TextField) parent.lookup("#txtKor");
			TextField txtMath = (TextField) parent.lookup("#txtMath");
			TextField txtEng = (TextField) parent.lookup("#txtEng");
//					PasswordField pass = (PasswordField) parent.lookup("#pass");
			
			
			
			Button btnOk = (Button) parent.lookup("#btnOk");
			btnOk.setOnAction(e2->{
						
				tname.setCellValueFactory(new PropertyValueFactory<>("tname"));
				tlang.setCellValueFactory(new PropertyValueFactory<>("tlang"));
				tmath.setCellValueFactory(new PropertyValueFactory<>("tmath"));
				teng.setCellValueFactory(new PropertyValueFactory<>("teng"));

				System.out.println("이름 : "+ txtName.getText());
				System.out.println("국어 : "+ txtKor.getText());
				System.out.println("수학 : "+ txtMath.getText());
				System.out.println("영어 : "+ txtEng.getText());
//						System.out.println("비밀번호 : "+ pass.getText());

				
				
				Member mvo = new Member();
				mvo.setTname(txtName.getText());
				mvo.setTlang(Integer.parseInt(txtKor.getText()));
				mvo.setTmath(Integer.parseInt(txtMath.getText()));
				mvo.setTeng(Integer.parseInt(txtEng.getText()));
				 
				 tableList.add(mvo);//VO 객체에 담아서 어레이리스트에 담음.

				 
			 tableData = FXCollections.observableArrayList(tableList); //어레이리스트에 담은 데이터를 observableArrayList에 담음
			 
			 tv.setItems(tableData); //observableArrayList에 담은 데이터를 테이블뷰에 세팅.

				
				
//				data.add(new Member(txtName.getText(), 
//						Integer.parseInt(txtKor.getText()), 
//						Integer.parseInt(txtMath.getText()), 
//						Integer.parseInt(txtEng.getText())));
				dialog.close();
			});
			
			Button btnCancel = (Button) parent.lookup("#btnCancel");
			btnCancel.setOnAction(e3->{
				dialog.close();
			});
			
			// 5. Scene 객체 생성해서 컨테이너 객체 추가
			Scene scene = new Scene(parent);
			
			//6. Stage 객체에 Scene객체 추가
			dialog.setScene(scene);
			dialog.setResizable(false); //크기 고정
			dialog.show();
		}
	
	
	
	public class Member {
		private String tname;
		private int tlang;
		private int tmath;
		private int teng;
		
		public Member() {}
		
		public Member(String tname, int tlang, int tmath, int teng) {
			super();
			this.tname = tname;
			this.tlang = tlang;
			this.tmath = tmath;
			this.teng = teng;
			
		}


		public String getTname() {
			return tname;
		}


		public void setTname(String tname) {
			this.tname = tname;
		}


		public int getTlang() {
			return tlang;
		}


		public void setTlang(int tlang) {
			this.tlang = tlang;
		}


		public int getTmath() {
			return tmath;
		}


		public void setTmath(int tmath) {
			this.tmath = tmath;
		}


		public int getTeng() {
			return teng;
		}


		public void setTeng(int teng) {
			this.teng = teng;
		}
		
		
		
		
		
		
	}

	@FXML public void btnbarClicked(ActionEvent event) {
		
		// 1. Stage객체 생성
				Stage dialog = new Stage(StageStyle.UTILITY);
				
				// 축의 값이 주로 문자열일 때 사용하는 객체
				CategoryAxis xAxis = new CategoryAxis();
				
				// 축의 값이 숫자일 때 사용하는 객체
				NumberAxis yAxis = new NumberAxis();
				
				//	위에서 만든 축 정보를 이용한 BarChart객체 생성
				BarChart<String, Number> parent = new BarChart<>(xAxis, yAxis);
				
				dialog.setTitle("성적 막대그래프");
				parent.setTitle("총괄 성적 관리");
				xAxis.setLabel("학생");
				yAxis.setLabel("점수");
				
				XYChart.Series<String , Number> ser1 = new XYChart.Series<>();
				XYChart.Series<String, Number> ser2 = new XYChart.Series<>();
				XYChart.Series<String, Number> ser3 = new XYChart.Series<>();
				
				ser1.setName("국어");
				ser2.setName("수학");
				ser3.setName("영어");
				
				
//				System.out.println(tableList.get(0).getTname());
				for(int i =0; i < tableList.size();i++){
					//BarChart에 나타날 데이터 구성하기
										
					ser1.getData().add(new XYChart.Data<String, Number>(tableList.get(i).getTname(),tableList.get(i).getTlang()));
					ser2.getData().add(new XYChart.Data<String, Number>(tableList.get(i).getTname(),tableList.get(i).getTeng()));
					ser3.getData().add(new XYChart.Data<String, Number>(tableList.get(i).getTname(),tableList.get(i).getTmath()));
					
					}
				System.out.println(tableList.get(1).getTname());
	
				parent.getData().addAll(ser1,ser2,ser3);
				// 5. Scene 객체 생성해서 컨테이너 객체 추가
				Scene scene = new Scene(parent,500,500);
				
				//6. Stage 객체에 Scene객체 추가
				dialog.setScene(scene);
				dialog.setResizable(false); //크기 고정
				dialog.show();
			
	}
	
		

		
			
	
}
