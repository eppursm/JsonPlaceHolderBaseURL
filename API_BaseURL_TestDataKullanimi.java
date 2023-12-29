package test;

import baseURLDeposu.JsonPlaceHolderBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testDataDeposu.jsonPlaceHolderTestData;

import static io.restassured.RestAssured.given;

public class API_BaseURL_TestDataKullanimi extends JsonPlaceHolderBaseURL {

    @Test
    public void test01(){

        //1- URL ve Request body
        specJsonPlace.pathParam("pp1",22);

        //2- Expected Data
        jsonPlaceHolderTestData jsonPlaceHolder = new jsonPlaceHolderTestData();
        JSONObject expBody = jsonPlaceHolder.expDataOlustur();

        //3- Response kayıt
        Response response = given().spec(specJsonPlace).when().get("{pp1}");

        //4- Assertion
        JsonPath responseJSonPath = response.jsonPath();
        Assert.assertEquals(jsonPlaceHolder.basariliStatusKodu,response.getStatusCode());
        Assert.assertEquals(expBody.getInt("userId"),responseJSonPath.getInt("userId"));
        Assert.assertEquals(expBody.getInt("id"),responseJSonPath.getInt("id"));
        Assert.assertEquals(expBody.getString("title"),responseJSonPath.getString("title"));
        Assert.assertEquals(expBody.getString("body"),responseJSonPath.getString("body"));











    }



}
