package nicomed.backend.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "workshops")
public class Workshop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "code")
    private Integer code;

    @ManyToOne
    @JoinColumn(name="buro_id")
    private Buro customerBuro;


}
