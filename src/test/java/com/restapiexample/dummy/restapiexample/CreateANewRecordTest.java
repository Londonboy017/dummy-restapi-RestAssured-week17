package com.restapiexample.dummy.restapiexample;


import com.restapiexample.dummy.model.EmpPojo;
import com.restapiexample.dummy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class CreateANewRecordTest extends TestBase {

    @Test
    public void createANewRecord() {
        HashMap<String, Object> createRecord = new HashMap<>();
        createRecord.put("name", "Nikunj");
        createRecord.put("salary", "60500");
        createRecord.put("age", "35");
        createRecord.put("id", 106);
        EmpPojo empPojo = new EmpPojo();
        // empPojo.setStatus("success");
        empPojo.setData(createRecord);

        Response response = given()
                .header("Content-Type", "application/json")
                .body(empPojo)
                .when()
                .post("/create");
        response.then().statusCode(200);
        response.prettyPrint();

    }


}
