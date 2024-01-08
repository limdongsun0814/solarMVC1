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

public class dept_insert_view extends JFrame implements ActionListener {

	empService service = new empService();
	JButton insert_button;
	JTextField dept_name;
	JButton dispose;
	public dept_insert_view(){ // 이름, 이메일, 전화번호, 아이디, 비밀번호
		setTitle("부서 추가");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,200);
		Container c = getContentPane();
		c.setLayout(null);
		JLabel dept_text = view_util.JLabel_setting("부서 이름",30,30,100,30);
		dept_name = view_util.JTextField_setting("",150,30,200,30);
		insert_button = view_util.JButton_setting("추가",30,100,100,30);
		dispose =view_util.JButton_setting("창 닫기",230,100,100,30);
		c.add(insert_button);
		c.add(dept_text);
		c.add(dept_name);
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
				boolean result = service.dept_insert_service(dept_name.getText());
				if(result) {
					new min_text_box("삽입에 성공했습니다.");
				}else {
					new min_text_box("삽입에 실패했습니다.");
				}
			}
		
	}
	public static void main(String[] args) {
		new dept_insert_view();
	}
}





