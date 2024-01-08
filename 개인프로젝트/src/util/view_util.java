package util;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class view_util {
	public static JLabel JLabel_setting(String name,int Location_x, int Location_y, int size_x,int size_y) {
		JLabel jlabel = new JLabel(name);
		jlabel.setLocation(Location_x,Location_y);
		jlabel.setSize(size_x,size_y);
		return jlabel;
	}
	public static JTextField JTextField_setting(String name,int Location_x, int Location_y, int size_x,int size_y) {
		JTextField jtextfield = new JTextField(name);
		jtextfield.setLocation(Location_x,Location_y);
		jtextfield.setSize(size_x,size_y);
		return jtextfield;
	}
	public static JButton JButton_setting(String name,int Location_x, int Location_y, int size_x,int size_y) {
		JButton jbutton = new JButton(name);
		jbutton.setLocation(Location_x,Location_y);
		jbutton.setSize(size_x,size_y);
		return jbutton;
	}
	public static JScrollPane table_setting(String[][] contents, String[] header,int Location_x, int Location_y, int size_x,int size_y) 
	{	
		JTable jtable = new JTable(contents,header);
		JScrollPane scrollpane = new JScrollPane(jtable);
		scrollpane.setLocation(Location_x,Location_y);
		scrollpane.setSize(size_x,size_y);
		return scrollpane;
		
	}
	
	
}
