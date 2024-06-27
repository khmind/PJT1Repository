package vo.bkMng;

import java.util.Date;

public class AskVO {
		private String ask_id;
		private String ask_title;
		private String ask_content;
		private String user_id;
		private Date ask_date;
		private Date ask_update;
		private String recomm_content;
		private String recomm_user_id;
		private Date recomm_date;
		private String title;
		private String content;
		
		private String sel1;
		private String searchText;
		private int page;
		private int startPage;
		private int endPadge;
		private int limit;
		
		
		public String getAsk_id() {
			return ask_id;
		}
		public AskVO setAsk_id(String ask_id) {
			this.ask_id = ask_id;
			return this;
		}
		public String getAsk_title() {
			return ask_title;
		}
		public AskVO setAsk_title(String ask_title) {
			this.ask_title = ask_title;
			return this;
		}
		public String getAsk_content() {
			return ask_content;
		}
		public AskVO setAsk_content(String ask_content) {
			this.ask_content = ask_content;
			return this;
		}
		public String getUser_id() {
			return user_id;
		}
		public AskVO setUser_id(String user_id) {
			this.user_id = user_id;
			return this;
		}
		public Date getAsk_date() {
			return ask_date;
		}
		public AskVO setAsk_date(Date ask_date) {
			this.ask_date = ask_date;
			return this;
		}
		public Date getAsk_update() {
			return ask_update;
		}
		public AskVO setAsk_update(Date ask_update) {
			this.ask_update = ask_update;
			return this;
		}
		public String getRecomm_content() {
			return recomm_content;
		}
		public AskVO setRecomm_content(String recomm_content) {
			this.recomm_content = recomm_content;
			return this;
		}
		public String getRecomm_user_id() {
			return recomm_user_id;
		}
		public AskVO setRecomm_user_id(String recomm_user_id) {
			this.recomm_user_id = recomm_user_id;
			return this;
		}
		public Date getRecomm_date() {
			return recomm_date;
		}
		public AskVO setRecomm_date(Date recomm_date) {
			this.recomm_date = recomm_date;
			return this;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getSel1() {
			return sel1;
		}
		public void setSel1(String sel1) {
			this.sel1 = sel1;
		}
		public String getSearchText() {
			return searchText;
		}
		public void setSearchText(String searchText) {
			this.searchText = searchText;
		}
		public int getPage() {
			return page;
		}
		public void setPage(int page) {
			this.page = page;
		}
		public int getStartPage() {
			return startPage;
		}
		public void setStartPage(int startPage) {
			this.startPage = startPage;
		}
		public int getEndPadge() {
			return endPadge;
		}
		public void setEndPadge(int endPadge) {
			this.endPadge = endPadge;
		}
		public int getLimit() {
			return limit;
		}
		public void setLimit(int limit) {
			this.limit = limit;
		}

}
