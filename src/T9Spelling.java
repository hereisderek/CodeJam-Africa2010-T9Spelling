import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class T9Spelling {
	static Map<Integer, String> keys = new HashMap<Integer, String>();
	public static void main(String[] args){
		
		// generate map table
		for (int i = (int)'a'; i <= (int)'r'; i++){
			//System.out.println((char)i + " : " + (i - 91) / 3);
			String str = (keys.get((i-91)/3) == null)?"":keys.get((i-91)/3);
			keys.put((i - 91) / 3, str + (char)i);
		}
		keys.put(7, keys.get(7) + 's');
		for (int i = (int)'t'; i <= (int)'y'; i++){
			//System.out.println((char)i + " : " + (i - 92) / 3);
			String str = keys.get((i-92)/3) == null?"":keys.get((i-92)/3);
			keys.put((i - 92) / 3, str + (char)i);
		}
		keys.put(9, keys.get(9) + 'z');
		keys.put(0, " ");
		
/*		Iterator iterator = keys.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>) iterator.next();
			Integer key = entry.getKey();
			String value = keys.get(key);
			System.out.println(key + ":" + value);
		}*/
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int cases = Integer.parseInt(br.readLine());
			for (int i = 0; i < cases; i++){
				System.out.println("Case #" + (i+1) + ": " + getStr(br.readLine()));
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static String getStr(String str){
		String returnStr = "";
		for (char chr : str.toCharArray()){
			for(int i :new int[]{2,3,4,5,6,7,8,9,0}){
				int times;
				if ((times = keys.get(i).indexOf(chr)) != -1){
					String addOn = "";
					for (int j = 0; j < times+1; j++){
						addOn += i;
					}
//					returnStr += ((!returnStr.equals("") && returnStr.charAt(returnStr.length()-1)==(char)i)? " " : "") + addOn;
					if (!returnStr.equals("") && (returnStr.charAt(returnStr.length()-1) == (""+i).charAt(0))){
						returnStr += " ";
					}
					//if (!returnStr.equals("")) System.out.println("returnStr.charAt(returnStr.length()-1)==(char)i ?: " + (returnStr.charAt(returnStr.length()-1) == (""+i).charAt(0)) + " " + returnStr.charAt(returnStr.length()-1) + " ? " + i);
					returnStr += addOn;
					break;
				}
			}
		}
		return returnStr;
	}
}
