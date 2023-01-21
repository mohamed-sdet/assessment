package readJSON;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

public class ValidateJSON {
	
	public static Object obj;
	
	@Test
	public void ValidateTest01() throws IOException, ParseException
	{
		
		JSONParser jsonParser = new JSONParser();
		
		FileReader reader = new FileReader(".\\testdata\\inputData\\TeamRCB.json");
		
		Object obj = jsonParser.parse(reader);
		
		JSONObject  playersobj = (JSONObject)obj;
		
		String playerName = (String)playersobj.get("name");
		String countryName = (String)playersobj.get("country");
		JSONArray players = (JSONArray)playersobj.get("player");
		
		for(int i=0;i<players.size();i++)
		{
			JSONObject player = (JSONObject)players.get(i);
			String playerNames = (String) player.get("name");
			String countryNames = (String) player.get("country");
			String roles = (String) player.get("role");
			
		    System.out.println(playerNames +countryNames+roles);
		}

	}
	
	public static Object parseJSON(String fileName) throws IOException, ParseException
	{
		JSONParser jsonParser = new JSONParser();
		
		FileReader reader = new FileReader(".\\testdata\\inputData\\"+fileName+".json");
		
		 obj = jsonParser.parse(reader);
		
		return obj;
		
	}
	
	

	
}
