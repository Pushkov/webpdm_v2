package nicomed.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String designation;

    @ManyToMany
    @JoinTable(name = "projects_designers", joinColumns = @JoinColumn(name = "project_id"),  inverseJoinColumns = @JoinColumn(name = "designer_id"))
    private List<User> designers;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    @Nullable
    @JsonBackReference
    private List<Project> parts;

    @ManyToOne
    @Nullable
    @JoinColumn(name = "parent_id")
    private Project parent;

    @OneToMany (mappedBy = "project", fetch = FetchType.LAZY)
    @Nullable
    @JsonBackReference
    private List<PlanPoint> points;

    private Calendar startDate;

    private Calendar endDate;

    private Calendar plannedEndDate;

    @ManyToOne
    @JoinColumn(name = "workshop_id")
    private Workshop workshop;

    @Nullable
    private String basics;

    @Nullable
    private String basicsDocument;
}
