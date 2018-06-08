package EventListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Data.Tree;
import Function.FileExplorer;

public class FileExplorerListener implements ActionListener{
	Tree mainTree;
	int op;
	
	public FileExplorerListener(Tree mainTree, int op) {
		this.mainTree = mainTree;
		this.op = op;
	}
	
	public void starter() {
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (op == 1) {
			// load
			FileExplorer.Loading(mainTree);
			GUI.FrameGUI.mindmapArea.repaint();
		}
		else if (op == 2) {
			// save
			FileExplorer.Loading(mainTree);
		}
		
	}
	
	

}
