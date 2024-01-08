package 개인프로젝트.view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import DTO.empDTO;
import DTO.발전DTO;
import model.empService;
import util.view_util;

public class 발전_view_init extends JFrame implements ActionListener {
	
	JButton table_check;
	JButton dispose;
	JTextField 발전소_id;
	JTextField 측정_날짜_시작_값;
	JTextField 측정_날짜_종료_값;

	String[] header_arr = {"발전소 ID","측정 날짜","발전량"};
	
	public  발전_view_init(){
		setTitle("발전_view_init");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);

		Container c = getContentPane();
		dispose = view_util.JButton_setting("종료",150,210,100,30);	
		table_check = view_util.JButton_setting("테이블 확인",30,210,100,30);
		JLabel 발전소_id_text = view_util.JLabel_setting("확인할 발전소 ID",30,30,110,30);		
		JLabel 측정_날짜_시작_값_text = view_util.JLabel_setting("확인할 날짜 값 시작",30,90,110,30);		
		JLabel 측정_날짜_종료_값_text = view_util.JLabel_setting("확인할 날짜 값 종료",30,150,110,30);	
		
		발전소_id = view_util.JTextField_setting("",150,30,100,30);
		측정_날짜_시작_값 = view_util.JTextField_setting("",150,90,100,30);
		측정_날짜_종료_값 = view_util.JTextField_setting("",150,150,100,30);

		c.setLayout(null);
		
		c.add(발전소_id_text);
		c.add(측정_날짜_시작_값_text);
		c.add(측정_날짜_종료_값_text);
		
		c.add(발전소_id);
		c.add(측정_날짜_시작_값);
		c.add(측정_날짜_종료_값);
		
		c.add(dispose);
		c.add(table_check);
		
		table_check.addActionListener(this);
		dispose.addActionListener(this);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==dispose) {
			dispose();
		}
		if(e.getSource()==table_check) {
			new table_발전_view(
					발전소_id.getText()
					+측정_날짜_시작_값.getText()
					+측정_날짜_종료_값.getText()
					,header_arr
					,발전소_id.getText()
					,측정_날짜_시작_값.getText()
					,측정_날짜_종료_값.getText());
		}
		
	}
	public static void main(String[] args) {
		new 발전_view_init();
	}


}
