package Function;

import org.json.simple.JSONObject;

public class JsonHandler {
		
	public static void saveJson (JSONObject jsonObject) {
		//save all nodes as Json
	}
	
	public static JSONObject getJsonObj (JSONObject jsonObject, int[] place) {
		JSONObject returnObj = null;
		//3,1 (��� 0���� �����ؾ� �Ѵ�!) (���� ���� root-�ܿ�-(����) ����Ŵ!)
		for(int i=0; i<place.length; i++) {
			//go to (left child)
			for (int j=0; j<place[i]; j++) {
				//go to (right sibling)
			}
		}
		return returnObj;
	}
	
}
