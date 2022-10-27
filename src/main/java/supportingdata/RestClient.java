package supportingdata;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static supportingdata.URLs.AUTH;


public class RestClient {
    public static final RequestSpecification REQUEST_SPECIFICATION = new RequestSpecBuilder()
            .setBaseUri(URLs.BASE_URL)
            .setBasePath(AUTH)
            .setContentType(ContentType.JSON)
            .build();
}
