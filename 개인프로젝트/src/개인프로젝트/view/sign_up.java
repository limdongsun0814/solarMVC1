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

public class sign_up extends JFrame implements ActionListener {
	JButton check_button;
	JButton login_id_check_button;
	JButton dispose;
	JButton email_check_button;
	JButton phone_number_check_button;
	JTextField name;
	JTextField email;
	JTextField phone_number;
	JTextField login_id;
	JTextField login_password;
	empService service = new empService();
	
	String name_str;
	String email_str;
	String phone_number_str;
	String login_password_str;
	String login_id_str;
	
	
	boolean check_login_id=false;
	boolean check_phone=false;
	boolean check_email=false;
	public sign_up(){ // 이름, 이메일, 전화번호, 아이디, 비밀번호
		setTitle("회원가입 프레임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,600);
		Container c = getContentPane();
		
		check_button =view_util.JButton_setting("확인",400,450,100,30);
		dispose =view_util.JButton_setting("홈으로",400,500,100,30);
		JLabel name_text = view_util.JLabel_setting("이름: ",30,30,100,30);
		JLabel email_text = view_util.JLabel_setting("이메일: ",30,90,100,30);
		JLabel phone_number_text = view_util.JLabel_setting("전화번호: ",30,150,100,30);
		JLabel login_id_text = view_util.JLabel_setting("아이디: ",30,210,100,30);
		JLabel login_password_text = view_util.JLabel_setting("비밀번호: ",30,270,100,30);
		
		name = view_util.JTextField_setting("",160,30,150,30);
		email = view_util.JTextField_setting("",160,90,150,30);
		phone_number = view_util.JTextField_setting("",160,150,150,30);
		login_id = view_util.JTextField_setting("",160,210,150,30);
		login_password = view_util.JTextField_setting("",160,270,150,30);
		
		

		email_check_button = view_util.JButton_setting("이메일 중복 확인",290+50,90,150,30);
		phone_number_check_button = view_util.JButton_setting("전화번호 중복 확인",290+50,150,150,30);
		login_id_check_button = view_util.JButton_setting("아이디 중복 확인",290+50,210,150,30);
		c.setLayout(null);
		c.add(check_button);
		c.add(dispose);
		c.add(name_text);
		c.add(email_text);
		c.add(phone_number_text);
		c.add(login_id_text);
		c.add(login_password_text);
		c.add(name);
		c.add(email);
		c.add(phone_number);
		c.add(login_id);
		c.add(login_password);
		c.add(email_check_button);
		
		c.add(email_check_button);
		c.add(phone_number_check_button);
		c.add(login_id_check_button);
		
		dispose.addActionListener(this);
		
		email_check_button.addActionListener(this);
		phone_number_check_button.addActionListener(this);
		login_id_check_button.addActionListener(this);
		
		check_button.addActionListener(this);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == check_button) {
			if(check_email||check_phone||check_login_id) {
				new min_text_box("중복 확인 버튼들을 눌러주세요.");
			}else {	
				name_str = name.getText();
				login_password_str= login_password.getText();
				service.sign_up_service(name_str, email_str,phone_number_str
						,login_id_str,login_password_str);
				dispose();
				new min_text_box("회원가입이 되었습니다");
				new mainFrame();
			}
		}
		if(e.getSource()==dispose) {
			dispose();
			new mainFrame();
		}
		if(e.getSource() == email_check_button) {
			
			check_email = service.Duplicate_check_service("이메일",email.getText()); // 중복이 있으면 true
			
			if(check_email) {
				new min_text_box("이메일이 중복되었습니다.");
			}else {
				email_str = email.getText();
				new min_text_box("중복이 없습니다.");
			}
		}
		
		if(e.getSource() == phone_number_check_button) {

			check_phone = service.Duplicate_check_service("전화번호",phone_number.getText());
			if(check_phone) {
				new min_text_box("전화번호가 중복되었습니다.");
			}else {
				phone_number_str = phone_number.getText();
				new min_text_box("중복이 없습니다.");
			}
		}
		
		if(e.getSource() == login_id_check_button) {
			check_login_id = service.Duplicate_check_service("서버_ID",login_id.getText());
			if(check_login_id) {
				new min_text_box("아이디가 중복되었습니다.");
			}else {
				login_id_str = login_id.getText();
				new min_text_box("중복이 없습니다.");
			}
		}
		
	}
}