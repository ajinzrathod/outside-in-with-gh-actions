package co.incubyte;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class UserServiceShould {
    @Mock
    UserGateway userGateway;

    UserService userService;

    @BeforeEach
    public void init(){
        userService = new UserService(userGateway);

        Post post1 = new Post();
        post1.setId("1");

        Post post2 = new Post();
        post2.setId("2");

        List<Post> posts = List.of(post1, post2);

        when(userGateway.getPostsFromUserId()).thenReturn(posts);
    }

    @Test
    public void get_posts_from_gateway() {
        List<Post> posts = userService.getPostsFromUserId("2");
        verify(userGateway).getPostsFromUserId();
        assertEquals(1, posts.size());
    }
}
