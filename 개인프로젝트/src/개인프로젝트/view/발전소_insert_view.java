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

public class 발전소_insert_view extends JFrame implements ActionListener {

	empService service = new empService();
	JButton insert_button;
	JTextField 발전소_name;
	JTextField 최대발전량;
	JTextField 주소;
	JButton dispose;
	public 발전소_insert_view(){ // 이름, 이메일, 전화번호, 아이디, 비밀번호
		setTitle("발전소 추가");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		Container c = getContentPane();
		c.setLayout(null);
		JLabel 발전소_name_text = view_util.JLabel_setting("발전소 이름",30,30,100,30);
		JLabel 최대발전량_text = view_util.JLabel_setting("최대 발전량",30,90,100,30);
		JLabel 주소_text = view_util.JLabel_setting("주소",30,150,100,30);
		
		발전소_name = view_util.JTextField_setting("",150,30,100,30);
		최대발전량 = view_util.JTextField_setting("",150,90,100,30);
		주소 = view_util.JTextField_setting("",150,150,100,30);
		
		
		insert_button = view_util.JButton_setting("추가",30,210,100,30);
		dispose =view_util.JButton_setting("창 닫기",150,210,100,30);
		
		c.add(발전소_name_text);
		c.add(최대발전량_text);
		c.add(주소_text);
		
		c.add(발전소_name);
		c.add(최대발전량);
		c.add(주소);
		
		c.add(insert_button);
		c.add(dispose);
		dispose.addActionListener(this);
		insert_button.addActionListener(this);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			if(e.getSource() == dispose) {
				dispose();
			}
			if(e.getSource() == insert_button) {
				boolean result = service.발전소_insert_service(발전소_name.getText(),최대발전량.getText(),주소.getText());
				if(result) {
					new min_text_box("삽입에 성공했습니다.");
				}else {
					new min_text_box("삽입에 실패했습니다.");
				}
			}
		
	}
	public static void main(String[] args) {
		new 발전소_insert_view();
	}
}





