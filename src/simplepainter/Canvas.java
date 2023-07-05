package simplepainter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Canvas extends JPanel implements MouseMotionListener{

	private int x = -100;
	private int y = -100;
	private int count = 0;
	Image image;
	BufferedImage bufferedImage = null;
	

	public Canvas() {
		setLayout(null);
		addMouseMotionListener(this);
		setSize(600,400);

		try {
			bufferedImage = ImageIO.read(new File(System.getProperty("user.dir") + "\\src\\simplepainter\\犬.jpg"));
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
        image = bufferedImage.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
	}

	public void paintComponent(Graphics g) {

		changeIcon();
		g.setColor(Color.RED);
		g.fillOval(x-5, y-5, 10, 10);
		g.drawImage(image, 200, 0, null);
		
	}

	private void changeIcon() {
		
		try {
			if(count == 5) {
				bufferedImage = ImageIO.read(new File(System.getProperty("user.dir") + "\\src\\simplepainter\\犬.jpg"));
			}else if(count == 100){
				bufferedImage = ImageIO.read(new File(System.getProperty("user.dir") + "\\src\\simplepainter\\犬b.jpg"));
			}else if(count == 200){
				bufferedImage = ImageIO.read(new File(System.getProperty("user.dir") + "\\src\\simplepainter\\犬c.jpg"));
			}else if(count == 300){
				bufferedImage = ImageIO.read(new File(System.getProperty("user.dir") + "\\src\\simplepainter\\犬d.jpg"));
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		image = bufferedImage.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		x = e.getX();
		y = e.getY();

		count++;
		if(count == 300) {
			count = 0;
		}
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

}