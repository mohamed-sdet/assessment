package readJSON;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import junit.framework.Assert;

public class TestCase01 {
	
	//Validate Test that then team has only 4 foreign players

	@Test
	public void verifyForeignPlayer() throws IOException, ParseException
	{
		int count =4;
		List player = new ArrayList<>(ValidateJSON.getplayerCountry());
		
		int tempcount =0;
		for(int i=0;i<player.size();i++)
		{
			if(player.get(i).toString().toLowerCase() != "india")
			{
				tempcount++;
			}
		}
		
		Assert.assertEquals( count, tempcount);
		
	}

}
