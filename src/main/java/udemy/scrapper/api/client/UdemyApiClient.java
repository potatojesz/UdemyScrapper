package udemy.scrapper.api.client;

import org.glassfish.jersey.internal.util.Base64;
import udemy.scrapper.api.client.model.CourseList;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

public class UdemyApiClient {
    public static final String URL = "https://www.udemy.com/api-2.0/courses/?page=1&page_size=100";
    public static Client client = ClientBuilder.newClient();

    public CourseList getCourses(String url) {
        Invocation.Builder target = client.target(url)
                .request(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION , "Basic " + encodeToken());
        return target.get(CourseList.class);
}

    private String encodeToken() {
        String clientId = "5kKF2aDHjxAr0lTcg2cNVGD3J10xtJBLbANactCL";
        String clientSecret = "EAbhMw9sSNV2jge8Yu66U6CUTUqjwHi1kVuGyGVAfjZlzwn4HRjdeQq7O1YqF880F4srU8bJEzIztMZsnJR2VVB3Ou6SpmUjIEbsU7FucaixOJL99tqIcU309pYTxHBX";
        String encodeString = clientId + ":" + clientSecret;
        return Base64.encodeAsString(encodeString);
    }
}
