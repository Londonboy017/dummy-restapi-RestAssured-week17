package com.restapiexample.dummy.restapiexample;

import com.restapiexample.dummy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetAllEmployeesTest extends TestBase {

    @Test
    public void getAllEmployees() {
        Response response = given()
                .when()
                .get("/employees");
        response.then().statusCode(200);

        //All Test

        List<?> records = response.then().extract().path("data");
        System.out.println("Total Records              :" + records.size());

        int id = response.then().extract().path("data[23].id");
        System.out.println("data[23].id                :" + id);

        String employeeName = response.then().extract().path("data[23].employee_name");
        System.out.println("data[23].employee_name     :" + employeeName);

        String message = response.then().extract().path("message");
        System.out.println("Message                    :" + message);

        String status = response.then().extract().path("status");
        System.out.println("Status                     :" + status);

        List<Integer> employeeSalary = response.then().extract().path("data.findAll{it.id==3}.employee_salary");
        System.out.println("id = 3 has employee_salary :" + employeeSalary);

        List<Integer> employeeAge = response.then().extract().path("data.findAll{it.id==6}.employee_age");
        System.out.println("id = 6 employee age           :" + employeeAge);

        List<String> empName = response.then().extract().path("data.findAll{it.id==11}.employee_name");
        System.out.println("id = 11 employee name        :" + empName);


        response.prettyPrint();
    }


}

