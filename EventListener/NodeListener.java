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

public class NodeListener implements MouseListener {
	Tree t;
	JPanel mindmapPane;
	int eventx;
	int eventy;
	public NodeListener(Tree t, JPanel mindmapPane) {
		this.t = t;
		this.mindmapPane = mindmapPane;
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
		t.makeArray(arr, t.root);
		ListIterator<Node> it = arr.listIterator();
		Node n = null;
		int realx;
		int realy;
		System.out.println("1");
		while(it.hasNext()) {
			n = (Node)it.next();
			realx = (int) (n.x*10 + mindmapPane.getSize().getWidth()/2);
			realy = (int) (n.y*10 + mindmapPane.getSize().getHeight()/2);
			System.out.print(realx-n.w/2 + " " +eventx +  " "+ (realx+n.w/2) +"and");
			System.out.println(realy-n.h/2 + " " +eventy +  " "+ (realy+n.h/2));
			if(((realx-n.w/2 < eventx) && (eventx<realx+n.w/2)) && ((realy-n.h/2 < eventy) && (eventy<realy+n.h/2))) {
				System.out.println("잡았다 요놈");
				break;
			}
//			if(!it.hasNext()) {
//				System.out.println("조졌다");
//				
//				System.exit(0);
//			}
		}
		n.x = x2;
		n.y = y2;
		System.out.println(x2 + " " + y2);
		mindmapPane.removeAll();
		mindmapPane.revalidate();
		mindmapPane.repaint();
		return;
		}
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}


}
