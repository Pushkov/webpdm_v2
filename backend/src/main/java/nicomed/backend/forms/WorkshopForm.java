package nicomed.backend.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nicomed.backend.model.Workshop;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkshopForm {

    private String name;
    private String fullName;
    private Integer code;


    public static WorkshopForm from (Workshop workshop){
        return WorkshopForm.builder()
                .name(workshop.getName())
                .fullName(workshop.getFullName())
                .code(workshop.getCode())
                .build();
    }

    public Workshop create(){
        Workshop workshop = new Workshop();
        return formTo(workshop);
    }

    public Workshop edit(Workshop workshop){
        return formTo(workshop);
    }

    private Workshop formTo(Workshop workshop){
        workshop.setName(this.name);
        workshop.setFullName(this.fullName);
        workshop.setCode(this.code);
        return workshop;
    }
}
