package requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.order.Order;
import models.pet.Pet;

import static config.ApiConfig.getRequestSpecification;
import static constant.urlConstants.ORDER_URL;
import static constant.urlConstants.PET_URL;
import static io.restassured.RestAssured.given;

public class orderRequests {

    //запрос создания заказа
    public Response postOrder(Order order){
        Response response = given(getRequestSpecification())
                .contentType(ContentType.JSON)
                .body(order)
                .when()
                .post(ORDER_URL)
                .andReturn();

        return response;
    }

    //запрос получения заказа
    public Response getOrder(String orderId){
        Response response = given(getRequestSpecification())
                .contentType(ContentType.JSON)
                .when()
                .get(ORDER_URL + orderId)
                .andReturn();

        return response;
    }

    //запрос удаления заказа
    public Response deleteOrder(String orderId){
        Response response = given(getRequestSpecification())
                .contentType(ContentType.JSON)
                .when()
                .delete(ORDER_URL + orderId)
                .andReturn();

        return response;
    }
}
