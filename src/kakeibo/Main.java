package kakeibo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();//スレッド内の処理としてMainで作成したフレームをインスタンス化し、表示
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		Tabpane();//Tabメソッドの実装
		
	}
	
	void Tabpane() {
		
		JTabbedPane tabpane = new JTabbedPane();
		tabpane.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				Toolkit.getDefaultToolkit().beep();
				
			}
		});
		setLayout(new BorderLayout());
		JPanel panel1 = new Hyouji();
		tabpane.addTab("表示",panel1);
		JPanel panel2 = new Kensaku();
		tabpane.addTab("検索",panel2);
		JPanel panel3 = new Touroku();
		tabpane.addTab("登録",panel3);
		
		//tabとFrameのサイズを合わせる
		add(tabpane,BorderLayout.CENTER);
		
		
		
		
	}

}
