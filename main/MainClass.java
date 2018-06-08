	package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Data.Tree;
import Function.JsonHandler;

public class MainClass {
	
	public static void main (String[] args) {
		

	    Tree mainTree = new Tree();	
	    JSONObject jsonObject = null;
	    
//		//jsonObject는 모든 jasnoObject를 가리키는 참조변수
//		try {
//			jsonObject = (JSONObject)parser.parse(new FileReader("C:\\Users\\JongHoon\\Desktop\\숭실대\\2-1\\객체\\saveTest.json"));

//		} 
//		catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		JsonHandler.loadJson(jsonObject, mainTree);		

		JFrame mainFrame = new JFrame();
		GUI.FrameGUI GUI = new GUI.FrameGUI(mainFrame, mainTree);
//		new TreeStructure(GUI,mainTree);		
	}
}
