package kakeibo;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Hyouji extends JPanel {

	ArrayList<Kakeibo> list=new ArrayList<>();
	
	String [] columns = {"日付","費目","メモ","入金額","出金額"};
	private JTable table_1;
	db db =new db();
	/**
	 * Create the panel.
	 */
	public Hyouji() {
		
		//db db =new db();
		
		db.connect();
		list = db.dbGetKakeiboData();
		db.disConnect();
		
		//JPanel pane = new JPanel();mainのほうでnewしたらこいつが生まれるのでいらない

		
		JLabel lblNewLabel = new JLabel("テーブル表示");	
		Font font = new Font("PLAIN", Font.BOLD, 15);
		lblNewLabel.setFont(font);
		
		
		//作ってから配置しないと空のまま貼り付けられて意味ない
		table_1 = new JTable();
		
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
		
		
	}
	
	//リストの中身を詰める
	private Object[][]ConvertToObject(){ 
		
		Object[][]ob=new Object[list.size()][columns.length];
		
		//リストでループ処理
		for(int i=0;i<list.size();i++) {
			ob[i][0]=list.get(i).getHiduke();
			ob[i][1]=list.get(i).getHimoku();
			ob[i][2]=list.get(i).getMemo();
			ob[i][3]=list.get(i).getNyuukinn();
			ob[i][4]=list.get(i).getSyukkinn();
					
		}
		return ob;
	}
}
