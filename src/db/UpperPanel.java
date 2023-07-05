package db;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
public class UpperPanel extends JPanel {

	ArrayList<ArchiveData> list=new ArrayList<>();
	DbAccess db =new DbAccess();
	
	private JTable table;
	String [] columns = {"学籍番号","学生名","法学","経済学","哲学","情報理論","外国語","総合成績"};
	/**
	 * 
	 * Create the panel.
	 */
	public UpperPanel() {

		//データベースから取得したリストを受けとる
		list = db.dbGetArchiveData();
		
		//defalulttablemodelにリストを詰める
		DefaultTableModel tablemodel=new DefaultTableModel(ConvertToObject(),columns);
		table=new JTable(tablemodel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//複数選択できなくする処理
		
		//テーブルの列のサイズ設定                    キャスト
		DefaultTableColumnModel columnModel = (DefaultTableColumnModel)table.getColumnModel();
		//テーブルから列設定用クラスのインスタンスを作る
		TableColumn column =null;
		for(int i=0;i<columnModel.getColumnCount();i++) {
			column =columnModel.getColumn(i);
			column.setPreferredWidth(100);//（幅指定）
			
		}
		
		//スクロールパネルにテーブルを追加
		JScrollPane sp=new JScrollPane(table);//作ったtableをJScrollPaneにのせる
		sp.setPreferredSize(new Dimension(500,100));//スクロールパネルのサイズ
		
		//upperpanelにスクロールパネルを追加する
		this.add(sp);
		
		
	}
	
	//ArrayList→Objectに変換する
	private Object[][]ConvertToObject(){ 
		Object[][]ob=new Object[list.size()][columns.length];
		
		//リストでループ処理
		for(int i=0;i<list.size();i++) {
			ob[i][0]=list.get(i).getGakusekibanngou();
			ob[i][1]=list.get(i).getGakuseimei();
			ob[i][2]=list.get(i).getHougaku();
			ob[i][3]=list.get(i).getKeizaigaku();
			ob[i][4]=list.get(i).getTetugaku();
			ob[i][5]=list.get(i).getJyoiuhouriron();
			ob[i][6]=list.get(i).getGaikokugo();
			ob[i][7]=list.get(i).getSougouseiseki();
			
			
			
		}
		return ob;
	}

}
