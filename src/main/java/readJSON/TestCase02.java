package readJSON;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase02 {
	
	//Write a test to validate atleast one wicket keeper 

	
	@Test
	public void VerifyWicketKeeper() throws IOException, ParseException
	{
	  List<String> list = new ArrayList<>(ValidateJSON.getplayerRole());
	  
	  boolean keeper =false;
	  for(int i=0;i<list.size();i++)
		  if(list.get(i).toString().toLowerCase().equals("wicket-keeper"))
			  keeper=true;  
	  if(keeper)
		  Assert.assertTrue(true,"Playes list has one Wicket-Keeper");
	  else
		  Assert.assertTrue(false,"Playes list has no Wicket-Keeper");
	}
	
}
