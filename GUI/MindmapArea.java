package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Data.Node;
import Data.Tree;

public class MindmapArea {
	JPanel mindmapPane;
	Tree mainTree;
	public MindmapArea(Tree mainTree) { 
		this.mainTree = mainTree;
	 mindmapPane = new JPanel();
	 DrawingPane drawing = new DrawingPane(mainTree, mindmapPane);
	 mindmapPane.add(drawing);
	 mindmapPane.setBackground(Color.GRAY);
	}
}

class DrawingPane extends JPanel {
	Tree t;
	JPanel mindmapPane;
	public DrawingPane (Tree t, JPanel mindmapPane){
		this.t = t;
		this.mindmapPane = mindmapPane;
	}
	public void paintComponent(Graphics g) {
		ArrayList<Node> NodeArray = new ArrayList<Node>();
		if (t.root == null)
			return;
		
		t.makeArray(NodeArray,t.root);
		
        Iterator<Node> it = NodeArray.iterator();
        while(it.hasNext()) {
//        	g.setColor(Color.BLUE); 
//            Node now = it.next();
//            g.drawString((String)now.info,(int)(now.x*100 + (mindmapPane.getWidth()/2)), (int)(now.y*100 + (mindmapPane.getHeight()/2)));
//            g.drawRect((int)(now.x*100 + (mindmapPane.getWidth()/2)), (int)(now.y*100 + (mindmapPane.getHeight()/2)),50, 50);
//            System.out.println("complete");
            Node dataNode = it.next();
    		JLabel showNode =new JLabel((String)(dataNode.info));
    		showNode.setBackground(Color.black);
    		showNode.setVisible(true);
    		mindmapPane.add(showNode);
    		showNode.setLocation((int)(dataNode.x*10 + mindmapPane.getSize().getWidth()/2), (int)(dataNode.y*10+ mindmapPane.getSize().getHeight()/2));
    		g.drawRect((int)(dataNode.x*10 + (300)), (int)(dataNode.y*10 + (200)), 20, 20);
    		

    		showNode.setSize(50, 40);
         	}
		}
	}





