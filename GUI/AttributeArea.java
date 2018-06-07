package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import EventListener.AttributeListener;

public class AttributeArea{
	public JPanel attributePane;
	public MindmapArea mindmapArea;
	public JTextField infoField = new JTextField();
	public JTextField xField = new JTextField();
	public JTextField yField = new JTextField();
	public JTextField wField = new JTextField();
	public JTextField hField = new JTextField();
	public JTextField colorField = new JTextField();
	JButton changeButton;
	

	public AttributeArea() {
		attributePane = new JPanel();
		
		JLabel nameText2 = new JLabel ("Attribute Pane");
		changeButton = new JButton("Ŕűżë");
		changeButton.addActionListener(new AttributeListener(this, null));
		JPanel attributeArea = new JPanel();

		attributeArea.setLayout(new GridLayout(6,2));

		attributeArea.add(new JLabel("TEXT"));
		attributeArea.add(new JTextField());

		attributeArea.add(new JLabel("X"));
		attributeArea.add(new JTextField());

		attributeArea.add(new JLabel("Y"));
		attributeArea.add(new JTextField());

		attributeArea.add(new JLabel("W"));
		attributeArea.add(new JTextField());

		attributeArea.add(new JLabel("H"));
		attributeArea.add(new JTextField());

		attributeArea.add(new JLabel("Color"));
		attributeArea.add(new JTextField());



		attributePane.setLayout(new BorderLayout());
		attributePane.add(nameText2, BorderLayout.NORTH);
		attributePane.add(attributeArea, BorderLayout.CENTER);
		attributePane.add(changeButton, BorderLayout.SOUTH);
	}

	public void setMindemapArea(MindmapArea mindmapArea) {
		this.mindmapArea = mindmapArea;
		changeButton.addActionListener(new AttributeListener(this, mindmapArea));
	}

}
