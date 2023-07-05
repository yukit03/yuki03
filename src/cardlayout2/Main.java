package cardlayout2;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame implements ActionListener{

	private JPanel contentPane;
	JPanel panel;
	CardLayout card;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
		setBounds(100, 100, 672, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		//上部パネル
		panel = new JPanel();
		card = new CardLayout();
		panel.setLayout(card);//カードレイアウトを設定 カードケースを作成
		
		panel.add("パネル1",new Panel1());//カードケースにパネルをセット
		panel.add("パネル2",new panel2());
		panel.add("パネル3",new panel3());
		panel.setBounds(12, 10, 628, 274);
		contentPane.add(panel);
		//下部パネル
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 304, 628, 98);
		contentPane.add(panel_1);

		JButton btnNewButton_1 = new JButton("ボタン１");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setActionCommand("ボタン1");
		panel_1.add(btnNewButton_1);

		JButton btnNewButton = new JButton("ボタン２");
		btnNewButton.addActionListener(this);
		btnNewButton.setActionCommand("ボタン2");
		panel_1.add(btnNewButton);

		JButton btnNewButton_2 = new JButton("ボタン3");
		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setActionCommand("ボタン3");
		panel_1.add(btnNewButton_2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand().equals("ボタン1")) {
			card.show(panel,"パネル1");
		}else if (e.getActionCommand().equals("ボタン2")) {
			card.show(panel,"パネル2");
		}else if(e.getActionCommand().equals("ボタン3")) {
			card.show(panel,"パネル3");
		}


	}
}
