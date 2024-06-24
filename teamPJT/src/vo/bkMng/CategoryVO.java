package vo.bkMng;

import java.sql.Date;

public class CategoryVO {

	private String cate_id;
	private String cate_name;
	private String cate_order;
	private String cate_place;
	private Date cate_date;
	private String action;	
	
	public String getCate_id() {
		return cate_id;
	}
	public CategoryVO setCate_id(String cate_id) {
		this.cate_id = cate_id;
		return this;
	}
	public String getCate_name() {
		return cate_name;
	}
	public CategoryVO setCate_name(String cate_name) {
		this.cate_name = cate_name;
		return this;
	}
	public String getCate_order() {
		return cate_order;
	}
	public CategoryVO setCate_order(String cate_order) {
		this.cate_order = cate_order;
		return this;
	}
	public String getCate_place() {
		return cate_place;
	}
	public CategoryVO setCate_place(String cate_place) {
		this.cate_place = cate_place;
		return this;
	}
	public Date getCate_date() {
		return cate_date;
	}
	public CategoryVO setCate_date(Date cate_date) {
		this.cate_date = cate_date;
		return this;
	}
	public String getAction() {
		return action;
	}
	public CategoryVO setAction(String action) {
		this.action = action;
		return this;
	}
	
}
