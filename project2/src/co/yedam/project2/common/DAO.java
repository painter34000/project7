package co.yedam.project2.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	public Connection conn;
	
	private String Driver="oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";

	private String user = "project";
	private String pwd = "project";
	
	public DAO() {

		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url,user,pwd);
		}catch (Exception e){
			e.printStackTrace();
			
		}
	}
}
