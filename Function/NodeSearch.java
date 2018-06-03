package Function;

import java.util.ArrayList;
import java.util.Iterator;
import Data.Node;
import Data.Tree;

public class NodeSearch {
	
    public static Node findNode(Tree t, Node me, String info) {
    	String name = info;
    	Node root = t.getRoot();
    	
    	if(name.equals(root.getInfo()))
    		return root;
    	
        Iterator<Node> it = me.getChildren().iterator();

        if (!it.hasNext())
          return null;

        while(it.hasNext()) {
          Node now = it.next();
          if(name.equals(now.getInfo()))
        	  return now;
          Node roopNode = findNode(t, now, info);
          if (roopNode != null)
        	  return roopNode;
       }
        
        return null;        
    }
}
