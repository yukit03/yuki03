package cardLayout;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Card extends JFrame{
	
	
	Card(){
		
		JPanel upperpanel = new JPanel();
		CardLayout layout = new CardLayout(5,5);
		
		JPanel lowerpanel = new JPanel();
		upperpanel.setLayout(layout);//upperpanelをカードレイアウトに設定する
		
		JLabel lbl[] = new JLabel[5];//それぞれのコンポーネントの配列を作る
		JButton btn [] = new JButton[5];
		JPanel pnl [] = new JPanel[5];
		for(int i = 0;i<5; i++) {//for文でそれぞれnewして名前をつける
			lbl[i] = new JLabel("Label:"+Integer.toString(i));
			btn[i] = new JButton("Button:"+Integer.toString(i));
			pnl[i] = new JPanel();
			pnl[i].setLayout(new BoxLayout(pnl[i],BoxLayout.Y_AXIS));//pnl[i]内のコンポーネントを垂直に配置するためのBoxLayout。X_AXISなら水平
			pnl[i].add(lbl[i]);//i番目のパネルにiラベルを追加
			pnl[i].add(btn[i]);//i番目のパネルにiボタンを追加
			
			
		}
		
		for(int i = 0;i<5;i++) {//for文を回してupperpanel(ベースとなるパネル)に追加する。
			upperpanel.add(pnl[i],"p"+Integer.toString(i));
		}
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.setMinimumSize(new Dimension(120,36));
		btnPrevious.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				layout.previous(upperpanel);//Previousボタンを押したらパネルを切り替える（前のパネルを出す）
			}		
		});
		
		JButton btnNext = new JButton("Next");
		btnNext.setMinimumSize(new Dimension(120,36));
		btnNext.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				layout.next(upperpanel);//nextボタンを押したらパネルを切り替える（次のパネルを出す）
			}		
		});
		
		JButton btnshow2 = new JButton("p2");
		btnshow2.setMinimumSize(new Dimension(120,36));
		btnshow2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				layout.show(upperpanel,"p2");//showボタンを押したらｐ２のページに飛ぶ
			}		
		});
		
		
		
		upperpanel.setBorder(BorderFactory.createRaisedBevelBorder());//←浮き上がらせるような加工を施すレイアウト
		lowerpanel.add(btnPrevious);//lowerpanelにbtnPreviousボタンと、btnNextボタンを追加
		lowerpanel.add(btnNext);
		lowerpanel.add(btnshow2);
		JPanel panel = new JPanel();//upperpanelとlowerpanelを設置するベースのなるパネル
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));//垂直にレイアウト
		panel.add(upperpanel);
		panel.add(lowerpanel);
		
		this.getContentPane().add(panel);//ベースとなるpanelパネルをフレームに追加
		this.setTitle("card");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setVisible(true);
	
	}

	public static void main(String[] args) {
		new Card();
		

	}

}
