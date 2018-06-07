package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextArea {
	public JTextArea textarea;
	JPanel textPane;
	JFrame mainFrame;
	JButton applyButton;
	
	public TextArea(JFrame mainFrame) {

		this.mainFrame = mainFrame;

		textPane = new JPanel();
		textarea = new JTextArea();
		JScrollPane textEditor = new JScrollPane(textarea);

		JLabel nameText1 = new JLabel ("Text Editor Pane");

		applyButton = new JButton("Àû¿ë");		
		textPane.setLayout(new BorderLayout());
		//nameText1.setSize(comSize);
		//applyButton.setSize(comSize);

		textPane.add(nameText1, BorderLayout.NORTH);
		textPane.add(textEditor, BorderLayout.CENTER);
		textPane.add(applyButton, BorderLayout.SOUTH);


	}
	
}
