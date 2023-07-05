package sample;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Panel1 extends JPanel {

	/**
	 * Create the panel.
	 */
	public Panel1() {
		
		JButton button = new JButton("閉じる");
		add(button);//ボタンをパネルに追加
		button.addActionListener(new ActionListener(){//ボタンを押したときの処理をさせるクラスの実装
			public void actionPerformed(ActionEvent e) {//実際の内容
				System.exit(0);//プログラムの終了				
			}
		});
		
		

	}

}
