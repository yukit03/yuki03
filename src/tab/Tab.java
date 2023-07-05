package tab;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Tab extends JFrame{
	
	Tab(){
		JTabbedPane tabpane = new JTabbedPane();
		tabpane.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				Toolkit.getDefaultToolkit().beep();
				
			}
		});
		
		JPanel panel1 = new JPanel();//1ページ目のパネル用意
		JTextArea txtarea = new JTextArea(5,10);//テキスト用意
		txtarea.setText("タブの１ページ目");//テキストに値セット
		panel1.add(txtarea);//パネル１に追加
		tabpane.addTab("1ページ",panel1);//タブに追加（タブの名前と、追加したいパネル）
		JPanel panel2 = new JPanel();//２ページ目のパネル
		JLabel lbl = new JLabel("タブの２ページ目");//名前付きのラベル用意
		panel2.add(lbl);//パネル２にラベル追加
	    tabpane.addTab("2ページ",panel2);//タブに追加
	    String lst[] = {"かつ丼","うどん","天丼","ライス","カレー"};//リストに追加するための値をもった配列を用意
	    JList<String>lstbox = new JList<String>(lst);//GUI版のリスト？用意
	    JPanel panel3 = new JPanel();//３ページ目のパネル用意
	    panel3.add(lstbox);//パネルにリストを追加
	    tabpane.addTab("3ページ", panel3);//タブに追加
	    
	    add(tabpane);//frameに追加
	    
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setTitle("Tab");
	    setSize(250,160);
	    setVisible(true);
	    
	}
	
	

	public static void main(String[] args) {
		new Tab();

	}

}
