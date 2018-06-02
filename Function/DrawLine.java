package Function;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawLine {

	public static void main(String[] args) {
		Dimension dim = new Dimension(400,300);
		
		JFrame frame = new JFrame("Morrph's House");
		frame.setLocation(200,400);
		frame.setPreferredSize(dim);
		
		DrawPanel drawpanel =new DrawPanel();
		
		frame.add(drawpanel);
		frame.pack();
		frame.setVisible(true);
		

	}

}
class DrawPanel extends JPanel{
	public void paint(Graphics g) {
		super.paint(g);
		g.drawArc(100,100,150,150,90,360);
	}
}