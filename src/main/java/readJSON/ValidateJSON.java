package readJSON;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

public class ValidateJSON {
	
	public static Object obj;
	public static JSONObject jsonobj;
	
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
	
	public static JSONObject parseJSON(String fileName) throws IOException, ParseException
	{
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader(".\\testdata\\inputData\\"+fileName+".json");
		obj = jsonParser.parse(reader);
		try {
			jsonobj = (JSONObject)obj;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.print("Check for the fileName1:"+ e.toString());
		}
		return jsonobj;
		
	}
	
	public static String getTeamDetails(String teamName, String location)
	{
		JSONObject  playersobj = (JSONObject)obj;
		String playerName = (String)playersobj.get(teamName);
		String countryName = (String)playersobj.get(location);
		
		return playerName+" "+countryName;	
	}
	
	public static List <String> getplayerDetailsAsList(String fileName,String playerDetails,String details) throws IOException, ParseException
	{
		List<String> list = new ArrayList<>();
		
		JSONObject  playersobj  =parseJSON(fileName);
		
		JSONArray players = (JSONArray)playersobj.get(playerDetails);
		
		for(int i=0;i<players.size();i++)
		{
			JSONObject player = (JSONObject)players.get(i);
			  list.add((String) player.get(details));
		}
		
		return list;

	}
	
	
	public static List getplayerNames() throws IOException, ParseException
	{
		
		List <String > list = new ArrayList <>(getplayerDetailsAsList("TeamRCB","player","name"));

		return list;
	}
	
	public static List getplayerCountry() throws IOException, ParseException
	{
		
		List <String > list = new ArrayList <>(getplayerDetailsAsList("TeamRCB","player","country"));

		return list;
	}
	
	public static List getplayerRole() throws IOException, ParseException
	{
		
		List <String > list = new ArrayList <>(getplayerDetailsAsList("TeamRCB","player","role"));

		return list;
	}

	
}
