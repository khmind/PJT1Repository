package vo.bkMng;

import java.util.Date;

public class UserVO {

	private String user_id;
	private String user_name;
	private String user_email;
	private String user_pw;
	private String user_role;
	private Date user_date;
	private int cnt;
	private int goodCnt;
	private int rcmCnt;
	
	private String sel1;
	private String sel2;
	private String searchText;
	
	
	
	public String getUser_id() {
		return user_id;
	}
	public UserVO setUser_id(String user_id) {
		this.user_id = user_id;
		return this;
	}
	public String getUser_name() {
		return user_name;
	}
	public UserVO setUser_name(String user_name) {
		this.user_name = user_name;
		return this;
	}
	public String getUser_email() {
		return user_email;
	}
	public UserVO setUser_email(String user_email) {
		this.user_email = user_email;
		return this;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public UserVO setUser_pw(String user_pw) {
		this.user_pw = user_pw;
		return this;
	}
	public String getUser_role() {
		return user_role;
	}
	public UserVO setUser_role(String user_role) {
		this.user_role = user_role;
		return this;
	}
	public Date getUser_date() {
		return user_date;
	}
	public UserVO setUser_date(Date user_date) {
		this.user_date = user_date;
		return this;
	}
	public int getCnt() {
		return cnt;
	}
	public UserVO setCnt(int cnt) {
		this.cnt = cnt;
		return this;
	}
	public int getGoodCnt() {
		return goodCnt;
	}
	public UserVO setGoodCnt(int goodCnt) {
		this.goodCnt = goodCnt;
		return this;
	}
	public int getRcmCnt() {
		return rcmCnt;
	}
	public UserVO setRcmCnt(int rcmCnt) {
		this.rcmCnt = rcmCnt;
		return this;
	}
	public String getSel1() {
		return sel1;
	}
	public UserVO setSel1(String sel1) {
		this.sel1 = sel1;
		return this;
	}
	public String getSel2() {
		return sel2;
	}
	public UserVO setSel2(String sel2) {
		this.sel2 = sel2;
		return this;
	}
	public String getSearchText() {
		return searchText;
	}
	public UserVO setSearchText(String searchText) {
		this.searchText = searchText;
		return this;
	}
	
	
	 	
	
}
