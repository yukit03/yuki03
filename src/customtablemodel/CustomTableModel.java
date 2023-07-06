package customtablemodel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class CustomTableModel  extends AbstractTableModel{

	private List<Object[]> dataList;
	private List<Object[]> showList;
	private String filterText = "";
	private String[] colum;

	public CustomTableModel(List<Object[]> list,String[] col){
		dataList = new ArrayList<Object[]>(list);
		showList = new ArrayList<Object[]>(list);
		colum = col.clone();
	}

	public CustomTableModel(Object[][] obj,String[] col){
		dataList = new ArrayList<Object[]>();
		showList = new ArrayList<Object[]>();
		changeData(obj);
		colum = col.clone();
	}

	public CustomTableModel(String[] col){
		dataList = new ArrayList<Object[]>();
		showList = new ArrayList<Object[]>();
		colum = col.clone();
	}

	//二次元配列の場合はリストにする
	private void changeData(Object[][] obj) {
		int row = obj.length;
		for(int i=0;i<row;i++) {
			dataList.add(obj[i]);
			showList.add(obj[i]);
		}
	}

	//リストの中がオブジェクト配列になっているので、配列の先頭にフィルターテキストが含まれているかを見る
	public void filterData(String filterText) {
		this.filterText = filterText;
		filterReset();
	}
	
	private void filterReset() {
		showList.clear();
		for (Object[] row : dataList) {
			if (row[0].toString().contains(filterText)) {
				showList.add(row);
			}
		}
		
		fireTableDataChanged(); // テーブルの再描画
	}

	public void addRow(Object[] rowData) {
		// データモデルに新しい行を追加する処理
		dataList.add(rowData);
		// テーブルビューに新しい行が挿入されたことを通知
		int rowIndex = dataList.size() - 1; // 挿入された行のインデックス
		//fireTableRowsInserted(rowIndex, rowIndex);
		filterReset();
	}

	@Override
	public int getRowCount() {
		return showList.size();
	}

	@Override
	public int getColumnCount() {
		return colum.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return showList.get(rowIndex)[columnIndex];
	}
	
	@Override
    public String getColumnName(int column) {
        return colum[column];
    }

}
