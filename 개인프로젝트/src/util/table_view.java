package util;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class table_view extends JFrame implements ActionListener {
	JScrollPane table;
	JButton dispose;
	public  table_view(String title,String[][] contents_arr,String[] header_arr ){
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setSize(600,600);
		Container c = getContentPane();
		
		
		table = view_util.table_setting(contents_arr, header_arr, 15,15 ,540 ,450);
		dispose =view_util.JButton_setting("종료",450,500,80,30);
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
//public static void main(String[] args) {
//	String arr[][] = {{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"},{"박영수","90","87","98"}};
//	String arr2[] = {"sad","sad","asd","dsa"};
//	new table_view("test",arr,arr2);
//}


}
