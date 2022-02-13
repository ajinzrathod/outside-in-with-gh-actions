package co.incubyte;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class UserService {

    @Inject
    private final UserGateway userGateway;

    public UserService(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public List<Post> getPostsFromUserId(String userId) {
        return userGateway.getPostsFromUserId().stream().
                filter(post -> userId.equals(post.getId())).
                collect(Collectors.toList());
    }
}
