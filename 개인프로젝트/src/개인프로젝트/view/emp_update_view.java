package 개인프로젝트.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JList;

import util.two_arg_emp_update_box;
import util.view_util;

import javax.swing.*;

public class emp_update_view  extends JFrame implements ActionListener{
	JButton name_edit;
	JButton email_edit;
	JButton phone_number_edit;
	JButton dept_edit;
	JButton job_edit;
	JButton leave_edit;
	JButton password_edit;
	JButton dispose;
	public emp_update_view() {
		setTitle("직원 정보 수정 메뉴");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(600,600);
		Container c = getContentPane();
		c.setLayout(null);
		name_edit = view_util.JButton_setting("이름 수정",200,30,200,30);
		email_edit = view_util.JButton_setting("이메일 수정",200,90,200,30);
		phone_number_edit = view_util.JButton_setting("전화번호 수정",200,150,200,30);
		dept_edit = view_util.JButton_setting("부서 수정",200,210,200,30);
		job_edit = view_util.JButton_setting("업무 수정",200,270,200,30);
		leave_edit = view_util.JButton_setting("퇴직유무 수정",200,330,200,30);
		password_edit = view_util.JButton_setting("비밀번호 수정",200,390,200,30);
		dispose =view_util.JButton_setting("작업 메뉴 화면으로",400,500,150,30);
		
		
		c.add(name_edit);
		c.add(email_edit);
		c.add(phone_number_edit);
		c.add(dept_edit);
		c.add(job_edit);
		c.add(leave_edit);
		c.add(password_edit);
		c.add(dispose);
		

		name_edit.addActionListener(this);
		email_edit.addActionListener(this);
		phone_number_edit.addActionListener(this);
		dept_edit.addActionListener(this);
		job_edit.addActionListener(this);
		leave_edit.addActionListener(this);
		password_edit.addActionListener(this);
		dispose.addActionListener(this);
		setVisible(true);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==dispose) {
			dispose();
			new Action_Menu();
		}

//		String sql = "call update_"+update_위치+"(?,?)";
		if(e.getSource()==name_edit) {
			new two_arg_emp_update_box("직원_이름","직원 ID" ,"변경할 이름" );
		}
		if(e.getSource()==email_edit) {
			new two_arg_emp_update_box("이메일","직원 ID" ,"변경할 이메일" );
		}
		if(e.getSource()==phone_number_edit) {
			new two_arg_emp_update_box("전화번호","직원 ID" ,"변경할 전화번호" );
		}
		if(e.getSource()==dept_edit) {
			new two_arg_emp_update_box("부서_ID","직원 ID" ,"변경할 부서_ID" );
		}
		if(e.getSource()==job_edit) {
			new two_arg_emp_update_box("직무_ID","직원 ID" ,"변경할 직무_ID" );
		}
		if(e.getSource()==leave_edit) {
			new two_arg_emp_update_box("퇴직유무","직원 ID" ,"변경할 퇴직유무" );
		}
		if(e.getSource()==password_edit) {
			new two_arg_emp_update_box("서버_Password","직원 ID" ,"변경할 비밀번호" );
		}
	}

	public static void main(String[] args) {
		new emp_update_view();
	}
}
