package Function;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import Data.Tree;

public class FileExplorer {
	static JFileChooser chooser;
	
	public static String Loading(Tree mainTree){
		
		if (mainTree == null)
			return null;

		chooser = new JFileChooser(); 
		chooser.setFileFilter(new FileNameExtensionFilter("json", "json"));
        chooser.setMultiSelectionEnabled(false);
		int ret = chooser.showOpenDialog(null);
		if (ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "경로를 선택하지않았습니다.","경고", JOptionPane.WARNING_MESSAGE);
			return null;
		}

		String filePath = chooser.getSelectedFile().getPath();  //파일경로를 가져옴
		JSONObject jsonObject = new JSONObject();
		JSONParser parser = new JSONParser(); 

		try {
			jsonObject = (JSONObject)parser.parse(new FileReader(filePath.toString()));
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		catch (ParseException e) {
			e.printStackTrace();
		}
		JsonHandler.loadJson(jsonObject, mainTree);
		return filePath;
	}
	
	public static String saving (Tree mainTree, String address){
		String filePath = null;		
		if (mainTree == null)
			return null;
		if (address == null) {
			chooser = new JFileChooser();
			int ret = chooser.showSaveDialog(null); 
			if (ret != JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null, "경로를 선택하지않았습니다.","경고", JOptionPane.WARNING_MESSAGE);
				return null;
			}
			filePath = chooser.getSelectedFile().getPath();
		}
		else
			filePath = address;
		Function.JsonHandler.saveData(mainTree, filePath);
		return filePath;
	}
}




 