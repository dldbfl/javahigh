package vo;

import java.io.Serializable;

/*게시판 테이블 구조 및 시퀀스

create table jdbc_board(
    board_no number not null,  -- 번호(자동증가)
    board_title varchar2(100) not null, -- 제목
    board_writer varchar2(50) not null, -- 작성자
    board_date date not null,   -- 작성날짜
    board_content clob,     -- 내용
    constraint pk_jdbc_board primary key (board_no)
);
create sequence board_seq
    start with 1   -- 시작번호
    increment by 1; -- 증가값
		
----------------------------------------------------------

// 시퀀스의 다음 값 구하기
//  시퀀스이름.nextVal
*/
public class BoardVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8707448855461133754L;
	
	private int board_no; //번호
	private String board_title; //제목
	private String board_writer; //작성자
	private String board_date; //작성날짜
	private String board_content; //내용
	
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_writer() {
		return board_writer;
	}
	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}
	public String getBoard_date() {
		return board_date;
	}
	public void setBoard_date(String board_date) {
		this.board_date = board_date;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String mem_content) {
		this.board_content = mem_content;
	}
	
	@Override
	public String toString() {
		return "BoardVO [board_no=" + board_no + ", board_title=" + board_title + ", board_writer=" + board_writer
				+ ", board_date=" + board_date + ", mem_content=" + board_content + "]";
	}

	
}
