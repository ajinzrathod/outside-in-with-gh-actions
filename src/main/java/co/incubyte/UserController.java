package co.incubyte;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

import java.util.List;

@Controller("/users")
public class UserController {

    @Inject
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Get("/{userId}/posts")
    public List<Post> getPostsFromUserId(String userId) {
        return userService.getPostsFromUserId(userId);
    }
}
