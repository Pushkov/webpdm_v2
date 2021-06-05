package nicomed.backend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import nicomed.backend.enums.Position;
import nicomed.backend.enums.Status;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.util.Calendar;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="buro_id")
    private Buro buro;


    @Enumerated(value = EnumType.STRING)
    @Column(name = "position")
    private Position position;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column (name = "phone")
    private Long phone;

    @Column (name = "mobile")
    private Long mobile;

    @Column (name = "cabinet")
    private Integer cabinet;

    @Column (name = "birthday")
    private Calendar birthday;
}
