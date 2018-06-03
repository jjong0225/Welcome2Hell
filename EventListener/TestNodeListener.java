//package EventListener;
//
//import java.awt.event.*;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.ListIterator;
//import java.awt.*;
//import java.awt.TextArea;
//import java.awt.event.MouseListener;
//
//import Function.ApplyTree;
//import Function.NodeSearch;
//import Data.Node;
//import GUI.*;
//import Data.*;
//
//
//import javax.swing.JPanel;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JTextArea;
//
//public class TestNodeListener implements MouseListener {
//	Tree t;
//	JPanel mindmapArea;
//	int flag = 0;
//	int eventx;
//	int eventy;
//	public TestNodeListener(Tree t, JPanel mindmapArea) {
//		this.t = t;
//		this.mindmapArea = mindmapArea;
//	}
//	public void mousePressed(MouseEvent e) {
//		int x = e.getX();
//		int y = e.getY();
//		eventx = x;
//		eventy = y;
//		
//		System.out.println(x + " " + y);
//	}
//	public void mouseReleased(MouseEvent e) {
//		int x2 = e.getX();
//		int y2 = e.getY();
//		ArrayList<Node> arr = new ArrayList<Node>();
//		t.makeArray(arr, t.root);
//		ListIterator<Node> it = arr.listIterator();
//		Node n = null;
//		int realx=0;
//		int realy=0;
//		int rec = 10;
//		System.out.println("1");
//		while(it.hasNext()) {
//			n = (Node)it.next();
//			realx = (int) (n.x + mindmapArea.getSize().getWidth()/2);
//			realy = (int) (n.y + mindmapArea.getSize().getHeight()/2);
//			System.out.print(realx + " " +eventx +  " "+ (realx+n.w/2) +"and");
//			System.out.println(realy-n.h/2 + " " +eventy +  " "+ (realy+n.h/2));
//			
//			if(realx <= eventx && eventx <= realx + n.w && realy-rec <= eventy && eventy <= realy+rec) {
//				n.y = realy + y2 - eventy -(int)mindmapArea.getSize().getHeight()/2;
//				n.h = n.h + eventy - y2;
//				mindmapArea.removeAll();
//				mindmapArea.revalidate();
//				mindmapArea.repaint();
//				flag =1;
//			}
//			if(realx <= eventx && eventx <= realx + n.w && realy+n.h-rec <= eventy && eventy <= realy+n.h+rec) {
//				n.h = y2 -realy;
//				mindmapArea.removeAll();
//				mindmapArea.revalidate();
//				mindmapArea.repaint();
//				flag =2;
//			}
//			if(realy <= eventy && eventy <= realy + n.h && realx-rec <= eventx && eventx <= realx+rec) {
//				n.x = realx + x2 - eventx -(int)mindmapArea.getSize().getWidth()/2;
//				n.w = n.w + eventx - x2;
//				mindmapArea.removeAll();
//				mindmapArea.revalidate();
//				mindmapArea.repaint();
//				
//				return;
//			}
//			if(realy <= eventy && eventy <= realy + n.h && realx+n.w-rec <= eventx && eventx <= realx+n.w+rec) {
//				n.w = x2 - realx;
//				mindmapArea.removeAll();
//				mindmapArea.revalidate();
//				mindmapArea.repaint();
//				return;
//			}
//			if(((realx < eventx) && (eventx<realx+n.w)) && ((realy < eventy) && (eventy<realy+n.h))) {
//				n.x = (x2-eventx+realx-(int)mindmapArea.getSize().getWidth()/2);
//				n.y = (y2-eventy+realy-(int)mindmapArea.getSize().getHeight()/2);
//				mindmapArea.removeAll();
//				mindmapArea.revalidate();
//				mindmapArea.repaint();
//				return;
//			}
//			if(!it.hasNext()) {
//				return;
//			}
//		}
//		
//		}
//	public void mouseClicked(MouseEvent e) {
//		flag = 1;
//		
//	}
//	public void mouseEntered(MouseEvent e) {
//	}
//	public void mouseExited(MouseEvent e) {
//	}
//
//
//}
