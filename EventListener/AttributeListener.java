package EventListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Data.Node;
import Data.Tree;
import GUI.AttributeArea;
import GUI.MindmapArea;
import GUI.TextArea;

public class AttributeListener implements ActionListener {
	AttributeArea attributeArea;
	MindmapArea mindmapArea;
	static Node me = null;
	
	public AttributeListener(AttributeArea attributeArea, MindmapArea mindmapArea) {
		this.attributeArea = attributeArea;
		this.mindmapArea = mindmapArea;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(mindmapArea == null)
			return;
		// TODO Auto-generated method stub
		if(me == null)
			return;
		String info = attributeArea.infoField.getText();
		double x = Double.parseDouble(attributeArea.xField.getText());
		double y = Double.parseDouble(attributeArea.yField.getText());
		int w = Integer.parseInt(attributeArea.wField.getText());
		int h = Integer.parseInt(attributeArea.hField.getText());
		String color = attributeArea.colorField.getText();
		me.setX(x);
		me.setY(y);
		me.setWidth(w);
		me.setHeight(h);
		me.setColorFromStr(color);
		mindmapArea.removeAll();
		mindmapArea.revalidate();		
		mindmapArea.repaint();
	}
}
