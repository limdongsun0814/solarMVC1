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

public class job_insert_view extends JFrame implements ActionListener {

	empService service = new empService();
	JButton insert_button;
	JTextField job_name;
	JTextField job_내용;
	JButton dispose;
	public job_insert_view(){ // 이름, 이메일, 전화번호, 아이디, 비밀번호
		setTitle("직무 추가");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,250);
		Container c = getContentPane();
		c.setLayout(null);
		JLabel job_name_text = view_util.JLabel_setting("직무 이름",30,30,100,30);
		JLabel job_내용_text = view_util.JLabel_setting("직무 내용",30,90,100,30);
		
		job_name = view_util.JTextField_setting("",150,30,100,30);
		job_내용 = view_util.JTextField_setting("",150,90,100,30);
		
		
		insert_button = view_util.JButton_setting("추가",30,150,100,30);
		dispose =view_util.JButton_setting("창 닫기",150,150,100,30);
		
		c.add(job_name_text);
		c.add(job_내용_text);
		
		c.add(job_name);
		c.add(job_내용);
		
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
				boolean result = service.job_insert_service(job_name.getText(),job_내용.getText());
				if(result) {
					new min_text_box("삽입에 성공했습니다.");
				}else {
					new min_text_box("삽입에 실패했습니다.");
				}
			}
		
	}
	public static void main(String[] args) {
		new job_insert_view();
	}
}





