package Inn.Pojo;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;

import static io.restassured.RestAssured.given;

public class TestClass {
	
	@Test
	public void Example2()
	{
	String[] expectedNames= {"cerulean","fuchsia rose","true red","aqua sky","tigerlily","blue turquoise"};
	List<String> expectedListOfNames = Arrays.asList(expectedNames);
	RestAssured.baseURI="https://reqres.in";
	Pojo response = given().expect().defaultParser(Parser.JSON).when().get("/api/unknown").as(Pojo.class);

        Assert.assertEquals(1, response.getPage());
        Assert.assertEquals(6, response.getPer_page());
        Assert.assertEquals(12, response.getTotal());
        Assert.assertEquals(2, response.getTotal_pages());
        
        ArrayList<String> actualListOfNames= new ArrayList<String>();
        for (int i = 0; i < response.getData().size(); i++) {
           String colorName = response.getData().get(i).getName();
           actualListOfNames.add(colorName);
		}
        Assert.assertEquals(actualListOfNames, expectedListOfNames);
	}
}
