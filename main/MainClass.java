	package main;

import javax.swing.JFrame;
import org.json.simple.parser.JSONParser;
import Data.Tree;

public class MainClass {
	
	public static void main (String[] args) {
		
		JSONParser parser = new JSONParser();
		
		//jsonObject�� ��� jasnoObject�� ����Ű�� ��������
//		Object obj = parser.parse(new FileReader("c:\���\����.json"));
//		JSONObject jsonObject = (JSONObject) obj;
		
	    Tree mainTree = new Tree();	
		JFrame mainFrame = new JFrame();
		GUI.FrameGUI GUI = new GUI.FrameGUI(mainFrame, mainTree);
//		new TreeStructure(GUI,mainTree);		
	}
}
