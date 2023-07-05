package sample;

import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Button {//名前JButtonにしたらややこしい
	
	public static int counter = 0;

	public static void main(String[] args) {
		//デスクトップの情報を取得
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] gs = ge.getScreenDevices();
		//スクリーンの境界を取得
		GraphicsDevice gd = gs[0];
		GraphicsConfiguration[]gc=gd.getConfigurations();
		GraphicsConfiguration gc0=gc[0];
		Rectangle rect = gc0.getBounds();
		//境界値を格納
		int dw = rect.width;
		int dh = rect.height;
		//座標設定
		int ww = 500;
		int wh = 500;
		
		//ウィンドウ中央に配置するための計算
		//
		Rectangle rct = new Rectangle((dw-ww)/2,(dh-wh)/2,ww,wh);
		
	
		JFrame frame = new JFrame("ボタン");//ウィンドウを作成
		JButton button = new JButton("閉じる");//ボタンをインスタンス化。初期値に「閉じる」を持たせてボタンのテキストを表示
		JButton button1 = new JButton("クリック");
		JLabel label = new JLabel("0");
		//JDialog dlg=null;
		JButton button2 = new JButton("クリック数が20回を超えた時押したら閉じるよ");
		JButton button3 = new JButton("ダイアログボックスを開く");
		
		

//レイアウト設定
		frame.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		button3.addActionListener(new ActionListener(){//ボタンを押したときの処理をさせるクラスの実装
			public void actionPerformed(ActionEvent e) {
				JDialog dlg = new JDialog(frame,"Dialog",false);
				//ダイアログの表示場所を設定
				dlg.setBounds(rct);

				dlg.setMinimumSize(new java.awt.Dimension(500,500));//ダイアログのサイズを決める。これしないと最小サイズのままで表示されない
				//button2.addActionListener(new ActionListener(){//ボタンを押したときの処理をさせるクラスの実装
					//public void actionPerformed(ActionEvent e) {//実際の内容
						if(counter>20) {
						dlg.setVisible(false);
						dlg.dispose();//終了操作
						}
				
				dlg.getContentPane().add(button2);
				dlg.setVisible(true);
				
			}
		});


		button.addActionListener(new ActionListener(){//ボタンを押したときの処理をさせるクラスの実装
			public void actionPerformed(ActionEvent e) {//実際の内容
				System.exit(0);//プログラムの終了
			}
		});

		button1.addActionListener(new ActionListener(){//ボタンを押したときの処理をさせるクラスの実装
			public void actionPerformed(ActionEvent e) {//実際の内容				
				//int counter = Integer.parseInt(label.getText());//ボタンをクリックするたびに隣のラベルの数が増える
				counter++;
				label.setText(Integer.toString(counter));//String型にして表示さす

				
			}
		});
		
		
//上から順番にレイアウト(表示)される
		frame.getContentPane().add(button);//フレームの領域にボタンのコンポーネントを追加
		frame.getContentPane().add(button1);
		//frame.getContentPane().add(button3);
		frame.getContentPane().add(label);
		frame.getContentPane().add(button3);

		frame.addWindowListener(new WindowAdapter() {//ウィンドウ関係のアクションを設定

			@Override
			public void windowClosing(WindowEvent e) {//×を押したら動く処理
				System.exit(0);//プログラムの終了

			}	
		});

		frame.setSize(300,220);//サイズの指定
		frame.setVisible(true);//ウィンドウの可視可

	}

} 
