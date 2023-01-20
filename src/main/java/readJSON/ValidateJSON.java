package readJSON;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.parser.JSONParser;

public class ValidateJSON {
	
	public void ValidateTest01() throws FileNotFoundException
	{
		
		JSONParser jsonParser = new JSONParser();
		
		FileReader reader = new FileReader(".\\testdata\\inputData\\TeamRCB.json");
	}

	
}
