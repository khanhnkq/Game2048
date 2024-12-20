package Game2048;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class quanlyMH{
	public int mg = 2;//le
	public int width = 400+3*mg;
	public int height = 400+3*mg;
	
	veMH veMH;
	quanlyData qlData;
	public quanlyMH(veMH veMH,quanlyData qlData,JFrame frame) {
		this.veMH = veMH;
		this.veMH = new veMH();
		this.qlData=qlData;
		this.qlData=new quanlyData();
		this.veMH.veNut(frame, width, height, mg);
		
	}
	
	public void setUp(JFrame frame) {
		frame.setSize(width+2*mg,height+28+2*mg);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setTitle("2048");
		frame.setFocusable(true);
		frame.setBackground(Color.red);
		frame.getContentPane().setBackground(Main.hex2Rgb("#000000"));
		
		//xu li su kien
		frame.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_LEFT) {
					qlData.moveLeft();
				}
				else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
					qlData.moveRight();
				}
				else if(e.getKeyCode()==KeyEvent.VK_UP) {
					qlData.moveUp();
				}
				else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
					qlData.moveDown ();
				}
				veMH.upDate();
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
	}


}
