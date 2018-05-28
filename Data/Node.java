package Data;

import java.util.ArrayList;

public class Node {

    public Node parent; // The parent of the current node
    public ArrayList<Node> children; // The children of the current node
    public Object info;
    public double x;
    public double y;
    public int h;
    public int w;
    String color;

    public Node (Object info)
    {
        this.info=info;
        x=0;
        y=0;
        h=0;
        w=0;
        color=null;
        children  = new ArrayList<Node>();
    }
    
    public void addChild(Node node) {
       node.parent = this;
       this.children.add(node);
     }
    
}