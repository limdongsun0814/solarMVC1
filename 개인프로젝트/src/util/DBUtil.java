package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	
	
	
	//DB 연결
	public static Connection getConnection() {
		String url="jdbc:oracle:thin:@localhost:1521:XE"; //나의 hr pro~에 drv~ uri에 있다.
		String user_id="limgndsolar";
		String password="1234";
		Connection conn = null; 
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. Driver Load 성공");
			
			conn = DriverManager.getConnection(url, user_id, password);
			System.out.println("2. DB 연결 완료");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	//자원 반납(DB 연결 해제, statement 해제, ResultSet 해제)
	public static void getDisconnect(Connection conn, Statement st , ResultSet rs) {
		try {
			if(rs!= null) rs.close();
			if(st!= null) st.close();
			if(conn!= null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
