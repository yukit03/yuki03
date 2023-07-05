package swing.Sample;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Panel1 extends JPanel implements ItemListener{

	String [] name = {"のび太","じゃいあん","ドラえもん","すねお","しずかちゃん","出木杉"};
	JComboBox<String> comboBox_1;
	JLabel lblNewLabel = new JLabel("");
	private JTextField textField;
	//private JComboBox comboBox_1;
	/**
	 * Create the panel.
	 */
	public Panel1() {
		JButton btnNewButton_1 = new JButton("B");

		JButton btnNewButton_2 = new JButton("C");

		JButton btnNewButton = new JButton("A");

		//JLabel lblNewLabel = new JLabel("");


		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lblNewLabel.setText("Aが押されました");


			}
		});

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lblNewLabel.setText("Bが押されました");
			}
		});

		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lblNewLabel.setText("Cが押されました");
			}
		});

		//JComboBox comboBox = new JComboBox();

		comboBox_1 = new JComboBox<>();
		for(int i=0;i<name.length;i++) {
			comboBox_1.addItem(name[i]);
		}
		comboBox_1.addItemListener(this);

		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("閉じる");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(60)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(40)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(67)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_3)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton)
									.addGap(131)
									.addComponent(btnNewButton_1)
									.addGap(134)
									.addComponent(btnNewButton_2)))))
					.addContainerGap(31, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(64)
					.addComponent(btnNewButton_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

	public void itemStateChanged(ItemEvent e) {//ItemListenerの抽象メソッド
		textField.setText((String) comboBox_1.getSelectedItem());
		lblNewLabel.setText((String) comboBox_1.getSelectedItem());
		//jjcomboBoxでメソッドを確認できる

	}
}
