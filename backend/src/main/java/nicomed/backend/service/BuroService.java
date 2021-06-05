package nicomed.backend.service;

import nicomed.backend.model.Buro;

import java.util.List;

public interface BuroService {

    Buro findById(Long id);
    List<Buro> findAll();
    void save(Buro buro);
}
