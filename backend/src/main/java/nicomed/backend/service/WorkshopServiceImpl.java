package nicomed.backend.service;

import nicomed.backend.model.Workshop;
import nicomed.backend.repository.WorkshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class WorkshopServiceImpl implements WorkshopService {

    private final
    WorkshopRepository repo;

    @Autowired
    public WorkshopServiceImpl(WorkshopRepository repo) {
        this.repo = repo;
    }

    @Override
    public Workshop findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException(""));
    }

    @Override
    public Workshop findByName(String name) {
        return repo.findByName(name)
                .orElseThrow(() -> new NoSuchElementException(""));
    }

    @Override
    public List<Workshop> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Workshop> findByCode(int code) {
        return repo.findByCode(code);
    }

    @Override
    public void save(Workshop ws) {
        repo.save(ws);
    }

    @Override
    public void delete(Workshop ws) {
        repo.delete(ws);
    }
}
