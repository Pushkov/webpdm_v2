package nicomed.backend.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocS4 implements Serializable {

    private int docID;
    private String Designation;
    private String fileName;
    private byte[] fileBody;

}
