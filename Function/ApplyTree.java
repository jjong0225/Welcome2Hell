package Function;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Data.Tree;

public class ApplyTree {
	
	public static Tree makeTree(String[] strArr, int[] tabCounter, Tree t) {
	int comp;
    t.addRoot(strArr[0]);
    for(int i = 1; i < strArr.length ; i++) {
    	comp = tabCounter[i] - tabCounter[i-1];
       if(comp < 0) {
    	   for(int j = 0 ; j < -comp+1 ; j++)
        	  t.now = t.now.parent;
          t.addNewNodeVasithChildOfNodeU(strArr[i]);
       }
       else if(comp == 0){
    	   t.now = t.now.parent;
    	   t.addNewNodeVasithChildOfNodeU(strArr[i]);
       	}
       	else {
    	   t.addNewNodeVasithChildOfNodeU(strArr[i]);
       		}    
    	}
    	t.show();
    	t.setRealXY();
    	return t;
 	}
}
