package Data;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class Tree {
    private Node root;
    private Node now;
   

    public Tree(){
    }
    public Node getRoot() {
    	return root;
    }
    public Node getNow() {
    	return now;
    }
    public void setRoot(Node root) {
    	this.root = root;
    }
    public void setNow(Node now) {
    	this.now = now;
    }
    public void addRoot(String info)
    {
        root=new Node(info);
        now = root;
        root.setParent(null);
        root.setChildren(new ArrayList<Node>());
    }

    public void addNewNodeVasithChildOfNodeU(String info)
    {
       Node child = new Node(info);
        now.addChild(child);
        now = child;
    }

    public int numberOfNodesInTree(Node rootNode){
        int count=0;

        count++;
        if(rootNode.getChildren().size()!=0) {
            for(Node ch : rootNode.getChildren())
                count=count+numberOfNodesInTree(ch);
        }

        return count;
    }

    public int numberOfNodesInTree()
    {
        return numberOfNodesInTree(this.root);
    }

    public void changeRoot(Node newRoot, int i)
    {
        Node oldRoot=this.root;
        newRoot.setParent(null);
        newRoot.addChild(oldRoot);
        oldRoot.setParent(newRoot);
        this.root=newRoot;
    }
    
    
    public void show() {
        Iterator<Node> it;
        Node me;
        now = root;
        it = root.getChildren().iterator();
        int i = 0;
        while(it.hasNext()) {
            double theta = 2*Math.PI/root.getChildren().size();
            me = it.next();
            me.setPoint(100, theta*i);
            i++;
            System.out.println((String)me.getInfo()+"("+me.getX()+", "+me.getY()+")");
         }
        System.out.println(root.getInfo());
        ArrayList<Node> c;
        c = now.getChildren();
        it = c.iterator();
        go2c(c,1);
     }
     
     public void go2c(ArrayList<Node> ca, int i) 
     {
    	 if(ca == null)
    		 return;

         Iterator<Node> it = ca.iterator();
        if (!it.hasNext())
           return;
        while(it.hasNext()) {
           Node me = it.next();
           for(int m=0; m<i ; m++) {
              System.out.print("   ");
           }
           
           me.setColor(new Color((50*i)%256, (100*i)%256,(150*i)%256,50)); // when level 1 => 326496
           List<Integer> list = new ArrayList<Integer>();
           Node node;
           node = me;
           while(true) {
        	   list.add(me.getParent().getChildren().size());
        	   me = me.getParent();
        	   if(me.getParent() == null)
        		   break;
           }
           me = node;
           double angle=2*Math.PI;
           Iterator<Integer> ti = list.iterator();
           while(ti.hasNext()) {
        	   angle /= (ti.next()+1);
           }
           angle = angle * (root.getChildren().size()+1)/root.getChildren().size();
           
           if(me.getParent() != root) {
        	   me.setPoint(i * 110, me.getY()+(me.getParent().getY() - angle*(me.getParent().getChildren().size()+1)/2)+angle*(me.getParent().getChildren().indexOf(me)+1));
           }

           System.out.println(i+(String)me.getInfo()+"("+me.getX()+", "+me.getY()+")");
           go2c(me.getChildren(), i+1);
        }
     }
     public void setRealXY() {
    	 ArrayList<Node> list = new ArrayList<>();
    	 makeArray(list,root);
    	 Iterator<Node> it = list.iterator();
    	 Node n;
    	 while(it.hasNext()) {
    		 n = it.next();
    		 n.setPoint(n.getX() * Math.cos(n.getY()), n.getX() * Math.sin(n.getY()));
    	 }
     }
     
     public ArrayList<Node> makeArray(ArrayList<Node> exArray,Node now) {
    	 if(now == root)
    		 exArray.add(root);
    	 
         if(now.getChildren() == null)
    		 return null;

    	        Iterator<Node> it = now.getChildren().iterator();

    	        if (!it.hasNext())
    	          return exArray;

    	        while(it.hasNext()) {
    	            Node node = it.next();
    	            exArray.add(node);
    	    			makeArray(exArray, node);
    	        	}
    	        return exArray;
    		}

    
    public String toString() {
       
       return "("+now.getX()+","+now.getY()+"),"+now.getWidth()+","+now.getHeight()+","+now.getColor()+","+now.getInfo();
    }
   
}
