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
	boolean drag = true;
	AttributeArea attributeArea;
	
	public NodeListener(Tree t, JPanel mindmapArea, Node dataNode, AttributeArea attributeArea) {
		this.t = t;
		this.mindmapArea = mindmapArea;
		this.dataNode = dataNode;
		this.attributeArea = attributeArea;
	}

	public void mousePressed(MouseEvent e) {
		drag = true;
		event = new Point(e.getX(),e.getY());
		if(dataNode.getFocus() == false) {
			dataNode.setColor(new Color(255-dataNode.getColor().getRed(),255-dataNode.getColor().getGreen(),255-dataNode.getColor().getBlue(),100));
			ArrayList<Node> arr = new ArrayList<>();
			t.makeArray(arr, t.getRoot());
			Iterator<Node> it = arr.iterator();
			Node n;
			while(it.hasNext()) {
				n = (Node)it.next();
				if(n != dataNode)
					if(n.getFocus() == true) {
						n.setFocus(false);
						n.setColor(new Color(255-n.getColor().getRed(),255-n.getColor().getGreen(),255-n.getColor().getBlue(),100));
						break;
					}
			}
			dataNode.setFocus(true);
		}
		
		mindmapArea.repaint();		attributeArea.xField.setText(dataNode.getInfo());
		attributeArea.xField.setText(Double.toString(dataNode.getX()));
		attributeArea.yField.setText(Double.toString(dataNode.getY()));
		attributeArea.wField.setText(Integer.toString(dataNode.getWidth()));
		attributeArea.hField.setText(Integer.toString(dataNode.getHeight()));
		attributeArea.colorField.setText(Integer.toHexString(((dataNode.getColor().getRGB() - dataNode.getColor().getAlpha())/0x100)));
		// node 정보 출력
	}
	public void mouseReleased(MouseEvent e) {
		drag = false;
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
				if(p2.getY() < dataNode.getHeight()) {
				dataNode.setY(dataNode.getY() + p2.getY() - event.getY());
				dataNode.setHeight((int) (dataNode.getHeight() + event.getY() - p2.getY()));
				}
			}
			if(flag%3==0) {
				if(p2.getY() > 0)
					dataNode.setHeight((int) (dataNode.getHeight() + p2.getY() - event.getY()));
			}
			if(flag%5==0) {
				if(p2.getX() < dataNode.getWidth()) {
					dataNode.setX(dataNode.getX() + p2.getX() - event.getX());
					dataNode.setWidth((int) (dataNode.getWidth() + event.getX() - p2.getX()));
				}
			}
			if(flag%7==0) {
				if(p2.getX() > 0)
					dataNode.setWidth((int) (dataNode.getWidth() + p2.getX() - event.getX()));
			}
			if(flag == 1) {
				dataNode.setPoint(dataNode.getX() + p2.getX() - event.getX(), dataNode.getY() + p2.getY() - event.getY());
//				dataNode.setPoint(dataNode.getX() - event.getX(), dataNode.getY() - event.getY());
			}
				
			mindmapArea.removeAll();
			mindmapArea.revalidate();
			mindmapArea.repaint();
	
		
		}
	public void mouseClicked(MouseEvent e) {
		if(dataNode.getFocus() == true) {
		dataNode.setColor(new Color(255-dataNode.getColor().getRed(), 255-dataNode.getColor().getGreen(), 255-dataNode.getColor().getBlue(), 100));
		dataNode.setFocus(false);
		}
		mindmapArea.removeAll();
		mindmapArea.revalidate();
		mindmapArea.repaint();
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}	

}
