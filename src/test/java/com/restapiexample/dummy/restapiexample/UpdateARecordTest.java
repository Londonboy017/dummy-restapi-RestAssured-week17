package com.restapiexample.dummy.restapiexample;

import com.restapiexample.dummy.model.EmpPojo;
import com.restapiexample.dummy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class UpdateARecordTest extends TestBase {

    @Test
    public void updateARecord() {
        HashMap<String,Object> createRecord = new HashMap<>();
        createRecord.put("name","Jason");
        EmpPojo empPojo = new EmpPojo();
        empPojo.setData(createRecord);

        Response response = given()
                .header("Content-Type", "application/json")
                .body(empPojo)
                .when()
                .put("/update/24");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
