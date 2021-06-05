package nicomed.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "buros")
public class Buro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "full_name")
    private String fullName;

//    @JsonBackReference
//    @OneToMany(mappedBy = "buro", fetch = FetchType.EAGER)
//    private List<User> users;
    //    @JsonIgnore

    @OneToOne
    @JsonIgnore
    private User chief;

//    @OneToMany(mappedBy = "customerBuro", fetch = FetchType.LAZY)
//    @JsonIgnore
//    private List<Workshop> customers;
}
