package EventListener;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import GUI.MindmapArea;

public class PanelResizedListener implements ComponentListener{
	MindmapArea mindmapPane;
	public PanelResizedListener(MindmapArea mindmapPane) {
		this.mindmapPane = mindmapPane;
	}
	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		mindmapPane.removeAll();
		mindmapPane.revalidate();
//		mindmapPane.repaint();		
	}

	@Override
	public void componentResized(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		mindmapPane.removeAll();
		mindmapPane.revalidate();
		mindmapPane.repaint();
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
