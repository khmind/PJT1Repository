package vo.bkMng;

import java.sql.Date;
import java.sql.Timestamp;

public class RecipeVO {

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
	
	private String img_main;
	private String class_name;
	private String user_name;
	
	private String img_path_01;
	private String img_path_02;
	private String img_path_03;
	
	private String commnet_id;
	private String comment_content;
	private Date comment_date;
	
	public String getRecipe_id() {
		return recipe_id;
	}
	public RecipeVO setRecipe_id(String recipe_id) {
		this.recipe_id = recipe_id;
		return this;
	}
	public String getClass_id() {
		return class_id;
	}
	public RecipeVO setClass_id(String class_id) {
		this.class_id = class_id;
		return this;
	}
	public String getRecipe_title() {
		return recipe_title;
	}
	public RecipeVO setRecipe_title(String recipe_title) {
		this.recipe_title = recipe_title;
		return this;
	}
	public String getRecipe_content() {
		return recipe_content;
	}
	public RecipeVO setRecipe_content(String recipe_content) {
		this.recipe_content = recipe_content;
		return this;
	}
	public String getRecipe_stuff() {
		return recipe_stuff;
	}
	public RecipeVO setRecipe_stuff(String recipe_stuff) {
		this.recipe_stuff = recipe_stuff;
		return this;
	}
	public String getRecipe_show() {
		return recipe_show;
	}
	public RecipeVO setRecipe_show(String recipe_show) {
		this.recipe_show = recipe_show;
		return this;
	}
	public int getRecipe_good() {
		return recipe_good;
	}
	public RecipeVO setRecipe_good(int recipe_good) {
		this.recipe_good = recipe_good;
		return this;
	}
	public int getRecipe_rcm() {
		return recipe_rcm;
	}
	public RecipeVO setRecipe_rcm(int recipe_rcm) {
		this.recipe_rcm = recipe_rcm;
		return this;
	}
	public int getRecipe_cnt() {
		return recipe_cnt;
	}
	public RecipeVO setRecipe_cnt(int recipe_cnt) {
		this.recipe_cnt = recipe_cnt;
		return this;
	}
	public String getRecipe_level() {
		return recipe_level;
	}
	public RecipeVO setRecipe_level(String recipe_level) {
		this.recipe_level = recipe_level;
		return this;
	}
	public String getUser_id() {
		return user_id;
	}
	public RecipeVO setUser_id(String user_id) {
		this.user_id = user_id;
		return this;
	}
	public Date getRecipe_date() {
		return recipe_date;
	}
	public RecipeVO setRecipe_date(Date date) {
		this.recipe_date = date;
		return this;
	}
	
	public String getImg_main() {
		return img_main;
	}
	public RecipeVO setImg_main(String img_main) {
		this.img_main = img_main;
		return this;
	}
	public String getClass_name() {
		return class_name;
	}
	public RecipeVO setClass_name(String class_name) {
		this.class_name = class_name;
		return this;
	}
	public String getUser_name() {
		return user_name;
	}
	public RecipeVO setUser_name(String user_name) {
		this.user_name = user_name;
		return this;
	}
	public String getImg_path_01() {
		return img_path_01;
	}
	public RecipeVO setImg_path_01(String img_path_01) {
		this.img_path_01 = img_path_01;
		return this;
	}
	public String getImg_path_02() {
		return img_path_02;
	}
	public RecipeVO setImg_path_02(String img_path_02) {
		this.img_path_02 = img_path_02;
		return this;
	}
	public String getImg_path_03() {
		return img_path_03;
	}
	public RecipeVO setImg_path_03(String img_path_03) {
		this.img_path_03 = img_path_03;
		return this;
	}
	public String getCommnet_id() {
		return commnet_id;
	}
	public RecipeVO setCommnet_id(String commnet_id) {
		this.commnet_id = commnet_id;
		return this;
	}
	public String getComment_content() {
		return comment_content;
	}
	
	public RecipeVO setComment_content(String comment_content) {
		this.comment_content = comment_content;
		return this;
	}
	public Date getComment_date() {
		return comment_date;
	}
	public RecipeVO setComment_date(Date comment_date) {
		this.comment_date = comment_date;
		return this;
	}
	
}
