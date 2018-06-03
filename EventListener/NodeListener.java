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
import Data.Point;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class NodeListener implements MouseListener{
	Tree t;
	JPanel mindmapArea;
	Node dataNode;
	int flag;
	Point event;
	
	public NodeListener(Tree t, JPanel mindmapArea, Node dataNode) {
		this.t = t;
		this.mindmapArea = mindmapArea;
		this.dataNode = dataNode;
	}
	public void mousePressed(MouseEvent e) {
		event = new Point(e.getX(),e.getY());
		System.out.println(event);
	}
	public void mouseReleased(MouseEvent e) {
			Point p2 = new Point(e.getX(),e.getY());
			int rec = 10;
			flag = 1;
			if(event.getX() <= dataNode.getWidth() && event.getY() <= rec) 
				flag *=2;
			if(event.getX() <= dataNode.getWidth() && dataNode.getHeight() - rec <= event.getY()) 
				flag *=3;
			if(event.getY() <= dataNode.getHeight() && event.getX() <= rec) 
				flag *=5;
			if(event.getY() <= dataNode.getHeight() && dataNode.getWidth() - rec <= event.getX()) 
				flag *=7;
			
			
			if(flag%2==0) {
				dataNode.setY(dataNode.getY() + p2.getY() - event.getY());
				dataNode.setHeight((int) (dataNode.getHeight() + event.getY() - p2.getY()));
			}
			if(flag%3==0) {
				dataNode.setHeight((int) (dataNode.getHeight() + p2.getY() - event.getY()));
			}
			if(flag%5==0) {
				dataNode.setX(dataNode.getX() + p2.getX() - event.getX());
				dataNode.setWidth((int) (dataNode.getWidth() + event.getX() - p2.getX()));
			}
			if(flag%7==0) {
				dataNode.setWidth((int) (dataNode.getWidth() + p2.getX() - event.getX()));
			}
			if(flag == 1) {
				dataNode.setPoint(dataNode.getX() + p2.getX() - event.getX(), dataNode.getY() + p2.getY() - event.getY());
			}
			if(p2.equals(event))
				;
			else {
				mindmapArea.removeAll();
				mindmapArea.revalidate();
				mindmapArea.repaint();
			}
		
		}
	public void mouseClicked(MouseEvent e) {
		System.out.println("¿À¿ìšx!!!!!!!!!!!!!!!!!");
		dataNode.setColor(new Color(255-dataNode.getColor().getRed(),255-dataNode.getColor().getGreen(),255-dataNode.getColor().getBlue(),100));
		mindmapArea.removeAll();
		mindmapArea.revalidate();
		mindmapArea.repaint();
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	

}
