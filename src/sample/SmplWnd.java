package sample;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SmplWnd {
	
     static JPanel contentPane;
     
     
	public static void main(String[] args) {
		
		final JFrame frame = new JFrame("sample");

		frame.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

		});

		contentPane = new Panel1();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);

		frame.setSize(300,220);
		frame.setVisible(true);
		
//		contentPane = new Panel1();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		frame.add(contentPane);

	}

}
