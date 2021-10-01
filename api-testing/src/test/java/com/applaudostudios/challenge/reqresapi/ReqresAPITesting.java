package com.applaudostudios.challenge.reqresapi;

import com.applaudostudios.challenge.poi.RespUserAPI;
import com.applaudostudios.challenge.poi.User;
import com.applaudostudios.challenge.utils.PrintUserInfo;
import com.google.gson.Gson;
import groovy.json.JsonBuilder;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ReqresAPITesting {

    public User[] users = null;

    @BeforeClass
    public void initAPI(){
        Response response = RestAssured.get("https://reqres.in/api/users?page=1");

        var responseUser = response.getBody().as(RespUserAPI.class);
        System.out.println(responseUser.toString());
        users = responseUser.getData();
    }

    @Test
    public void usersEmail(){
        Assert.assertEquals(
                PrintUserInfo.printUserEmail(PrintUserInfo.findUser(users, "Janet", "Weaver")),
                true);
        Assert.assertEquals(
        PrintUserInfo.printUserEmail(PrintUserInfo.findUser(users, "Emma", "Wong")),
                true);
        Assert.assertEquals(
        PrintUserInfo.printUserEmail(PrintUserInfo.findUser(users, "Eve", "Holt")),
                true);
    }

    @Test
    public void printAllUserAvatars(){
        for (User user:users) {
            Assert.assertEquals(
                    PrintUserInfo.printUserAvatar(user),
                    true);
        }
    }

}
