package Data;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class Tree {
    public Node root;
    public Node now;
   

    public Tree(){
    }

    public void addRoot(Object info)
    {
        root=new Node(info);
        now = root;
        root.parent=null;
        root.children=new ArrayList<Node>();
    }

    public void addNewNodeVasithChildOfNodeU(Object info)
    {
       Node child = new Node(info);
        now.addChild(child);
        now = child;
    }

    // I've made the above two methods of type void, not Node, because
    // I see no reason in returning anything; however, you can override by calling
    //'return root;' or 'return child;'

    public int numberOfNodesInTree(Node rootNode){
        int count=0;

        count++;
        if(rootNode.children.size()!=0) {
            for(Node ch : rootNode.children)
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
        newRoot.parent=null;
        newRoot.addChild(oldRoot);
        oldRoot.parent=newRoot;
        this.root=newRoot;
    }
    
//    public void show() {
//        Iterator<Node> it;
//        Node me;
////        Iterator<Node> tmp;
//        now = root;
//        it = root.children.iterator();
//        int i = 0;
////        while(it.hasNext()) {
////           double t = 2*Math.PI/root.children.size();
////           me = it.next();
////           me.x = (int)(Math.cos(t*i)*100);
////           me.y = (int)(Math.sin(t*i)*100);
////           i++;
////           System.out.println((String)me.info+"("+me.x+", "+me.y+")");
////        }
//        while(it.hasNext()) {
//            double theta = 2*Math.PI/root.children.size();
//            me = it.next();
//            me.x = 100;
//            me.y = (int)(theta*i);
//            i++;
//            System.out.println((String)me.info+"("+me.x+", "+me.y+")");
//         }
//        System.out.println(root.info);
//        ArrayList<Node> c;
//        c = now.children;
//        it = c.iterator();
//        go2c(c,1);
//     }
//     
//     public void go2c(ArrayList<Node> ca, int i) {
//         Iterator<Node> it = ca.iterator();
//         int n;
//         double t;
//         double d;
//         int j=1;
//        if (!it.hasNext())
//           return;
//        while(it.hasNext()) {
//           Node me = it.next();
//           for(int m=0; m<i ; m++) {
//              System.out.print("   ");
//           }
////           n = me.parent.children.size();
////           t = -Math.PI/2+Math.atan(me.parent.y/me.parent.x);
////           if(me.parent.x < 0)
////              me.x += me.parent.x-(int)(Math.cos(t+(Math.PI/(n+1))*j)*10);
////           else
////              me.x += me.parent.x+(int)(Math.cos(t+(Math.PI/(n+1))*j)*10);
////           me.y += me.parent.y+(int)(Math.sin(t+(Math.PI/(n+1))*j)*10);
//           
//            //현재 최선의 해결책
//           n = me.parent.children.size();
//           d = Math.hypot(me.parent.x, me.parent.y);
//           t = (-2.0/3.0)*Math.PI+Math.atan2( me.parent.y, me.parent.x);
//           if(!(me.parent.x == 0 && me.parent.y == 0)) {
//              me.x=(me.x +me.parent.x +(int)(Math.cos(t+(4.0/3.0*Math.PI/(double)(n+1))*j)*120));
//              me.y=(me.y + me.parent.y+(int)(Math.sin(t+(4.0/3.0*Math.PI/(double)(n+1))*j)*120));
//              if(me.parent.children.get(0) == me) {
//            	  int temp = me.x;
//            	  me.x = (int)(temp*Math.cos(Math.PI/36)-me.y*Math.sin(Math.PI/36));
//            	  me.y = (int)(temp*Math.sin(Math.PI/36)+me.y*Math.cos(Math.PI/36));
//              }
//              if(me.parent.children.get(n-1) == me) {
//            	  int temp = me.x;
//            	  me.x = (int)(temp*Math.cos(-Math.PI/36)-me.y*Math.sin(-Math.PI/36));
//            	  me.y = (int)(temp*Math.sin(-Math.PI/36)+me.y*Math.cos(-Math.PI/36));
//              }
//            	 
//           
//           
//           }
//            j++;
//           System.out.println((String)me.info+"("+me.x+", "+me.y+")");
//           go2c(me.children, i+1);
//        }
//     }
    
    public void show() {
        Iterator<Node> it;
        Node me;
        now = root;
        it = root.children.iterator();
        int i = 0;
        while(it.hasNext()) {
            double theta = 2*Math.PI/root.children.size();
            me = it.next();
            me.x=100;
            me.y=theta*i;
            i++;
            System.out.println((String)me.info+"("+me.x+", "+me.y+")");
         }
        System.out.println(root.info);
        ArrayList<Node> c;
        c = now.children;
        it = c.iterator();
        go2c(c,1);
     }
     
     public void go2c(ArrayList<Node> ca, int i) {
         Iterator<Node> it = ca.iterator();
        if (!it.hasNext())
           return;
        while(it.hasNext()) {
           Node me = it.next();
           for(int m=0; m<i ; m++) {
              System.out.print("   ");
           }
           
           me.color = new Color((50*i)%256,(100*i)%256,(150*i)%256,100);
           List<Integer> list = new ArrayList<Integer>();
           Node node;
           node = me;
           while(true) {
        	   list.add(me.parent.children.size());
        	   me = me.parent;
        	   if(me.parent == null)
        		   break;
           }
           me = node;
           double angle=2*Math.PI;
           Iterator<Integer> ti = list.iterator();
           while(ti.hasNext()) {
        	   angle /= (ti.next()+1);
           }
           angle = angle * (root.children.size()+1)/root.children.size();
           
           if(me.parent != root) {
        	   me.x= i * 110;
        	   me.y=(me.y+(me.parent.y - angle*(me.parent.children.size()+1)/2)+angle*(me.parent.children.indexOf(me)+1));
           }

           System.out.println(i+(String)me.info+"("+me.x+", "+me.y+")");
           go2c(me.children, i+1);
        }
     }
     public void setRealXY() {
    	 ArrayList<Node> list = new ArrayList<>();
    	 makeArray(list,root);
    	 Iterator<Node> it = list.iterator();
    	 Node n;
    	 while(it.hasNext()) {
    		 n = it.next();
    		double temp = n.x;
    		 n.x=((int)(temp * Math.cos(n.y)));
    		 n.y=(temp * Math.sin(n.y));
    	 }
     }
     
     public ArrayList<Node> makeArray(ArrayList<Node> exArray,Node now) {
    	 if(now == root)
    		 exArray.add(root);
    	 
    	        Iterator<Node> it = now.children.iterator();

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
       
       return "("+now.x+","+now.y+"),"+now.w+","+now.h+","+now.color+","+now.info;
    }
   
}