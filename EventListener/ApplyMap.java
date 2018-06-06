package EventListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import Data.Tree;
import GUI.MindmapArea;


public class ApplyMap implements ActionListener {
	JPanel mindmapPane;
	Tree mainTree;
	MindmapArea mindmapArea;
	
	public ApplyMap (JPanel mindmapPane, Tree mainTree, MindmapArea mindmapArea) {
		this.mindmapPane = mindmapPane;
		this.mainTree = mainTree;
		this.mindmapArea = mindmapArea;
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println(mindmapPane);
		mindmapPane.removeAll();
//		mindmapPane.repaint();
		mindmapPane.revalidate();
		mindmapPane.repaint();
		mindmapArea.scroll.getHorizontalScrollBar().setValue((int)mainTree.getRoot().getX());
		mindmapArea.scroll.getVerticalScrollBar().setValue((int)mainTree.getRoot().getY());
		System.out.println(mindmapPane);
		System.out.println("repainted");
		Function.JsonHandler.saveData(mainTree);
	}
}