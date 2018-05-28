	package main;

import javax.swing.JFrame;
import org.json.simple.parser.JSONParser;
import Data.Tree;

public class MainClass {
	
	public static void main (String[] args) {
		
		JSONParser parser = new JSONParser();
		
		//jsonObject는 모든 jasnoObject를 가리키는 참조변수
//		Object obj = parser.parse(new FileReader("c:\경로\파일.json"));
//		JSONObject jsonObject = (JSONObject) obj;
		
	    Tree mainTree = new Tree();	
		JFrame mainFrame = new JFrame();
		GUI.FrameGUI GUI = new GUI.FrameGUI(mainFrame, mainTree);
//		new TreeStructure(GUI,mainTree);		
	}
}
