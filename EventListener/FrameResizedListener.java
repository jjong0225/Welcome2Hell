 package EventListener;

import javax.swing.JFrame;
import java.awt.event.*;
import javax.swing.*;
import GUI.MindmapArea;

public class FrameResizedListener implements ComponentListener  {
	JPanel mindmapArea;
	public FrameResizedListener(JPanel mindmapArea) {
		this.mindmapArea = mindmapArea;
	}
	
  public void componentHidden(ComponentEvent ce) {};
  public void componentShown(ComponentEvent ce) {};
  public void componentMoved(ComponentEvent ce) { };
 
  public void componentResized(ComponentEvent ce) {
	  mindmapArea.removeAll();	  
	  mindmapArea.revalidate();
	  mindmapArea.repaint();
		System.out.println("repainted");
  };
}