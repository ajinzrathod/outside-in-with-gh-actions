package co.incubyte;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserControllerShould {
    UserController userController;
    String id;

    @Mock
    UserService userService;

    @BeforeEach
    public void init() {
        id = "2";
        userController = new UserController(userService);
    }

    @Test
    public void get_posts_from_user_id() {
        userController.getPostsFromUserId(id);
        verify(userService).getPostsFromUserId(id);
    }
}
