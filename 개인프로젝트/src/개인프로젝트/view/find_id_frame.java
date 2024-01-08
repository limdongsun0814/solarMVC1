package 개인프로젝트.view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.empService;
import util.min_text_box;
import util.view_util;

public class find_id_frame extends JFrame implements ActionListener{
	JButton check_button;
	JButton dispose;
	
	JTextField email;
	JTextField phone_number;

	empService service = new empService();
	public find_id_frame(){
		setTitle("아이디 찾기 프레임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,600);
		Container c = getContentPane();
		
		check_button =view_util.JButton_setting("확인",400,450,100,30);
		dispose =view_util.JButton_setting("홈으로",400,500,100,30);
		JLabel email_text = view_util.JLabel_setting("이메일: ",30,90,100,30);
		JLabel phone_number_text = view_util.JLabel_setting("전화번호: ",30,150,100,30);
		
		email = view_util.JTextField_setting("",160,90,150,30);
		phone_number = view_util.JTextField_setting("",160,150,150,30);
		
		
		c.setLayout(null);
		c.add(check_button);
		c.add(dispose);
		c.add(email_text);
		c.add(phone_number_text);
		c.add(email);
		c.add(phone_number);
		
		dispose.addActionListener(this);
		check_button.addActionListener(this);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==dispose) {
			dispose();
			new mainFrame();
		}
		if(e.getSource() == check_button) {
			String email_str = email.getText();
			String phone_number_str = phone_number.getText();
			 // 이메일 and 전화번호가 존재하면 1
			String find_id_data=service.find_id_service(email_str, phone_number_str);
			System.out.println(find_id_data);
			if(find_id_data != null) {
				String find_login_id ="아이디는 (";
				find_login_id += find_id_data; // 해당 아이디를 리턴
				find_login_id+=")입니다.";
				new min_text_box(find_login_id);
			}else {
				new min_text_box("잘못 입력하셨습니다.");
			}
			// sql 입력			
		}
	}

}
