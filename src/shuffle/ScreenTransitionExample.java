package shuffle;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ScreenTransitionExample extends JFrame {
    private JPanel currentScreen;
    private JPanel screen1;
    private JPanel screen2;
    private JPanel screen3;

    public ScreenTransitionExample() {
        setTitle("Screen Transition Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // スクリーン1
        screen1 = new JPanel();
        screen1.setLayout(new FlowLayout());
        JLabel label1 = new JLabel("Screen 1");
        screen1.add(label1);
        JButton nextButton1 = new JButton("Next");
        screen1.add(nextButton1);

        // スクリーン2
        screen2 = new JPanel();
        screen2.setLayout(new FlowLayout());
        JLabel label2 = new JLabel("Screen 2");
        screen2.add(label2);
        JButton nextButton2 = new JButton("Next");
        screen2.add(nextButton2);
        JButton backButton2 = new JButton("Back");
        screen2.add(backButton2);

        // スクリーン3
        screen3 = new JPanel();
        screen3.setLayout(new FlowLayout());
        JLabel label3 = new JLabel("Screen 3");
        screen3.add(label3);
        JButton backButton3 = new JButton("Back");
        screen3.add(backButton3);

        // 初期画面を設定
        currentScreen = screen1;
        add(currentScreen);

        // Nextボタンのアクションリスナー
        nextButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(currentScreen);  // 現在のスクリーンを削除
                currentScreen = screen2;  // スクリーン2に切り替え
                add(currentScreen);  // 新しいスクリーンを追加
                revalidate();  // コンポーネントの再配置
                repaint();  // コンポーネントの再描画
            }
        });

        nextButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(currentScreen);  // 現在のスクリーンを削除
                currentScreen = screen3;  // スクリーン3に切り替え
                add(currentScreen);  // 新しいスクリーンを追加
                revalidate();  // コンポーネントの再配置
                repaint();  // コンポーネントの再描画
            }
        });

        // Backボタンのアクションリスナー
        backButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(currentScreen);  // 現在のスクリーンを削除
                currentScreen = screen1;  // スクリーン1に切り替え
                add(currentScreen);  // 新しいスクリーンを追加
                revalidate();  // コンポーネントの再配置
                repaint();  // コンポーネントの再描画
            }
        });

        backButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(currentScreen);  // 現在のスクリーンを削除
                currentScreen = screen2;  // スクリーン2に切り替え
                add(currentScreen);  // 新しいスクリーンを追加
                revalidate();  // コンポーネントの再配置
                repaint();  // コンポーネントの再描画
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ScreenTransitionExample example = new ScreenTransitionExample();
                example.setVisible(true);
            }
        });
    }
}

