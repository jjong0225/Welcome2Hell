package EventListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Function.ApplyTree;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import Data.Tree;


public class ApplyListener implements ActionListener {
	JTextArea textarea;
	Tree mainTree;
	
	public ApplyListener (JTextArea textarea, Tree mainTree) {
		this.textarea = textarea;
		this.mainTree = mainTree;
	}
	
	public void actionPerformed(ActionEvent e) {
        String pack = textarea.getText();	    		
	    String[] strArr = pack.split("\n");
	    int[] tabCounter = new int[strArr.length];
	    for(int i = 0 ; i < tabCounter.length ; i++)
	       tabCounter[i] = 0;
	    for(int i = 0; i<strArr.length; i++)
	       for(int j = 0 ; j<strArr[i].length() ; j++)
	          if(strArr[i].charAt(j) == '\t')
	             tabCounter[i]++;
	    for(int i = 0 ; i<strArr.length ; i++)
	       strArr[i] = strArr[i].replaceAll("\t", "");
	    ApplyTree.makeTree(strArr,tabCounter, mainTree);
	}
}
