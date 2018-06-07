package Data;

import java.awt.Color;
import java.util.ArrayList;

public class Node {

    private Node parent; // The parent of the current node
    private ArrayList<Node> children; // The children of the current node
    private String info;
    private Point p;
    private int h;
    private int w;
    private boolean focus;
    private Color color;

    public Node (String info)
    {
        this.info=info;
        p = new Point();
        h=40;
        w=60;
        focus = false;
        color= new Color(255,255,255,100);
        children  = new ArrayList<Node>();
    }
    
    public void setAll (Point p, int w, int h, String colorString,ArrayList<Node> children, Node parent){
    	this.p=p;
    	this.w=w;
    	this.h=h;
    	this.p=p;
    	this.children = children;
    	this.parent = parent;
		String tmpColor = colorString;
		Color color = null;

		if (tmpColor != null) {
			int ColorData = Integer.parseInt(tmpColor);
			if (ColorData > 0x1000000 || ColorData<0x000000) {
				System.out.println("잘못된 Color String입니다.");
			}
			else {
				int blue = ColorData % 0x100;
				int green = ((ColorData-blue)%0x10000)/0x100;
				int red = ((ColorData-blue)-green*0x100)/0x10000;

				color = new Color(red, green, blue, 100);
			}	
		}
    	this.color=color;
    }
    
    public Node getParent() {
    	return parent;
    }
    public ArrayList<Node> getChildren(){
    	return children;
    }
    public String getInfo() {
    	return info;
    }
    public Point getPoint() {
    	return p;
    }
    public double getX() {
    	return p.getX();
    }
    public double getY() {
    	return p.getY();
    }
    public int getHeight() {
    	return h;
    }
    public int getWidth() {
    	return w;
    }
    public Color getColor() {
    	return color;
    }
    public boolean getFocus() {
    	return focus;
    }
    public void setParent(Node n) {
    	parent = n;
    }
    public void setChildren(ArrayList<Node> arr) {
    	this.children = arr;
    }
    public void setInfo(String info) {
    	this.info = info;
    }
    public void setPoint(Number x, Number y) {
    	p.setX(x);
    	p.setY(y);
    }
    public void setX(Number x) {
    	p.setX(x);
    }
    public void setY(Number y) {
    	p.setY(y);
    }
    public void setHeight(int h) {
    	this.h = h;
    }
    public void setWidth(int w) {
    	this.w = w;
    }
    public void setColor(Color c) {
    	this.color = c;
    }
    public void setFocus(boolean b) {
    	this.focus = b;
    }
    public int compare(Node n) {
		if(this.getX() > n.getX() && this.getY() > n.getY())
			return 2;
		else if(this.getX() <= n.getX() && this.getY() > n.getY())
			return 1;
		else if(this.getX() > n.getX() && this.getY() <= n.getY())
			return 3;
		else if(this.getX() <= n.getX() && this.getY() <= n.getY())
			return 4;
		else
			return 0;
	}
    public void addChild(Node node) {
       node.parent = this;
       this.children.add(node);
     }
    public void setColorFromStr (String colorString) {
		String tmpColor = colorString;
		Color color = null;

		if (tmpColor != null) {

			int ColorData = Integer.parseInt(tmpColor, 16);

			if (ColorData > 0x1000000 || ColorData<0x000000) {
				System.out.println("잘못된 Color String입니다.");
			}
			else {
				int blue = ColorData % 0x100;
				int green = ((ColorData-blue)%0x10000)/0x100;
				int red = ((ColorData-blue)-green*0x100)/0x10000;

				color = new Color(red, green, blue, 100);

			}

		}
    	this.color=color;
    }
}