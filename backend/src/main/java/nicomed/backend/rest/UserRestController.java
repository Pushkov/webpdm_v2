package nicomed.backend.rest;

import io.jsonwebtoken.JwtException;
import nicomed.backend.forms.UserViewForm;
import nicomed.backend.model.Buro;
import nicomed.backend.model.User;
import nicomed.backend.service.BuroService;
import nicomed.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/pdm/api/users")
public class UserRestController {

    private final UserService service;
    private final BuroService buroService;

    @Autowired
    public UserRestController(UserService service, BuroService buroService) {
        this.service = service;
        this.buroService = buroService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllViewForms() {
        try {
            return new ResponseEntity<>(service.findAll()
                    .stream()
                    .map(UserViewForm::from)
                    .collect(Collectors.toList()), HttpStatus.OK);
        } catch (JwtException | IllegalArgumentException e) {
            System.out.println("JWT exception");
            return new ResponseEntity<>("Invalid email/password combination", HttpStatus.FORBIDDEN);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
        } catch (JwtException | IllegalArgumentException e) {
            return new ResponseEntity<>("Invalid email/password combination", HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping("")
    public void createUser(@RequestBody UserViewForm data) {

        System.out.println(" data create -> " + data);
        User user = new User();
        if(data.getBuroId() != 0L && data.getBuroId() != null){
            Buro buro = buroService.findById(data.getBuroId());
            user.setBuro(buro);
        }
        service.save(UserViewForm.formToUser(data, user));
    }

    @PutMapping("/{id}")
    public void updateUser(
            @RequestBody UserViewForm data,
            @PathVariable("id") Long id
    ) {
        System.out.println(" data update -> " + data);
        User user = service.findById(id);
        user = UserViewForm.formToUser(data, user);
//        if(user.getBuro() !=null &&  user.getBuro().getId() != data.getBuroId()){
        if(data.getBuroId() != 0L && data.getBuroId() != null){
            Buro buro = buroService.findById(data.getBuroId());
            user.setBuro(buro);
        }
        service.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        User user = service.findById(id);
        service.delete(user);
    }

}
