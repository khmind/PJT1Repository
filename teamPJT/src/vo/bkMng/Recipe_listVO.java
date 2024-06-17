package vo.bkMng;

import java.sql.Date;
import java.sql.Timestamp;

public class Recipe_listVO {

	private String recipe_id; //레시피번호( 규칙 : RE001 )
	private String class_id; //레시피분류번호( 규칙 : C001 )
	private String recipe_title;
	private String recipe_content;
	private String recipe_stuff;
	private String recipe_show;
	private int recipe_good;
	private int recipe_rcm;
	private int recipe_cnt;
	private String recipe_level;
	private String user_id; //사용자번호(  규칙 : U001 )
	private Date recipe_date;
	
	
	public String getRecipe_id() {
		return recipe_id;
	}
	public Recipe_listVO setRecipe_id(String recipe_id) {
		this.recipe_id = recipe_id;
		return this;
	}
	public String getClass_id() {
		return class_id;
	}
	public Recipe_listVO setClass_id(String class_id) {
		this.class_id = class_id;
		return this;
	}
	public String getRecipe_title() {
		return recipe_title;
	}
	public Recipe_listVO setRecipe_title(String recipe_title) {
		this.recipe_title = recipe_title;
		return this;
	}
	public String getRecipe_content() {
		return recipe_content;
	}
	public Recipe_listVO setRecipe_content(String recipe_content) {
		this.recipe_content = recipe_content;
		return this;
	}
	public String getRecipe_stuff() {
		return recipe_stuff;
	}
	public Recipe_listVO setRecipe_stuff(String recipe_stuff) {
		this.recipe_stuff = recipe_stuff;
		return this;
	}
	public String getRecipe_show() {
		return recipe_show;
	}
	public Recipe_listVO setRecipe_show(String recipe_show) {
		this.recipe_show = recipe_show;
		return this;
	}
	public int getRecipe_good() {
		return recipe_good;
	}
	public Recipe_listVO setRecipe_good(int recipe_good) {
		this.recipe_good = recipe_good;
		return this;
	}
	public int getRecipe_rcm() {
		return recipe_rcm;
	}
	public Recipe_listVO setRecipe_rcm(int recipe_rcm) {
		this.recipe_rcm = recipe_rcm;
		return this;
	}
	public int getRecipe_cnt() {
		return recipe_cnt;
	}
	public Recipe_listVO setRecipe_cnt(int recipe_cnt) {
		this.recipe_cnt = recipe_cnt;
		return this;
	}
	public String getRecipe_level() {
		return recipe_level;
	}
	public Recipe_listVO setRecipe_level(String recipe_level) {
		this.recipe_level = recipe_level;
		return this;
	}
	public String getUser_id() {
		return user_id;
	}
	public Recipe_listVO setUser_id(String user_id) {
		this.user_id = user_id;
		return this;
	}
	public Date getRecipe_date() {
		return recipe_date;
	}
	public Recipe_listVO setRecipe_date(Date date) {
		this.recipe_date = date;
		return this;
	}
	
	
}
