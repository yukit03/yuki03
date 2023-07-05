package kakeibo;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Kensaku extends JPanel {
	ArrayList<Kakeibo>list = new ArrayList<>();
	Kakeibo kakeibo = new Kakeibo();
	JTable table_1;
	db db = new db();
	String [] columns = {"日付","費目","メモ","入金額","出金額"};
	/**
	 * Create the panel.
	 */
	public Kensaku() {


		SpringLayout l = new SpringLayout(); 
		this.setLayout(l);//このパネルはSpringレイアウトでつくりますよー
		JLabel lblNewLabel = new JLabel("検索");		
		Font font = new Font("PLAIN", Font.BOLD, 15);
		lblNewLabel.setFont(font);
		
		JTextField tex = new JTextField();
		tex.setColumns(10);
		
		
		

		JButton b = new JButton("検索");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				db.connect();
				list = db.getHimoku(tex.getText());
				db.disConnect();
				
			
					if(list.isEmpty()) {
						JOptionPane.showMessageDialog(null, "費目に存在しない項目です");
						tex.setText("");
						
//						int result = JOptionPane.showConfirmDialog(null, "費目に存在しない項目です");
//						if (result == JOptionPane.YES_OPTION) {
//							//「はい」の時の処理
//						} else if (result == JOptionPane.NO_OPTION) {
//							//「いいえ」の時の処理
//						} else if (result == JOptionPane.CANCEL_OPTION) {
//							//「キャンセル」の時の処理
//						}

						//JOptionPane.showMessageDialog(null, "これは情報メッセージです。");
//						JDialog d = new JDialog();
//						JButton b1 = new JButton("費目内に存在しません"); 
//						//ダイアログにタイトルをつける
//						     d.setTitle("エラー");
//						//ダイアログのサイズを指定する
//						     d.setSize(300, 200);
//						    //ダイアログの表示場所。Nullなら画面中央。
//						     d.setLocationRelativeTo(null);
//						    // ダイアログをモーダルダイアログとして設定
//						    // モーダルの時は他のウインドウとかの操作をブロックできる
//						     d.setModal(true);
//						     d.setVisible(true);
//						     tex.setText("");
//						     
//						     d.add(b1);
//						
					}
					
				
				
				//テーブルデータの更新
				DefaultTableModel tableModel = (DefaultTableModel) table_1.getModel();
				tableModel.setDataVector(ConvertToObject(), columns);
				
				table_1.repaint();

			}
		});
		
		
		add(b);
		add(lblNewLabel);
		add(tex);
		
		//table_1 = new JTable();

		//defalulttablemodelにリストを詰める
		DefaultTableModel tablemodel=new DefaultTableModel(ConvertToObject(),columns);
		table_1=new JTable(tablemodel);
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//複数選択できなくする処理

		//テーブルの列のサイズ設定                    キャスト
		DefaultTableColumnModel columnModel = (DefaultTableColumnModel)table_1.getColumnModel();
		//テーブルから列設定用クラスのインスタンスを作る
		TableColumn column =null;
		for(int i=0;i<columnModel.getColumnCount();i++) {
			column =columnModel.getColumn(i);
			column.setPreferredWidth(100);//（幅指定）

		}

		//スクロールパネルにテーブルを追加
		JScrollPane sp=new JScrollPane(table_1);//作ったtableをJScrollPaneにのせる
		sp.setPreferredSize(new Dimension(500,100));//スクロールパネルのサイズ

		this.add(sp);
		
		l.putConstraint(SpringLayout.WEST,lblNewLabel,10,SpringLayout.WEST,this);
		l.putConstraint(SpringLayout.NORTH,lblNewLabel,10,SpringLayout.NORTH,this);
		l.putConstraint(SpringLayout.SOUTH,b,-50,SpringLayout.SOUTH,this);
		l.putConstraint(SpringLayout.WEST,b,50,SpringLayout.WEST,this);
		l.putConstraint(SpringLayout.NORTH,sp,80,SpringLayout.WEST,this);
		l.putConstraint(SpringLayout.EAST,tex,-100,SpringLayout.EAST,this);
		l.putConstraint(SpringLayout.SOUTH,tex,-50,SpringLayout.SOUTH,this);
		

	}

	//リストの中身を詰める
	private Object[][]ConvertToObject(){ 

		Object[][]ob=new Object[list.size()][columns.length];

		//リストでループ処理
		for(int i = 0;i<list.size();i++) {
		ob[i][0]=list.get(i).getHiduke();
		ob[i][1]=list.get(i).getHimoku();
		ob[i][2]=list.get(i).getMemo();
		ob[i][3]=list.get(i).getNyuukinn();
		ob[i][4]=list.get(i).getSyukkinn();
		}

		return ob;


	}

}
