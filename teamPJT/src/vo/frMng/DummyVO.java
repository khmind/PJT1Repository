package vo.frMng;

import java.sql.Timestamp;

public class DummyVO {

	private String user_id;
	private String user_name;
	private String user_email;
	private String user_pw;
	private String user_role;
	private Timestamp user_date; 
		
	public String getUser_id() {
		return user_id;
	}
	public DummyVO setUser_id(String user_id) {
		this.user_id = user_id;
		return this;
	}
	public String getUser_name() {
		return user_name;
	}
	public DummyVO setUser_name(String user_name) {
		this.user_name = user_name;
		return this;
	}
	public String getUser_email() {
		return user_email;
	}
	public DummyVO setUser_email(String user_email) {
		this.user_email = user_email;
		return this;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public DummyVO setUser_pw(String user_pw) {
		this.user_pw = user_pw;
		return this;
	}
	public String getUser_role() {
		return user_role;
	}
	public DummyVO setUser_role(String user_role) {
		this.user_role = user_role;
		return this;
	}
	public Timestamp getUser_date() {
		return user_date;
	}
	public DummyVO setUser_date(Timestamp user_date) {
		this.user_date = user_date;
		return this;
	}
}
