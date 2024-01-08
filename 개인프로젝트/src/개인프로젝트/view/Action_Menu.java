package 개인프로젝트.view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import DTO.JobDTO;
import DTO.deptDTO;
import DTO.empDTO;
import DTO.발전DTO;
import DTO.위치_DTO;
import model.empService;
import util.table_view;
import util.two_arg_emp_update_box;
import util.view_util;

public class Action_Menu extends JFrame implements ActionListener{
	//jlist =>  리스트 확인
	//jtable => 테이블 확인
	JButton emp_update_button;
	JButton emp_view_button;
	JButton 부서_view;
	JButton 부서_insert;
	JButton 부서_update;
	JButton 발전소_위치_view;
	JButton 발전소_insert; 
	JButton 발전소_update; 
	JButton get_발전데이터_view_button;
	JButton dispose;

	

	JButton job_view;
	JButton job_insert; 
	JButton job_update; 
	
	empService service = new empService();
	public Action_Menu(){
		setTitle("작업 메뉴");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(600,600);
		Container c = getContentPane();
		
		emp_update_button = view_util.JButton_setting("직원 정보 수정",30,30,150,30);
		emp_view_button = view_util.JButton_setting("직원들 정보 확인",210,30,150,30);
		
		부서_update = view_util.JButton_setting("부서 수정",30,90,150,30);
		부서_view = view_util.JButton_setting("부서 확인",210,90,150,30);
		부서_insert = view_util.JButton_setting("부서 추가",390,90,150,30);
		
		

		발전소_update = view_util.JButton_setting("발전소 수정",30,150,150,30);
		발전소_위치_view = view_util.JButton_setting("위치 확인",210,150,150,30);
		발전소_insert = view_util.JButton_setting("발전소 추가",390,150,150,30);
		//발전소 추가
		//발전소 수정

		//직무도 view,수정,추가
		job_update = view_util.JButton_setting("직무 수정",30,210,150,30);
		job_view = view_util.JButton_setting("직무 확인",210,210,150,30);
		job_insert = view_util.JButton_setting("직무 추가",390,210,150,30);
		
		get_발전데이터_view_button = view_util.JButton_setting("발전 데이터 확인",30,270,150,30);
		dispose =view_util.JButton_setting("로그인 화면",400,500,150,30);
		
		
		c.setLayout(null);
		c.add(emp_update_button);
		c.add(emp_view_button);
		c.add(부서_view);
		c.add(발전소_위치_view);
		c.add(get_발전데이터_view_button);
		
		c.add(부서_insert);
		c.add(부서_update);
		c.add(발전소_insert);
		c.add(발전소_update);
		
		c.add(job_update);
		c.add(job_view);
		c.add(job_insert);
		
		c.add(dispose);
		
		get_발전데이터_view_button.addActionListener(this);
		
		job_insert.addActionListener(this);
		부서_insert.addActionListener(this);
		발전소_insert.addActionListener(this);
		
		job_update.addActionListener(this);
		발전소_update.addActionListener(this);
		부서_update.addActionListener(this);
		발전소_위치_view.addActionListener(this);
		job_view.addActionListener(this);
		emp_view_button.addActionListener(this);
		부서_view.addActionListener(this);
		emp_update_button.addActionListener(this);
		dispose.addActionListener(this);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==dispose) {
			dispose();
			new mainFrame();
		}
		if(e.getSource()==emp_update_button) {
			dispose();
			new emp_update_view();
		}
		if(e.getSource() == emp_view_button) {
			ArrayList<empDTO> emp_list=service.get_emp_table_service();
			//String[][] contents_arr,String[] header_arr
			String[] header_arr = {"직원 ID","이름","이메일"
					,"전화번호","부서 이름","서버 ID"
					,"서버 비밀번호","직무 이름","퇴직 유무"};
			String[][] contents_arr = new String[emp_list.size()][header_arr.length];
			int flog_cnt =0;
			for(empDTO emp :emp_list) {
				contents_arr[flog_cnt][0]=String.valueOf(emp.get직원_ID());
				contents_arr[flog_cnt][1]=String.valueOf(emp.get이름());
				contents_arr[flog_cnt][2]=String.valueOf(emp.get이메일());
				contents_arr[flog_cnt][3]=String.valueOf(emp.get전화번호());
				contents_arr[flog_cnt][4]=String.valueOf(emp.get부서_이름());
				contents_arr[flog_cnt][5]=String.valueOf(emp.getLogin_ID());
				contents_arr[flog_cnt][6]=String.valueOf(emp.getLogin_password());
				contents_arr[flog_cnt][7]=String.valueOf(emp.get직무_이름());
				contents_arr[flog_cnt][8]=String.valueOf(emp.get퇴직유무());
				flog_cnt++;
			}
			new table_view("직원 테이블",contents_arr,header_arr);
		}
		if(e.getSource()==get_발전데이터_view_button) {
			new 발전_view_init();
		}
		
		if(e.getSource() == 부서_view) {
			ArrayList<deptDTO> dept_list=service.get_dept_table_service();
			String[] header_arr = {"부서 ID","부서 이름"};
			String[][] contents_arr = new String[dept_list.size()][header_arr.length];
			int flog_cnt =0;
			for(deptDTO dept :dept_list) {
				contents_arr[flog_cnt][0]=String.valueOf(dept.get부서_id());
				contents_arr[flog_cnt][1]=String.valueOf(dept.get부서_이름());
				flog_cnt++;
			}
			new table_view("부서 테이블",contents_arr,header_arr);
		}
		if(e.getSource()==job_view) {
			ArrayList<JobDTO> job_list=service.get_job_table_service();
			String[] header_arr = {"직무 ID","직무 이름","직무 내용"};
			String[][] contents_arr = new String[job_list.size()][header_arr.length];
			int flog_cnt =0;
			for(JobDTO job :job_list) {
				contents_arr[flog_cnt][0]=String.valueOf(job.get직무_ID());
				contents_arr[flog_cnt][1]=String.valueOf(job.get직무_이름());
				contents_arr[flog_cnt][2]=String.valueOf(job.get직무_내용());
				flog_cnt++;
			}
			new table_view("직무 테이블",contents_arr,header_arr);
		}
		if(e.getSource()==발전소_위치_view){
			ArrayList<위치_DTO> 위치_list=service.get_위치_table_service();
			String[] header_arr = {"발전소 ID","건물 이름","최대 발전량","주소"};
			String[][] contents_arr = new String[위치_list.size()][header_arr.length];
			int flog_cnt =0;
			for(위치_DTO 위치 :위치_list) {
				contents_arr[flog_cnt][0]=String.valueOf(위치.get발전소_ID());
				contents_arr[flog_cnt][1]=String.valueOf(위치.get건물_이름());
				contents_arr[flog_cnt][2]=String.valueOf(위치.get최대_발전량()==0?"null":위치.get최대_발전량());
				contents_arr[flog_cnt][3]=String.valueOf(위치.get주소());
				flog_cnt++;
			}
			new table_view("발전소 테이블",contents_arr,header_arr);
		}
		if(e.getSource()==부서_update) {
			new two_arg_emp_update_box("부서_이름", "부서 ID", "부서 이름");
		}
		if(e.getSource() == 발전소_update){
			dispose();
			new 발전소_update_view();
		}
		if(e.getSource() == job_update) {
			dispose();
			new job_update_view();
		}
		if(e.getSource()==부서_insert) {
			new dept_insert_view();
		}
		if(e.getSource()==발전소_insert) {
			new 발전소_insert_view();
		}
		if(e.getSource()==job_insert) {
			new job_insert_view();
		}
		
	}
	
	public static void main(String[] args) {
		new Action_Menu();
	}
}
