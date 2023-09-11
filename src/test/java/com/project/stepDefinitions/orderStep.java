package com.project.stepDefinitions;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.restassured.response.Response;
import models.order.Order;
import requests.orderRequests;
import requests.petRequests;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class orderStep {

    String orderId;

    @Когда("создать заказ статус {int}")
    public void getPetByID(int statusCode, List<List<String>> dataTable) {

        Response response = new orderRequests().postOrder(
                                 Order.builder()
                                         .id(Integer.parseInt(dataTable.get(0).get(1)))
                                         .petId(Integer.parseInt(dataTable.get(1).get(1)))
                                         .quantity(Integer.parseInt(dataTable.get(2).get(1)))
                                         .shipDate(dataTable.get(3).get(1))
                                         .status(dataTable.get(4).get(1))
                                         .complete(Boolean.parseBoolean(dataTable.get(5).get(1)))
                                         .build());
        orderId = response.jsonPath().get("id").toString();
        assertEquals(statusCode, response.getStatusCode());

    }

    @И("Получить заказ статус {int}")
    public void getOrder(int statusCode) {
        Response response = new orderRequests().getOrder(orderId);
        assertEquals(statusCode, response.getStatusCode());
    }

    @И("Удалить заказ статус {int}")
    public void deleteOrder(int statusCode) {
        Response response = new orderRequests().deleteOrder(orderId);
        assertEquals(statusCode, response.getStatusCode());
    }
}
