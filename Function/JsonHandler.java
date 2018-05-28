package Function;

import org.json.simple.JSONObject;

public class JsonHandler {
		
	public static void saveJson (JSONObject jsonObject) {
		//save all nodes as Json
	}
	
	public static JSONObject getJsonObj (JSONObject jsonObject, int[] place) {
		JSONObject returnObj = null;
		//3,1 (모두 0부터 시작해야 한다!) (사진 참조 root-겨울-(군대) 가리킴!)
		for(int i=0; i<place.length; i++) {
			//go to (left child)
			for (int j=0; j<place[i]; j++) {
				//go to (right sibling)
			}
		}
		return returnObj;
	}
	
}
