 package Game2048;
 import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class veMH {
	JLabel arrlb[][]= new JLabel[4][4];
	
	public void veNut(JFrame frame, int W, int H, int M ) {
		 int w = (W-3*M)/4;
		 int h = (H-3*M)/4;
		 int x=0,y=0;
		  
		 for(int i=0; i<4;i++) {               //cot
			 y = i * h + (1 + i) * M;
			 for(int j=0; j<4;  j++) {         //hang
				 x = j * w + (1 + j) * M;
				 arrlb[i][j] = taoO(x, y, w, h, i, j);
				 frame.add(arrlb[i][j]); 
			 }
		 }
		 frame.add(new JLabel());
	}
	private JLabel taoO(int x, int y, int w, int h, int i, int j) {
		JLabel l = new JLabel("5");
		l.setBounds(x, y, w, h);
		setBG(l,i,j); 
		l.setOpaque(true);
		return l;
	}
	private void setBG(JLabel l, int i, int j) {
		int data = Data.getData().arr[i][j]; 
		String color="";
		switch(data) {
		case 2:
			color = "9600FF";
			break;
		case 4:
			color = "F0145A";
			break;
		case 8:
			color = "FFC91B";
			break;
		case 16:
			color = "093711";
			break;
		case 32:
			color = "0095D6";
			break;
		case 64:
			color = "CE007B";
			break;
		case 128:
			color = "FF5518";
			break;
		case 256:
			color = "29D7A5";
			break;
		case 512:
			color = "73C702";
			break;
		case 1024:
			color = "FF0024";
			break;
		case 2048:
			color = "5F069B";
			break;
		default:
			color = "373737";
			break;
		}
		if(data==0) {
			l.setText("");
		}else {
			l.setText(""+data);
		}
		l.setFont(new Font("Sefif",Font.BOLD,26));	
		l.setForeground(Color.WHITE);
		l.setHorizontalAlignment(SwingConstants.CENTER);
		l.setVerticalAlignment(SwingConstants.CENTER);
	    l.setBackground(Main.hex2Rgb("#"+color));
	}
    public void upDate() {
    	for(int i=0; i<4;i++) {
			 for(int j=0; j<4;  j++) {
				 setBG(arrlb[i][j], i, j);}
			 }
    	
    }
}
