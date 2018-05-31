package EventListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import Data.Tree;


public class ApplyMap implements ActionListener {
	JPanel mindmapPane;
	Tree mainTree;
	
	public ApplyMap (JPanel mindmapPane, Tree mainTree) {
		this.mindmapPane = mindmapPane;
		this.mainTree = mainTree;
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println(mindmapPane);
		mindmapPane.removeAll();
//		mindmapPane.repaint();
		mindmapPane.revalidate();
		mindmapPane.repaint();
		System.out.println(mindmapPane);
		System.out.println("repainted");
	}
}