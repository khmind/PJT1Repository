package controller.bkMng;

import java.util.Map;

import controller.Controller;
import dao.bkMng.ManegerDAO;

public class Maneger_Controller implements Controller{
	
	ManegerDAO manegerDAO;
	
	public Maneger_Controller setDAO(ManegerDAO manegerDAO) {
		this.manegerDAO = manegerDAO;
		return this;
	}
	
	

	@Override
	public String execute(String flag, Map<String, Object> model) throws Exception {

		return "bk_admin.jsp";
	}

}
