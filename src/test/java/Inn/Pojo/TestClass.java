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
		RestAssured.baseURI="https://reqres.in";
		Pojo response = given().expect().defaultParser(Parser.JSON).when().get("/api/unknown").as(Pojo.class);

        Assert.assertEquals(1, response.getPage());
        Assert.assertEquals(6, response.getPer_page());
        Assert.assertEquals(12, response.getTotal());
        Assert.assertEquals(2, response.getTotal_pages());
        for (int i = 0; i < response.getData().size(); i++) {
        	 DataForPojo contentsOfData = response.getData().get(i);
        	System.out.println(contentsOfData.getId());
          	System.out.println(contentsOfData.getName());
          	System.out.println(contentsOfData.getColor());
          	System.out.println(contentsOfData.getYear());
          	System.out.println(contentsOfData.getPantone_value());
          	System.out.println();
		}
	}
}
