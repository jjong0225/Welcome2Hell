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
	
	public static void Loading(Tree mainTree){
		
		if (mainTree == null)
			return;

		chooser = new JFileChooser(); 
		chooser.setFileFilter(new FileNameExtensionFilter("json", "json"));
        chooser.setMultiSelectionEnabled(false);
		int ret = chooser.showOpenDialog(null);
		if (ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "��θ� ���������ʾҽ��ϴ�.","���", JOptionPane.WARNING_MESSAGE);
			return;
		}

		String filePath = chooser.getSelectedFile().getPath();  //���ϰ�θ� ������
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
	}
	
	public static void saving (Tree mainTree){
		
		if (mainTree == null)
			return;

		chooser = new JFileChooser();
		int ret = chooser.showSaveDialog(null); 
		if (ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "��θ� ���������ʾҽ��ϴ�.","���", JOptionPane.WARNING_MESSAGE);
			return;
		}
		String filePath = chooser.getSelectedFile().getPath();
		Function.JsonHandler.saveData(mainTree, filePath);
	}
}




 