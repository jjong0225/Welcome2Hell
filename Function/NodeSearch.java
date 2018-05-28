package Function;

import java.util.ArrayList;
import java.util.Iterator;
import Data.Node;
import Data.Tree;

public class NodeSearch {
	
    public static Node findNode(Tree t, Node me, Object info) {
    	String name = (String)info;
    	Node root = t.root;
    	
    	if(name.equals((String)root.info))
    		return root;
    	
        Iterator<Node> it = me.children.iterator();

        if (!it.hasNext())
          return null;

        while(it.hasNext()) {
          Node now = it.next();
          if(name.equals((String)now.info))
        	  return now;
          Node roopNode = findNode(t, now, info);
          if (roopNode != null)
        	  return roopNode;
       }
        
        return null;        
    }
}
