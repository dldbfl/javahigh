package Vo;

public class productVo {
	
	private	String lprod_gu;
	private String lprod_nm;
	private String PROD_ID;
	private String PROD_NAME;
	private String PROD_LGU;
	private String PROD_BUYER;
	private String PROD_COST;
	private String PROD_PRICE;
	private String PROD_SALE;
	private String PROD_OUTLINE;
	private String PROD_DETAIL;
	
	
	
	public productVo() {
		
	}
	



	public productVo(String lprod_gu, String lprod_nm, String pROD_ID, String pROD_NAME, String pROD_LGU,
			String pROD_BUYER, String pROD_COST, String pROD_PRICE, String pROD_SALE, String pROD_OUTLINE,
			String pROD_DETAIL) {
		super();
		this.lprod_gu = lprod_gu;
		this.lprod_nm = lprod_nm;
		PROD_ID = pROD_ID;
		PROD_NAME = pROD_NAME;
		PROD_LGU = pROD_LGU;
		PROD_BUYER = pROD_BUYER;
		PROD_COST = pROD_COST;
		PROD_PRICE = pROD_PRICE;
		PROD_SALE = pROD_SALE;
		PROD_OUTLINE = pROD_OUTLINE;
		PROD_DETAIL = pROD_DETAIL;
	}




	public String getLprod_gu() {
		return lprod_gu;
	}




	public void setLprod_gu(String lprod_gu) {
		this.lprod_gu = lprod_gu;
	}




	public String getLprod_nm() {
		return lprod_nm;
	}




	public void setLprod_nm(String lprod_nm) {
		this.lprod_nm = lprod_nm;
	}




	public String getPROD_ID() {
		return PROD_ID;
	}




	public void setPROD_ID(String pROD_ID) {
		PROD_ID = pROD_ID;
	}




	public String getPROD_NAME() {
		return PROD_NAME;
	}




	public void setPROD_NAME(String pROD_NAME) {
		PROD_NAME = pROD_NAME;
	}




	public String getPROD_LGU() {
		return PROD_LGU;
	}




	public void setPROD_LGU(String pROD_LGU) {
		PROD_LGU = pROD_LGU;
	}




	public String getPROD_BUYER() {
		return PROD_BUYER;
	}




	public void setPROD_BUYER(String pROD_BUYER) {
		PROD_BUYER = pROD_BUYER;
	}




	public String getPROD_COST() {
		return PROD_COST;
	}




	public void setPROD_COST(String pROD_COST) {
		PROD_COST = pROD_COST;
	}




	public String getPROD_PRICE() {
		return PROD_PRICE;
	}




	public void setPROD_PRICE(String pROD_PRICE) {
		PROD_PRICE = pROD_PRICE;
	}




	public String getPROD_SALE() {
		return PROD_SALE;
	}




	public void setPROD_SALE(String pROD_SALE) {
		PROD_SALE = pROD_SALE;
	}




	public String getPROD_OUTLINE() {
		return PROD_OUTLINE;
	}




	public void setPROD_OUTLINE(String pROD_OUTLINE) {
		PROD_OUTLINE = pROD_OUTLINE;
	}




	public String getPROD_DETAIL() {
		return PROD_DETAIL;
	}




	public void setPROD_DETAIL(String pROD_DETAIL) {
		PROD_DETAIL = pROD_DETAIL;
	}


	
	

}
