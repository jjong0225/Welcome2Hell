package Data;

import java.awt.Color;
import java.util.ArrayList;

public class Node {

    public Node parent; // The parent of the current node
    public ArrayList<Node> children; // The children of the current node
    public Object info;
    public int x;
    public double y;
    public int h;
    public int w;
    public Color color;

    public Node (Object info)
    {
        this.info=info;
        x=0;
        y=0;
        h=40;
        w=60;
        color= new Color(255,255,255,100);
        children  = new ArrayList<Node>();
    }
    
    public void addChild(Node node) {
       node.parent = this;
       this.children.add(node);
     }
    
}