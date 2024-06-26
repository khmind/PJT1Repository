package vo.bkMng;

import java.util.Date;

public class NoticeVO {
	
	private String notice_id; // 공지사항번호
	private String notice_title; // 공지사항제목
	private String notice_content; // 공지사항 내용
	private String user_id; // 사용자번호
	private Date notice_date; // 작성일자
	private Date notice_update; // 수정일자
	
	private String title;
	private String content;
	
	private String sel1;
	private String searchText;
	private int page;
	private int startPage;
	private int endPage;
	private int limit;
	
	public String getNotice_id() {
		return notice_id;
	}
	public NoticeVO setNotice_id(String notice_id) {
		this.notice_id = notice_id;
		return this;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public  NoticeVO setNotice_title(String notice_title) {
		this.notice_title = notice_title;
		return this;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public  NoticeVO setNotice_content(String notice_content) {
		this.notice_content = notice_content;
		return this;
	}
	public String getUser_id() {
		return user_id;
	}
	public  NoticeVO setUser_id(String user_id) {
		this.user_id = user_id;
		return this;
	}
	public Date getNotice_date() {
		return notice_date;
	}
	public  NoticeVO setNotice_date(Date notice_date) {
		this.notice_date = notice_date;
		return this;
	}
	public Date getNotice_update() {
		return notice_update;
	}
	public  NoticeVO setNotice_update(Date notice_update) {
		this.notice_update = notice_update;
		return this;
	}
	
	public String getTitle() {
		return title;
	}
	public NoticeVO setTitle(String title) {
		this.title = title;
		return this;
	}
	public String getContent() {
		return content;
	}
	public NoticeVO setContent(String content) {
		this.content = content;
		return this;
	}
	public String getSel1() {
		return sel1;
	}
	public NoticeVO setSel1(String sel1) {
		this.sel1 = sel1;
		return this;
	}
	public String getSearchText() {
		return searchText;
	}
	public NoticeVO setSearchText(String searchText) {
		this.searchText = searchText;
		return this;
	}
	public int getPage() {
		return page;
	}
	public NoticeVO setPage(int page) {
		this.page = page;
		return this;
	}
	public int getStartPage() {
		return startPage;
	}
	public NoticeVO setStartPage(int startPage) {
		this.startPage = startPage;
		return this;
	}
	public int getEndPage() {
		return endPage;
	}
	public NoticeVO setEndPage(int endPage) {
		this.endPage = endPage;
		return this;
	}
	public int getLimit() {
		return limit;
	}
	public NoticeVO setLimit(int limit) {
		this.limit = limit;
		return this;
	}
	
}
