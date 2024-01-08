package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.JobDTO;
import DTO.deptDTO;
import DTO.empDTO;
import DTO.발전DTO;
import DTO.위치_DTO;
import util.DBUtil;



public class empDAO {
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	
	public boolean login_check(String login_id, String password) {
		boolean result = false;
		String sql = "select count(*) from 직원 where 서버_ID = ?  and 서버_password=?";
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,login_id);
			pst.setString(2,password);
			int cnt=0;
			rs=pst.executeQuery();  //update3
			
			while(rs.next()) {
				cnt = rs.getInt(1);  
			}
			
			if(cnt>=1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.getDisconnect(conn, pst, rs);
		}
		
		return result;
	}

	public boolean sign_up(String name, String email, String phone_number, String iD, String password) {
		boolean result = false;
		//EXECUTE insert_직원('임동선','asme12@naver.com','010-3393-2244',null,'asme12','1234',null);
//		String sql = "EXECUTE insert_직원(?,?,?,null,?,?,null)";
		String sql = "call insert_직원(?,?,?,null,?,?,null)";
		conn = DBUtil.getConnection();
		try {

			pst = conn.prepareCall(sql);
			pst.setString(1,name);
			pst.setString(2,email);
			pst.setString(3,phone_number);
			pst.setString(4,iD);
			pst.setString(5,password);
			pst.executeUpdate();
			
			result = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.getDisconnect(conn, pst, rs);
		}
		
		return result;
	}
	
	public boolean dept_insert(String name) {
		boolean result = false;
		//EXECUTE insert_직원('임동선','asme12@naver.com','010-3393-2244',null,'asme12','1234',null);
//		String sql = "EXECUTE insert_직원(?,?,?,null,?,?,null)";
		String sql = "call insert_부서(?)";
		conn = DBUtil.getConnection();
		try {

			pst = conn.prepareCall(sql);
			pst.setString(1,name);
			pst.executeUpdate();
			
			result = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.getDisconnect(conn, pst, rs);
		}
		
		return result;
	}

	public boolean 발전소_insert(String 발전소_name, String 최대발전량, String 주소) {
		boolean result = false;
		
		String sql = "call insert_발전소(?,?,?)";
		conn = DBUtil.getConnection();
		try {

			pst = conn.prepareCall(sql);
			pst.setString(1,발전소_name);
			pst.setString(2,최대발전량);
			pst.setString(3,주소);
			pst.executeUpdate();
			
			result = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.getDisconnect(conn, pst, rs);
		}
		
		return result;
	}
	public boolean 직무_insert(String job_name, String job_내용) {
		boolean result = false;
		
		String sql = "call insert_직무(?,?)";
		conn = DBUtil.getConnection();
		try {

			pst = conn.prepareCall(sql);
			pst.setString(1,job_name);
			pst.setString(2,job_내용);
			pst.executeUpdate();
			
			result = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.getDisconnect(conn, pst, rs);
		}
		
		return result;
	}
	
	public boolean 발전_insert(String iD, String date, String 발전량) {
		boolean result = false;
		
		String sql = "call insert_발전(?,?,?)";
		conn = DBUtil.getConnection();
		try {

			pst = conn.prepareCall(sql);
			pst.setString(1,iD);
			pst.setString(2,date);
			pst.setString(3,발전량);
			pst.executeUpdate();
			
			result = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.getDisconnect(conn, pst, rs);
		}
		
		return result;
	}
	
	public boolean Duplicate_check(String check_name,String name) {
		boolean result = false;
		String sql = "select count(*) from 직원 where "
				+ check_name
				+ " = ? ";
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
//			pst.setString(1,check_name);
			pst.setString(1,name);
			int cnt=0;
			rs=pst.executeQuery();  //update3
			
			while(rs.next()) {
				cnt = rs.getInt(1);  
			}
			System.out.println(cnt);
			
			if(cnt>=1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.getDisconnect(conn, pst, rs);
		}
		
		return result;
	}

	public String find_id(String email, String phone_number) {
		
		String sql = "select 서버_ID from 직원 where 이메일 = ?  and 전화번호 = ?";
		conn = DBUtil.getConnection();
		String data=null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,email);
			pst.setString(2,phone_number);
			rs=pst.executeQuery();  //update3
			
			while(rs.next()) {
				data = rs.getString(1);  
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.getDisconnect(conn, pst, rs);
		}
		
		return data;
	}

	public String find_password_service(String email, String phone_number, String id) {
		String sql = "select 서버_PASSWORD from 직원 where 이메일 = ?  and 전화번호 = ? and 서버_ID = ?";
		conn = DBUtil.getConnection();
		String data=null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,email);
			pst.setString(2,phone_number);
			pst.setString(3,id);
			rs=pst.executeQuery();  //update3
			
			while(rs.next()) {
				data = rs.getString(1);  
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.getDisconnect(conn, pst, rs);
		}
		return data;
	}

	public boolean emp_update(String update_위치, String update_내용, int id) {

		String sql = "call update_"+update_위치+"(?,?)";
		System.out.println(sql+" "+update_내용+" "+id);
		conn = DBUtil.getConnection();
		boolean result = false;
		try {

			pst = conn.prepareCall(sql);
			pst.setInt(1,id);
			pst.setString(2,update_내용);
			pst.executeUpdate();
			
			result = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.getDisconnect(conn, pst, rs);
		}
		
		return result;
	}

//	public boolean dept_update(String update_위치, String update_내용, int id) {
//		String sql = "call update_"+update_위치+"(?,?)";
//		System.out.println(sql+" "+update_내용+" "+id);
//		conn = DBUtil.getConnection();
//		boolean result = false;
//		try {
//
//			pst = conn.prepareCall(sql);
//			pst.setInt(1,id);
//			pst.setString(2,update_내용);
//			pst.executeUpdate();
//			
//			result = true;
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		finally {
//			DBUtil.getDisconnect(conn, pst, rs);
//		}
//		
//		return result;
//	}
	
	public ArrayList<발전DTO> get_발전_table(String 발전소_ID, String 측정_날짜_시작_값, String 측정_날짜_종료_값) {
		String sql = "select 발전소_ID, to_char(측정_날짜,'yy/mm/dd hh24') 측정_날짜, 발전량 "
				+ "from 발전 "
				+ "where 발전소_ID = ? "
				+ "and 측정_날짜 BETWEEN '"
				+ 측정_날짜_시작_값
				+ " 00:00:00' and '"
				+ 측정_날짜_종료_값
				+ " 23:59:59' "
				+ "ORDER by 측정_날짜";
				
		conn = DBUtil.getConnection();
		 
		String data=null;
		ArrayList<발전DTO> 발전_list = new ArrayList<발전DTO>();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,발전소_ID);
			rs=pst.executeQuery();  //update3
			while(rs.next()) {
				발전DTO 발전 = make_발전DTO(rs);
				발전_list.add(발전);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.getDisconnect(conn, pst, rs);
		}
		return 발전_list;
	}
	
	

	public ArrayList<empDTO> get_emp_table() {
		String sql = "select 직원_ID,이름, 이메일, 전화번호,부서.부서_이름,서버_ID, 서버_PASSWORD, 직무.직무_이름, 퇴직유무 "
				+ "from 직원 left join 부서 using(부서_ID) left join 직무 using(직무_ID)";
		conn = DBUtil.getConnection();
		 
		String data=null;
		ArrayList<empDTO> emp_list = new ArrayList<empDTO>();
		try {
			pst = conn.prepareStatement(sql);
			rs=pst.executeQuery();  //update3
			while(rs.next()) {
				empDTO emp = make_empDTO(rs);
				emp_list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.getDisconnect(conn, pst, rs);
		}
		return emp_list;
	}
	

	public ArrayList<deptDTO> get_dept_table() {
		String sql = "select * from 부서";
		conn = DBUtil.getConnection();
		 
		String data=null;
		ArrayList<deptDTO> dept_list = new ArrayList<deptDTO>();
		try {
			pst = conn.prepareStatement(sql);
			rs=pst.executeQuery();  //update3
			while(rs.next()) {
				deptDTO dept = make_deptDTO(rs);
				dept_list.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.getDisconnect(conn, pst, rs);
		}
		return dept_list;
	}
	public ArrayList<JobDTO> get_job_table() {
		String sql = "select * from 직무";
		conn = DBUtil.getConnection();
		 
		ArrayList<JobDTO> job_list = new ArrayList<JobDTO>();
		try {
			pst = conn.prepareStatement(sql);
			rs=pst.executeQuery();  //update3
			while(rs.next()) {
				JobDTO job = make_jobDTO(rs);
				job_list.add(job);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.getDisconnect(conn, pst, rs);
		}
		return job_list;
	}
	
	public ArrayList<위치_DTO> get_위치_table() {
		String sql = "select * from 발전소";
		conn = DBUtil.getConnection();
		 
		ArrayList<위치_DTO> 위치_list = new ArrayList<위치_DTO>();
		try {
			pst = conn.prepareStatement(sql);
			rs=pst.executeQuery();  //update3
			while(rs.next()) {
				위치_DTO 위치 = make_위치DTO(rs);
				위치_list.add(위치);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.getDisconnect(conn, pst, rs);
		}
		return 위치_list;
	}
	
	private 위치_DTO make_위치DTO(ResultSet rs2) throws SQLException {
		위치_DTO 위치 = new 위치_DTO();
		위치.set발전소_ID(rs.getInt("발전소_ID"));
		위치.set건물_이름(rs.getString("건물_이름"));
		위치.set최대_발전량(rs.getInt("최대_발전량"));
		위치.set주소(rs.getString("주소"));
		return 위치;
	}

	private JobDTO make_jobDTO(ResultSet rs) throws SQLException {
		JobDTO job = new JobDTO();
		job.set직무_ID(rs.getInt("직무_ID"));
		job.set직무_이름(rs.getString("직무_이름"));
		job.set직무_내용(rs.getString("직무_내용"));
		return job;
	}

	public empDTO make_empDTO(ResultSet rs) throws SQLException {
		empDTO emp = new empDTO();
		emp.set직원_ID(rs.getInt("직원_ID"));
		emp.set이름(rs.getString("이름"));
		emp.set이메일(rs.getString("이메일"));
		emp.set전화번호(rs.getString("전화번호"));
		emp.set부서_이름(rs.getString("부서_이름"));
		emp.setLogin_ID(rs.getString("서버_ID"));
		emp.setLogin_password(rs.getString("서버_PASSWORD"));
		emp.set직무_이름(rs.getString("직무_이름"));
		emp.set퇴직유무(rs.getString("퇴직유무"));
		return emp;
	}
	
	public deptDTO make_deptDTO(ResultSet rs) throws SQLException {
		deptDTO dept = new deptDTO();
		dept.set부서_id(rs.getInt("부서_ID"));
		dept.set부서_이름(rs.getString("부서_이름"));
		return dept;
	}

	private 발전DTO make_발전DTO(ResultSet rs) throws SQLException {
		발전DTO 발전 = new 발전DTO();
		발전.set발전소_ID(rs.getInt("발전소_ID"));
		발전.set측정_날짜(rs.getString("측정_날짜"));
		발전.set발전량(rs.getInt("발전량"));
		return 발전;
	}

	

	

	

	

	

	

	
}
