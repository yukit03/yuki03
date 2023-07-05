package practice1;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	String a = "";
	Object[][] date ;
	String[] columnNames = { "氏名", "住所", "性別" };
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
		setBounds(100, 100, 450, 400);
		setTitle("プロフィール登録");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("氏名");

		textField = new JTextField();
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("住所");



		JComboBox<String> comboBox = new JComboBox<String>();
		//選択欄の追加

		comboBox.addItem("東京都");
		comboBox.addItem("大阪府");
		comboBox.addItem("京都府");
		comboBox.addItem("兵庫県");
		comboBox.addItem("愛知県");

		//コンボボックスの値の取得
		String item = (String)comboBox.getSelectedItem();
		//コンボボックスのインデックスの取得
		//int index = comboBox.getSelectedIndex();


		textField_1 = new JTextField();
		textField_1.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("性別");

		JRadioButton rdbtnNewRadioButton = new JRadioButton("男性");

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("女性");

		ButtonGroup buttonGroup = new ButtonGroup();
		//ボタングループに、グループにしたいボタンを追加する
		buttonGroup.add(rdbtnNewRadioButton);
		buttonGroup.add(rdbtnNewRadioButton_1);

		ActionListener actionListener = new ActionListener() {
			//アクションリスナー等の中の処理以外はただのデザインなので処理されない
			@Override
			public void actionPerformed(ActionEvent e) {
				// 選択されたラジオボタンの内容を取得
				if (rdbtnNewRadioButton.isSelected()) {
					a = "男性";
				} else if (rdbtnNewRadioButton_1.isSelected()) {
					a = "女性";

				}
			}
		};

		// ActionListenerをラジオボタンに追加
		rdbtnNewRadioButton.addActionListener(actionListener);
		rdbtnNewRadioButton_1.addActionListener(actionListener);
		//上記の例では、ButtonGroupを作成し、その中にラジオボタンを追加しています。それぞれのラジオボタンに対してActionListenerを設定し、選択状態の変化があった際に処理が実行されるようにしています。

		//ActionListenerの中で、isSelected()メソッドを使用して選択されたラジオボタンを判定し、選択内容に応じた処理を行うことができます。


		//table = new JTable();
		
		
		//table = new JTable(date,columnNames);
		DefaultTableModel model = new DefaultTableModel(date, columnNames);
		table = new JTable(model);
		
		//スクロールパネル→テーブル→モデル(中身)という段階で重ねていく
		
		
//		DefaultTableColumnModel columnModel = (DefaultTableColumnModel)table.getColumnModel();
//		//テーブルから列設定用クラスのインスタンスを作る
//		TableColumn column =null;
//		for(int i=0;i<columnModel.getColumnCount();i++) {
//			column =columnModel.getColumn(i);
//			column.setPreferredWidth(100);//（幅指定）

//		}

		//スクロールパネルにテーブルを追加
		JScrollPane sp=new JScrollPane(table);//作ったtableをJScrollPaneにのせる
		sp.setPreferredSize(new Dimension(250,100));//スクロールパネルのサイズ
		
		add(sp);


		JButton btnNewButton = new JButton("登録");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int result = JOptionPane.showConfirmDialog(null, "登録しますか？","確認",JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					Object[] ob = {textField.getText(),item+" "+textField_1.getText(),a};
					model.addRow(ob);
					
					textField.setText("");
					textField_1.setText("");
					
					
				} else if (result == JOptionPane.NO_OPTION) {

				}
			}
		});


		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(24)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(sp, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_1)
												.addComponent(lblNewLabel_2))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(rdbtnNewRadioButton)
														.addGap(18)
														.addComponent(rdbtnNewRadioButton_1))
												.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
														.addComponent(btnNewButton)
														.addComponent(textField, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE))
												.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(32, Short.MAX_VALUE))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(rdbtnNewRadioButton)
								.addComponent(rdbtnNewRadioButton_1))
						.addGap(6)
						.addComponent(btnNewButton)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(sp, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(39, Short.MAX_VALUE))
				);
		contentPane.setLayout(gl_contentPane);
	}
}
