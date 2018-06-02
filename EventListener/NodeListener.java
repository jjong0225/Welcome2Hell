package EventListener;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.awt.*;
import java.awt.TextArea;

import Function.ApplyTree;
import Function.NodeSearch;
import GUI.*;
import Data.*;


import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class NodeListener implements MouseListener{
	Tree t;
	JPanel mindmapArea;
	Node dataNode;
	int flag;
	int flag2;
	int eventx;
	int eventy;
	
	public NodeListener(Tree t, JPanel mindmapArea, Node dataNode) {
		this.t = t;
		this.mindmapArea = mindmapArea;
		this.dataNode = dataNode;
		flag2 = 1;
	}
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		eventx = x;
		eventy = y;
		System.out.println(x + " " + y);
	}
	public void mouseReleased(MouseEvent e) {
			int x2 = e.getX();
			int y2 = e.getY();
			int rec = 10;
			flag = 1;
			if(eventx <= dataNode.w && eventy <= rec) 
				flag *=2;
			if(eventx <= dataNode.w && dataNode.h - rec <= eventy) 
				flag *=3;
			if(eventy <= dataNode.h && eventx <= rec) 
				flag *=5;
			if(eventy <= dataNode.h && dataNode.w - rec <= eventx) 
				flag *=7;
			
			
			if(flag%2==0) {
				dataNode.y += y2 - eventy;
				dataNode.h += eventy - y2;
			}
			if(flag%3==0) {
				dataNode.h += y2 - eventy;
			}
			if(flag%5==0) {
				dataNode.x += x2 - eventx;
				dataNode.w += eventx - x2;
			}
			if(flag%7==0) {
				dataNode.w += x2 - eventx;
			}
			if(flag == 1) {
				dataNode.x += x2 - eventx;
				dataNode.y += y2 - eventy;
			}
			if(x2 == eventx && y2 == eventy)
				;
			else {
				mindmapArea.removeAll();
				mindmapArea.revalidate();
				mindmapArea.repaint();
			}
		
		}
	public void mouseClicked(MouseEvent e) {
		flag2 *= -1;
		System.out.println("¿À¿ìšx!!!!!!!!!!!!!!!!!");
		dataNode.color = new Color(255-dataNode.color.getRed(),255-dataNode.color.getGreen(),255-dataNode.color.getBlue(),100);
		mindmapArea.removeAll();
		mindmapArea.revalidate();
		mindmapArea.repaint();
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	

}
