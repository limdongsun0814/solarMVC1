package util;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class min_text_box extends JFrame implements ActionListener{

	JButton dispose;
	public  min_text_box(String data) {
		setTitle(data);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		Container c = getContentPane();
		c.setLayout(null);
		JLabel name_text = view_util.JLabel_setting(data,30,30,270,30);

		dispose =view_util.JButton_setting("종료",100,200,100,30);
		c.add(name_text);
		c.add(dispose);
		dispose.addActionListener(this);
		dispose.addActionListener(this);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == dispose) {
			dispose();
		}
		
	}
}
