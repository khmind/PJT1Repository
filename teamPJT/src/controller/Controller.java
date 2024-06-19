package controller;

import java.util.Map;

public interface Controller {

	public String execute(String flag, Map<String, Object> model) throws Exception;
}
