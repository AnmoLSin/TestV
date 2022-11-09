package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class QuerySolution {
	
	@Test
	public void Test_1() {
		Response response = RestAssured.get("https://gist.githubusercontent.com/kumarpani/1e759f27ae302be92ad51ec09955e765/raw/184cef7125e6ef5a774e60de31479bb9b2884cb5/TeamRCB.json");
		String resp = response.getBody().asString();
		JsonPath json = new JsonPath(resp); 
		int count = json.getInt("player.size()"), FP = 0;
		
		for(int i = 0; i < count; i++) {
			if(!json.getString("player["+i+"].country").equals("India")) {
				FP++;	
			}
		}

		Assert.assertEquals(FP, 4);
	}
	
	@Test
	public void Test_2() {
		Response response = RestAssured.get("https://gist.githubusercontent.com/kumarpani/1e759f27ae302be92ad51ec09955e765/raw/184cef7125e6ef5a774e60de31479bb9b2884cb5/TeamRCB.json");
		String resp = response.getBody().asString();
		JsonPath json = new JsonPath(resp); 
		int count = json.getInt("player.size()"), FP = 0;
		
		for(int i = 0; i < count; i++) {
			if(!json.getString("player["+i+"].role").equals("Wicket-keeper")) {
				FP++;
				break;
			}
		}

		Assert.assertEquals(FP, 1);
	}
}