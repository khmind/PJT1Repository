package dao.bkMng;

import javax.sql.DataSource;

public class ManegerDAO {
	
	DataSource ds;
	
	public void setDataSource(DataSource ds) { 
		this.ds=ds;
	}

}
