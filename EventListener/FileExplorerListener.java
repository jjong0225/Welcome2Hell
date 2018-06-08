package EventListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Data.Tree;
import Function.FileExplorer;
import GUI.FrameGUI;

public class FileExplorerListener implements ActionListener{
	Tree mainTree;
	int op;
	public static String address = null;
	
	public FileExplorerListener(Tree mainTree, int op) {
		this.mainTree = mainTree;
		this.op = op;
	}
	
	public void starter() {
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (op == 1) {
			//make new
			mainTree.setRoot(null);
			address = null;
			FrameGUI.mindmapArea.removeAll();
			FrameGUI.mindmapArea.revalidate();
			FrameGUI.mindmapArea.repaint();
		}
		else if (op == 2) {
			// load
			address = FileExplorer.Loading(mainTree);
			GUI.FrameGUI.mindmapArea.repaint();
		}
		else if (op == 3) {
			// save
			FileExplorer.saving(mainTree, address);
		}
		else if (op == 4) {
			// save data to another file
			address = FileExplorer.saving(mainTree, null);
		}
		else if (op == 5) {
			// close
			System.exit(0);
		}
		else if (op == 6) {
			// apply text to mindmap
			
		}
		else if (op == 7) {
			// change attribute to mindmap
		}
	}
	
	

}
