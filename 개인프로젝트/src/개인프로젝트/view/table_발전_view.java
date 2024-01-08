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

public class table_발전_view extends JFrame implements ActionListener {
	JScrollPane table;
	JButton dispose;
	
	empService service = new empService();
	public  table_발전_view(String title,String[] header_arr, String 발전소_ID
			, String 측정_날짜_시작_값,String 측정_날짜_종료_값 ){
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setSize(600,700);
		Container c = getContentPane();
		ArrayList<발전DTO> 발전_list=
		service.get_발전_table_service(발전소_ID
				,측정_날짜_시작_값
				,측정_날짜_종료_값);

		String[][] contents_arr = new String[발전_list.size()][header_arr.length];
		int flog_cnt =0;
		for(발전DTO 발전 :발전_list) {
			contents_arr[flog_cnt][0]=String.valueOf(발전.get발전소_ID());
			contents_arr[flog_cnt][1]=String.valueOf(발전.get측정_날짜());
			contents_arr[flog_cnt][2]=String.valueOf(발전.get발전량());
			flog_cnt++;
		}
		table = view_util.table_setting(contents_arr, header_arr, 30,30 ,540 ,550);
		dispose =view_util.JButton_setting("종료",450,600,80,30);
		
		c.add(table);
		c.add(dispose);
		dispose.addActionListener(this);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==dispose) {
			dispose();
		}
		
	}
	public static void main(String[] args) {
		String arr[][] = {{"null","null","null"}};
		String[] header_arr = {"발전소 ID","측정 날짜","발전량"};
		new table_발전_view("test",header_arr,"3","22/01/01","22/01/01");
	}


}
