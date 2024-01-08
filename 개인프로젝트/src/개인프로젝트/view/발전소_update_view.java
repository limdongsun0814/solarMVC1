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

public class 발전소_update_view  extends JFrame implements ActionListener{
	JButton name_edit;
	JButton max_edit;
	JButton 주소_edit;
	JButton dispose;
	public 발전소_update_view() {
		setTitle("발전소 정보 수정 메뉴");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(600,600);
		Container c = getContentPane();
		c.setLayout(null);
		name_edit = view_util.JButton_setting("이름 수정",200,30,200,30);
		max_edit = view_util.JButton_setting("최대발전량 수정",200,90,200,30);
		주소_edit = view_util.JButton_setting("주소 수정",200,150,200,30);
		dispose =view_util.JButton_setting("작업 메뉴 화면으로",400,500,150,30);
		
		
		c.add(name_edit);
		c.add(max_edit);
		c.add(주소_edit);
		c.add(dispose);
		

		name_edit.addActionListener(this);
		max_edit.addActionListener(this);
		주소_edit.addActionListener(this);
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
			new two_arg_emp_update_box("건물_이름","발전소 ID" ,"변경할 이름" );
		}
		if(e.getSource()==max_edit) {
			new two_arg_emp_update_box("최대_발전량","발전소 ID" ,"변경최대발전량" );
		}
		if(e.getSource()==주소_edit) {
			new two_arg_emp_update_box("주소","발전소 ID" ,"변경할 주소" );
		}
//		
	}

	public static void main(String[] args) {
		new 발전소_update_view();
	}
}
