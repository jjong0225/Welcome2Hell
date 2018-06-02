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
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import Data.Node;
import Data.Tree;
import EventListener.NodeListener;

public class MindmapArea extends JPanel {
	Tree mainTree;
	JFrame mainFrame;
	
	public MindmapArea(Tree mainTree, JFrame mainFrame) { 
	this.mainTree = mainTree;
	this.mainFrame = mainFrame;
	
//	 mindmapPane.setLayout(null);
//	 DrawingPane drawing = new DrawingPane(mainTree, mindmapPane, mainFrame);
//	 drawing.setSize(600, 500);
//	 drawing.setLocation(0, 0);

//	 mindmapPane.add(drawing);
//	 mindmapPane = drawing;
//	 mindmapPane.setLayout(null);
//	 mindmapPane.setBackground(Color.GRAY);
	}
	
//	public void setMindmapPane(JPanel mindmapPane) {
//		this.mindmapPane = mindmapPane;
//	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
//		mindmapPane.removeAll();
		ArrayList<Node> NodeArray = new ArrayList<Node>();
		
		Tree t = mainTree;

		if (t.getRoot() == null)
			return;
		
		t.makeArray(NodeArray,t.getRoot());
		
        Iterator<Node> it = NodeArray.iterator();
        while(it.hasNext()) {
            Node dataNode = it.next();
    		JLabel showNode =new JLabel((String)(dataNode.getInfo()));
//    		System.out.println((String)dataNode.info);
    		
    		showNode.setBackground(dataNode.getColor());
    		showNode.setOpaque(true);
    		showNode.setBorder(new TitledBorder(new LineBorder(Color.black,3)));
    		
    		showNode.setSize(dataNode.getWidth(), dataNode.getHeight());
    		showNode.setLocation((int)(dataNode.getX() + this.getSize().getWidth()/2), (int)(dataNode.getY() + this.getSize().getHeight()/2));    		
    		this.add(showNode);
    		showNode.setVisible(true);
    		showNode.addMouseListener(new NodeListener(t,this, dataNode));
    		showNode = null;
         	}
//        it = NodeArray.iterator();
//        while(it.hasNext()) {
//        	Node dataNode = it.next();
//        	int parentUp ;
//        	int parentRight;
//        	int parentLeft;
//        	int parentDown;
//        	int nodeUp;
//        	int nodeDown;
//        	int nodeLeft;
//        	int nodeRight;
//        }
        NodeArray = null;
		}
}