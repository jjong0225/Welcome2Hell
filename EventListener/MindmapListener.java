package EventListener;


import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.awt.*;
import java.awt.TextArea;
import java.awt.event.MouseListener;

import Function.ApplyTree;
import Function.NodeSearch;
import Data.Node;
import GUI.*;
import Data.*;


import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class MindmapListener implements MouseListener {
	Tree t;
	JPanel mindmapArea;
	int flag = 0;
	int eventx;
	int eventy;
	public MindmapListener(Tree t, JPanel mindmapArea) {
		this.t = t;
		this.mindmapArea = mindmapArea;
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
		ArrayList<Node> arr = new ArrayList<Node>();
		t.makeArray(arr, t.getRoot());
		ListIterator<Node> it = arr.listIterator();
		Node n = null;
		int realx=0;
		int realy=0;
		int rec = 10;
		System.out.println("1");
		while(it.hasNext()) {
			n = (Node)it.next();
			realx = (int) (n.getX() + mindmapArea.getSize().getWidth()/2);
			realy = (int) (n.getY() + mindmapArea.getSize().getHeight()/2);
			System.out.print(realx + " " +eventx +  " "+ (realx+n.getWidth()/2) +"and");
			System.out.println(realy-n.getHeight()/2 + " " +eventy +  " "+ (realy+n.getHeight()/2));
			
			if(realx <= eventx && eventx <= realx + n.getWidth() && realy-rec <= eventy && eventy <= realy+rec) {
//				n.setY(realy + y2 - eventy -(int)mindmapArea.getSize().getHeight()/2);
//				n.setHeight(n.getHeight() + eventy - y2);
//				mindmapArea.removeAll();
//				mindmapArea.revalidate();
//				mindmapArea.repaint();
				flag =1;
			}
			if(realx <= eventx && eventx <= realx + n.getWidth() && realy+n.getHeight()-rec <= eventy && eventy <= realy+n.getHeight()+rec) {
//				n.setHeight(y2 -realy);
//				mindmapArea.removeAll();
//				mindmapArea.revalidate();
//				mindmapArea.repaint();
//				flag =2;
			}
			if(realy <= eventy && eventy <= realy + n.getWidth() && realx-rec <= eventx && eventx <= realx+rec) {
//				n.setX(realx + x2 - eventx -(int)mindmapArea.getSize().getWidth()/2);
//				n.setWidth(n.getWidth() + eventx - x2);
//				mindmapArea.removeAll();
//				mindmapArea.revalidate();
//				mindmapArea.repaint();
//				
				return;
			}
			if(realy <= eventy && eventy <= realy + n.getHeight() && realx+n.getWidth()-rec <= eventx && eventx <= realx+n.getWidth()+rec) {
//				n.setWidth(x2 - realx);
//				mindmapArea.removeAll();
//				mindmapArea.revalidate();
//				mindmapArea.repaint();
				return;
			}
			if(((realx < eventx) && (eventx<realx+n.getWidth())) && ((realy < eventy) && (eventy<realy+n.getHeight()))) {
//				n.setX(x2-eventx+realx-(int)mindmapArea.getSize().getWidth()/2);
//				n.setY(y2-eventy+realy-(int)mindmapArea.getSize().getHeight()/2);
//				mindmapArea.removeAll();
//				mindmapArea.revalidate();
//				mindmapArea.repaint();
				return;
			}
			if(!it.hasNext()) {
				it = arr.listIterator();
				while(it.hasNext()) {
					n = (Node)it.next();
					if(n.getFocus() == true) {
						n.setColor(new Color(255-n.getColor().getRed(), 255 - n.getColor().getGreen(), 255 - n.getColor().getBlue(), 100));
						n.setFocus(false);
						mindmapArea.removeAll();
						mindmapArea.revalidate();
						mindmapArea.repaint();
						break;
					}
				}
			}
		}
		
		}
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}


}