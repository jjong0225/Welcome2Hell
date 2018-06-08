package EventListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import GUI.MindmapArea;

public class scrollEvent implements ChangeListener{
	MindmapArea mindmapArea;
	public scrollEvent(MindmapArea mindmapArea) {
		this.mindmapArea = mindmapArea;
	}

	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		mindmapArea.removeAll();
		mindmapArea.revalidate();
		mindmapArea.repaint();
	}
}
