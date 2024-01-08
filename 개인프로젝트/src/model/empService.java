package model;

import java.util.ArrayList;

import DTO.JobDTO;
import DTO.deptDTO;
import DTO.empDTO;
import DTO.발전DTO;
import DTO.위치_DTO;

public class empService {
	empDAO dao = new empDAO();
	public boolean login_check_service(String login_id, String password) {
		return dao.login_check(login_id, password);
	}
	public boolean sign_up_service(String name, String email,String phone_number, String ID, String password) {
		return dao.sign_up(name, email,phone_number,ID,password);
	}
	public boolean Duplicate_check_service(String check_name, String name) {
		return dao.Duplicate_check(check_name,name);
	}
	public boolean emp_update_service(String update_위치,String update_내용, int id) {
		return dao.emp_update(update_위치,update_내용,id);
	}

	public String find_id_service(String email, String phone_number) {
		return dao.find_id(email,phone_number);
	}
	
	public String find_password_service(String email, String phone_number,String id) {
		return dao.find_password_service(email,phone_number,id);
	}
	public ArrayList<empDTO> get_emp_table_service(){
		return dao.get_emp_table();
	}
	public ArrayList<deptDTO> get_dept_table_service(){
		return dao.get_dept_table();
	}
	public ArrayList<JobDTO> get_job_table_service(){
		return dao.get_job_table();
	}
	public ArrayList<위치_DTO> get_위치_table_service(){
		return dao.get_위치_table();
	}
	public boolean dept_insert_service(String name) {
		// TODO Auto-generated method stub
		return dao.dept_insert(name);
	}
	public boolean 발전소_insert_service(String 발전소_name,String 최대발전량,String 주소) {
		// TODO Auto-generated method stub
		return dao.발전소_insert(발전소_name,최대발전량,주소);
	}
	public boolean job_insert_service(String job_name, String job_내용) {
		// TODO Auto-generated method stub
		return  dao.직무_insert(job_name,job_내용);
	}
	public boolean 발전_insert_service(String ID,String date, String 발전량) {
		// TODO Auto-generated method stub
		return  dao.발전_insert(ID,date,발전량);
	}
	public ArrayList<발전DTO> get_발전_table_service(String 발전소_ID, String 측정_날짜_시작_값, String 측정_날짜_종료_값) {
		return dao.get_발전_table(발전소_ID, 측정_날짜_시작_값, 측정_날짜_종료_값);
		
	}
	
}
