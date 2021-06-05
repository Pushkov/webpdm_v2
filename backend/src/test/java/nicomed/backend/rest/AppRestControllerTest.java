package nicomed.backend.rest;

import nicomed.backend.controller.AppController;
import nicomed.backend.model.User;
import nicomed.backend.repository.UserRepository;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AppRestControllerTest {

    @MockBean
    UserRepository repository;

    @Autowired
    AppController appController;

    private List<User> list;

    @BeforeEach
    void init(){
//        list = List.of(
//                new User(0L,"01","02","03"),
//                new User(1L,"11","12","13"),
//                new User(2L,"21","22","23")
//        );
    }

    @Test
    void getAllWorkshops() throws JSONException {
//        String exp = "[User(id=0, login=01, firstName=02, lastName=03), User(id=1, login=11, firstName=12, lastName=13), User(id=2, login=21, firstName=22, lastName=23)]";
//        Mockito.when(repository.findAll()).thenReturn(list);
//        assertEquals(exp,
//                appController.getAllWorkshops().toString());

    }
}