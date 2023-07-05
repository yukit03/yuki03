package kakeibo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Touroku extends JPanel {
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
//	private JTextField textField_3;
	private JTextArea textArea;
	
	/**
	 * Create the panel.
	 */
	public Touroku() {
		
		db db = new db();
				
		//JPanel panel = new JPanel();
		JLabel lblNewLabel = new JLabel("登録ページ");
		Font font = new Font("PLAIN", Font.BOLD, 15);
		lblNewLabel.setFont(font);
		
		JLabel lblNewLabel_1 = new JLabel("費目");
		
		JLabel lblNewLabel_2 = new JLabel("入金額");
		
		JLabel lblNewLabel_3 = new JLabel("出金額");
		
		JLabel lblNewLabel_4 = new JLabel("メモ");
		
		JButton btnNewButton = new JButton("登録");
		
		textField = new JTextField();//費目
		textField.setColumns(10);
		
		textField_1 = new JTextField();//入金額
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();//出金額
		textField_2.setColumns(10);
		
		textArea = new JTextArea();
//		textField_3 = new JTextField();//メモ
//		textField_3.setColumns(50);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String himoku = textField.getText();
				String memo = textArea.getText();
				int nyuukinn = Integer.parseInt(textField_1.getText());
				int syukkinn =  Integer.parseInt(textField_2.getText());
				
			
				db.insertKakeibo(new Kakeibo(new Date(),himoku,memo,nyuukinn,syukkinn));
				textField_1.setText("");
				textField_2.setText("");
				textField.setText("");
				textArea.setText("");
				
				
				
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(238, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_4))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(166, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(363, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(30))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton))
						.addComponent(lblNewLabel_4))
					.addGap(28))
		);
		setLayout(groupLayout);

	}
}
