package co.incubyte;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import jakarta.inject.Inject;

import java.util.List;

public class UserGateway {
    @Inject
    @Client("https://jsonplaceholder.typicode.com/")
    HttpClient httpClient;

    public List<Post> getPostsFromUserId() {
        return httpClient.toBlocking().
                retrieve(HttpRequest.GET("/posts"), Argument.listOf(Post.class));
    }
}
