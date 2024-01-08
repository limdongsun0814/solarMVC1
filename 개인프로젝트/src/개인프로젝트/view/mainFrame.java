package 개인프로젝트.view;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.empService;
import util.min_text_box;
import util.view_util;

public class mainFrame extends JFrame implements ActionListener {
	JButton sign_in_button;
	JButton sign_up_button;
	JButton find_id_button;
	JButton find_password_button;
	
	JButton dispose;
	JTextField login_id;
	JTextField login_password;
	empService service = new empService();
	public  mainFrame() {
		setTitle("로그인 프레임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(600,600);
//		GridLayout grid = new GridLayout(4,2);
		Container c = getContentPane();

		JLabel login_id_text = view_util.JLabel_setting("아이디: ", 30,30,200,30);
		login_id  = view_util.JTextField_setting("",250,30,200,30 );
		JLabel login_password_text = view_util.JLabel_setting("비밀번호: ", 30,90,200,30);
		login_password  = view_util.JTextField_setting("",250,90,200,30);
		sign_in_button = view_util.JButton_setting("로그인",30,150,200,30);
		sign_up_button = view_util.JButton_setting("가입",250,150,200,30);
		find_id_button = view_util.JButton_setting("아이디 찾기",30,200,200,30);
		find_password_button = view_util.JButton_setting("비밀번호 찾기",250,200,200,30);
		dispose =view_util.JButton_setting("종료",300,300,200,30);
		c.setLayout(null);
		c.add(login_id_text);
		c.add(login_id);
		c.add(login_password_text);
		c.add(login_password);
		c.add(sign_in_button);
		c.add(sign_up_button);
		c.add(find_id_button);
		c.add(find_password_button);
		c.add(dispose);
		setVisible(true);
		sign_in_button.addActionListener(this);
		dispose.addActionListener(this);
		sign_up_button.addActionListener(this);
		find_id_button.addActionListener(this);
		find_password_button.addActionListener(this);
	}
	public static void main(String[] args) {
		new mainFrame();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == sign_in_button) {
			String id_str=login_id.getText();
			String password_str=login_password.getText();
			boolean acc = service.login_check_service(id_str,password_str); // true이면 로그인 성공
			System.out.println(id_str+password_str);
			if(acc) {
				dispose();
				new min_text_box("로그인에 성공했습니다.");
				new Action_Menu();
			}else {
				new min_text_box("로그인에 실패했습니다.");
			}
		}
		if(e.getSource()==dispose) {
			dispose();
		}
		if(e.getSource()==sign_up_button) {
			dispose();
			new sign_up();
		}
		if(e.getSource()==find_id_button) {
			dispose();
			new find_id_frame();
		}
		if(e.getSource()==find_password_button) {
			dispose();
			new find_password_frame();
		}
	}
}
