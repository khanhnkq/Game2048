package Game2048;

import java.awt.Color;

import javax.swing.JFrame;

public class Main {
	JFrame game;
	quanlyMH qlMH;
	veMH veMH;
	quanlyData qlData;
	
	public Main() {
		init();
		setUp();
		
	}
	
	private void init() {
		game = new JFrame();
		qlMH = new quanlyMH(veMH,qlData,game);
	}
	private void setUp() {
		qlMH.setUp(game);
	}
	

	public static void main(String[] args) {
		Main g = new Main();
	

	}
	//set string sang color
	public static Color hex2Rgb(String colorStr) {
	    return new Color(
	            Integer.valueOf( colorStr.substring( 1, 3 ), 16 ),
	            Integer.valueOf( colorStr.substring( 3, 5 ), 16 ),
	            Integer.valueOf( colorStr.substring( 5, 7 ), 16 ) );
	}

}
