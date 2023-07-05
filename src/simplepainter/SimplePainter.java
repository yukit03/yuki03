package simplepainter;

import java.awt.Color;

import javax.swing.JFrame;

public class SimplePainter {
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("ペイント");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,400);
		frame.setLocationRelativeTo(null);
		
		Canvas canvas = new Canvas();
		canvas.setBackground(Color.BLACK);
		frame.add(canvas);
		
		frame.setVisible(true);
	}

}