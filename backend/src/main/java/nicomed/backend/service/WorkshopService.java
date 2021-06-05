package nicomed.backend.service;

import nicomed.backend.model.Workshop;

import java.util.List;

public interface WorkshopService {

    Workshop findById(Long id);
    Workshop findByName(String name);
    List<Workshop> findAll();
    List<Workshop> findByCode(int code);
    void save (Workshop ws);
    void delete (Workshop ws);
}
