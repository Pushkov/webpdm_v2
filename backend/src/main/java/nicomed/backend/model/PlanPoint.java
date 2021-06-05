package nicomed.backend.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Calendar;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="points")
public class PlanPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int orderInPlan;

//    @ManyToOne
//    @JsonBackReference
//    @JoinColumn(name = "planmonth_id")
//    private PlanMonth planmonth;


    private Calendar planDate;

    private Calendar startDate;

    @Nullable
    private Calendar endDate;

    private int readiness;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @Nullable
    private Project project;

    @ManyToOne
    @JoinColumn(name = "buro_id")
    private Buro buro;

}
