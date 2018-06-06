package Function;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import Data.Node;
import Data.Tree;

public class JsonHandler {

	public static void loadJson (JSONObject jsonObject, Tree mainTree) {
		JSONObject JOB = ((JSONObject)jsonObject.get("Data"));
		mainTree.setRoot(new Node((String)JOB.get("info")));
		mainTree.getRoot().setX((double) JOB.get("x"));
		mainTree.getRoot().setY((double) JOB.get("y"));
		mainTree.getRoot().setWidth((int)((long)JOB.get("w")));
		mainTree.getRoot().setHeight((int)((long)JOB.get("h")));
		mainTree.getRoot().setParent(null);

		JSONArray nowArray = (JSONArray)jsonObject.get("Children");
		mainTree.getRoot().setChildren(array2Data(nowArray, mainTree.getRoot()));
		getParent(mainTree.getRoot().getChildren(), mainTree.getRoot());
	}
	
	public static ArrayList<Node> array2Data(JSONArray childrenArray, Node parent) {
		if(childrenArray == null)
			return null;
		ArrayList<Node> returnArray = new ArrayList<Node>();
		Iterator<JSONObject> iterator = childrenArray.iterator();
		
		if(!iterator.hasNext()) {
			return null;
		}
		
		while(iterator.hasNext()) {
			JSONObject nowJOB = iterator.next();
			JSONObject JOBData = (JSONObject) nowJOB.get("Data");
			JSONArray newChildrenArray = (JSONArray)nowJOB.get("Children");
			Node nowNode = new Node((String)JOBData.get("info"));
			double x = (double) JOBData.get("x");
			nowNode.setX(x);
			nowNode.setY((double) JOBData.get("y"));
			nowNode.setWidth((int)((long)JOBData.get("w")));
			nowNode.setHeight((int)((long)JOBData.get("h")));
			nowNode.setColorFromStr((String)JOBData.get("color"));
//			nowNode.parent = parent;

			if (newChildrenArray != null) {
				nowNode.setChildren(array2Data(newChildrenArray, null));
			}
			else {
				nowNode.setChildren(null);
			}
			returnArray.add(nowNode);
		}
		return returnArray;
	}
	
	public static void getParent(ArrayList<Node> childrenArray, Node parent) {
		if(childrenArray == null)
			return;

		ArrayList<Node> returnArray = new ArrayList<Node>();
		Iterator<Node> iterator = childrenArray.iterator();
		
		if(!iterator.hasNext()) {
			return;
		}
		
		while(iterator.hasNext()) {
			Node node = iterator.next();
			System.out.println(node.getX());
			node.setParent(parent);
			if (node.getChildren() != null) {
				getParent(node.getChildren(), node);
			}
			else {
			}
		}
}

			
	
	public static void saveData (Tree mainTree) {
		JSONObject head = new JSONObject();
		if(mainTree == null)
			return;

		JSONObject dataObj = new JSONObject();
		if(mainTree.getRoot() != null) {
			JSONObject rootObj = new JSONObject();
			rootObj.put("parent", null);
			rootObj.put("info", mainTree.getRoot().getInfo());
			rootObj.put("x", mainTree.getRoot().getX());
			rootObj.put("y", mainTree.getRoot().getY());
			rootObj.put("w", mainTree.getRoot().getWidth());
			rootObj.put("h", mainTree.getRoot().getHeight());
			rootObj.put("color", Integer.toHexString((mainTree.getRoot().getColor().getRGB()-mainTree.getRoot().getColor().getAlpha())/0x100));

			//child 호출
			if(mainTree.getRoot().getChildren() != null && mainTree.getRoot().getChildren().get(0) != null) {
				JSONArray children =Tree2JObj(mainTree.getRoot(), mainTree.getRoot().getChildren(), head);
				head.put("Data", rootObj);
				head.put("Children", children);
			}
			else {
				head.put("Data", rootObj);
				head.put("Children", null);				
			}
		}		
		
		try {
			FileWriter file = new FileWriter("C:\\Users\\JongHoon\\Desktop\\숭실대\\2-1\\객체\\saveTest.json");
			file.write(head.toJSONString());
			file.flush();
			file.close();
			System.out.println("saved");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static JSONArray Tree2JObj (Node root,  ArrayList<Node> now, JSONObject head) {

		JSONArray JArray = new JSONArray();
		
		if(root == null || head == null)
			return null;
		
			JSONObject job = new JSONObject();
			Iterator<Node> iterator = now.iterator();
			if(!iterator.hasNext()) {
				return null;
			}
			
			System.out.println("1");

			while (iterator.hasNext()) {
				Node nowNode = iterator.next();
				JSONObject returnObj = new JSONObject();
				JSONObject dataObj = new JSONObject();

				dataObj.put("parent", nowNode.getParent().getInfo());
				dataObj.put("info", nowNode.getInfo());
				dataObj.put("x", nowNode.getX());
				double y = nowNode.getY();
				if (y<1 && y>-1) {
					y = 0;
				}
				dataObj.put("y", y) ;
				dataObj.put("w", nowNode.getWidth());
				dataObj.put("h", nowNode.getHeight());
				dataObj.put("color",Integer.toHexString((nowNode.getColor().getRGB()-nowNode.getColor().getAlpha())/0x100));
				
				JSONArray children = null;
				//child 호출
				if(nowNode.getChildren() != null) {
					children = Tree2JObj (root, nowNode.getChildren(), head);
					returnObj.put("Data", dataObj);
					returnObj.put("Children", children);
				}
				else {
					returnObj.put("Data", dataObj);
					returnObj.put("Children", null);			
				}
				//array에 추가
				JArray.add(returnObj);
			}
		return JArray;
	}
}
