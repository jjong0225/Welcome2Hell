//package GUI;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Graphics;
//import java.util.ArrayList;
//import java.util.Iterator;
//
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.border.LineBorder;
//import javax.swing.border.TitledBorder;
//
//import Data.Node;
//import Data.Tree;
//
//public class MindmapArea {
//	public JPanel mindmapPane;
//	Tree mainTree;
//	JFrame mainFrame;
//	
//	public MindmapArea(Tree mainTree, JFrame mainFrame) { 
//	this.mainTree = mainTree;
//	this.mainFrame = mainFrame;
//	 mindmapPane = new JPanel();
////	 mindmapPane.setLayout(null);
////	 DrawingPane drawing = new DrawingPane(mainTree, mindmapPane, mainFrame);
////	 drawing.setSize(600, 500);
////	 drawing.setLocation(0, 0);
//
////	 mindmapPane.add(drawing);
////	 mindmapPane = drawing;
////	 mindmapPane.setLayout(null);
////	 mindmapPane.setBackground(Color.GRAY);
//	}
//	
//	public void setMindmapPane(JPanel mindmapPane) {
//		this.mindmapPane = mindmapPane;
//	}
//	
//	
//	public void paintComponent(Graphics g) {
////		super.paintComponent(g);
////		mindmapPane.removeAll();
//		ArrayList<Node> NodeArray = new ArrayList<Node>();
//		g.drawLine(20, 30, 50, 60);
//		
//		Tree t = mainTree;
//
//		if (t.root == null)
//			return;
//		
//		t.makeArray(NodeArray,t.root);
//		
//        Iterator<Node> it = NodeArray.iterator();
//        while(it.hasNext()) {
//            Node dataNode = it.next();
//    		JLabel showNode =new JLabel((String)(dataNode.info));
//    		System.out.println((String)dataNode.info);
//    		
//    		//showNode.setBackground(Color.white);
//    		showNode.setOpaque(true);
//    		showNode.setBorder(new TitledBorder(new LineBorder(Color.black,3)));
////    		showNode.setLocation(30, 20);
//    		
//
//    		showNode.setSize(60, 40);
//    		System.out.println((int)(dataNode.x*10 + mindmapPane.getSize().getWidth()/2) + "," + (int)(dataNode.y*10+ mindmapPane.getSize().getHeight()/2));
//    		showNode.setLocation((int)(dataNode.x*10 + mindmapPane.getSize().getWidth()/2), (int)(dataNode.y*10+ mindmapPane.getSize().getHeight()/2));    		
//    		mindmapPane.add(showNode);
//
//    		showNode.setVisible(true);
//    		showNode = null;
//         	}
//        NodeArray = null;
//		}
//}
//
////class DrawingPane extends JPanel {
////	Tree t;
////	JPanel mindmapPane;
////	JFrame mainFrame;
////	
////	public DrawingPane (Tree t, JPanel mindmapPane, JFrame mainFrame){
////		this.t = t;
////		this.mindmapPane = mindmapPane;
////		this.mainFrame = mainFrame;
////	}
////	public void paintComponent(Graphics g) {
////		super.paintComponent(g);
//////		mindmapPane.removeAll();
////		ArrayList<Node> NodeArray = new ArrayList<Node>();
////		g.drawLine(20, 30, 50, 60);
////
////		if (t.root == null)
////			return;
////		
////		t.makeArray(NodeArray,t.root);
////		
////        Iterator<Node> it = NodeArray.iterator();
////        while(it.hasNext()) {
////            Node dataNode = it.next();
////    		JLabel showNode =new JLabel((String)(dataNode.info));
////    		System.out.println((String)dataNode.info);
////    		
////    		//showNode.setBackground(Color.white);
////    		showNode.setOpaque(true);
////    		showNode.setBorder(new TitledBorder(new LineBorder(Color.black,3)));
//////    		showNode.setLocation(30, 20);
////    		
////
////    		showNode.setSize(60, 40);
////    		System.out.println((int)(dataNode.x*10 + mindmapPane.getSize().getWidth()/2) + "," + (int)(dataNode.y*10+ mindmapPane.getSize().getHeight()/2));
////    		showNode.setLocation((int)(dataNode.x*10 + mindmapPane.getSize().getWidth()/2), (int)(dataNode.y*10+ mindmapPane.getSize().getHeight()/2));    		
////    		mindmapPane.add(showNode);
////
////    		showNode.setVisible(true);
////    		showNode = null;
////         	}
////        NodeArray = null;
////		}
////	}
////
////
////
////
////


package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.JViewport;

import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import Data.Node;
import Data.Point;
import Data.Tree;
import EventListener.NodeListener;

public class MindmapArea extends JPanel {
	Tree mainTree;
	JFrame mainFrame;

	AttributeArea attributeArea;
	public JScrollPane scroll;

	
	public MindmapArea(Tree mainTree, JFrame mainFrame) {
	this.mainTree = mainTree;
	this.mainFrame = mainFrame;
	//���⿡ ��ũ�� ����� �߰��Ϸ� ����� ������
//	setLayout(null);
//	JScrollPane sp = new JScrollPane(this, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//	setPreferredSize(new Dimension(4000,3000));
//	add(this);
	
	
	
//	 mindmapPane.setLayout(null);
//	 DrawingPane drawing = new DrawingPane(mainTree, mindmapPane, mainFrame);
//	 drawing.setSize(600, 500);
//	 drawing.setLocation(0, 0);

//	 mindmapPane.add(drawing);
//	 mindmapPane = drawing;
//	 mindmapPane.setLayout(null);
//	 mindmapPane.setBackground(Color.GRAY);
	}
	

	public void setScroll(JScrollPane scroll)
	{
		this.scroll = scroll;
	}

	
	public void paintComponent(Graphics g) {
		this.removeAll();
		this.revalidate();
		super.paintComponent(g);
		ArrayList<Node> NodeArray = new ArrayList<Node>();
		
		Tree t = mainTree;

		if (t.getRoot() == null)
			return;
		
		t.makeArray(NodeArray,t.getRoot());
		double maxX=0,maxY =0;
		double minX=0,minY=0;
		double sumX=0,sumY=0;
		Iterator iterator = NodeArray.iterator();
		while(iterator.hasNext()) {
			Node now = (Node)iterator.next();
			if(maxX < now.getX())
				maxX = now.getX();
			if(minX > now.getX())
				minX = now.getX();
			if(maxY < now.getY())
				maxY = now.getY();
			if(minY > now.getY())
				minY = now.getY();
		}
		sumX = (maxX-minX)*2 + 100;
		sumY = (maxY-minY)*2 + 100;
		this.setPreferredSize(new Dimension((int)sumX, (int)sumY));


		
        Iterator<Node> it = NodeArray.iterator();
        	while(it.hasNext()) {
            Node dataNode = it.next();
    		JLabel showNode =new JLabel(dataNode.getInfo());
//    		System.out.println((String)dataNode.info);
    		
    		showNode.setBackground(dataNode.getColor());
    		showNode.setOpaque(true);
    		showNode.setBorder(new TitledBorder(new LineBorder(Color.black,3)));
    		
    		showNode.setSize(dataNode.getWidth(), dataNode.getHeight());
    		showNode.setLocation((int)(dataNode.getX() + this.getSize().getWidth()/2), (int)(dataNode.getY() + this.getSize().getHeight()/2));    		
    		this.add(showNode);
    		showNode.setVisible(true);
    		showNode.addMouseListener(new NodeListener(t, this, dataNode));
    		
    		showNode = null;
         	}
        it = NodeArray.iterator();	
        while(it.hasNext()) {
        	Node n = it.next();
        	if(n != t.getRoot()) {
        		Point parentUp = new Point(n.getParent().getPoint().add(new Point(n.getParent().getWidth()/2,0)));
        		Point parentDown = new Point(n.getParent().getPoint().add(new Point(n.getParent().getWidth()/2,n.getParent().getHeight())));
        		Point parentLeft = new Point(n.getParent().getPoint().add(new Point(0,n.getParent().getHeight()/2)));
        		Point parentRight = new Point(n.getParent().getPoint().add(new Point(n.getParent().getWidth(),n.getParent().getHeight()/2)));
        		Point nodeUp = new Point(n.getPoint().add(new Point(n.getWidth()/2,0)));
        		Point nodeDown = new Point(n.getPoint().add(new Point(n.getWidth()/2,n.getHeight())));
        		Point nodeLeft = new Point(n.getPoint().add(new Point(0,n.getHeight()/2)));
        		Point nodeRight = new Point(n.getPoint().add(new Point(n.getWidth(),n.getHeight()/2)));
        		Point[] arrp = new Point[2];
        		switch(n.compare(n.getParent())) {
        		case 1:
        			arrp = Point.showMeTheShortest(nodeUp, nodeRight, parentLeft, parentDown);
        			if((arrp[0] == nodeRight && arrp[1] == parentLeft) || (arrp [0] == nodeUp && arrp[1] == parentDown))
        				g.drawLine((int)(arrp[0].getX()+this.getSize().getWidth()/2), (int)(arrp[0].getY()+this.getSize().getHeight()/2), (int)(arrp[1].getX()+this.getSize().getWidth()/2), (int)(arrp[1].getY()+this.getSize().getHeight()/2));
        			else if(arrp[0] == nodeRight && arrp[1] == parentDown)
        				g.drawArc((int)(2 * arrp[0].getX() - arrp[1].getX()+this.getSize().getWidth()/2), (int)(2 * arrp[1].getY() - arrp[0].getY()+this.getSize().getHeight()/2), (int)(2*(Math.abs(arrp[1].getX()-arrp[0].getX()))), (int)(2*(Math.abs(arrp[1].getY()-arrp[0].getY()))),270,90);
        			else
        				g.drawArc((int)(arrp[0].getX()+this.getSize().getWidth()/2), (int)(arrp[1].getY()+this.getSize().getHeight()/2), (int)(2*(Math.abs(arrp[1].getX()-arrp[0].getX()))), (int)(2*(Math.abs(arrp[1].getY()-arrp[0].getY()))),90,90);
        			break;
        		case 2:
        			arrp = Point.showMeTheShortest(nodeUp, nodeLeft, parentRight, parentDown);
        			if((arrp[0] == nodeLeft && arrp[1] == parentRight) || (arrp [0] == nodeUp && arrp[1] == parentDown))
        				g.drawLine((int)(arrp[0].getX()+this.getSize().getWidth()/2), (int)(arrp[0].getY()+this.getSize().getHeight()/2), (int)(arrp[1].getX()+this.getSize().getWidth()/2), (int)(arrp[1].getY()+this.getSize().getHeight()/2));
        			else if(arrp[0] == nodeUp && arrp[1] == parentRight)
        				g.drawArc((int)(2*arrp[1].getX()-arrp[0].getX()+this.getSize().getWidth()/2), (int)(arrp[1].getY()+this.getSize().getHeight()/2), (int)(2*(Math.abs(arrp[1].getX()-arrp[0].getX()))), (int)(2*(Math.abs(arrp[1].getY()-arrp[0].getY()))),0,90);
        			else
        				g.drawArc((int)(arrp[1].getX()+this.getSize().getWidth()/2), (int)(2 * arrp[1].getY() - arrp[0].getY()+this.getSize().getHeight()/2), (int)(2*(Math.abs(arrp[1].getX()-arrp[0].getX()))), (int)(2*(Math.abs(arrp[1].getY()-arrp[0].getY()))),180,90);
        			break;
        		case 3:
        			arrp = Point.showMeTheShortest(nodeLeft, nodeDown, parentUp, parentRight);
        			if((arrp[0] == nodeLeft && arrp[1] == parentRight) || (arrp [0] == nodeDown && arrp[1] == parentUp))
        				g.drawLine((int)(arrp[0].getX()+this.getSize().getWidth()/2), (int)(arrp[0].getY()+this.getSize().getHeight()/2), (int)(arrp[1].getX()+this.getSize().getWidth()/2), (int)(arrp[1].getY()+this.getSize().getHeight()/2));
        			else if(arrp[0] == nodeLeft && arrp[1] == parentUp)
        				g.drawArc((int)(arrp[1].getX()+this.getSize().getWidth()/2), (int)(arrp[0].getY()+this.getSize().getHeight()/2), (int)(2*(Math.abs(arrp[1].getX()-arrp[0].getX()))), (int)(2*(Math.abs(arrp[1].getY()-arrp[0].getY()))),90,90);
        			else
        				g.drawArc((int)(2 * arrp[1].getX() - arrp[0].getX()+this.getSize().getWidth()/2), (int)(2 * arrp[0].getY() - arrp[1].getY()+this.getSize().getHeight()/2), (int)(2*(Math.abs(arrp[1].getX()-arrp[0].getX()))), (int)(2*(Math.abs(arrp[1].getY()-arrp[0].getY()))),270,90);
        			break;
        		case 4:
        			arrp = Point.showMeTheShortest(nodeDown, nodeRight, parentLeft, parentUp);
        			if((arrp[0] == nodeRight && arrp[1] == parentLeft) || (arrp [0] == nodeDown && arrp[1] == parentUp))
        				g.drawLine((int)(arrp[0].getX()+this.getSize().getWidth()/2), (int)(arrp[0].getY()+this.getSize().getHeight()/2), (int)(arrp[1].getX()+this.getSize().getWidth()/2), (int)(arrp[1].getY()+this.getSize().getHeight()/2));
        			else if(arrp[0] == nodeRight && arrp[1] == parentUp)
        				g.drawArc((int)(2*arrp[0].getX()-arrp[1].getX()+this.getSize().getWidth()/2), (int)(arrp[0].getY()+this.getSize().getHeight()/2), (int)(2*(Math.abs(arrp[1].getX()-arrp[0].getX()))), (int)(2*(Math.abs(arrp[1].getY()-arrp[0].getY()))),0,90);
        			else
        				g.drawArc((int)(arrp[0].getX()+this.getSize().getWidth()/2), (int)(2 * arrp[0].getY() - arrp[1].getY()+this.getSize().getHeight()/2), (int)(2*(Math.abs(arrp[1].getX()-arrp[0].getX()))), (int)(2*(Math.abs(arrp[1].getY()-arrp[0].getY()))),180,90);
        			break;
        	default:
        		}
//        		g.drawLine((int)(arrp[0].getX()+this.getSize().getWidth()/2), (int)(arrp[0].getY()+this.getSize().getHeight()/2), (int)(arrp[1].getX()+this.getSize().getWidth()/2), (int)(arrp[1].getY()+this.getSize().getHeight()/2));
        	}
        	if(n.getFocus() == true) {
        		g.fillOval((int)n.getX()+this.getWidth()/2-3, (int)n.getY()+this.getHeight()/2-3, 10, 10);
        		g.fillOval((int)n.getX()+n.getWidth()+this.getWidth()/2-7, (int)n.getY()+this.getHeight()/2-3, 10, 10);
        		g.fillOval((int)n.getX()+this.getWidth()/2-3, (int)n.getY()+n.getHeight()+this.getHeight()/2-7, 10, 10);
        		g.fillOval((int)n.getX()+n.getWidth()+this.getWidth()/2-7, (int)n.getY()+n.getHeight()+this.getHeight()/2-7, 10, 10);
        	}
        	
        }
        NodeArray = null;
		}
}