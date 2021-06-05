package nicomed.backend.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nicomed.backend.enums.Position;
import nicomed.backend.model.User;
import nicomed.backend.service.BuroService;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserViewForm {

//        @Autowired
//        private static BuroService buroService;

        private Long id;
        private String login;
        private String firstName;
        private String lastName;
        private Long buroId;
//        private String buroName;
//        private String buroFullName;
        private Long phone;
        private Long mobile;
        private Integer cabinet;
        private String positionName;
        private String birthday;

        public static UserViewForm from(User user){
            return UserViewForm.builder()
                    .id(user.getId())
                    .login(user.getLogin())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .buroId(user.getBuro() != null ? user.getBuro().getId() : 0L)
//                    .buroName(user.getBuro() != null ? user.getBuro().getName() : "*")
//                    .buroFullName(user.getBuro() != null ? user.getBuro().getFullName() : "**")
                    .phone(user.getPhone())
                    .mobile(user.getMobile())
                    .cabinet(user.getCabinet())
                    .positionName(user.getPosition().getName())
                    .birthday(user.getBirthday() != null ? new SimpleDateFormat("dd MMMM YYYY").format(user.getBirthday().getTime()) : "-")
                    .build();
        }

        public static User formToUser(UserViewForm form, User user){

//                User user = new User();
                if(form.getId() != null)
                        user.setId(form.getId());
                user.setLogin(form.getLogin());
                user.setPassword("33");
                user.setFirstName(form.getFirstName());
                user.setLastName(form.getLastName());
//                user.setBuro(buroService.findById(form.getBuroId()));
                user.setPosition(Position.ENG);
                user.setBirthday(new GregorianCalendar(1994,10,12));
                return user;
        }


/*
    private Long id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private Buro buro;
    private Position position;
    private Status status;
    private Long phone;
    private Long mobile;
    private Integer cabinet;
    private Calendar birthday;
 */


}
