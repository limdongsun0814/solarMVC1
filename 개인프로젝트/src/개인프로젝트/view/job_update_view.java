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

public class job_update_view  extends JFrame implements ActionListener{
	JButton name_edit;
	JButton 내용_edit;
	JButton 주소_edit;
	JButton dispose;
	public job_update_view() {
		setTitle("발전소 정보 수정 메뉴");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(600,600);
		Container c = getContentPane();
		c.setLayout(null);
		name_edit = view_util.JButton_setting("직무 이름 수정",200,30,200,30);
		내용_edit = view_util.JButton_setting("직무 내용 수정",200,90,200,30);
		dispose =view_util.JButton_setting("작업 메뉴 화면으로",400,500,150,30);
		
		
		c.add(name_edit);
		c.add(내용_edit);
		c.add(dispose);
		

		name_edit.addActionListener(this);
		내용_edit.addActionListener(this);
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
			new two_arg_emp_update_box("직무_이름","직무 ID" ,"변경할 직무 이름" );
		}
		
		if(e.getSource()==내용_edit) {
			new two_arg_emp_update_box("직무_내용","직무 ID" ,"변경할 직무 내용" );
		}
//		
	}

	public static void main(String[] args) {
		new job_update_view();
	}
}
