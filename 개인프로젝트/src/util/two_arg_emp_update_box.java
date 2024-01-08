package util;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.empService;

public class two_arg_emp_update_box extends JFrame implements ActionListener{
	JButton dispose;
	JButton check;
	JTextField arg1_textfield;
	JTextField arg2_textfield;

	empService service = new empService();
	String update_위치;
	String update_내용;
	int id;
	public  two_arg_emp_update_box(String title,String arg1,String arg2) {
		update_위치 = title;
		
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		Container c = getContentPane();
		c.setLayout(null);
		

		JLabel arg1_text = view_util.JLabel_setting(arg1+": ", 30,30,100,30);
		JLabel arg2_text = view_util.JLabel_setting(arg2+": ", 30,90,100,30);
		arg1_textfield =view_util.JTextField_setting("",150,30,100,30 );
		arg2_textfield =view_util.JTextField_setting("",150,90,100,30 );
		dispose =view_util.JButton_setting("종료",150,200,100,30);
		check =view_util.JButton_setting("확인",30,200,100,30);
		c.add(arg1_text);
		c.add(arg2_text);
		c.add(arg1_textfield);
		c.add(arg2_textfield);
		c.add(dispose);
		c.add(check);
		dispose.addActionListener(this);
		check.addActionListener(this);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == dispose) {
			dispose();
		}
		if(e.getSource()==check) {
			//(String update_위치,String update_내용, int id)
			update_내용 = arg2_textfield.getText();
			id = Integer.parseInt( arg1_textfield.getText());
			boolean result = service.emp_update_service(update_위치,update_내용, id);
			if(result) {
				new min_text_box("업데이트에 성공했습니다.");
			}else{
				new min_text_box("업데이트에 실패했습니다.");
			}
		}
	}
	
	
}
